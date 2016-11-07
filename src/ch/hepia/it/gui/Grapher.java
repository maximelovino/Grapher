package ch.hepia.it.gui;

import ch.hepia.it.utils.DataPoints;

import javax.swing.*;

public class Grapher {
	public static void main (String[] args) {
		DataPoints data = new DataPoints("data/test.txt");
		System.out.println(data.getCount());
		System.out.println("minX: "+data.getMinX());
		System.out.println("maxX: "+data.getMaxX());
		System.out.println("minY: "+data.getMinY());
		System.out.println("maxY: "+data.getMaxY());
		DataDrawer drawer = new DataDrawer(data,600,400,10,10);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(drawer,"Center");
		frame.setTitle("Grapher");
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
