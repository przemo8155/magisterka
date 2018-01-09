
package application;

import application.interfaces.IFourDimension;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class FourDimensionObject implements IFourDimension
{

	public Circle c;
	public Rectangle r;
	public HeadArrow ha;
	public Label l;

	public FourDimensionObject()
	{
		// TODO Auto-generated constructor stub
	}

	public FourDimensionObject(Rectangle r, HeadArrow ha, Label l, Circle c)
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
	public HeadArrow getHa()
	{
		return ha;
	}

	@Override
	public void setHa(HeadArrow ha)
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
	public RightDoubleArrow getRda()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRda(RightDoubleArrow ha)
	{
		// TODO Auto-generated method stub

	}
}
