package org.tao.test.webapp.simple.rest;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCounterTest {
	@Test
	public void testCountAB() {
		StringCounter ct = new StringCounter();
		assertEquals("12", ct.countAB("aaaaba").getData());
		assertEquals("1", ct.countAB("aaaba").getData());
		assertEquals("2", ct.countAB("aba").getData());
	}
}
