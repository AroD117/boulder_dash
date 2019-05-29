package model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LorannTest 
{
	Lorann lorann;
	map map;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testRightMouvementLorann() throws IOException 
	{
		final map map = new map
				 ("BHHHHHHHHHHHHHHHHHHB"
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
		Lorann lorann = new Lorann("/lorann_1.png", map);
		lorann.setPosition(1, 3);
		lorann.rightMouvementLorann();
		final int xExpected = 1;
		assertEquals(xExpected,lorann.getX());
	}

	@Test
	public void testLeftMouvementLorann() throws IOException 
	{
		final map map = new map
				 ("BHHHHHHHHHHHHHHHHHHB"
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
		Lorann lorann = new Lorann("/lorann_1.png", map);
		lorann.setPosition(2, 3);
		lorann.leftMouvementLorann();
		final int xExpected = 1;
		assertEquals(xExpected,lorann.getX());
	}

	@Test
	public void testForwardMouvementLorann() throws IOException 
	{
		final map map = new map
				 ("BHHHHHHHHHHHHHHHHHHB"
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
		Lorann lorann = new Lorann("/lorann_1.png", map);
		lorann.setPosition(11, 7);
		lorann.forwardMouvementLorann();
		final int yExpected = 6;
		assertEquals(yExpected,lorann.getY());
	}

	@Test
	public void testBackwardMouvementLorann() throws IOException 
	{
		final map map = new map
				 ("BHHHHHHHHHHHHHHHHHHB"
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
		Lorann lorann = new Lorann("/lorann_1.png", map);
		lorann.setPosition(1, 2);
		lorann.backwardMouvementLorann();
		final int yExpected = 3;
		assertEquals(yExpected,lorann.getY());
	}

}
