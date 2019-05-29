package model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterTest 
{
	Monster monster;
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
	public void testRightMouvementMonster() throws IOException 
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
		Monster monster = new Monster("/monster_1.png", map);
		monster.setPosition(1, 2);
		monster.rightMouvementMonster();
		final int xExpected = 2;
		assertEquals(xExpected,monster.getX());
	}

	@Test
	public void testLeftMouvementMonster() throws IOException 
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
		Monster monster = new Monster("/monster_1.png", map);
		monster.setPosition(2, 2);
		monster.leftMouvementMonster();
		final int xExpected = 1;
		assertEquals(xExpected,monster.getX());
	}

	@Test
	public void testForwardMouvementMonster() throws IOException 
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
		Monster monster = new Monster("/monster_1.png", map);
		monster.setPosition(1, 3);
		monster.forwardMouvementMonster();
		final int yExpected = 2;
		assertEquals(yExpected,monster.getY());
	}

	@Test
	public void testBackwardMouvementMonster() throws IOException 
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
		Monster monster = new Monster("/monster_1.png", map);
		monster.setPosition(1, 3);
		monster.backwardMouvementMonster();
		final int yExpected = 4;
		assertEquals(yExpected,monster.getY());
	}

}
