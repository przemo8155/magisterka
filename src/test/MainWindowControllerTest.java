package test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import application.Counters;
import javafx.animation.FadeTransition;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class MainWindowControllerTest
{

	@Test(expected = ExceptionInInitializerError.class)
	public void testSetMiddleLabelText()
	{
		Label middleLabel = new Label();
		middleLabel.setDisable(false);
		middleLabel.setText("text");

		FadeTransition ft = new FadeTransition(Duration.millis(1200), middleLabel);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setAutoReverse(false);
		ft.play();
		middleLabel.setDisable(true);
		assertEquals("message", "hej", "text");

	}

	@Test(expected = IllegalStateException.class)
	public void testAnchorPane_OnMouseClicked()
	{
		Counters c = new Counters();
		ObservableList<Circle> circ = FXCollections.observableArrayList();
		circ.add(new Circle(10.0f));
		c.circleCounter(circ, new Label(circ.toString()));
	}

	@Test
	public void testMainPane_OnMouseClicked()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testMainPane_OnMouseDragged()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testInitialize()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testExitMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSettingsMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSaveFileMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testOpenFileMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testClearAllButton_OnMouseClicked()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testMainPane_OnDragDropped()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testMainPane_OnMouseReseased()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testMainPane_OnMouseMoved()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAboutMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testInitializeStats()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testMainPane_AddEventHandlerClick()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRefreshLine()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetBackgroundColor()
	{
		Pane pane = new Pane();
		String backgroundColor = null;
		pane.setStyle("-fx-background-color: " + backgroundColor);
	}

	@Test
	public void testSetCircleColor()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetRectangleColor()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetArrowColor()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetArrowColor()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testPane()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetBitmapToken()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testOpenAPTFileMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetAptStage()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddTagToggleButton_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveTagToggleButton_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTag()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testShowStatisticsMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testExportPdfMenuItem_OnAction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMainPane()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetMainPane()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetCircleList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetCircleList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetRectangleList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetRectangleList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeadArrowList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetHeadArrowList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetLeftDoubleArrowList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetLeftDoubleArrowList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetRightDoubleArrowList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetRightDoubleArrowList()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testReadFile()
	{
		fail("Not yet implemented");
	}

}
