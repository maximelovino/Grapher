package ch.hepia.it.geom2D;

import java.awt.*;

public class Line2D implements Object2D{
	private Point2D point;
	private Double slope;

	/**
	 * Primary constructor for our Line2D
	 *
	 * @param point	A point of the line
	 * @param slope	The slope of the line
	 */
	public Line2D (Point2D point, Double slope) {
		this.point = point;
		this.slope = slope;
	}

	/**
	 * Constructor for our Line2D
	 *
	 * @param slope	The slope of the line
	 * @param y	The y intersection of the line
	 */
	public Line2D (Double slope, Double y) {
		this(new Point2D(0.0,y),slope);
	}

	/**
	 * Constructor for our Line2D taking two points
	 *
	 * @param p1	A point of our line
	 * @param p2	A second point of our line (different)
	 */
	public Line2D (Point2D p1, Point2D p2){
		if (p1.equals(p2)) throw new IllegalArgumentException("Can't build a line with two equal points");

		Double slope;
		if (p1.getX()>p2.getX()){
			slope = (p1.getY()-p2.getY())/(p1.getX()-p2.getX());
		}else{
			slope = (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
		}

		this.slope = slope;
		this.point = p1;
	}

	/**
	 * Getter for the point
	 *
	 * @return	The point used to build the line
	 */
	public Point2D getPoint () {
		return point;
	}

	/**
	 * Setter for the point
	 *
	 * @param point	The point we want to set
	 */
	public void setPoint (Point2D point) {
		this.point = point;
	}

	/**
	 * Getter for the slope
	 *
	 * @return	The slope of the line
	 */
	public Double getSlope () {
		return slope;
	}

	/**
	 * Setter for the slope
	 *
	 * @param slope	The slope we want to set
	 */
	public void setSlope (Double slope) {
		this.slope = slope;
	}

	/**
	 * Setter for the point and slope
	 *
	 * @param point	The point we want to set
	 * @param slope	The slope we want to set
	 */
	public void setPointSlope (Point2D point, Double slope){
		this.point = point;
		this.slope = slope;
	}

	/**
	 *
	 * @return	The y value of the intersection of the line with the X axis
	 */
	public Double getXIntersect(){
		//y=ax+b => ax+b = 0 => ax = -b => x = -b/a
		return (this.getYIntersect()*-1)/this.getSlope();
	}

	/**
	 *
	 * @return	The x value of the intersection of the line with the Y axis
	 */
	public Double getYIntersect(){
		if (this.point.getX() == 0.0){
			return this.point.getY();
		}

		return this.point.getY() - this.getSlope()*this.point.getX();
	}

	/**
	 *
	 * @param point	The point we want to check
	 * @return	True if the point is contained in the line, false otherwise
	 */
	public boolean contains(Point2D point){
		return point.getY() == point.getX()*this.slope+this.getYIntersect();
	}

	/**
	 *
	 * @param line	The line we want to check parallelism with
	 * @return	True if the lines are parallel, false otherwise
	 */
	public boolean isParallel (Line2D line){
		return this.slope.equals(line.getSlope());
	}

	/**
	 * Override of the equals method
	 *
	 * @param obj	The object we want to compare with
	 * @return	True if they are the same Line, false otherwise
	 */
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Line2D)){
			return false;
		}

		Line2D line = (Line2D) obj;

		return this.getSlope().equals(line.getSlope()) && this.contains(line.getPoint());
	}

	/**
	 *
	 * @return	A string representation of the line in the format "Point: <point>, Slope: <slope>"
	 */
	@Override
	public String toString () {
		return "Point: "+this.getPoint()+", Slope: "+this.getSlope();
	}

	/**
	 *
	 * @return	A string representation of the line as a StringBuilder instance
	 */
	public StringBuilder toStringBuilder(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString());
		return sb;
	}

	@Override
	public void draw(Graphics g, int rectSize, int margin, double minX, double maxX, double minY, double maxY, int width, int height) {
		Point2D p1 = this.getPoint();
		Point2D p2 = new Point2D(p1.getX()+80,p1.getY()+80*this.getSlope());
		System.out.println(p1+","+p2);

		p1 = p1.getScaledPoint(margin, minX, maxX, minY, maxY, width, height);
		p2 = p2.getScaledPoint(margin, minX, maxX, minY, maxY, width, height);
		g.drawLine(p1.getX().intValue(),p1.getY().intValue(),p2.getX().intValue(),p2.getY().intValue());

	}
}
