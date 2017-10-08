
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

	public void Connect(String backgr, String cir, String rect, String arr)
	{
		try
		{
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String query = "SELECT * FROM colors";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
			{
				backgr = rs.getString(3);
				cir = rs.getString(3);
				rect = rs.getString(3);
				arr = rs.getString(3);
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
}
