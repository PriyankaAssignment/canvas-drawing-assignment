package com.soc.gen.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.soc.gen.ICanvas;
import com.soc.gen.exception.CanvasDrawingException;
import com.soc.gen.util.ShapeDimensionsModel;
import com.soc.gen.util.ShapeDimensionsModel.DrawingCommand;
import com.soc.gen.util.Utility;

public class DrawingAssignmentApplication {
	ShapeDimensionsModel c = new ShapeDimensionsModel();
	ICanvas canvasRef;

	public void verifyCommand(String cmdStr) {

		// verify canvas command and set the values in model
		char cmdChar=0;
		if(!cmdStr.isEmpty())
		cmdChar = Character.toUpperCase(cmdStr.charAt(0));
		Pattern p;
		Matcher m;
		switch (cmdChar) {

		case 'C': {
			p = Pattern.compile(Utility.createCmdExp);
			m = p.matcher(cmdStr);
			if (m.matches()) {
				int w = Integer.parseInt(m.group(1));
				int h = Integer.parseInt(m.group(2));
				if (w <= 0 || h <= 0) {
					throw new CanvasDrawingException("Only positive dimensions are allowed");
				}
				if (w > Utility.MaxCanvasDimX || h > Utility.MaxCanvasDimY) {
					throw new CanvasDrawingException("canvas dimension can not be greater than " + Utility.MaxCanvasDimX
							+ "" + Utility.MaxCanvasDimY);
				}
				c.setCmdType(DrawingCommand.CREATE);
				c.setWidth(w);
				c.setHeight(h);
				try {
					canvasRef = new CanvasFactory().execute(c);
					canvasRef.executeDrawCommand(c);
				} catch (CanvasDrawingException e) {
					System.out.println(e.getMessage());
				}
			} else {
				throw new CanvasDrawingException("Invalid create canvas command");
			}
			break;
		}
		// verify line command and set the values in model
		case 'L': {
			p = Pattern.compile(Utility.lineCmdExp);
			m = p.matcher(cmdStr);
			if (m.matches()) {
				c.setCmdType(DrawingCommand.LINE);
				int x1 = Integer.parseInt(m.group(1));
				int y1 = Integer.parseInt(m.group(2));
				int x2 = Integer.parseInt(m.group(3));
				int y2 = Integer.parseInt(m.group(4));
				if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
					throw new CanvasDrawingException("Only positive coordinates are allowed");
				}
				if (!(x1 == x2) && !(y1 == y2)) {
					throw new CanvasDrawingException("Line must be either vertical (x1=x2) or horizontal (y1=y2)");
				}
				c.setX1(x1);
				c.setY1(y1);
				c.setX2(x2);
				c.setY2(y2);
				try {
					canvasRef = new CanvasFactory().execute(c);
					canvasRef.executeDrawCommand(c);
				} catch (CanvasDrawingException e) {
					System.out.println(e.getMessage());
				}
			} else {
				throw new CanvasDrawingException("Invalid create line command");
			}
			break;
		}
		case 'R': {
			// verify rectangle command and set the values in model
			p = Pattern.compile(Utility.rectCmdExp);
			m = p.matcher(cmdStr);
			if (m.matches()) {
				c.setCmdType(DrawingCommand.RECTANGLE);
				int x1 = Integer.parseInt(m.group(1));
				int y1 = Integer.parseInt(m.group(2));
				int x2 = Integer.parseInt(m.group(3));
				int y2 = Integer.parseInt(m.group(4));
				if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
					throw new CanvasDrawingException("Only positive coordinates are allowed");
				}
				c.setX1(x1);
				c.setY1(y1);
				c.setX2(x2);
				c.setY2(y2);
				try {
					canvasRef = new CanvasFactory().execute(c);
					canvasRef.executeDrawCommand(c);
				} catch (CanvasDrawingException e) {
					System.out.println(e.getMessage());
				}
			} else {
				throw new CanvasDrawingException("Invalid create rectangle command");
			}
			break;
		}

		case 'B': {
			p = Pattern.compile(Utility.fillCmdExp);
			m = p.matcher(cmdStr);
			if (m.matches()) {
				c.setCmdType(DrawingCommand.FILL);
				int x1 = Integer.parseInt(m.group(1));
				int y1 = Integer.parseInt(m.group(2));
				char color = m.group(3).charAt(0);
				if (x1 <= 0 || y1 <= 0) {
					throw new CanvasDrawingException("Only positive coordinates are allowed");
				}
				c.setX1(x1);
				c.setY1(y1);
				c.setColor(color);
				try {
					canvasRef = new CanvasFactory().execute(c);
					canvasRef.executeDrawCommand(c);
				} catch (CanvasDrawingException e) {
					System.out.println(e.getMessage());
				}
			} else {
				throw new CanvasDrawingException("Invalid create canvas command");
			}
			break;
		}
		case 'Q': {
			p = Pattern.compile(Utility.quitCmdExp);
			m = p.matcher(cmdStr);
			if (m.matches()) {
				c.setCmdType(DrawingCommand.QUIT);
				System.exit(0);
			} else {
				throw new CanvasDrawingException("Invalid quit command");
			}
			break;
		}
		default:
			throw new CanvasDrawingException("Invalid command");

		}
	}

	public static void main(String... s) throws IOException {
		String command = "";
		DrawingAssignmentApplication sd = new DrawingAssignmentApplication();
		while (true) {
			System.out.println("\nC:draw Canvas please provide width and height for the canvas Ex: C 10 10");
			System.out.println(
					"L:draw horizonal/vertical lines please provide x-axes and y-axis for the line Ex: L 5 6 5 7 ");
			System.out.println("R:draw rectangl please provide x-axes and y-axes for the canvas Ex: R 4 5 7 8");
			System.out.println("B:fill the color please provide x-axes and y-axes for filling the color Ex: B 4 5 r");
			System.out.println("Q:to quit the program Ex: Q");
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				command = br.readLine();
				sd.verifyCommand(command);
			} catch (CanvasDrawingException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
