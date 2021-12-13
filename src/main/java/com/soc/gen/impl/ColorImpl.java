package com.soc.gen.impl;


import java.util.LinkedList;
import java.util.Queue;

import com.soc.gen.exception.CanvasDrawingException;
import com.soc.gen.util.Point;
import com.soc.gen.util.ShapeDimensionsModel;

public class ColorImpl extends CanvasImpl {

    char [][]grid;
  
	public void executeDrawCommand(ShapeDimensionsModel sdm) {
		int x1 = sdm.getX1();
		int y1 = sdm.getY1();
		grid=sdm.getGrid();
		char color = sdm.getColor();
		if (!sdm.coordinatesFitInCanvas(sdm))
			throw new CanvasDrawingException("coordinates is outside of the current canvas");
		/*
		 * if (grid[x1 - 1][y1 - 1] == 'x') { throw new
		 * CanvasDrawingException("Please select different axes"); }
		 */
		Point c = new Point(x1, y1);
		Queue<Point> q = new LinkedList<Point>();
		q.add(c);
		// Visiting array
        int vis[][]=new int[sdm.getWidth()][sdm.getHeight()];
        
       // Initialing all as zero
		/*
		 * for(int i=0;i<sdm.getWidth();i++){ for(int j=0;j<sdm.getHeight();j++){
		 * vis[i][j]=0; } }
		 */
		vis[x1][y1]= 1;
		while (!q.isEmpty()) {
			Point topCel = q.peek();
			 int x = topCel.getX();
	         int y = topCel.getY();
			grid[x][y]=color;			
			q.remove();
			// For Upside Pixel or Cell
			 if (x<sdm.getWidth()-1 && vis[x + 1][y] == 0 && grid[x + 1][y] != 'x' && grid[x + 1][y] != color)
	            {
	                Point p=new Point(x +1, y);
	                q.add(p);
	                vis[x + 1][y] = 1;
	            }
			//For Downside Pixel or Cell
			 if (x>0 && vis[x-1][y] == 0 && grid[x-1][y] != 'x' && grid[x-1][y] != color)
	            {
	                Point p=new Point(x -1, y);
	                q.add(p);
	                vis[x - 1][y] = 1;
	            }
			//For Right side Pixel or Cell
			 if (y<sdm.getHeight()-1 && vis[x][y+1] == 0 && grid[x][y+1] != 'x' && grid[x][y+1] != color)
	            {
	                Point p=new Point(x, y+1);
	                q.add(p);
	                vis[x][y+1] = 1;
	            }
			// For Left side Pixel or Cell
			 if (y>0 && vis[x][y-1] == 0 && grid[x][y-1] != 'x' && grid[x][y-1] != color)
	            {
	                Point p=new Point(x, y-1);
	                q.add(p);
	                vis[x][y-1] = 1;
	            }
			 
		}
		sdm.setGrid(grid);
		drawCanvas(sdm.getHeight(), sdm.getWidth(),sdm.getGrid());
	}

}
