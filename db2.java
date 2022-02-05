package swing;

import java.sql.Connection;
import java.sql.DriverManager;

public class db2 {

	java.sql.PreparedStatement pst;
	public static Connection dbConnect()
	{  
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","");
			return conn;
		}
		catch(Exception e3)
		{
			System.out.println(e3);
			e3.printStackTrace();
		}
		return conn;
	}
	
	}


