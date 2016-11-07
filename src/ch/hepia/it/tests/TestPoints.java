package ch.hepia.it.tests;

import ch.hepia.it.utils.DataPoints;

public class TestPoints {
	public static void main (String[] args) {
		DataPoints data = new DataPoints("data/test.txt");

		System.out.println(data.getData());
		System.out.println("minX:"+data.getMinX());
		System.out.println("maxX:"+data.getMaxX());
		System.out.println("minY:"+data.getMinY());
		System.out.println("maxY:"+data.getMaxY());
	}
}
