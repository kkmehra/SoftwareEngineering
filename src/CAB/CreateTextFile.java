/** This will create a text file based on user input and save it as donations.txt.
 * 
 */
package CAB;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class CreateTextFile {

    //object that outputs text to a file
    private Formatter output;

    //try opening a file
    public void openFile(){

        try
        {
        	 output = output = new Formatter(new FileOutputStream("Customer.txt", true));
        }
        catch (SecurityException securityException)
        {
            System.out.println("You cannot write to this file.");
        }
        catch (FileNotFoundException notFoundException)
        {
            System.out.println("You couldn't open or find the file.");
        }

    }
    //try writing to the file
    public void addRecords( String[] CustomerName, String[] IssuingPlace,String[] Destination,String[] Date,String[] Type,long[] MobileNo){

                try{
                     for (int j=0; j<CustomerName.length; j++) {
                         if (CustomerName[j] != null) {
                            output.format("\n %s %s %s %s %s %d \r\n",CustomerName[j],IssuingPlace[j],Destination[j],Date[j],Type[j],MobileNo[j]);
                         }
                     }
              }

              catch (FormatterClosedException formatterClosedException){

                     System.out.println("You couldn't write to this file.");

              }

              catch (NoSuchElementException elementException){

                     System.out.println("Invalid Input.");

              }

       }
    //try closing the file
    public void closeFile(){
        if(output!=null)
            output.close();
    }
}