package edu.prahlad.junit.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	StringHelper helper = new StringHelper();

	private String input;
	private String expectedOutput;

	public StringHelperParameterizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions(){
		String expectedOutputs[][] = {
				{"AACD","CD"},
				{"AACD","CD"}
		};
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void testTruncateAInFirst2Positions(){
		//AACD => CD, ACD => CD, CDEF=> CDEF, CDAA => CDAA
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

}