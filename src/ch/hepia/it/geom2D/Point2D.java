package ch.hepia.it.geom2D;

import java.awt.*;

/**
 * Class for a 2D point implementation, we implement Object2D interface
 */
public class Point2D implements Object2D{
	private Double x = null;
	private Double y = null;

	/**
	 * Empty constructor for Point2D, not really useful
	 */
	public Point2D () {
	}

	/**
	 * Constructor from two coordinates
	 *
	 * @param x	The x coordinate
	 * @param y	The y coordinate
	 */
	public Point2D (Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Copy constructor from other Point2D
	 *
	 * @param point	The point to copy
	 */
	public Point2D (Point2D point){
		this.x = point.getX();
		this.y = point.getY();
	}

	/**
	 * Constructor from an array of coordinates, not really useful
	 *
	 * @param coordinates	An array of coordinates
	 */
	public Point2D (Double[] coordinates){
		if (coordinates.length != 2) throw new IllegalArgumentException("The number of coordinates is invalid");

		this.x = coordinates[0];
		this.y = coordinates[1];
	}

	/**
	 *
	 * @return	True if the point is defined, false otherwise, not really useful if we didn't have the empty constructor
	 */
	public boolean isDefined(){
		return this.x!=null && this.y!=null;
	}

	/**
	 *
	 * @return	The x coordinate of the point
	 */
	public Double getX () {
		return x;
	}

	/**
	 *
	 * @param x	The x we want to set
	 */
	public void setX (Double x) {
		this.x = x;
	}

	/**
	 *
	 * @return	The y coordinate of the point
	 */
	public Double getY () {
		return y;
	}

	/**
	 *
	 * @param y	The y we want to set
	 */
	public void setY (Double y) {
		this.y = y;
	}

	/**
	 *
	 * @param point	The point we want the distance from
	 * @return	The distance between this point and the point passed as arg
	 */
	public Double dist (Point2D point){
		return Math.sqrt(Math.pow(this.getX()-point.getX(),2)+(Math.pow(this.getY()-point.getY(),2)));
	}

	/**
	 * Override of the equals method
	 *
	 * @param obj	The object we want to compare to
	 * @return	True if they are the same, false otherwise
	 */
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Point2D)){
			return false;
		}

		Point2D otherPoint = (Point2D) obj;

		return this.getX() == otherPoint.getX() && this.getY() == otherPoint.getY();
	}

	/**
	 * Override of the toString method
	 *
	 * @return	The string representation of a point
	 */
	@Override
	public String toString () {
		//output format (x,y)
		return "("+this.getX()+","+this.getY()+")";
	}

	/**
	 * Implementation of the draw method from Object2D
	 */
	@Override
	public void draw(Graphics g, int rectSize, int margin, double minX, double maxX, double minY, double maxY, int width, int height) {
		Double shift = rectSize / 2.0;
		System.out.println(this);
		Point2D scaledPoint = getScaledPoint(minX, maxX, minY, maxY, width, height);

		Integer startX = Double.valueOf(scaledPoint.getX()-shift).intValue();
		Integer startY = Double.valueOf(scaledPoint.getY()-shift).intValue();
		System.out.println("startX: "+startX);
		System.out.println("startY: "+startY);

		g.drawRect(startX,startY,rectSize,rectSize);
	}

	/**
	 * Return a point scaled for our view in Grapher
	 *
	 * @param minX	The minX of our view
	 * @param maxX	The maxX of our view
	 * @param minY	The minY of our view
	 * @param maxY	The maxY of our view
	 * @param width	The width of our view
	 * @param height	The height of our view
	 * @return	The point in scaled coordinates
	 */
	public Point2D getScaledPoint(double minX, double maxX, double minY, double maxY, int width, int height){
		Double xScaled = width * (this.getX()-minX) / (maxX-minX);
		Double yScaled = height * (this.getY()-minY) / (maxY-minY);
		return new Point2D(xScaled,yScaled);
	}
}
