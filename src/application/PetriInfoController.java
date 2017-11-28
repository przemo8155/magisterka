package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class PetriInfoController
{
	@FXML
	private Pane mainPane;

	@FXML
	private Button closeButton, copyButton;

	@FXML
	private TextArea messageTextArea;


	public PetriInfoController()
	{
		// TODO Auto-generated constructor stub
	}


	public void initialize(String message)
	{
		this.messageTextArea.setText(message);
	}

	public void setMessageInfo(String message)
	{
		this.messageTextArea.setText(message);
	}

	@FXML
	void copyButton_OnAction(ActionEvent event)
	{
		String text = messageTextArea.getText();
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(text);
		clipboard.setContent(content);
	}

	@FXML
	void closeButton_OnAction(ActionEvent event)
	{
		Stage closeStage = (Stage) closeButton.getScene().getWindow();
		closeStage.close();
	}

	public EventHandler<WindowEvent> event = new EventHandler<WindowEvent>()
	{

		@Override
		public void handle(WindowEvent event)
		{
			// TODO Auto-generated method stub

		}
	};
}
