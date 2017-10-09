package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDatabase
{
	public static final String URL = "jdbc:mysql://localhost:3306/chernikova?useSSL=false";
	public static final String USER = "przemek";
	public static final String PASSWORD = "przemek";

	public void Update(String color, String type)
	{
		try
		{
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String query1 = "UPDATE chernikova.colors SET color = '" + color + "' WHERE type = '" + type + "';";
			Statement st1 = connection.createStatement();
			st1.executeUpdate(query1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
