
package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import APTOptionsFolder.Check;
import APTOptionsFolder.CoveredByInvariant;
import APTOptionsFolder.Draw;
import APTOptionsFolder.Fairness;
import APTOptionsFolder.Help;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class OpenAPTController
{

	Utilities utilities = new Utilities();
	BigInfoAPTList bial = new BigInfoAPTList();
	Help helpObj = new Help();
	Draw drawObj = new Draw();
	Check checkObj = new Check();
	CoveredByInvariant coveredByInvariant = new CoveredByInvariant();
	Fairness fairness = new Fairness();

	public String option1Value = "";
	public String option2Value = "";
	public String option3Value = "";
	public String smallTextBoxValue = "";
	final String startDir = System.getProperty("user.dir");
	final String eee = startDir + "\\apt\\apt.jar";
	final String aptJarPath = eee.replaceAll("\\\\", "/");
	String sep = System.getProperty("file.separator");
	Stage stage = MainWindowController.aptStage;

	File jarFile;
	File secondJarFile;

	@FXML
	private Label headLabel, typeLabel, fileLabel, descriptionLabel, descTextLabel, optionalInfoLabel;

	@FXML
	private Button selectFileButton, openButton, closeButton, infoAboutNetButton, secondFileButton;

	@FXML
	private TextField fileTextField, secondFileTextField, optionalValueTextField;

	@FXML
	private ListView<String> options1ListView, options2ListView, options3ListView;

	@FXML
	private CheckBox optionalValueCheckBox;

	Tooltip tooltip = new Tooltip();

	public void initialize()
	{
		setSecondFileFieldsVisible(false);
		setOptions2Visible(false);
		setOptions3Visible(false);
		setOptionalValueVisible(false);

		fileTextField.setEditable(false);

		optionalValueCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>()
		{

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
			{
				if (newValue)
				{
					optionalValueTextField.setDisable(false);
				} else
				{
					optionalValueTextField.setDisable(true);
				}
			}
		});

		ObservableList<String> allTypes = bial.getTypesList();

		options1ListView.setItems(allTypes);

		options1ListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
		{

			@Override
			public ListCell<String> call(ListView<String> param)
			{
				return new ListCell<String>()
				{

					@Override
					protected void updateItem(String item, boolean empty)
					{
						super.updateItem(item, empty);
						if (bial.getMiscHeader().equals(item) || bial.getPetriNetsHeader().equals(item))
						{
							setDisable(true);
						} else
						{
							setDisable(false);
						}
						setText(item);
					}

				};
			}
		});

		options1ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				option1Value = newValue;
				if (!newValue.equals("") && !fileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				} else
				{
					setInfoButtonEnable(false);
				}
				String desc = "";

				if (newValue.equals(bial.getHelp()) || newValue.equals(bial.getCheck()))
				{
					selectFileButton.setDisable(true);
					fileTextField.setDisable(true);
				}

				else
				{
					fileTextField.setDisable(false);
					selectFileButton.setDisable(false);
				}

				for (Map.Entry<String, String> entry : bial.getBigList().entrySet())
				{
					if (entry.getKey().equals(newValue))
					{
						desc = entry.getValue();
						break;
					}
				}

				descriptionLabel.setText(desc);

				if (newValue.equals(bial.getHelp()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					options2ListView.setItems(helpObj.getHelpClassList());
					options3ListView.setItems(null);

				} else if (newValue.equals(bial.getDraw()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					options2ListView.setItems(drawObj.getDrawClassList());
					options3ListView.setItems(null);

				} else if (newValue.equals(bial.getBisimulation()))
				{
					setSecondFileFieldsVisible(true);
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptionalValueVisible(false);
					options2ListView.setItems(null);
					options3ListView.setItems(null);

				} else if (newValue.equals(bial.getBounded()))
				{

					setOptions2Visible(false);
					setOptions3Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(true);
					options2ListView.setItems(null);
					options3ListView.setItems(null);

				} else if (newValue.equals(bial.getCheck()))
				{
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptionalValueVisible(true);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(checkObj.getCheckGeneratorsClassList());
					options3ListView.setItems(checkObj.getCheckAttributesClassList());

				}

				else if (newValue.equals(bial.getCovered_by_invariant()))
				{
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);

					options2ListView.setItems(coveredByInvariant.getCoveredByInvariantInvClassList());
					options3ListView.setItems(coveredByInvariant.getCoveredByInvariantAlgoClassList());
				}

				else if (newValue.equals(bial.getFairness()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);

					options2ListView.setItems(fairness.getFairnessClassList());
					options3ListView.setItems(null);
				}

				else
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					options2ListView.setItems(null);
					options3ListView.setItems(null);
				}
			}
		});

		options2ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				option2Value = newValue;
			}
		});

		options3ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				option3Value = newValue;
			}
		});

		setInfoButtonEnable(false);

		optionalValueTextField.textProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if (!newValue.matches("\\d*"))
				{
					optionalValueTextField.setText(newValue.replaceAll("[^\\d]", ""));
					tooltip.setText("Only digits are allowed!");
					tooltip.setX(optionalValueTextField.getLayoutX() + 400);
					tooltip.setY(optionalValueTextField.getLayoutY());
					tooltip.show((Stage) optionalValueTextField.getScene().getWindow());
				} else
				{
					try
					{
						tooltip.hide();
					} catch (Exception e)
					{
						e.printStackTrace();
					}

				}
			}
		});

	}

	@FXML
	void closeButton_OnAction(ActionEvent event)
	{
		Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
	}

	@FXML
	void openButton_OnAction(ActionEvent event)
	{

	}

	@FXML
	void infoAboutNetButton_OnAction(ActionEvent event)
	{

		if (!fileTextField.getText().trim().isEmpty()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getHelp()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getBisimulation()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getCheck()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getCovered_by_invariant()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getFairness())
		{
			option2Value = "";
			JarProcess(jarFile);

		} else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getHelp()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		} else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFairness()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						 option1Value, fileTextField.getText(), option2Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCheck()
				&& !optionalValueTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, optionalValueTextField.getText(), option2Value, option3Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCovered_by_invariant()
				&& !selectFileButton.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), option2Value, option3Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getBisimulation()
				&& !secondFileTextField.getText().trim().isEmpty() && !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, jarFile.getAbsolutePath(), secondJarFile.getAbsolutePath());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} else
		{
			Alert alert = new Alert(AlertType.WARNING, "One or more of required fields are empty.", ButtonType.OK);
			alert.showAndWait();
		}

	}

	public void setJarFile(File file)
	{
		this.jarFile = file;
	}

	public void setSecondJarFile(File file)
	{
		this.secondJarFile = file;
	}

	public File getJarFile()
	{
		return this.jarFile;
	}

	private void setSecondFileFieldsVisible(boolean vis)
	{
		if (vis)
		{
			secondFileTextField.setVisible(true);
			secondFileButton.setVisible(true);
		}

		else
		{
			secondFileTextField.clear();
			secondFileTextField.setVisible(false);
			secondFileButton.setVisible(false);
		}
	}

	private void setOptions2Visible(boolean vis)
	{
		if (vis)
		{
			options2ListView.setVisible(true);
		} else
		{
			options2ListView.setVisible(false);
		}
	}

	private void setOptions3Visible(boolean vis)
	{
		if (vis)
		{
			options3ListView.setVisible(true);
		} else
		{
			options3ListView.setVisible(false);
		}
	}

	void JarProcess(File file)
	{

		try
		{
			if (option2Value.equals(""))
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, file.getAbsolutePath());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			}

			else
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, file.getAbsolutePath());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				utilities.modernInfoMessage(strFileContents);
			}

		} catch (IOException e)
		{
			System.out.print(e.getMessage());
		}

	}

	@FXML
	void secondFileButton_OnAction(ActionEvent event)
	{
		File file;
		File directory = new File(startDir);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open APT File");
		fileChooser.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("APT files (*.apt)", "*.apt");
		fileChooser.getExtensionFilters().add(extFilter);

		file = fileChooser.showOpenDialog(stage);

		if (file != null)
		{
			secondFileTextField.setText(file.getAbsolutePath());
			setSecondJarFile(file);
		}

	}

	@FXML
	void selectFileButton_OnAction(ActionEvent event)
	{
		File file;
		File directory = new File(startDir);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open APT File");
		fileChooser.setInitialDirectory(directory);
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("APT files (*.apt)", "*.apt");
		fileChooser.getExtensionFilters().add(extFilter);

		file = fileChooser.showOpenDialog(stage);

		if (file != null)
		{
			fileTextField.setText(file.getAbsolutePath());
			setJarFile(file);
		}

		if (!option1Value.equals("") && !fileTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(true);
		} else
		{
			setInfoButtonEnable(false);
		}
	}

	void setOptionalValueVisible(boolean vis)
	{
		if (vis)
		{
			optionalInfoLabel.setVisible(true);
			optionalValueCheckBox.setVisible(true);
			optionalValueTextField.setVisible(true);
			optionalValueTextField.setDisable(false);
			optionalInfoLabel.setText("If given, k-boundedness is checked");
		} else
		{
			optionalInfoLabel.setVisible(false);
			optionalValueCheckBox.setVisible(false);
			optionalValueTextField.setVisible(false);
			optionalValueTextField.setDisable(true);
		}
	}

	void setInfoButtonEnable(boolean en)
	{
		if (en)
		{
			infoAboutNetButton.setDisable(false);
		} else
		{
			infoAboutNetButton.setDisable(true);
		}
	}
}
