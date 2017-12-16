
package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

public class NetParser
{

	Utilities utilities = new Utilities();

	ObservableList<String> flowsList = FXCollections.observableArrayList();
	ObservableList<String> placesList = FXCollections.observableArrayList();
	ObservableList<String> transitionsList = FXCollections.observableArrayList();
	ObservableList<String> initialMarkingsList = FXCollections.observableArrayList();

	ObservableList<String> statesList = FXCollections.observableArrayList();
	ObservableList<String> labelsList = FXCollections.observableArrayList();
	ObservableList<String> arcsList = FXCollections.observableArrayList();

	final String startDir = System.getProperty("user.dir");
	String sep = System.getProperty("file.separator");

	public NetParser(String path)
	{
		this.placesList = getPlaces(path);
		this.transitionsList = getTransitions(path);
		this.flowsList = getFlows(path);
		this.initialMarkingsList = getMarkings(path);
	}

	public NetParser(String path, String useless)
	{
		this.statesList = getStates(path);
		this.labelsList = getLabels(path);
		this.arcsList = getArcs(path);
	}

	public ObservableList<String> getArcs(String path)
	{
		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.equals(".arcs"))
				{

					while ((line = reader.readLine()) != null)
					{
						if (!line.equals("") && !line.contains(".arcs"))
						{
							arcsList.add(line);
						}
					}

				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return this.arcsList;

	}

	public ObservableList<String> getLabels(String path)
	{
		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.equals(".labels"))
				{
					while (!(line = reader.readLine()).equals(".arcs"))
					{
						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+", "");
							try
							{
								int spaceIndex = asd.indexOf("[");
								if (spaceIndex != -1)
								{
									asd = asd.substring(0, spaceIndex);
								}
							} catch (Exception e)
							{
								e.printStackTrace();
							}

							labelsList.add(asd);
						}
					}
				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return this.labelsList;

	}

	public ObservableList<String> getStates(String path)
	{

		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.equals(".states"))
				{
					while (!(line = reader.readLine()).equals(".labels"))
					{
						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+", "");
							statesList.add(asd);
						}
					}
				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return this.statesList;

	}

	public ObservableList<String> getMarkings(String path)
	{
		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.contains("initial_marking"))
				{
					String marks = line.split("\\{")[1];
					marks = marks.replace("}", "");
					initialMarkingsList.add(marks);
				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return this.initialMarkingsList;

	}

	public ObservableList<String> getPlaces(String path)
	{

		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.equals(".places"))
				{
					while (!(line = reader.readLine()).equals(".transitions"))
					{
						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+", "");
							placesList.add(asd);
						}
					}
				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return this.placesList;

	}

	public ObservableList<String> getFlows(String path)
	{

		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.equals(".flows"))
				{
					while (!(line = reader.readLine()).contains("initial_marking") && line != null)
					{
						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+", "");

							String[] splitter = asd.split("\\:");
							if (splitter.length > 1)
							{
								String beforeDoubleDot = splitter[0];
								String afterDoubleDot = splitter[1];
								String beforeArrow = afterDoubleDot.split("\\->")[0];
								String afterArrow = afterDoubleDot.split("\\->")[1];

								String withoutClamreBeforeTemp = beforeArrow.replace("{", "");
								String withoutClamreBefore = withoutClamreBeforeTemp.replace("}", "");

								String withoutClamreAfterTemp = afterArrow.replace("{", "");
								String withoutClamreAfter = withoutClamreAfterTemp.replace("}", "");

								String fullString = beforeDoubleDot + ";" + withoutClamreBefore + ";"
										+ withoutClamreAfter;

								flowsList.add(fullString);
							}

						}
					}
				}
			}

		}

		catch (InterruptedException | IOException | ArrayIndexOutOfBoundsException | NullPointerException e)
		{
			e.printStackTrace();
		}

		return this.flowsList;

	}

	public ObservableList<String> getTransitions(String path)
	{
		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{

				if (line.equals(".transitions"))
				{
					while (!(line = reader.readLine()).equals(".flows"))
					{
						if (!line.equals(""))
						{
							String asd = line.replaceAll("\\s+", "");
							try
							{
								int spaceIndex = asd.indexOf("[");
								if (spaceIndex != -1)
								{
									asd = asd.substring(0, spaceIndex);
								}
							} catch (Exception e)
							{
								e.printStackTrace();
							}

							transitionsList.add(asd);
						}
					}
				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return this.transitionsList;

	}

	public boolean isLPN(String path)
	{
		try
		{
			Process p = Runtime.getRuntime().exec("cmd /c more " + path);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null)
			{
				if (line.equals(".type LTS"))
				{
					return false;
				}
				if (line.equals(".type LPN"))
				{
					return true;
				}
			}

		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

		return false;
	}

	public ObservableList<String> getFlowsList()
	{
		return flowsList;
	}

	public void setFlowsList(ObservableList<String> flowsList)
	{
		this.flowsList = flowsList;
	}

	public ObservableList<String> getPlacesList()
	{
		return placesList;
	}

	public void setPlacesList(ObservableList<String> placesList)
	{
		this.placesList = placesList;
	}

	public ObservableList<String> getTransitionsList()
	{
		return transitionsList;
	}

	public void setTransitionsList(ObservableList<String> transitionsList)
	{
		this.transitionsList = transitionsList;
	}

	public ObservableList<String> getInitialMarkingsList()
	{
		return initialMarkingsList;
	}

	public void setInitialMarkingsList(ObservableList<String> initialMarkingsList)
	{
		this.initialMarkingsList = initialMarkingsList;
	}

	public String getSep()
	{
		return sep;
	}

	public void setSep(String sep)
	{
		this.sep = sep;
	}

	public String getStartDir()
	{
		return startDir;
	}

	public Utilities getUtilities()
	{
		return utilities;
	}

	public void setUtilities(Utilities utilities)
	{
		this.utilities = utilities;
	}

	public ObservableList<String> getStatesList()
	{
		return statesList;
	}

	public void setStatesList(ObservableList<String> statesList)
	{
		this.statesList = statesList;
	}

	public ObservableList<String> getLabelsList()
	{
		return labelsList;
	}

	public void setLabelsList(ObservableList<String> labelsList)
	{
		this.labelsList = labelsList;
	}

	public ObservableList<String> getArcsList()
	{
		return arcsList;
	}

	public void setArcsList(ObservableList<String> arcsList)
	{
		this.arcsList = arcsList;
	}
}
