package com.simulator.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.simulator.surfaces.Table;

public class TableTest {

	private Table table;
	
	@Before
	public void setup()
	{
		table = new Table(4, 4);
	}
	
	@Test
	public void testIsValidLength()
	{
		Assert.assertEquals(false, table.isValidLocation(6, 6));
		Assert.assertEquals(true, table.isValidLocation(3, 3));
		Assert.assertEquals(true, table.isValidLocation(4, 4));
	}
}
