package com.soc.gen.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.soc.gen.util.Point;
import com.soc.gen.util.ShapeDimensionsModel;

public class ColorImpl extends CanvasImpl {

    char [][]grid;
    
	private void colorBlock(Point sdm, char color) {
		grid[sdm.getY() - 1][sdm.getX() - 1] = color;
	}

	public void executeDrawCommand(ShapeDimensionsModel sdm) {
		int x = sdm.getX1();
		int y = sdm.getY1();
		grid=sdm.getGrid();
		char color = sdm.getColor();
		if (!sdm.coordinatesFitInCanvas(sdm))
			throw new RuntimeException("The supplied coordinate is outside of the current canvas");
		if (grid[y - 1][x - 1] == 'x') {
			return;
		}
		Point c = new Point(x, y);
		Queue<Point> q = new LinkedList<Point>();
		q.add(c);
		while (!q.isEmpty()) {
			Point topCel = q.poll();
			List<Point> lc = getCanvasEmptyCells(topCel, color, sdm);
			q.addAll(lc);
			colorBlock(topCel, color);
		}
		sdm.setGrid(grid);
		drawCanvas(sdm.getHeight(), sdm.getWidth(),sdm.getGrid());
	}

	private List<Point> getCanvasEmptyCells(Point c, char color, ShapeDimensionsModel sdm) {
		List<Point> li = new ArrayList<Point>();
		int x = c.getX();
		int y = c.getY();
		int x1 = x;
		int y1 = y + 1;
		if (y1 <= sdm.getHeight() && grid[y1 - 1][x1 - 1] != 'x' && grid[y1 - 1][x1 - 1] != color)
			li.add(new Point(x1, y1));
		// Upper cells
		int x2 = x;
		int y2 = y - 1;

		if (y2 >= 1 && grid[y2 - 1][x2 - 1] != 'x' && grid[y2 - 1][x2 - 1] != color)
			li.add(new Point(x2, y2));

		// Left Cells
		int x3 = x - 1;
		int y3 = y;

		if (x3 >= 1 && grid[y3 - 1][x3 - 1] != 'x' && grid[y3 - 1][x3 - 1] != color)
			li.add(new Point(x3, y3));

		// Right Cells
		int x4 = x + 1;
		int y4 = y;

		if (x4 <= sdm.getWidth() && grid[y4 - 1][x4 - 1] != 'x' && grid[y4 - 1][x4 - 1] != color)
			li.add(new Point(x4, y4));

		return li;
	}
}
