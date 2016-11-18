package ch.hepia.it.geom2D;

import java.awt.*;

/**
 * Class for a 2D line implementation, we implement Object2D interface
 */
public class Line2D implements Object2D {
	private Point2D point;
	private Double slope;

	/**
	 * Main constructor for Line
	 *
	 * @param point A point of the line
	 * @param slope The slope of the line
	 */
	public Line2D (Point2D point, Double slope) {
		this.point = point;
		this.slope = slope;
	}

	/**
	 * Constructor from a y intersect value and a slope
	 *
	 * @param slope The slope of the line
	 * @param y     The y intersect of the line
	 */
	public Line2D (Double slope, Double y) {
		this(new Point2D(0.0, y), slope);
	}

	/**
	 * Constructor from two points
	 *
	 * @param p1 A point
	 * @param p2 Another point
	 * @throws IllegalArgumentException If the two points are the same
	 */
	public Line2D (Point2D p1, Point2D p2) throws IllegalArgumentException {
		if (p1.equals(p2)) throw new IllegalArgumentException("Can't build a line with two equal points");

		Double slope;
		if (p1.getX() > p2.getX()) {
			slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
		} else {
			slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		}

		this.slope = slope;
		this.point = p1;
	}

	/**
	 * Getter for the point
	 *
	 * @return The point used to build the line
	 */
	public Point2D getPoint () {
		return point;
	}

	/**
	 * Setter for the point
	 *
	 * @param point The point we want to set
	 */
	public void setPoint (Point2D point) {
		this.point = point;
	}

	/**
	 * Getter for the slope
	 *
	 * @return The slope of the line
	 */
	public Double getSlope () {
		return slope;
	}

	/**
	 * Setter for the slope
	 *
	 * @param slope The slope we want to set
	 */
	public void setSlope (Double slope) {
		this.slope = slope;
	}

	/**
	 * Setter for the point and slope
	 *
	 * @param point The point we want to set
	 * @param slope The slope we want to set
	 */
	public void setPointSlope (Point2D point, Double slope) {
		this.point = point;
		this.slope = slope;
	}

	/**
	 * @return The x value of the intersection of the line with the X axis
	 */
	public Double getXIntersect () {
		return (this.getYIntersect() * -1) / this.getSlope();
	}

	/**
	 * @return The y value of the intersection of the line with the Y axis
	 */
	public Double getYIntersect () {
		if (this.point.getX() == 0.0) return this.point.getY();

		return this.point.getY() - this.getSlope() * this.point.getX();
	}

	/**
	 * @param point The point we want to check
	 * @return True if the point is contained in the line, false otherwise
	 */
	public boolean contains (Point2D point) {
		return point.getY() == point.getX() * this.slope + this.getYIntersect();
	}

	/**
	 * @param line The line we want to check parallelism with
	 * @return True if the lines are parallel, false otherwise
	 */
	public boolean isParallel (Line2D line) {
		return this.slope.equals(line.getSlope());
	}

	/**
	 * Override of the equals method
	 *
	 * @param obj The object we want to compare with
	 * @return True if they are the same Line, false otherwise
	 */
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Line2D)) {
			return false;
		}

		Line2D line = (Line2D) obj;

		return this.getSlope().equals(line.getSlope()) && this.contains(line.getPoint());
	}

	/**
	 * Override of the toString method
	 *
	 * @return A string representation of the line in the format "Point: <point>, Slope: <slope>"
	 */
	@Override
	public String toString () {
		return "Point: " + this.getPoint() + ", Slope: " + this.getSlope();
	}

	/**
	 * @return A string representation of the line as a StringBuilder instance
	 */
	public StringBuilder toStringBuilder () {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString());
		return sb;
	}

	/**
	 * Method to get the x coordinate of a point of the line from its y coordinate
	 *
	 * @param y The y coordinate
	 * @return The x coordinate of the point on the line
	 */
	private double xValueFromY (double y) {
		return (y - this.getYIntersect()) / this.slope;
	}

	/**
	 * Method to get the y coordinate of a point of the line from its x coordinate
	 *
	 * @param x The x coordinate
	 * @return The y coordinate of the point on the line
	 */
	private double yValueFromX (double x) {
		return this.slope * x + this.getYIntersect();
	}

	/**
	 * Implementation of the draw method from Object2D
	 */
	@Override
	public void draw (Graphics g, int rectSize, int margin, double minX, double maxX, double minY, double maxY, int width, int height) {
		Point2D borderLeft = new Point2D((minX), this.yValueFromX(minX));
		Point2D scaledBorderLeft = borderLeft.getScaledPoint(minX, maxX, minY, maxY, width, height);

		Point2D borderRight = new Point2D((maxX), this.yValueFromX(maxX));
		Point2D scaledBorderRight = borderRight.getScaledPoint(minX, maxX, minY, maxY, width, height);

		g.drawLine(scaledBorderLeft.getX().intValue(), scaledBorderLeft.getY().intValue(), scaledBorderRight.getX().intValue(), scaledBorderRight.getY().intValue());
	}
}
