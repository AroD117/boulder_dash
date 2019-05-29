package model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class mapTest 
{
	map map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void testReadmapBDD() throws IOException 
	{
		final map map = new map("BHHHHHHHHHHHHHHHHHHB"
				+ "VNBBBBNNNNNNNNNNNNNV"
				+ "VNNNNNNCBHHHHHHHHHNV"
				+ "VNBBBBBBBNNNNNNNNNNV"
				+ "VNBHHHHHBNBNBNBNBNBV"
				+ "VNVNNNNPVNNBPNNNNBNV"
				+ "VNVNHHHHBNNNBHHBPNNV"
				+ "VNVNNVNNVNBNBHHHHBNV"
				+ "VNVNVNVCVCBNBGNNNVNV"
				+ "VNBNBHHHBHBNBHHHHPNV"
				+ "VNNNBPNNNNNBNNNNNNNV"
				+ "BHHHHHHHHHHHHHHHHHHB");
		final char expected = 'B';
		assertEquals(expected,map.mapRead[0][0]);
	}

	@Test
	public void testCalculatedNumberOfCrystallBall() throws IOException 
	{
		final map map = new map("BHHHHHHHHHHHHHHHHHHB"
				+ "VNBBBBNNNNNNNNNNNNNV"
				+ "VNNNNNNCBHHHHHHHHHNV"
				+ "VNBBBBBBBNNNNNNNNNNV"
				+ "VNBHHHHHBNBNBNBNBNBV"
				+ "VNVNNNNPVNNBPNNNNBNV"
				+ "VNVNHHHHBNNNBHHBPNNV"
				+ "VNVNNVNNVNBNBHHHHBNV"
				+ "VNVNVNVCVCBNBGNNNVNV"
				+ "VNBNBHHHBHBNBHHHHPNV"
				+ "VNNNBPNNNNNBNNNNNNNV"
				+ "BHHHHHHHHHHHHHHHHHHB");
		final int expected = 3;
		assertEquals(expected,map.getNumberOfCrystallBall());
	}

}
