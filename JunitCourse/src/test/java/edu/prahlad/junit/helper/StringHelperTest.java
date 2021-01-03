package edu.prahlad.junit.helper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

	StringHelper helper;

	@Before
	public void before(){
		helper = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2Positions_Ainfirst2Positions(){
		//AACD => CD, ACD => CD, CDEF=> CDEF, CDAA => CDAA
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AinfirstPosition(){
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
		//expected actual
	}

	//ABCD ==> false, ABAB ==> true, AB => true, A => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario(){
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

}