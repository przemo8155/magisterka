package application;


public class HeadArrow
{
	public double x1, y1, x2, y2;

	public HeadArrow(double ax1, double ay1, double ax2, double ay2)
	{
		double arrowAngle = Math.toRadians(25.0);
		double arrowLength = 30.0;
		double dx = ax1 - ax2;
		double dy = ay1 - ay2;
		double angle = Math.atan2(dy, dx);
		double x1 = Math.cos(angle + arrowAngle) * arrowLength + ax2;
		double y1 = Math.sin(angle + arrowAngle) * arrowLength + ay2;

		double x2 = Math.cos(angle - arrowAngle) * arrowLength + ax2;
		double y2 = Math.sin(angle - arrowAngle) * arrowLength + ay2;

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public final double getLeftX()
	{
		return this.x1;
	}

	public final double getRightX()
	{
		return this.x2;
	}

	public final double getLeftY()
	{
		return this.y1;
	}

	public final double getRightY()
	{
		return this.y2;
	}

	public final void setLeftX(double val)
	{
		this.x1 = val;
	}

	public final void setLeftY(double val)
	{
		this.y1 = val;
	}

	public final void setRightY(double val)
	{
		this.y2 = val;
	}

	public final void setRightX(double val)
	{
		this.x2 = val;
	}


}
