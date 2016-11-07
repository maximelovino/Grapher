package ch.hepia.it.geom2D;

import java.awt.*;

public class Point2D implements Object2D{
	private Double x = null;
	private Double y = null;

	public Point2D () {
	}

	public Point2D (Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Point2D (Point2D point){
		this.x = point.getX();
		this.y = point.getY();
	}

	public Point2D (Double[] coordinates){
		if (coordinates.length != 2) throw new IllegalArgumentException("The number of coordinates is invalid");

		this.x = coordinates[0];
		this.y = coordinates[1];
	}

	public boolean isDefined(){
		return this.x!=null && this.y!=null;
	}

	public Double getX () {
		return x;
	}

	public void setX (Double x) {
		this.x = x;
	}

	public Double getY () {
		return y;
	}

	public void setY (Double y) {
		this.y = y;
	}

	public Double dist (Point2D point){
		return Math.sqrt(Math.pow(this.getX()-point.getX(),2)+(Math.pow(this.getY()-point.getY(),2)));
	}

	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Point2D)){
			return false;
		}

		Point2D otherPoint = (Point2D) obj;

		return this.getX() == otherPoint.getX() && this.getY() == otherPoint.getY();
	}

	@Override
	public String toString () {
		//output format (x,y)
		return "("+this.getX()+","+this.getY()+")";
	}

	@Override
	public void draw(Graphics g, int rectSize, int margin, double minX, double maxX, double minY, double maxY, int width, int height) {
		Double shift = rectSize / 2.0;

		Double xScaled = (this.getX()/maxX)*(width-margin);
		System.out.println("xscaled: "+xScaled);
		Double yScaled = (this.getY()/maxY)*(height-margin);
		System.out.println("yscaled: "+yScaled);

		Integer startX = Double.valueOf(xScaled-shift).intValue();
		Integer startY = Double.valueOf(yScaled-shift).intValue();

		g.drawRect(startX,startY,rectSize,rectSize);
	}
}
