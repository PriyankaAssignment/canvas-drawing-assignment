package com.soc.gen.main;

import com.soc.gen.ICanvas;
import com.soc.gen.exception.CanvasDrawingException;
import com.soc.gen.impl.CanvasImpl;
import com.soc.gen.impl.ColorImpl;
import com.soc.gen.impl.LineImpl;
import com.soc.gen.impl.RectangleImpl;
import com.soc.gen.util.ShapeDimensionsModel;
import com.soc.gen.util.ShapeDimensionsModel.DrawingCommand;

public class CanvasFactory {
	ICanvas canvasRef;
	public ICanvas execute(ShapeDimensionsModel sdm) {

		if (sdm.getCmdType() == DrawingCommand.CREATE) {
			canvasRef = new CanvasImpl();
		}
		if (sdm.getCmdType() == DrawingCommand.LINE) {
			if (sdm.getGrid() == null)
				throw new CanvasDrawingException("Please create a canvas first in order to draw a line");
			canvasRef = new LineImpl();
		}

		if (sdm.getCmdType() == DrawingCommand.RECTANGLE) {
			if (sdm.getGrid() == null)
				throw new CanvasDrawingException("Please create a canvas first in order to draw a rectangle");
			canvasRef = new RectangleImpl();
		}

		if (sdm.getCmdType() == DrawingCommand.FILL) {

			if (sdm.getGrid() == null)
				throw new CanvasDrawingException("Please create a canvas first in order to fill the color");
			canvasRef = new ColorImpl();
		}

		return canvasRef;

	}

}
