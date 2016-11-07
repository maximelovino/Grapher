package ch.hepia.it.geom2D;

import java.awt.*;

/**
 * @author Maxime Lovino
 * @date 07.11.16
 * @package ch.hepia.it.geom2D
 * @project TP4
 */

public interface Object2D {
	public abstract void draw(Graphics g, int rectSize, int margin, double minX, double maxX, double minY, double maxY, int width, int height);
}
