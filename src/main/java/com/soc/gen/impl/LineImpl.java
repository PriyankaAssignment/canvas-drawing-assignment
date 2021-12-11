package com.soc.gen.impl;


import com.soc.gen.exception.CanvasDrawingException;
import com.soc.gen.util.ShapeDimensionsModel;

public class LineImpl extends CanvasImpl {

	char[][] grid;
	int height;
	int width;

	public void executeDrawCommand(ShapeDimensionsModel sdm) {
		if (!sdm.coordinatesFitInCanvas(sdm))
			throw new CanvasDrawingException("Line coordinates are exceeding the canvas coordinates");
		int x1 = sdm.getX1();
		int x2 = sdm.getX2();
		int y1 = sdm.getY1();
		int y2 = sdm.getY2();
		height=sdm.getHeight();
		width=sdm.getWidth();
		grid = sdm.getGrid();
		drawLine(x1, y1, x2, y2, grid,height,width);
		sdm.setGrid(grid);
		drawCanvas(sdm.getHeight(), sdm.getWidth(), sdm.getGrid());
	}

	public void drawLine(int x1, int y1, int x2, int y2, char[][] grid,int height,int width) {
		        for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
		            for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
		                grid[row][col] ='x';
		            }
		        
		    }
	}
}
