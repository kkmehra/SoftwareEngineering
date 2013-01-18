package CAB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {

    private Scanner input;

    //try to open the file
    public void openFile(){
        try{
            input = new Scanner(new File("Customer.txt"));
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("File not found.");
            System.exit(1);
        }
    }
    //try to read from the file
    public CabServiceGUI readRecords(){

        CabServiceGUI gui = new CabServiceGUI();

        while(input.hasNext())
        {
            for(int j = 0;j<20;j++){
            
            gui.CustomerName[j] = input.next();
            gui.IssuingPlace[j] = input.next();
            gui.Destination[j] = input.next();
            gui.Date[j] = input.next();
            gui.Type[j] = input.next();
            gui.Mobile[j] = input.nextLong();
            
            
            }
        }
        return gui;

    }
    //try to close the file
    public void closeFile(){
        if(input!=null)
            input.close();

    }
}