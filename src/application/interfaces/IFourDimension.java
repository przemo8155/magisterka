package application.interfaces;

import application.HeadArrow;
import application.LeftDoubleArrow;
import application.RightDoubleArrow;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public interface IFourDimension
{
	public Circle getC();

	public void setC(Circle c);

	public void setR(Rectangle r);

	public Rectangle getR();

	public LeftDoubleArrow getLda();

	public void setLda(LeftDoubleArrow ha);

	public Label getL();

	public void setL(Label l);

	public HeadArrow getHa();

	public void setHa(HeadArrow ha);

	public RightDoubleArrow getRda();

	public void setRda(RightDoubleArrow ha);
}
