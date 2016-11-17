package ch.hepia.it.utils;

import ch.hepia.it.geom2D.Line2D;
import ch.hepia.it.geom2D.Object2D;
import ch.hepia.it.geom2D.Point2D;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class DataPoints{
	private String filePath;
	private ArrayList<Object2D> data;
	private double minX = Double.MAX_VALUE;
	private double maxX = Double.MIN_VALUE;
	private double minY = Double.MAX_VALUE;
	private double maxY = Double.MIN_VALUE;

	public DataPoints (String filePath) {
		this.filePath = filePath;
		data = new ArrayList<>();
		readData();
	}

	public int getCount(){
		return this.getData().size();
	}

	private void readData () {
		try {
			LineNumberReader reader = new LineNumberReader(new FileReader(filePath));
			String line;


			while ((line=reader.readLine())!=null){
				ArrayList<Point2D> lineList = new ArrayList<>();
				String[] lineArray = line.split(" ");
				if (lineArray.length!=2 && lineArray.length!=4) throw new FileFormatException(reader.getLineNumber());

				double x = 0;
				double y = 0;

				for (int i = 0; i < lineArray.length; i++) {
					if (i%2 == 0){
						x = Double.valueOf(lineArray[i]);
						this.minX = Double.min(x,this.minX);
						this.maxX = Double.max(x,this.maxX);
					}else{
						y = Double.valueOf(lineArray[i]);
						this.minY = Double.min(y,this.minY);
						this.maxY = Double.max(y,this.maxY);
						lineList.add(new Point2D(x,y));
					}
				}

				if (lineList.size() == 2){
					data.add(new Line2D(lineList.get(0),lineList.get(1)));
				}else{
					data.add(lineList.get(0));
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getMinX () {
		return minX;
	}

	public double getMaxX () {
		return maxX;
	}

	public double getMinY () {
		return minY;
	}

	public double getMaxY () {
		return maxY;
	}

	public ArrayList<Object2D> getData () {
		return data;
	}
}
