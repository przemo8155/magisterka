package application;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class FourDimensionRightObject
{
	public Circle c;
	public Rectangle r;
	public RightDoubleArrow ha;
	public Label l;


	public FourDimensionRightObject()
	{
		// TODO Auto-generated constructor stub
	}

	public FourDimensionRightObject(Rectangle r, RightDoubleArrow ha, Label l, Circle c)
	{
		this.r = r;
		this.ha = ha;
		this.l = l;
		this.c = c;
	}


	public Circle getC()
	{
		return c;
	}


	public void setC(Circle c)
	{
		this.c = c;
	}


	public Rectangle getR()
	{
		return r;
	}


	public void setR(Rectangle r)
	{
		this.r = r;
	}


	public RightDoubleArrow getHa()
	{
		return ha;
	}


	public void setHa(RightDoubleArrow ha)
	{
		this.ha = ha;
	}


	public Label getL()
	{
		return l;
	}


	public void setL(Label l)
	{
		this.l = l;
	}
}
