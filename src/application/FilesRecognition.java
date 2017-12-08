package application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilesRecognition
{
	ObservableList<String> edgesList = FXCollections.observableArrayList();
	ObservableList<String> circlesList = FXCollections.observableArrayList();
	ObservableList<String> rectanglesList = FXCollections.observableArrayList();

	final String startDir = System.getProperty("user.dir");
	String sep = System.getProperty("file.separator");

	Utilities utilities = new Utilities();

	public FilesRecognition()
	{
		// TODO Auto-generated constructor stub
	}

	public FilesRecognition(String filePath)
	{
		this.circlesList = getCircles(filePath);
		this.rectanglesList = getRectangles(filePath);
		this.edgesList = getEdges(filePath);

	}

	public ObservableList<String> getRectangles(String path)
	{

		try
		{
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
					"draw", path);

			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.equals("	node [fontsize=20,shape=rect,height=0.5,width=0.5,fixedsize=true];"))
				{
					while (!(line = reader.readLine()).equals("	edge [fontsize=20]"))
					{

						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+","");
							int spaceIndex = asd.indexOf("[");
							if (spaceIndex != -1)
							{
							    asd = asd.substring(0, spaceIndex);
							}
							rectanglesList.add(asd);

						}

					}
				}
			}


		}

		catch (IOException e)
		{
			e.printStackTrace();
		}

		return this.rectanglesList;
	}


	public ObservableList<String> getCircles(String path)
	{

		try
		{
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
					"draw", path);

			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.equals("	node [fontsize=20,shape=circle,height=0.5,width=0.5,fixedsize=true];"))
				{
					while (!(line = reader.readLine()).equals("	node [fontsize=20,shape=rect,height=0.5,width=0.5,fixedsize=true];"))
					{

						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+","");
							int spaceIndex = asd.indexOf("[");
							if (spaceIndex != -1)
							{
							    asd = asd.substring(0, spaceIndex);
							}
							circlesList.add(asd);

						}

					}
				}
			}


		}

		catch (IOException e)
		{
			e.printStackTrace();
		}

		return this.circlesList;
	}

	public ObservableList<String> getEdges(String path)
	{

		try
		{
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
					"draw", path);

			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.equals("	edge [fontsize=20]"))
				{
					while (!(line = reader.readLine()).equals("}"))
					{
						String asd = line.replaceAll("\\s+","");

						int spaceIndex = asd.indexOf("[");
						if (spaceIndex != -1)
						{
						    asd = asd.substring(0, spaceIndex);
						}

						//String[] parts = asd.split("->");
						//String left = parts[0];
						//String right = parts[1];
						//System.out.println(left + " " + right);



						if (!line.equals(""))
						{
							edgesList.add(asd);

						}

					}
				}
			}


		}

		catch (IOException e)
		{
			e.printStackTrace();
		}

		return this.edgesList;
	}

	public int sizeOfEdgesList()
	{
		return this.edgesList.size();
	}

	public int sizeOfCirclesList()
	{
		return this.circlesList.size();
	}

	public int sizeOfRectanglesList()
	{
		return this.rectanglesList.size();
	}


	public ObservableList<String> getEdgesList()
	{
		return edgesList;
	}


	public void setEdgesList(ObservableList<String> edgesList)
	{
		this.edgesList = edgesList;
	}


	public ObservableList<String> getCirclesList()
	{
		return circlesList;
	}


	public void setCirclesList(ObservableList<String> circlesList)
	{
		this.circlesList = circlesList;
	}


	public ObservableList<String> getRectanglesList()
	{
		return rectanglesList;
	}


	public void setRectanglesList(ObservableList<String> rectanglesList)
	{
		this.rectanglesList = rectanglesList;
	}
}
