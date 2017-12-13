package application;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class FourDimensionLeftObject
{
	public Circle c;
	public Rectangle r;
	public LeftDoubleArrow ha;
	public Label l;


	public FourDimensionLeftObject()
	{
		// TODO Auto-generated constructor stub
	}

	public FourDimensionLeftObject(Rectangle r, LeftDoubleArrow ha, Label l, Circle c)
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


	public LeftDoubleArrow getHa()
	{
		return ha;
	}


	public void setHa(LeftDoubleArrow ha)
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
