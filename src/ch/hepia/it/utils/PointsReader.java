package ch.hepia.it.utils;

import ch.hepia.it.geom2D.Point2D;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class PointsReader {
	private String pathOfFile;

	public PointsReader (String pathOfFile) {
		this.pathOfFile = pathOfFile;
	}

	public ArrayList<Point2D> getPoints() throws FileFormatException, IOException {
		ArrayList<Point2D> points = new ArrayList<>();

		LineNumberReader reader = new LineNumberReader(new FileReader(this.pathOfFile));

		String line;

		while ((line=reader.readLine())!=null){
			String[] lineArray = line.split(" ");

			if (lineArray.length!=2 && lineArray.length!=4) throw new FileFormatException(reader.getLineNumber());

			double x = 0;
			double y = 0;

			for (int i = 0; i < lineArray.length; i++) {
				if (i%2==0){
					x = Double.valueOf(lineArray[i]);
				}else{
					y = Double.valueOf(lineArray[i]);
					points.add(new Point2D(x,y));
				}
			}
		}
		return points;
	}
}
