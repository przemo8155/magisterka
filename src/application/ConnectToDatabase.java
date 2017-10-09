
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
	public static final String PASSWORD = "przemek";

	private String background;
	private String circle;
	private String rectangle;
	private String arrow;

	public void Connect()
	{
		try
		{
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String query1 = "SELECT color FROM chernikova.colors WHERE type = 'background';";
			Statement st1 = connection.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);
			while (rs1.next())
			{
				this.background = rs1.getString(1);
			}

			String query2 = "SELECT color FROM chernikova.colors WHERE type = 'circle';";
			Statement st2 = connection.createStatement();
			ResultSet rs2 = st2.executeQuery(query2);
			while (rs2.next())
			{
				this.circle = rs2.getString(1);
			}

			String query3 = "SELECT color FROM chernikova.colors WHERE type = 'rectangle';";
			Statement st3 = connection.createStatement();
			ResultSet rs3 = st3.executeQuery(query3);
			while (rs3.next())
			{
				this.rectangle = rs3.getString(1);
			}

			String query4 = "SELECT color FROM chernikova.colors WHERE type = 'arrow';";
			Statement st4 = connection.createStatement();
			ResultSet rs4 = st4.executeQuery(query4);
			while (rs4.next())
			{
				this.arrow = rs4.getString(1);
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final String getBackgroundString()
	{
		return this.background;
	}

	public final String getCircleString()
	{
		return this.circle;
	}

	public final String getRectangleString()
	{
		return this.rectangle;
	}

	public final String getArrowString()
	{
		return this.arrow;
	}

	public final void showStrings()
	{
		Utilities.infoBox(background);
		Utilities.infoBox(circle);
		Utilities.infoBox(rectangle);
		Utilities.infoBox(arrow);
	}
}
