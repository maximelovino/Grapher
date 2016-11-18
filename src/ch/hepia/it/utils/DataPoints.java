package ch.hepia.it.utils;

import ch.hepia.it.geom2D.Line2D;
import ch.hepia.it.geom2D.Object2D;
import ch.hepia.it.geom2D.Point2D;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 * DataPoints class containing the parser for the file
 */
public class DataPoints {
	private String filePath;
	//We implement the data as an ArrayList of Object2D
	private ArrayList<Object2D> data;
	private double minX = Double.MAX_VALUE;
	private double maxX = Double.MIN_VALUE;
	private double minY = Double.MAX_VALUE;
	private double maxY = Double.MIN_VALUE;

	/**
	 * Constructor taking a filepath as arg
	 *
	 * @param filePath The path of the data file
	 */
	public DataPoints (String filePath) {
		this.filePath = filePath;
		data = new ArrayList<>();
		readData();
	}

	/**
	 * @return The number of Object2D in our data
	 */
	public int getCount () {
		return this.getData().size();
	}

	/**
	 * Parser method for the data file
	 */
	private void readData () {
		try {
			LineNumberReader reader = new LineNumberReader(new FileReader(filePath));
			String line;


			while ((line = reader.readLine()) != null) {
				ArrayList<Point2D> lineList = new ArrayList<>();
				String[] lineArray = line.split(" ");
				if (lineArray.length != 2 && lineArray.length != 4)
					throw new FileFormatException(reader.getLineNumber());

				double x = 0;
				double y = 0;

				for (int i = 0; i < lineArray.length; i++) {
					if (i % 2 == 0) {
						x = Double.valueOf(lineArray[i]);
						this.minX = Double.min(x, this.minX);
						this.maxX = Double.max(x, this.maxX);
					} else {
						y = Double.valueOf(lineArray[i]);
						this.minY = Double.min(y, this.minY);
						this.maxY = Double.max(y, this.maxY);
						lineList.add(new Point2D(x, y));
					}
				}
				for (Point2D point : lineList) {
					data.add(point);
				}

				if (lineList.size() == 2) {
					data.add(new Line2D(lineList.get(0), lineList.get(1)));
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return The minimal x coordinate from our data
	 */
	public double getMinX () {
		return minX;
	}

	/**
	 * @return The maximal x coordinate from our data
	 */
	public double getMaxX () {
		return maxX;
	}

	/**
	 * @return The minimal y coordinate from our data
	 */
	public double getMinY () {
		return minY;
	}

	/**
	 * @return The maximal y coordinate from our data
	 */
	public double getMaxY () {
		return maxY;
	}

	/**
	 * @return The data as an ArrayList of Object2D
	 */
	public ArrayList<Object2D> getData () {
		return data;
	}
}
