package ch.hepia.it.tests;

import ch.hepia.it.geom2D.Point2D;
import ch.hepia.it.utils.PointsReader;

import java.io.IOException;
import java.util.ArrayList;

public class TestPoints {
	public static void main (String[] args) {
		PointsReader reader = new PointsReader("data/test.txt");

		try {
			ArrayList<Point2D> points = reader.getPoints();
			System.out.println(points);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
