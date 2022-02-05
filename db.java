package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.*;
import com.mysql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class db {
	java.sql.PreparedStatement pst;
	public static Connection dbConnect()
	{  
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","");
			return conn;
		}
		catch(Exception e2)
		{
			System.out.println(e2);
			e2.printStackTrace();
		}
		return conn;
	}
	

}
