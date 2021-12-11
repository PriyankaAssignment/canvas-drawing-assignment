package com.soc.gen.main.drawingassignment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.soc.gen.util.ShapeDimensionsModel;


class DrawingAssignmentApplicationTests {

	ShapeDimensionsModel model=new ShapeDimensionsModel();
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void testCordinateFit() {
		model.setX1(3);
		model.setX2(4);
		model.setY1(5);
		model.setY2(7);
		model.setWidth(10);
		model.setHeight(10);
	 assertTrue(model.coordinatesFitInCanvas(model));
	}
	
	
	  @Test public void testNonCordinateFit() { model.setX1(3); 
	  model.setX2(4);
	  model.setY1(15);
	  model.setY2(7); 
	  model.setWidth(10); 
	  model.setHeight(10);
	  assertFalse(model.coordinatesFitInCanvas(model)); }
	 

}
