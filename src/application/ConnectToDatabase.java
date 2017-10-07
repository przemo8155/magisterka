package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ConnectToDatabase
{
	public static final String URL = "jdbc:mysql://localhost:3306/chernikova?useSSL=false";
	public static final String USER = "przemek";
	public static final String PASSWORD = "Przemo94";

	public void Connect()
	{
		try
		{
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String query = "SELECT * FROM colors";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
