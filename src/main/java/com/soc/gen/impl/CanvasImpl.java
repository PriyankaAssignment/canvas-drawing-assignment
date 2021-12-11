package com.soc.gen.impl;

import com.soc.gen.ICanvas;
import com.soc.gen.util.ShapeDimensionsModel;

public class CanvasImpl implements ICanvas {
	int width;
	int height;
	public char[][] grid = null;

	public void executeDrawCommand(ShapeDimensionsModel sdm) {
		width = sdm.getWidth();
		height = sdm.getHeight();
		grid = new char[height][width];
		sdm.setGrid(grid);
		draw(sdm);
	}
	
	private void draw(ShapeDimensionsModel sdm) {
		if (grid == null)
			return;
		drawCanvas(sdm.getWidth(), sdm.getHeight(), sdm.getGrid());
	}

	public void drawCanvas(int height, int width, char[][] grid) {
		System.out.print("-");
		for (int ii = 0; ii < width; ii++) {
			System.out.print("-");
		}
		System.out.println("-");
		for (int rowNum = 0; rowNum < height; rowNum++) {
			System.out.print("|");
			for (int ii = 0; ii < width; ii++) {
				char printChar = grid[rowNum][ii];
				if (printChar == 0)
					printChar = ' ';
				System.out.print(printChar);
			}
			System.out.print("|\n");
		}
		System.out.print("-");
		for (int ii = 0; ii < width; ii++) {
			System.out.print("-");
		}
		System.out.println("-");
	}
}
