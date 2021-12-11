package com.soc.gen.impl;

import com.soc.gen.exception.CanvasDrawingException;
import com.soc.gen.util.ShapeDimensionsModel;

public class RectangleImpl extends LineImpl {
	
	public void executeDrawCommand(ShapeDimensionsModel sdm) {
		if (!sdm.coordinatesFitInCanvas(sdm))
			throw new CanvasDrawingException("Please check the rectangle coordinates do not fit into the canvas");
		int x1 = sdm.getX1();
		int x2 = sdm.getX2();
		int y1 = sdm.getY1();
		int y2 = sdm.getY2();
		int height=sdm.getHeight();
		int width=sdm.getWidth();
		char[][] grid = sdm.getGrid();
		drawRactangle(x1, y1, x2, y2, grid,height,width);
		sdm.setGrid(grid);
		drawCanvas(sdm.getHeight(), sdm.getWidth(), sdm.getGrid());
	}

	public void drawRactangle(int x1, int y1, int x2, int y2, char[][] grid,int height,int width) {
	    drawLine(x1, y1, x2, y1,grid,height,width);
        drawLine(x1, y1, x1, y2,grid,height,width);
        drawLine(x2, y1, x2, y2,grid,height,width);
        drawLine(x1, y2, x2, y2,grid,height,width);
	}

}
