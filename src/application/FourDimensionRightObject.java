package application;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class FourDimensionRightObject implements FourDimension
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

	@Override
	public Circle getC()
	{
		return c;
	}

	@Override
	public void setC(Circle c)
	{
		this.c = c;
	}

	@Override
	public Rectangle getR()
	{
		return r;
	}

	@Override
	public void setR(Rectangle r)
	{
		this.r = r;
	}

	@Override
	public RightDoubleArrow getRda()
	{
		return ha;
	}

	@Override
	public void setRda(RightDoubleArrow ha)
	{
		this.ha = ha;
	}

	@Override
	public Label getL()
	{
		return l;
	}

	@Override
	public void setL(Label l)
	{
		this.l = l;
	}

	@Override
	public LeftDoubleArrow getLda()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLda(LeftDoubleArrow ha)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public HeadArrow getHa()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHa(HeadArrow ha)
	{
		// TODO Auto-generated method stub

	}


}
