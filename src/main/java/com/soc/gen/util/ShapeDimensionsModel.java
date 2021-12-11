package com.soc.gen.util;

import java.util.Arrays;

public class ShapeDimensionsModel {
	
	public enum DrawingCommand{
		  CREATE, LINE, RECTANGLE, FILL, QUIT;
		}
	
	private DrawingCommand cmdType;
	private int width;
	private int height;
	private int x1;
	private int x2;
	private int y1; 
	private int y2; 
	private char color;
	private  char[][] grid;
	
	public DrawingCommand getCmdType() {
		return cmdType;
	}

	public void setCmdType(DrawingCommand cmdType) {
		this.cmdType = cmdType;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}
	
	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public boolean coordinatesFitInCanvas(ShapeDimensionsModel cc) {
		int x1 = cc.getX1();
		int x2 = cc.getX2();
		int y1 = cc.getY1();
		int y2 = cc.getY2();
		if (x1 > cc.getWidth())
			return false;

		if (x2 > cc.getWidth())
			return false;

		if (y1 > cc.getHeight())
			return false;

		if (y2 > cc.getHeight())
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(grid);
		result = prime * result + height;
		result = prime * result + width;
		result = prime * result + x1;
		result = prime * result + x2;
		result = prime * result + y1;
		result = prime * result + y2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShapeDimensionsModel other = (ShapeDimensionsModel) obj;
		if (!Arrays.deepEquals(grid, other.grid))
			return false;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		if (x1 != other.x1)
			return false;
		if (x2 != other.x2)
			return false;
		if (y1 != other.y1)
			return false;
		if (y2 != other.y2)
			return false;
		return true;
	}



	
	
}
