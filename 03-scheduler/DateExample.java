import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class DateExample
{
     public static void main( String[] args ) 
    {
        try{
 

            SimpleDateFormat sdf = new
                                SimpleDateFormat("M-d-yyyy hh:mm a");

            Date date1 = sdf.parse("11-6-2014 05:18 AM");
            Date date2 = sdf.parse("11-6-2014 02:47 PM");
 
            System.out.println(sdf.format(date1));
            System.out.println(sdf.format(date2));
 
            if(date1.compareTo(date2)>0){
                System.out.println("Date1 is after Date2");
            }else if(date1.compareTo(date2)<0){
                System.out.println("Date1 is before Date2");
            }else if(date1.compareTo(date2)==0){
                System.out.println("Date1 is equal to Date2");
            }else{
                System.out.println("How to get here?");
            }



            String dateStr = new SimpleDateFormat("MM-dd-yyyy").format(date1);
            System.out.println(dateStr);
 
        }catch(ParseException ex){
            ex.printStackTrace();
        }
    }
}
