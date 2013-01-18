package CAB;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CabServiceGUI<JavaDBClass> extends JFrame
{

 

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	// Components
    private JPanel panel;
    private JTextArea results;
    private JButton entryButton;
    private JButton exitButton;
    private JButton clearButton;
    private JButton saveButton;
    private JButton openButton;
    private JButton AvailabilityButton;
    private JButton MapButton;
    
    private JTextField CustomerField;
    private JTextField FromField;
    private JTextField ToField;
    private JTextField DateField;
    private JTextField MobileField;
    private JTextField TypeField;
    
    
    
    
    
    
   


    //create variables
    
    
  
    String[] CustomerName = new String[20];
    String[] IssuingPlace = new String[20];
    String[] Destination = new String[20];
    String[] Date = new String[20];
    long [] Mobile = new long [20];
    String[] Type = new String[20];
    int i = 0;
    // Constants for the window size
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 600;


    //Constructor
    public CabServiceGUI(){

        // Set the title.
        setTitle("Cab Administator Service");

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the panel that contains the other components.
        buildPanel();

        // Add the panel to the content pane.
        add(panel);

        // Size and display the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
    }

    //The buildPanel method creates a panel containing other components.
    @SuppressWarnings("rawtypes")
	private void buildPanel(){

        // Create labels to display instructions.
        JLabel message1 = new JLabel("Name of the Customer:");
        JLabel message2 = new JLabel("Name of the issuing Place:");
        JLabel message3 = new JLabel("Name of the Destination Place:");
        JLabel message4 = new JLabel("Date:");
        JLabel message5 = new JLabel("Mobile Number:");
        JLabel message6 = new JLabel("AC/Non-AC");
        
        //instantiate the results area
        results = new JTextArea(25,60);
        results.setEditable(false);
        results.setWrapStyleWord(true);
        results.setLineWrap(true);
        results.setBorder(BorderFactory.createLoweredBevelBorder());


        // Create text fields to receive user input
        CustomerField = new JTextField(10);
        ToField = new JTextField(10);
        FromField = new JTextField(10);
        DateField = new JTextField(10);
        MobileField = new JTextField(10);
        TypeField = new JTextField(10);



        //create the user buttons to cause action
        entryButton = new JButton("Issue a Cab");
        entryButton.addActionListener((ActionListener) new EntryButtonListener());
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ExitButtonListener());
        clearButton = new JButton ("Clear Fields");
        clearButton.addActionListener(new ClearButtonListener());
        saveButton = new JButton ("Save");
        saveButton.addActionListener(new SaveButtonListener());
        openButton = new JButton ("Open");
        openButton.addActionListener(new OpenButtonListener());
        AvailabilityButton = new JButton ("Availability");
        AvailabilityButton.addActionListener(new  AvailabilityButtonListener());
        MapButton = new JButton ("Map");
        MapButton.addActionListener(new MapButtonListener());
        

        // Create a panel.
        panel = new JPanel();
        panel.setBackground(Color.green);

        //set the LayoutManager
        panel.setLayout(new FlowLayout());

        // Add the labels, text fields, and button to the panel.
        panel.add(message1);
        panel.add(CustomerField);
     
        panel.add(message2);
        panel.add(FromField);
        
        panel.add(message3);
        panel.add(ToField);
       
        panel.add(message4);
        panel.add(DateField);
    
        panel.add(message5);
        panel.add(MobileField);
        
        panel.add(message6);
        panel.add(TypeField);
        
        panel.add(results);
        
        panel.add(entryButton);
        panel.add(clearButton);
        panel.add(saveButton);
        panel.add(openButton);
        panel.add(exitButton);
        panel.add(AvailabilityButton);
        panel.add(MapButton);
    }
 
    private class EntryButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) 
        {

            CustomerName[i] = CustomerField.getText();
            IssuingPlace[i] = FromField.getText();
            Destination[i] = ToField.getText();
            Date[i] = DateField.getText();
            Type[i] = TypeField.getText();
           
            
            
            if (MobileNo(MobileField.getText())) {
                  Mobile[i] = Long.parseLong(MobileField.getText());
            }else{
                CustomerField.setText("");
                FromField.setText("");
                ToField.setText("");
                FromField.setText("");
                DateField.setText("");
                MobileField.setText("");
                TypeField.setText("");
                
            }
            results.append(CustomerName[i]+" \t "+IssuingPlace[i]+" \t "+Destination[i]+" \t "+Date[i]+" \t "+Type[i]+"  \t"+Mobile[i]+"  \n ");

            CustomerField.setText("");
            FromField.setText("");
            ToField.setText("");
            DateField.setText("");
            MobileField.setText("");
            TypeField.setText("");
            
            i++;
        } 
    }
    public boolean MobileNo(String Number) {

        if(Number==null || Number=="" || Number.length()<1){  //checking for empty field
            JOptionPane.showMessageDialog(null, "Please enter the Mobile Number");
            return false;
        }
        for(int i = 0; i <Number.length(); i++){  //verifying Mobile Number entered as number
            if (!Character.isDigit(Number.charAt(i))){ 
                JOptionPane.showMessageDialog(null, "Invalid input.");
                return false;
                } 
        }
        return true;

    }  
    private class ClearButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            CustomerField.setText("");
            FromField.setText("");
            ToField.setText("");
            DateField.setText("");
            MobileField.setText("");
            TypeField.setText("");
            }
    }
    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private class SaveButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            CreateTextFile cr = new CreateTextFile();
            cr.openFile();
            cr.addRecords(CustomerName, IssuingPlace, Destination, Date, Type, Mobile );
            cr.closeFile();

            }

    }
    private class AvailabilityButtonListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    	
    	CabInfo CI = new CabInfo();
    	CI.setVisible(true);
    	
    	}	
    }
    private class MapButtonListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    	
    	SetMap SM = new SetMap();
    	SM.setVisible(true);
    	
    	}	
    }
    private class OpenButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            ReadTextFile read = new ReadTextFile();
            read.openFile();
            @SuppressWarnings("rawtypes")
			CabServiceGUI Customer = read.readRecords();
            read.closeFile(); 
            @SuppressWarnings({ "unchecked", "rawtypes" })
			JavaDBClass db = (JavaDBClass) new CabServiceGUI();
            for(int i = 0; i<12 ; i++){

                try {
                	results.append(( (String) db).showTable()[i]+"\n\n");
					
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        }
    }
    /* Application method */
    
        public static void main(String[] args){

        @SuppressWarnings({ "unused", "rawtypes" })
		CabServiceGUI gui = new CabServiceGUI();
    }
}
