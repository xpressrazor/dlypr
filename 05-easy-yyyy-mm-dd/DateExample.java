import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DateExample {

    public static Date formatDate(String pattern, String dateFormat, String line)
    {
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        SimpleDateFormat ft;
        String group;
        Date date = null;
        if (m.find()) {

            ft = new  SimpleDateFormat(dateFormat);
            group = m.group(1) + " " + m.group(2) + " " + m.group(3);
            try {
                date = ft.parse(group);
            }catch (ParseException pe) {
                System.out.println("Parse exception");
            }
        }
        return date;
    }

    public static void printDate(Date date) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    public static void main(String[] args) {

        // Read the file
        try {
            BufferedReader br = new BufferedReader(new FileReader("gistfile1.txt"));
            String line = br.readLine();
            Date date;

            while (line != null) {

                // 1. 1996-10-24. Its default (not needed really to convert, but done anyways)
                if((date=formatDate("(\\d{4})-(\\d{2})-(\\d{2})", "yyyy M d", line))!=null)
                    printDate(date);
                // 2. 01/11/55
                else if((date=formatDate("(\\d{2})/(\\d{2})/(\\d{2})", "M d yy", line))!=null)
                    printDate(date);
                // 3. 09#65#21
                else if((date=formatDate("(\\d{2})#(\\d{2})#(\\d{2})", "M yy d", line))!=null)
                    printDate(date);
                // 4. 15*10*1981
                else if((date=formatDate("(\\d{2})\\*(\\d{2})\\*(\\d{4})", "d M yyyy", line))!=null)
                    printDate(date);
                // 5. Jul 13, 07
                else if((date=formatDate("(\\w{3})\\ (\\d{2})\\,\\ (\\d{2})", "MMM d yy", line))!=null)
                    printDate(date);
                // 6. Mar 21, 1980
                else if((date=formatDate("(\\w{3}) (\\d{2}), (\\d{4})", "M d yyyy", line))!=null)
                    printDate(date);

                line = br.readLine();
            }
        }catch(Exception ex) {
            System.out.println("File read exception");
        }
    }
}

