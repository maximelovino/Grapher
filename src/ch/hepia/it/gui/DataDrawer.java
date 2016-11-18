package ch.hepia.it.gui;

import ch.hepia.it.geom2D.Object2D;
import ch.hepia.it.utils.DataPoints;

import javax.swing.*;
import java.awt.*;

/**
 * Drawing class to draw our Object2D
 */
public class DataDrawer extends JPanel {
	private DataPoints data;
	private int boundsMargin;
	private int rectSize;

	/**
	 * @param data         The datapoints we want to output
	 * @param width        The preferred width for our panel
	 * @param height       The preferred height for our panel
	 * @param boundsMargin The margin of our view
	 * @param rectSize     The size of the rectangles representing the points
	 */
	public DataDrawer (DataPoints data, int width, int height, int boundsMargin, int rectSize) {
		super();
		this.data = data;
		this.boundsMargin = boundsMargin;
		this.rectSize = rectSize;
		this.setPreferredSize(new Dimension(width, height));
	}

	/**
	 * @return The min Y for our view
	 */
	private double getMinY () {
		return data.getMinY() - boundsMargin;
	}

	/**
	 * @return The min X for our view
	 */
	private double getMinX () {
		return data.getMinX() - boundsMargin;
	}

	/**
	 * @return The max Y for our view
	 */
	private double getMaxY () {
		return data.getMaxY() + boundsMargin;
	}

	/**
	 * @return The max X for our view
	 */
	private double getMaxX () {
		return data.getMaxX() + boundsMargin;
	}

	/**
	 * Override of the paintComponent method from JPanel class
	 *
	 * @param g The graphics context
	 */
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
		for (Object2D entry : this.data.getData()) {
			entry.draw(g, rectSize, boundsMargin, this.getMinX(), this.getMaxX(), this.getMinY(), this.getMaxY(), this.getWidth(), this.getHeight());
		}

	}
}
