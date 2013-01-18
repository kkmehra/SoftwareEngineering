package CAB;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sony
 */
import java.sql.*;
import javax.swing.*;


public class javaConnect
{
	Connection conn = null;
	public static Connection ConncerDb()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sony\\Documents\\NetBeansProjects\\Databse\\New.sqlite");
//			JOptionPane.showMessageDialog(null,"Connection Established");
			return conn;
		
		}
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null, e);
		return null;
		}
	}
	
	
}