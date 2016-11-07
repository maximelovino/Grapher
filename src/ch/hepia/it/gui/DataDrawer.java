package ch.hepia.it.gui;

import ch.hepia.it.geom2D.Object2D;
import ch.hepia.it.utils.DataPoints;

import javax.swing.*;
import java.awt.*;

public class DataDrawer extends JPanel {
	private DataPoints data;
	private int boundsMargin;
	private int rectSize;

	public DataDrawer(DataPoints data, int width, int height, int boundsMargin,int rectSize){
		super();
		this.data = data;
		this.boundsMargin = boundsMargin;
		this.rectSize = rectSize;
		this.setPreferredSize(new Dimension(width,height));
	}



	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawRect(boundsMargin,boundsMargin,this.getWidth()-2*boundsMargin,this.getHeight()-2*boundsMargin);
		//g.setXORMode(Color.red);
		g.setColor(Color.BLUE);
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
		for (Object2D entry : this.data.getData()) {
			entry.draw(g,rectSize,boundsMargin,data.getMinX(),data.getMaxX(),data.getMinY(),data.getMaxY(), this.getWidth(), this.getHeight());
		}

	}
}
