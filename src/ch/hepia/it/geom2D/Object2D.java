package ch.hepia.it.geom2D;

import java.awt.*;

/**
 * Interface to declare method for Object2D
 */
public interface Object2D {

	/**
	 * Method to draw the Object2D on a graphics context
	 *
	 * @param g        The graphics context
	 * @param rectSize The size of the rectangle used to represent a point
	 * @param margin   The margin of the grapher view
	 * @param minX     The minX of our view
	 * @param maxX     The maxX of our view
	 * @param minY     The minY of our view
	 * @param maxY     The maxY of our view
	 * @param width    The width of our viewport
	 * @param height   The height of our viewport
	 */
	void draw (Graphics g, int rectSize, int margin, double minX, double maxX, double minY, double maxY, int width, int height);
}
