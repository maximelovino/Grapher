package ch.hepia.it.gui;

import ch.hepia.it.utils.DataPoints;

import javax.swing.*;

/**
 * Class containing the main of our program, used to launch the Grapher
 */
public class Grapher {
	public static void main (String[] args) {
		if (args.length < 1) {
			System.out.println("Please call the program by using: \n \nGrapher <pathOfDataFile>");
			System.exit(1);
		}
		DataPoints data = new DataPoints(args[0]);
		DataDrawer drawer = new DataDrawer(data, 600, 400, 1, 10);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(drawer, "Center");
		frame.setTitle("Grapher");
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
