package com.soc.gen.main.drawingassignment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import com.soc.gen.util.Utility;

public class TestCommand {
	private ArrayList<String> strArrayList = new ArrayList<String>();

	@Test
	public void testCreateCmdRexStr() {
		strArrayList.clear();
		strArrayList.add("C 10");
		strArrayList.add("C 10 10 10");
		strArrayList.add(" ");
		strArrayList.add("C 10 9.0");
		boolean test = false;
		for (String str : strArrayList) {
			test = Pattern.matches(Utility.createCmdExp, str);
			assertFalse(test);
		}
		test = Pattern.matches(Utility.createCmdExp, "C 10 10");
		assertTrue(test);
	}

	@Test
	public void testLineCmdRexStr() {
		strArrayList.clear();
		strArrayList.add("L 10");
		strArrayList.add("L 10 10 10");
		strArrayList.add("R 10 10 10 10");
		strArrayList.add(" ");
		strArrayList.add("L 10 9.0 8 7.2");
		boolean test = false;
		for (String str : strArrayList) {
			test = Pattern.matches(Utility.lineCmdExp, str);
			assertFalse(test);
		}
		test = Pattern.matches(Utility.lineCmdExp, "L 4 5 4 7");
		assertTrue(test);
	}

	@Test
	public void testRectangleCmdRexStr() {
		strArrayList.clear();
		strArrayList.add("R 10");
		strArrayList.add("R 10 10 10");
		strArrayList.add("L 10 9.0 10 11");
		strArrayList.add(" ");
		strArrayList.add("R 10 9.0 10 11");
		boolean test = false;
		for (String str : strArrayList) {
			test = Pattern.matches(Utility.rectCmdExp, str);
			assertFalse(test);
		}
		test = Pattern.matches(Utility.rectCmdExp, "R 4 5 7 8");
		assertTrue(test);
	}

	@Test
	public void testFillColorCmdRexStr() {
		strArrayList.clear();
		strArrayList.add("B 10");
		strArrayList.add("B 10 10 10");
		strArrayList.add("B 10 9.0 r");
		strArrayList.add(" ");
		strArrayList.add("L 10 2 r");
		boolean test = false;
		for (String str : strArrayList) {
			test = Pattern.matches(Utility.fillCmdExp, str);
			assertFalse(test);
		}
		test = Pattern.matches(Utility.fillCmdExp, "B 4 5 r");
		assertTrue(test);
	}
}
