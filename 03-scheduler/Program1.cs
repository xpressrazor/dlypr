    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;

    // gmcs Program1.cs
    // based on http://www.reddit.com/user/madkatalpha solution

    class Program1
    {
    struct TimeBlock
    {
        public DateTime Start;
        public DateTime End;
        public string Activity;
    }

    static void Main()
    {
        SortedDictionary<DateTime, List<TimeBlock>> schedule = new SortedDictionary<DateTime, List<TimeBlock>>();
        var inputFile = File.ReadAllLines("input.txt");
        List<string> inputLines = new List<string>(inputFile);
        
        
        foreach (var input in inputLines) {
            int dateTerminator = input.IndexOf(':');
            int firstTimeTerminator = input.IndexOf("to");
            int secondTimeTerminator = input.IndexOf("--");
            
            DateTime date = DateTime.Parse(input.Substring(1, dateTerminator - 1));
                // DateTime date = DateTime.Parse(input.Substring(0, dateTerminator - 1));
            TimeBlock timeBlock = new TimeBlock();
            if (!schedule.ContainsKey(date))
                schedule.Add(date, new List<TimeBlock>());
            timeBlock.Start = DateTime.Parse(
                input.Substring(dateTerminator + 2, firstTimeTerminator - dateTerminator - 3)
            );
            timeBlock.End = DateTime.Parse(
                input.Substring(firstTimeTerminator + 3, secondTimeTerminator - firstTimeTerminator - 4)
            );
            timeBlock.Activity = input.Substring(secondTimeTerminator + 3);
            schedule[date].Add(timeBlock);
        }

        // Sort dictionary
        foreach (var key in schedule.Keys)        
        {
            List<TimeBlock> list = schedule[key];
            list.Sort(
                delegate(TimeBlock p1, TimeBlock p2)
                {
                    return p1.Start.CompareTo(p2.Start);
                }
            );
            schedule[key] = list;
        }

        // Solve daily reddit allocation
        foreach (var key in schedule.Keys)
        {
            TimeBlock dailyReddit = new TimeBlock() { Activity = "redditing" };
            double longestDuration = 0;
            int insertionIndex = 0;

            for (int i = 1; i < schedule[key].Count; i++)
            {
                var duration = ((TimeSpan)(schedule[key][i].Start - schedule[key][i-1].End)).TotalMinutes;
                if (duration > longestDuration)
                {
                    longestDuration = duration;
                    dailyReddit.Start = schedule[key][i - 1].End;
                    dailyReddit.End = schedule[key][i].Start;
                    insertionIndex = i;
                }
            }
            schedule[key].Insert(insertionIndex, dailyReddit);
        }
        
        Console.WriteLine("Coder_d00d's schedule:\n");
        double totalTime = 0;
        Dictionary<string, double> tasks = new Dictionary<string, double>();


            foreach (var key in schedule.Keys)
            {
                Console.WriteLine(String.Format(SchedDayFormat, key.ToShortDateString()));
                foreach (var activity in schedule[key])
                {
                    if (!tasks.ContainsKey(activity.Activity))
                        tasks.Add(activity.Activity, 0);
                    var duration = ((TimeSpan)(activity.End - activity.Start));
                    tasks[activity.Activity] += duration.TotalMinutes;
                    totalTime += duration.TotalMinutes;
                    Console.WriteLine(
                        String.Format(
                            SchedItemFormat, 
                            activity.Start.ToShortTimeString(), 
                            activity.End.ToShortTimeString(),
                            activity.Activity)
                    );
                }
                Console.WriteLine();
            }


            // Output week / task breakdown
            Console.WriteLine(String.Format(TaskHeaderFormat, totalTime));
            
            foreach (var key in tasks.Keys)
            {
                Console.WriteLine(
                    String.Format(
                        TaskFormat,
                        key,
                        tasks[key],
                        (tasks[key] / totalTime * 100)));
            }

        } // Main
        
        static string SchedDayFormat = "Schedule for {0}:";
            static string SchedItemFormat = "\t{0} to {1}\t-- {2}";
            static string TaskHeaderFormat = "Week breakdown ({0} minutes of tasks):";
            static string TaskFormat = "\t{0,-23} - {1} minutes, {2:00.0}% of your time";

        
    }
