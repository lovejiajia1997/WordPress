package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Demo2 {
	@Test
	public void test1() {
		assertEquals(3, 3);
	}

	@Test
	public void test2() {
		assertEquals(3, 4);
	}
}
