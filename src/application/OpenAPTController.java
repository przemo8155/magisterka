
package application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aptOptionsFolderGenerators.BistatePhilnetGenerator;
import aptOptionsFolderGenerators.BitnetGenerator;
import aptOptionsFolderGenerators.ConnectedBitnetGenerator;
import aptOptionsFolderGenerators.CycleGenerator;
import aptOptionsFolderGenerators.QuadstatePhilnetGenerator;
import aptOptionsFolderGenerators.RandomTNetGenerator;
import aptOptionsFolderGenerators.TNetGenerator;
import aptOptionsFolderGenerators.TristatePhilnetGenerator;
import aptOptionsFolderLTS.ExtendDeterministicPersistent;
import aptOptionsFolderLTS.ExtendLts;
import aptOptionsFolderLTS.FindWords;
import aptOptionsFolderLTS.OverapproximateSynthesize;
import aptOptionsFolderLTS.PnExtendAndSynthesize;
import aptOptionsFolderLTS.RegularLanguageToLts;
import aptOptionsFolderLTS.Synthesize;
import aptOptionsFolderLTS.UsePetrify;
import aptOptionsFolderLTS.WordSynthesize;
import aptOptionsFolderPetriNets.Bounded;
import aptOptionsFolderPetriNets.Check;
import aptOptionsFolderPetriNets.CoveredByInvariant;
import aptOptionsFolderPetriNets.Draw;
import aptOptionsFolderPetriNets.Fairness;
import aptOptionsFolderPetriNets.Help;
import aptOptionsFolderPetriNets.Invariants;
import aptOptionsFolderPetriNets.PnAnalysis;
import aptOptionsFolderPetriNets.StrongSeparation;
import aptOptionsFolderPetriNets.StrongSeparationLength;
import aptOptionsFolderPetriNets.WeakSeparation;
import aptOptionsFolderPetriNets.WeakSeparationLength;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
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
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class OpenAPTController
{

	MainWindowController mwc = new MainWindowController();
	SplitObjectsAlgorithms soa = new SplitObjectsAlgorithms();
	FilesRecognition filesRecognition = new FilesRecognition();
	Utilities utilities = new Utilities();
	OptionsHeaders oh = new OptionsHeaders();
	BigInfoAPTList bial = new BigInfoAPTList();
	Help helpObj = new Help();
	Draw drawObj = new Draw();
	Check checkObj = new Check();
	CoveredByInvariant coveredByInvariantObj = new CoveredByInvariant();
	Bounded bounded = new Bounded();
	Fairness fairnessObj = new Fairness();
	Invariants invariantsObj = new Invariants();
	PnAnalysis pnAnalysisObj = new PnAnalysis();
	StrongSeparation strongSeparationObj = new StrongSeparation();
	StrongSeparationLength strongSeparationLengthObj = new StrongSeparationLength();
	WeakSeparation weakSeparationObj = new WeakSeparation();
	WeakSeparationLength weakSeparationLengthObj = new WeakSeparationLength();
	ExtendLts extendLts = new ExtendLts();
	FindWords findWords = new FindWords();
	OverapproximateSynthesize overapproximateSynthesize = new OverapproximateSynthesize();
	PnExtendAndSynthesize pnExtendAndSynthesize = new PnExtendAndSynthesize();
	RegularLanguageToLts regularLanguageToLts = new RegularLanguageToLts();
	Synthesize synthesize = new Synthesize();
	UsePetrify usePetrify = new UsePetrify();
	WordSynthesize wordSynthesize = new WordSynthesize();
	BistatePhilnetGenerator bistatePhilnetGenerator = new BistatePhilnetGenerator();
	BitnetGenerator bitnetGenerator = new BitnetGenerator();
	ConnectedBitnetGenerator connectedBitnetGenerator = new ConnectedBitnetGenerator();
	CycleGenerator cycleGenerator = new CycleGenerator();
	QuadstatePhilnetGenerator quadstatePhilnetGenerator = new QuadstatePhilnetGenerator();
	RandomTNetGenerator randomTNetGenerator = new RandomTNetGenerator();
	TNetGenerator tNetGenerator = new TNetGenerator();
	TristatePhilnetGenerator tristatePhilnetGenerator = new TristatePhilnetGenerator();
	ExtendDeterministicPersistent extendDeterministicPersistent = new ExtendDeterministicPersistent();

	public String option1Value = "";
	public String option2Value = "";
	public String option3Value = "";
	public String option4Value = "";
	public String smallTextBoxValue = "";
	final String startDir = System.getProperty("user.dir");
	final String eee = startDir + "\\apt\\apt.jar";
	final String aptJarPath = eee.replaceAll("\\\\", "/");
	String sep = System.getProperty("file.separator");
	Stage stage = MainWindowController.aptStage;

	public static Stage aptStage;

	String catFileContents = "";

	File jarFile;
	File secondJarFile;

	@FXML
	private Pane mainPane;

	@FXML
	private Label headLabel, typeLabel, fileLabel, descriptionLabel, descTextLabel, optionalInfoLabel, wordLabel,
			warningLabel, eventLabel1, eventLabel2, opt1Label, opt2Label, opt3Label, opt4Label;

	@FXML
	private Button selectFileButton, openButton, closeButton, infoAboutNetButton, secondFileButton, outputFileButton;

	@FXML
	private TextField fileTextField, secondFileTextField, optionalValueTextField, wordTextField, eventTextField1,
			eventTextField2;

	@FXML
	private ListView<String> options1ListView, options2ListView, options3ListView, options4ListView;

	@FXML
	private CheckBox optionalValueCheckBox;

	Tooltip tooltip = new Tooltip();

	public void initialize()
	{
		setSecondFileFieldsVisible(false);
		setOptions2Visible(false);
		setOptions3Visible(false);
		setOptions4Visible(false);
		setOptionalValueVisible(false);
		setWordFieldsVisible(false);
		setWarningVisible(false);
		setOutputFileButtonVisible(false);
		setEventVisible(false);

		descTextLabel.setWrapText(true);
		opt2Label.setWrapText(true);
		opt3Label.setWrapText(true);
		opt4Label.setWrapText(true);

		fileTextField.setEditable(false);
		secondFileTextField.setEditable(false);

		wordTextField.textProperty().addListener((observable, oldValue, newValue) ->
		{
			if (!newValue.trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
					&& !fileTextField.getText().trim().isEmpty()
					&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
			{
				setInfoButtonEnable(true);
			}
			else if(newValue.trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
					&& !fileTextField.getText().trim().isEmpty()
					&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
			{
				setInfoButtonEnable(false);
			}

			else if (!newValue.trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
					&& !fileTextField.getText().trim().isEmpty()
					&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
			{
				setInfoButtonEnable(true);
			}
			else if(newValue.trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
					&& !fileTextField.getText().trim().isEmpty()
					&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
			{
				setInfoButtonEnable(false);
			}

			else if (!newValue.trim().isEmpty() && option1Value.equals(bial.getWord())
					&& !fileTextField.getText().trim().isEmpty())
			{
				setInfoButtonEnable(true);
			}
			else if(newValue.trim().isEmpty() && option1Value.equals(bial.getWord())
					&& !fileTextField.getText().trim().isEmpty())
			{
				setInfoButtonEnable(false);
			}

			else if(newValue.trim().isEmpty() && option1Value.equals(bial.getFind_words2())
					&& options2ListView.getSelectionModel().getSelectedIndex() > -1
					&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
			{
				setInfoButtonEnable(false);
			}

			else if(!newValue.trim().isEmpty() && option1Value.equals(bial.getFind_words2())
					&& options2ListView.getSelectionModel().getSelectedIndex() > -1
					&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
			{
				setInfoButtonEnable(true);
			}
		});

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
						if (bial.getMiscHeader().equals(item) || bial.getPetriNetsHeader().equals(item)
								|| bial.getLTSHeader().equals(item) || bial.getGeneratorsHeader().equals(item)
								|| bial.getConvetersHeader().equals(item))
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

		options2ListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
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
						if (option1Value.equals(bial.getHelp()))
						{
							if (bial.getMiscHeader().equals(item) || bial.getPetriNetsHeader().equals(item)
									|| bial.getLTSHeader().equals(item) || bial.getGeneratorsHeader().equals(item)
									|| bial.getConvetersHeader().equals(item))
							{
								setDisable(true);
							} else
							{
								setDisable(false);
							}
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
					checkFileLTSorNET(options1ListView.getSelectionModel().getSelectedIndex(), fileTextField.getText());
					checkFileLTSorNET(options1ListView.getSelectionModel().getSelectedIndex(),
							secondFileTextField.getText());
				} else
				{
					setInfoButtonEnable(false);
				}
				String desc = "";

				if (newValue.equals(bial.getHelp()) || newValue.equals(bial.getCheck())
						|| newValue.equals(bial.getFind_words2()) || newValue.equals(bial.getRegular_language_to_lts2())
						|| newValue.equals(bial.getWord_synthesize2())
						|| newValue.equals(bial.getBistate_philnet_generator())
						|| newValue.equals(bial.getBitnet_generator())
						|| newValue.equals(bial.getConnected_bitnet_generator())
						|| newValue.equals(bial.getCycle_generator())
						|| newValue.equals(bial.getQuadstate_philnet_generator())
						|| newValue.equals(bial.getRandom_t_net_generator())
						|| newValue.equals(bial.getTnet_generator())
						|| newValue.equals(bial.getTristate_philnet_generator()))
				{
					selectFileButton.setVisible(false);
					fileTextField.setVisible(false);
				}

				else
				{
					fileTextField.setVisible(true);
					selectFileButton.setVisible(true);
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
					opt2Label.setText(oh.getHelp2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setInfoButtonEnable(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(helpObj.getHelpClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				} else if (newValue.equals(bial.getDraw()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(drawObj.getDrawClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				} else if (newValue.equals(bial.getBisimulation()))
				{
					opt2Label.setText(oh.getBisimulation2());
					opt3Label.setText(oh.getBisimulation3());
					setSecondFileFieldsVisible(true);
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setInfoButtonEnable(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				} else if (newValue.equals(bial.getBounded()))
				{
					opt2Label.setText(oh.getBounded2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					options2ListView.setItems(bounded.getBoundedClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				} else if (newValue.equals(bial.getCheck()))
				{
					opt2Label.setText(oh.getCheck2());
					opt3Label.setText(oh.getCheck3());
					opt4Label.setText(oh.getCheck4());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					options2ListView.setItems(checkObj.getCheckGeneratorsClassList());
					options3ListView.setItems(checkObj.getCheckAttributesClassList());
					options4ListView.setItems(checkObj.getCheckMaxSecondsClassList());

				}

				else if (newValue.equals(bial.getCovered_by_invariant()))
				{
					opt2Label.setText(oh.getCovered_by_invariant2());
					opt3Label.setText(oh.getCovered_by_invariant3());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(coveredByInvariantObj.getCoveredByInvariantInvClassList());
					options3ListView.setItems(coveredByInvariantObj.getCoveredByInvariantAlgoClassList());
					options4ListView.setItems(null);
				}

				else if (newValue.equals(bial.getFairness()) && !fileTextField.getText().trim().isEmpty()
						&& options1ListView.getSelectionModel().getSelectedIndex() < 30)
				{
					opt2Label.setText(oh.getFairness2());
					opt3Label.setText(oh.getFairness3());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(fairnessObj.getFairnessClassList());
					catFile_GetTransitions3List(fileTextField.getText());
					options4ListView.setItems(null);

				}


				else if (newValue.equals(bial.getFairness()) && !fileTextField.getText().trim().isEmpty()
						&& options1ListView.getSelectionModel().getSelectedIndex() > 30)
				{
					opt2Label.setText(oh.getFairness2());
					opt3Label.setText(oh.getFairness3());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(fairnessObj.getFairnessClassList());
					catFile_GetLabels3List(fileTextField.getText());
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getFire_sequence()) && !fileTextField.getText().trim().isEmpty())
				{
					opt2Label.setText(oh.getFire_sequence2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					catFile_GetTransitions(fileTextField.getText());

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options3ListView.setItems(null);
					options4ListView.setItems(null);
				}

				else if (newValue.equals(bial.getInvariants()))
				{
					opt2Label.setText(oh.getInvariants2());
					opt3Label.setText(oh.getInvariants3());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(invariantsObj.getInvariantsInvClassList());
					options3ListView.setItems(invariantsObj.getInvariantsAlgoClassList());
					options4ListView.setItems(null);
				}

				else if (newValue.equals(bial.getIsomorphism()))
				{
					setSecondFileFieldsVisible(true);
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getLanguage_equivalence()))
				{
					setSecondFileFieldsVisible(true);
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getPn_analysis()))
				{
					opt2Label.setText(oh.getPn_analysis2());
					opt3Label.setText(oh.getPn_analysis3());
					opt4Label.setText(oh.getPn_analysis4());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(pnAnalysisObj.getgClassList());
					options3ListView.setItems(pnAnalysisObj.getkClassList());
					options4ListView.setItems(pnAnalysisObj.getRandomlylassList());

				}

				else if (newValue.equals(bial.getSimply_live()) && !fileTextField.getText().trim().isEmpty())
				{
					opt2Label.setText(oh.getSimply_live2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					catFile_GetTransitions(fileTextField.getText());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getStrong_separation()))
				{
					opt2Label.setText(oh.getStrong_separation3());
					opt3Label.setText(oh.getStrong_separation2());
					opt4Label.setText(oh.getStrong_separation4());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(true);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					opt3Label.setVisible(true);
					wordLabel.setLayoutX(430);
					wordLabel.setLayoutY(390);
					wordTextField.setLayoutX(495);
					wordTextField.setLayoutY(386);
					wordLabel.setText("Sequcence: ");

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(strongSeparationObj.getStrongSeparationKClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(strongSeparationObj.getStrongSeparationVerboseClassList());
				}

				else if (newValue.equals(bial.getStrong_separation_length()))
				{
					opt2Label.setText(oh.getStrong_separation_length2());
					opt3Label.setText(oh.getStrong_separation_length3());
					opt4Label.setText(oh.getStrong_separation_length4());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);


					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(strongSeparationLengthObj.getStrongSeparationLengthLengthClassList());
					options3ListView.setItems(strongSeparationLengthObj.getStrongSeparationLengthKClassList());
					options4ListView.setItems(strongSeparationLengthObj.getStrongSeparationLengthVerboseClassList());
				}

				else if (newValue.equals(bial.getStrongly_live()) && !fileTextField.getText().trim().isEmpty())
				{
					opt2Label.setText(oh.getStrongly_live2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					catFile_GetTransitions(fileTextField.getText());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getSum_async()))
				{
					setSecondFileFieldsVisible(true);
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getSum_sync()))
				{
					setSecondFileFieldsVisible(true);
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getWeak_separation()))
				{
					opt2Label.setText(oh.getWeak_separation3());
					opt3Label.setText(oh.getWeak_separation2());
					opt4Label.setText(oh.getWeak_separation4());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(true);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					opt3Label.setVisible(true);
					wordLabel.setLayoutX(430);
					wordLabel.setLayoutY(390);
					wordTextField.setLayoutX(495);
					wordTextField.setLayoutY(386);
					wordLabel.setText("Sequcence: ");

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(weakSeparationObj.getWeakSeparationKClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(weakSeparationObj.getWeakSeparationVerboseClassList());

				}

				else if (newValue.equals(bial.getWeak_separation_length()))
				{
					opt2Label.setText(oh.getWeak_separation_length2());
					opt3Label.setText(oh.getWeak_separation_length3());
					opt4Label.setText(oh.getWeak_separation_length4());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);


					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(weakSeparationLengthObj.getWeakSeparationLengthLengthClassList());
					options3ListView.setItems(weakSeparationLengthObj.getWeakSeparationLengthKClassList());
					options4ListView.setItems(weakSeparationLengthObj.getWeakSeparationLengthVerboseClassList());
				}

				else if (newValue.equals(bial.getWeakly_live()) && !fileTextField.getText().trim().isEmpty())
				{
					opt2Label.setText(oh.getWeakly_live2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					catFile_GetTransitions(fileTextField.getText());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getWord()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(true);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					wordLabel.setLayoutX(250);
					wordLabel.setLayoutY(250);
					wordTextField.setLayoutX(350);
					wordTextField.setLayoutY(246);
					wordLabel.setText("Word: ");

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getExtend_lts2()))
				{
					opt2Label.setText(oh.getExtend_lts2());
					opt3Label.setText(oh.getExtend_lts3());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(true);
					setEventVisible(false);
					secondFileTextField.setVisible(true);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(extendLts.getExtendLtsGClassList());
					options3ListView.setItems(extendLts.getExtendLtsModeClassList());
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getFind_words2()))
				{
					opt2Label.setText(oh.getFind_words2());
					opt3Label.setText(oh.getFind_words3());
					opt4Label.setText(oh.getFind_words4());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(true);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					wordLabel.setLayoutX(250);
					wordLabel.setLayoutY(200);
					wordTextField.setLayoutX(350);
					wordTextField.setLayoutY(196);
					wordLabel.setText("Alphabet: ");

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(findWords.getFindWordsOptionsClassList());
					options3ListView.setItems(findWords.getFindWordsOperationsClassList());
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getGdiam2()) && !fileTextField.getText().trim().isEmpty())
				{
					opt2Label.setText(oh.getGdiam2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					catFile_GetLabels(fileTextField.getText());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getLabel_separation2()) && !fileTextField.getText().trim().isEmpty())
				{
					opt2Label.setText(oh.getLabel_separation2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					catFile_GetLabels(fileTextField.getText());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getOverapproximate_synthesize2()))
				{
					opt2Label.setText(oh.getOverapproximate_synthesize2());
					opt3Label.setText(oh.getOverapproximate_synthesize2());
					opt4Label.setText(oh.getOverapproximate_synthesize2());
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(overapproximateSynthesize.getOverapproximateSynthesizeOptionsClassList());
					options3ListView.setItems(overapproximateSynthesize.getOverapproximateSynthesizeOptionsClassList());
					options4ListView.setItems(overapproximateSynthesize.getOverapproximateSynthesizeOptionsClassList());

				}

				else if (newValue.equals(bial.getPn_extend_and_synthesize2()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(true);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(pnExtendAndSynthesize.getPnExtendAndSynthesizeOptionsClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getProduct_async2()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(true);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getProduct_sync2()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(true);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getRegular_language_to_lts2()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(true);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					wordLabel.setLayoutX(250);
					wordLabel.setLayoutY(250);
					wordTextField.setLayoutX(350);
					wordTextField.setLayoutY(246);
					wordLabel.setText("Word: ");

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(regularLanguageToLts.getRegularLanguageToLtsOperationsClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getSynthesize2()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(synthesize.getSynthesizeOptionsClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getUse_petrify2()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(usePetrify.getUsePetrifyDeadClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getWord_synthesize2()))
				{
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(true);
					setOutputFileButtonVisible(false);
					setEventVisible(false);
					wordLabel.setLayoutX(250);
					wordLabel.setLayoutY(250);
					wordTextField.setLayoutX(350);
					wordTextField.setLayoutY(246);
					wordLabel.setText("Word: ");

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(wordSynthesize.getWordSynthesizeOptionsClassList());
					options3ListView.setItems(wordSynthesize.getWordSynthesizeOptionsClassList());
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getBistate_philnet_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(bistatePhilnetGenerator.getBistatePhilnetGeneratorNClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getBitnet_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(bitnetGenerator.getBitnetGeneratorNClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getConnected_bitnet_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(connectedBitnetGenerator.getConnectedBitnetGeneratorNClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getCycle_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(cycleGenerator.getCycleGeneratorNClassList());
					options3ListView.setItems(cycleGenerator.getCycleGeneratorInitClassList());
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getGenerate_reverse_arc()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(true);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getQuadstate_philnet_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(quadstatePhilnetGenerator.getQuadstatePhilnetGeneratorNClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getRandom_t_net_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(randomTNetGenerator.getRandomTNetGeneratorGClassList());
					options3ListView.setItems(randomTNetGenerator.getRandomTNetGeneratorKClassList());
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getTnet_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(true);
					setOptions4Visible(true);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(tNetGenerator.gettNetGeneratorNPClassList());
					options3ListView.setItems(tNetGenerator.gettNetGeneratorNTClassList());
					options4ListView.setItems(tNetGenerator.gettNetGeneratorMClassList());

				}

				else if (newValue.equals(bial.getTristate_philnet_generator()))
				{
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(true);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(tristatePhilnetGenerator.getTristatePhilnetGeneratorNClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getCreate_lts2()))
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(true);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(null);
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}

				else if (newValue.equals(bial.getExtend_deterministic_persistent2()))
				{
					opt2Label.setText(oh.getExtend_deterministic_persistent2());
					setOptions2Visible(true);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setOptionalValueVisible(false);
					setSecondFileFieldsVisible(false);
					setInfoButtonEnable(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);
					setEventVisible(false);

					optionalInfoLabel.setVisible(false);
					optionalValueCheckBox.setVisible(false);
					optionalValueTextField.setDisable(false);

					options2ListView.setItems(extendDeterministicPersistent.getExtendDeterministicPersistentClassList());
					options3ListView.setItems(null);
					options4ListView.setItems(null);

				}


				else
				{
					setOptions2Visible(false);
					setOptions3Visible(false);
					setOptions4Visible(false);
					setSecondFileFieldsVisible(false);
					setOptionalValueVisible(false);
					setWordFieldsVisible(false);
					setOutputFileButtonVisible(false);

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
				if (option1Value.equals(bial.getHelp()) && options2ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getCheck()) && options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getCovered_by_invariant())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getFire_sequence())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getInvariants())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getPn_analysis())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !wordTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getStrong_separation_length())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !wordTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getExtend_lts2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty()
						&& !secondFileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getFind_words2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& !wordTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getGdiam2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}

				if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLabel_separation2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}

				if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getOverapproximate_synthesize2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}
			}
		});

		options3ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				option3Value = newValue;
				if (option1Value.equals(bial.getCheck()) && options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getCovered_by_invariant())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getExtend_lts2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& !fileTextField.getText().trim().isEmpty()
						&& !secondFileTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}

				if (option1Value.equals(bial.getFind_words2())
						&& options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& !wordTextField.getText().trim().isEmpty())
				{
					setInfoButtonEnable(true);
				}
			}
		});

		options4ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				option4Value = newValue;
				if (option1Value.equals(bial.getCheck()) && options2ListView.getSelectionModel().getSelectedIndex() > -1
						&& options3ListView.getSelectionModel().getSelectedIndex() > -1
						&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
				{
					setInfoButtonEnable(true);
				}
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
		// TODO

	}

	@FXML
	void infoAboutNetButton_OnAction(ActionEvent event)
	{

		if (!fileTextField.getText().trim().isEmpty()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getHelp()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getBisimulation()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getBounded()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getCheck()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getCovered_by_invariant()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getFairness()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getFire_sequence()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getInvariants()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getIsomorphism()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getLanguage_equivalence()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getPn_analysis()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getSimply_live()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getStrong_separation()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getStrong_separation_length()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getStrongly_live()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getSum_async()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getSum_sync()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getWeak_separation()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getWeak_separation_length()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getWeakly_live()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getWord()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getExtend_lts2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getFind_words2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getGdiam2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getLabel_separation2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getOverapproximate_synthesize2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getPn_extend_and_synthesize2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getProduct_async2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getProduct_sync2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getRegular_language_to_lts2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getSynthesize2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getUse_petrify2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getWord_synthesize2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getBistate_philnet_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getBitnet_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getConnected_bitnet_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getCycle_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getGenerate_reverse_arc()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getQuadstate_philnet_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getRandom_t_net_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getTnet_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getTristate_philnet_generator()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getCreate_lts2()
				&& options1ListView.getSelectionModel().getSelectedItem() != bial.getExtend_deterministic_persistent2())
		{
			option2Value = "";
			JarProcess(jarFile);

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getHelp()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getExtend_deterministic_persistent2()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getExtend_deterministic_persistent2()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}



		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCreate_lts2()
				&& !fileTextField.getText().trim().isEmpty()
				&& secondFileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCreate_lts2()
				&& !fileTextField.getText().trim().isEmpty()
				&& !secondFileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), secondFileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getBounded()
				&& !fileTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() > 0)
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getBounded()
				&& !fileTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() == 0)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getTristate_philnet_generator()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getGenerate_reverse_arc()
				&& !eventTextField1.getText().trim().isEmpty() && !eventTextField2.getText().trim().isEmpty()
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), eventTextField1.getText(), eventTextField2.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getTnet_generator()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, option3Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getTnet_generator()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, option3Value, option4Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCycle_generator()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0)
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCycle_generator()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, option3Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getRandom_t_net_generator()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0)
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getRandom_t_net_generator()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, option3Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getBitnet_generator()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getQuadstate_philnet_generator()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getConnected_bitnet_generator()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getBistate_philnet_generator()
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
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getUse_petrify2()
				&& !fileTextField.getText().trim().isEmpty())
		{
			String cmd = "";
			if (option2Value.equals("[no dead]"))
			{
				cmd = "";
			} else if (option2Value.equals("dead"))
			{
				cmd = "dead";
			}
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), cmd);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWord_synthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !wordTextField.getText().trim().isEmpty())
		{
			String cmd = "";
			if (!option2Value.equals("") && !option3Value.equals(""))
			{
				cmd = option2Value + "," + option3Value;
			} else if (!option2Value.equals("") && option3Value.equals(""))
			{
				cmd = option2Value;
			}

			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, cmd, wordTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getSynthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getRegular_language_to_lts2()
				&& !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, wordTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getPn_extend_and_synthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !secondFileTextField.getText().trim().isEmpty() && !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, fileTextField.getText(), secondFileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getOverapproximate_synthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			String cmd = option2Value + "," + option3Value + "," +  option4Value;
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, cmd, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getOverapproximate_synthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			String cmd = option2Value + "," + option3Value;
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, cmd, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getOverapproximate_synthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
				&& options4ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			String cmd = option2Value;
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, cmd, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getOverapproximate_synthesize2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			String cmd = option2Value + "," + option4Value;
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, cmd, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);

			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWord()
				&& !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				String opt2 = "\"" + ":" + wordTextField.getText() + "\"";
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), opt2);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFire_sequence()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getSimply_live()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getSimply_live()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrongly_live()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrongly_live()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getLabel_separation2()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getGdiam2()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeakly_live()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeakly_live()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFairness()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFairness()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFairness()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& !fileTextField.getText().trim().isEmpty())
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getPn_analysis()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1
				&& !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), option2Value, option3Value, option4Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getPn_analysis()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 0
				&& !fileTextField.getText().trim().isEmpty())
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getPn_analysis()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
				&& options4ListView.getSelectionModel().getSelectedIndex() < 0
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrong_separation_length()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
				&& options4ListView.getSelectionModel().getSelectedIndex() < 1)
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrong_separation_length()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 1)
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrong_separation_length()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > 0)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), option2Value, option3Value, "verbose");

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeak_separation_length()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0
				&& options4ListView.getSelectionModel().getSelectedIndex() < 1)
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeak_separation_length()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 1)
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeak_separation_length()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > 0)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), option2Value, option3Value, "verbose");

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFind_words2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option2Value, option3Value, wordTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrong_separation()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 1
				&& !fileTextField.getText().trim().isEmpty() && !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				String cmd = wordTextField.getText();
				cmd = "\"" + cmd + "\"";
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), cmd, option2Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getStrong_separation()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > 0
				&& !fileTextField.getText().trim().isEmpty() && !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				String cmd = wordTextField.getText();
				cmd = "\"" + cmd + "\"";
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), cmd, option2Value, option4Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeak_separation()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() > 0
				&& !fileTextField.getText().trim().isEmpty() && !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				String cmd = wordTextField.getText();
				cmd = "\"" + cmd + "\"";
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), cmd, option2Value, "verbose");

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getWeak_separation()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options4ListView.getSelectionModel().getSelectedIndex() < 1
				&& !fileTextField.getText().trim().isEmpty() && !wordTextField.getText().trim().isEmpty())
		{
			try
			{
				String cmd = wordTextField.getText();
				cmd = "\"" + cmd + "\"";
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), cmd, option2Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getCheck()
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, option4Value, option2Value, option3Value);

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getInvariants()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getInvariants()
				&& !selectFileButton.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0)
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
				showPetriInfo(strFileContents);
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getSum_async()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getProduct_sync2()
				&& !secondFileTextField.getText().trim().isEmpty() && !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), secondFileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getProduct_async2()
				&& !secondFileTextField.getText().trim().isEmpty() && !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), secondFileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getExtend_lts2()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& !secondFileTextField.getText().trim().isEmpty() && !fileTextField.getText().trim().isEmpty())
		{
			try
			{
				ProcessBuilder pb = new ProcessBuilder("java", "-jar", startDir + sep + "apt" + sep + "apt.jar",
						option1Value, fileTextField.getText(), option2Value, option3Value,
						secondFileTextField.getText());

				Process p = pb.start();
				BufferedInputStream in = new BufferedInputStream(p.getInputStream());
				byte[] contents = new byte[1024];

				int bytesRead = 0;
				String strFileContents = "";
				while ((bytesRead = in.read(contents)) != -1)
				{
					strFileContents += new String(contents, 0, bytesRead);
				}
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getSum_sync()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getIsomorphism()
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
				showPetriInfo(strFileContents);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (options1ListView.getSelectionModel().getSelectedItem() == bial.getLanguage_equivalence()
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
				showPetriInfo(strFileContents);
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
				showPetriInfo(strFileContents);
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
			opt2Label.setVisible(true);
		} else
		{
			options2ListView.setVisible(false);
			opt2Label.setVisible(false);
		}
	}

	private void setOptions4Visible(boolean vis)
	{
		if (vis)
		{
			options4ListView.setVisible(true);
			opt4Label.setVisible(true);
		} else
		{
			options4ListView.setVisible(false);
			opt4Label.setVisible(false);
		}
	}

	private void setWarningVisible(boolean vis)
	{
		if (vis)
		{
			warningLabel.setVisible(true);
		} else
		{
			warningLabel.setVisible(false);
		}
	}

	private void setWordFieldsVisible(boolean vis)
	{
		if (vis)
		{
			wordLabel.setVisible(true);
			wordTextField.setVisible(true);
		}

		else
		{
			wordLabel.setVisible(false);
			wordTextField.setVisible(false);
		}
	}

	private void setOptions3Visible(boolean vis)
	{
		if (vis)
		{
			options3ListView.setVisible(true);
			opt3Label.setVisible(true);
		} else
		{
			options3ListView.setVisible(false);
			opt3Label.setVisible(false);
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
				showPetriInfo(strFileContents);
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
				showPetriInfo(strFileContents);
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
			checkFileLTSorNET(options1ListView.getSelectionModel().getSelectedIndex(), secondFileTextField.getText());
		}

		if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getBisimulation()) && file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getBisimulation())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getIsomorphism()) && file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getIsomorphism())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLanguage_equivalence())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLanguage_equivalence())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_async())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_async())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}


		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_sync())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_sync())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getExtend_lts2())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getExtend_lts2())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1 && file == null)
		{
			setInfoButtonEnable(false);
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
			checkFileLTSorNET(options1ListView.getSelectionModel().getSelectedIndex(), fileTextField.getText());

		}

		if (!option1Value.equals("") && !fileTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(true);
		} else
		{
			setInfoButtonEnable(false);
		}

		if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFire_sequence() && file != null
				|| options1ListView.getSelectionModel().getSelectedItem() == bial.getSimply_live() && file != null
				|| options1ListView.getSelectionModel().getSelectedItem() == bial.getStrongly_live() && file != null
				|| options1ListView.getSelectionModel().getSelectedItem() == bial.getWeakly_live() && file != null)
		{
			catFile_GetTransitions(file.getAbsolutePath());
		}

		if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFairness() && file != null
				&& options1ListView.getSelectionModel().getSelectedIndex() < 40)
		{
			opt2Label.setText(oh.getFairness2());
			opt3Label.setText(oh.getFairness3());
			setOptions2Visible(true);
			options2ListView.setItems(fairnessObj.getFairnessClassList());
			catFile_GetTransitions3List(file.getAbsolutePath());
		}

		if (options1ListView.getSelectionModel().getSelectedItem() == bial.getFairness() && file != null
				&& options1ListView.getSelectionModel().getSelectedIndex() > 40)
		{
			opt2Label.setText(oh.getFairness2());
			opt3Label.setText(oh.getFairness3());
			setOptions2Visible(true);
			options2ListView.setItems(fairnessObj.getFairnessClassList());
			catFile_GetLabels3List(file.getAbsolutePath());
		}

		if (options1ListView.getSelectionModel().getSelectedItem() == bial.getGdiam2() && file != null
				|| options1ListView.getSelectionModel().getSelectedItem() == bial.getLabel_separation2()
						&& file != null)
		{
			catFile_GetLabels(file.getAbsolutePath());
		}

		if (!secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getBisimulation())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getBisimulation())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getCovered_by_invariant()))
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getFire_sequence()))
		{
			setInfoButtonEnable(false);
			opt2Label.setText(oh.getFire_sequence2());
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getInvariants())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getInvariants())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getIsomorphism())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getIsomorphism())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLanguage_equivalence())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLanguage_equivalence())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getPn_analysis())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getPn_analysis())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getPn_analysis())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSimply_live()))
		{
			opt2Label.setText(oh.getSimply_live2());
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeakly_live()))
		{
			opt2Label.setText(oh.getWeakly_live2());
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrongly_live()))
		{
			opt2Label.setText(oh.getStrongly_live2());
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& !wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation_length())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getStrong_separation_length())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getStrong_separation_length())
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getStrong_separation_length())
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& !wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& !wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getWeak_separation())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}


		else if (option1Value.equals(bial.getWeak_separation_length())
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getWeak_separation_length())
				&& options4ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(false);
		}

		else if (secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_async())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_async())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_sync())
				&& file != null)
		{
			setInfoButtonEnable(false);
		}

		else if (!secondFileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getSum_sync())
				&& file != null)
		{
			setInfoButtonEnable(true);
		}

		else if (option1Value.equals(bial.getWord())
				&& wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getWord())
				&& !wordTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(true);
		}

		else if (option1Value.equals(bial.getCreate_lts2())
				&& !fileTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(true);
		}

		else if (option1Value.equals(bial.getCreate_lts2())
				&& fileTextField.getText().trim().isEmpty())
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getExtend_lts2())
				&& !fileTextField.getText().trim().isEmpty() && !secondFileTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(true);
		}

		else if (option1Value.equals(bial.getExtend_lts2())
				&& !fileTextField.getText().trim().isEmpty() && !secondFileTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1
				&& options3ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getExtend_lts2())
				&& fileTextField.getText().trim().isEmpty() && !secondFileTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (option1Value.equals(bial.getExtend_lts2())
				&& !fileTextField.getText().trim().isEmpty() && secondFileTextField.getText().trim().isEmpty()
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0
				&& options3ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getGdiam2()))
		{
			opt2Label.setText(oh.getGdiam2());
			catFile_GetLabels(fileTextField.getText());
			setInfoButtonEnable(false);
		}

		else if (fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLabel_separation2()))
		{
			opt2Label.setText(oh.getLabel_separation2());
			catFile_GetLabels(fileTextField.getText());
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getLabel_separation2()))
		{
			opt2Label.setText(oh.getLabel_separation2());
			catFile_GetLabels(fileTextField.getText());
			setInfoButtonEnable(true);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getOverapproximate_synthesize2())
				&& options2ListView.getSelectionModel().getSelectedIndex() < 0)
		{
			setInfoButtonEnable(false);
		}

		else if (!fileTextField.getText().trim().isEmpty() && option1Value.equals(bial.getOverapproximate_synthesize2())
				&& options2ListView.getSelectionModel().getSelectedIndex() > -1)
		{
			setInfoButtonEnable(true);
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

	void setEventVisible(boolean vis)
	{
		if (!vis)
		{
			eventLabel1.setVisible(false);
			eventLabel2.setVisible(false);
			eventTextField1.setVisible(false);
			eventTextField2.setVisible(false);
		} else
		{
			eventLabel1.setVisible(true);
			eventLabel2.setVisible(true);
			eventTextField1.setVisible(true);
			eventTextField2.setVisible(true);
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

	void checkFileLTSorNET(int selected_index, String path)
	{
		if (!path.equals(""))
		{
			if (path.toLowerCase().contains("-net"))
			{
				if (selected_index > 66 && selected_index < 107)
				{
					setWarningVisible(true);
					warningLabel.setText("YOU NEED TO SELECT '-AUT' FILE. THIS FILE MAY NOT WORK CORRETLY");
				} else
				{
					setWarningVisible(false);
				}
			} else if (path.toLowerCase().contains("-aut"))
			{
				if (selected_index < 66)
				{
					setWarningVisible(true);
					warningLabel.setText("YOU NEED TO SELECT '-NET' FILE. THIS FILE MAY NOT WORK CORRETLY");
				} else
				{
					setWarningVisible(false);
				}
			}
		}

	}

	void catFile_GetLabels(String path)
	{
		ObservableList<String> tempList = FXCollections.observableArrayList();
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
							tempList.add(line);
					}
				}
			}

			setOptions2Visible(true);
			options2ListView.setItems(tempList);
		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

	}

	void catFile_GetTransitions(String path)
	{
		ObservableList<String> tempList = FXCollections.observableArrayList();
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
							tempList.add(line);
					}
				}
			}

			setOptions2Visible(true);
			options2ListView.setItems(tempList);
		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

	}

	void catFile_GetTransitions3List(String path)
	{
		ObservableList<String> tempList = FXCollections.observableArrayList();
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
							tempList.add(line);
					}
				}
			}

			setOptions3Visible(true);
			options3ListView.setItems(tempList);
		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

	}


	void catFile_GetLabels3List(String path)
	{
		ObservableList<String> tempList = FXCollections.observableArrayList();
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
							tempList.add(line);
					}
				}
			}

			setOptions3Visible(true);
			options3ListView.setItems(tempList);
		}

		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

	}

	@FXML
	void outputFileButton_OnAction(ActionEvent event)
	{
		File file;
		File directory = new File(startDir);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Output File");
		fileChooser.setInitialDirectory(directory);
		// FileChooser.ExtensionFilter extFilter = new
		// FileChooser.ExtensionFilter("all files", "*.");
		// fileChooser.getExtensionFilters().add(extFilter);

		file = fileChooser.showSaveDialog(stage);
		if (file != null)
		{
			secondFileTextField.setText(file.getAbsolutePath());
		}
	}

	private void setOutputFileButtonVisible(boolean vis)
	{
		if (vis)
		{
			outputFileButton.setVisible(true);
		} else
		{
			outputFileButton.setVisible(false);
		}
	}

	private void showPetriInfo(String message)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("PetriInfo.fxml"));

			Scene scene = new Scene(fxmlLoader.load(), 600, 700);
			scene.getStylesheets().add(getClass().getResource("petrinet.css").toExternalForm());
			aptStage = new Stage();
			aptStage.setTitle("Petri Information");
			aptStage.setScene(scene);
			aptStage.getIcons()
					.add(new Image(MainWindowController.class.getResourceAsStream("resources/petrinet-icon.png")));
			aptStage.show();
			PetriInfoController controller = fxmlLoader.<PetriInfoController>getController();
			controller.initialize(message);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
