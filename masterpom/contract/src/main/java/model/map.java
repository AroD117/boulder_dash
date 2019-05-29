package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h1> The class map. </h1>
 * <p>
 * This class is used to instantiate a map, this is an arrayList which contain every elements of the map
 * </p>
 * <p>
 * The map class is a public class with 23 attributes (private and public) and 5 methods (private and public)
 * </p>
 * <p>
 * The map class contain the position of every elements on a arraylist (bone, vertical bone, and so on)
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 * @see readMap
 * @see readmapBDD
 * @see calculatedNumberOfCrystallBall
 * @see updateElementsOnMap
 * @see updateGateOnMap
 */

public class map 
{
	/** create and set the sprite for the bone */
	private final Elements Bone = new Elements("/bone.png");
	/** create and set the sprite for the horizontal bone */
	private final Elements H_Bone = new Elements("/horizontal_bone.png");
	/** create and set the sprite for the vertical bone */	
	private final Elements V_Bone = new Elements("/vertical_bone.png");
	/** create and set the sprite for the void */
	private final Elements Nothing = new Elements("/void.png");
	/** create and set the sprite for the gate closed */
	private Elements closeGate = new Elements("/gate_closed.png");
	/** create and set the sprite for the purse */
	private Elements purse = new Elements("/purse.png");
	/** create and set the sprite for the crystal ball */
	private Elements crystallBall = new Elements("/crystal_ball.png");
	/** create and set the sprite for the element */
	private Elements OpenGate = new Elements("/gate_open.png");
	
	/** Object Lorann */
	private Lorann lorann;
	/** Object magicBall */
	private MagicBall magicBall;
	/** Object monster number 1 */
	private Monster Monster1;
	/** Object monster number 2 */
	private Monster Monster2;
	/** Object monster number 3 */
	private Monster Monster3;
	/** cObject monster number 4 */
	private Monster Monster4;
	
	//Reading the file
	File f = new File("annex/MAP5.txt");
    FileReader fileReader;
    public char choice;
    //Map (Array List of char) and size of the map (number of sprite which the map can contain)
    public char mapRead[][] = new char[width][height];
    private final static int height = 12;
	private final static int width = 20;
	
	//characteristic of the map (crystal ball and score obtain through purse)
	private int numberOfCrystallBall = 0;
	private int scoreLorann = 0;
	private String map;
	
	/** This constructor is used to create and set the sprite of every Mobile element (elements which can move)
	 * Read the map (large String) which is contain on a data base
	 * Calculate the number of crystal ball for the win condition
	 **/
	public map(String map_p) throws IOException
    {
        this.map = map_p;
        this.readmapBDD();
        this.lorann = new Lorann("/lorann_1.png", this);
        this.magicBall = new MagicBall("/fireball_1.png", this);
        this.Monster1 = new Monster("/monster_1.png",this);
        this.Monster2 = new Monster("/monster_2.png",this);
        this.Monster3 = new Monster("/monster_3.png",this);
        this.Monster4 = new Monster("/monster_4.png",this);
        this.calculatedNumberOfCrystallBall();
    }
    
	/** Read the map through a file */
	@SuppressWarnings("unused")
	private void readMap()
	{
		try
	    {
	        fileReader = new FileReader(f);
	    }
	    catch (FileNotFoundException exception)
	    {
	        System.out.println("File not found");
	    }
	    //Reading
	    try
	    {
	        int c = 0;
	        for (int y = 0; y < height ; y++) 
	        {
	            for (int x = 0; x < width; x++) 
	            {
	            	c = fileReader.read();
	            	choice = (char)c;
	            	switch (choice) 
	            	{
	        		case 'B' :
	        			mapRead[x][y] = 'B';
	        			break;
	        			
	        		case 'H' : 
	        			mapRead[x][y] = 'H';
	        			break;
	        			
	        		case 'V' : 
	        			mapRead[x][y] = 'V';
	        			break;
	        		
	        		case 'N' : 
	        			mapRead[x][y] = 'N';
	        			break;
	        			
	        		case 'G' :
	        			mapRead[x][y] = 'G';
	        			break;
	        			
	        		case 'P' :
	        			mapRead[x][y] = 'P';
	        			break;
	        			
	        		case 'C' :
	        			mapRead[x][y] = 'C';
	        			break;
	            	}
	            }
	        }
	    }
	    catch (IOException exception)
	    {
	        System.out.println ("Error when reading the file : " + exception.getMessage());
	    }
	}
	
	/** Read the map trough the data base */
	public void readmapBDD () {

        char choice;
        int i = 0;

         for (int y = 0; y < height ; y++) 
            {
                for (int x = 0; x < width; x++) 
                {

                    choice = this.map.charAt(i);

                            switch (choice) 
                            {
                            case 'B' :
                                mapRead[x][y] = 'B';
                                break;

                            case 'H' : 
                                mapRead[x][y] = 'H';
                                break;

                            case 'V' :
                                mapRead[x][y] = 'V';
                                break;

                            case 'N' :
                                mapRead[x][y] = 'N';
                                break;

                            case 'G' :
                                mapRead[x][y] = 'G';
                                break;
                            case 'P' :
                                mapRead[x][y] = 'P';
                                break;
                            case 'C' :
                                mapRead[x][y] = 'C';
                                break;
                            }
                            i++;
                }
            }
    }
	
	/** Check every elements of the map and calculate the number of crystal ball */
	public void calculatedNumberOfCrystallBall()
	{
		for (int y = 0; y < height ; y++) 
        {
            for (int x = 0; x < width; x++) 
            {
            	if (mapRead[x][y] == 'C')
            	{
            		this.numberOfCrystallBall = this.numberOfCrystallBall + 1;
            	}
            }
        }
	}
	
	/** Update Elements on the map (arraylist), transform it into "void" */
	public void updateElementsOnMap(int x,int y)
	{
		this.mapRead[x][y] = 'N';
	}
	
	/** Update the elements closeGate on the map (arraylist), transform it into "openGate" */
	public void updateGateOnMap(int x,int y)
	{
		this.mapRead[x][y] = 'O';
	}
	
	public String getMap()
	{
        return map;
    }

    public void setMap(String map) 
    {
        this.map = map;
    }
    
	public static int getHeight() 
	{
		return height;
	}
	
	public static int getWidth() 
	{
		return width;
	}
	
	public Elements getBone() 
	{
		return Bone;
	}
	
	public Elements getH_Bone() 
	{
		return H_Bone;
	}
	
	public Elements getV_Bone() 
	{
		return V_Bone;
	}
	
	public Elements getNothing() 
	{
		return Nothing;
	}
	
	public Elements getCloseGate() 
	{
		return closeGate;
	}
		
	public void setCloseGate(Elements CloseGate_p)
	{
		this.closeGate = CloseGate_p;
	}
		
	public Elements getPurse() 
	{
		return purse;
	}

	public void setPurse(Elements purse) 
	{
		this.purse = purse;
	}
		
	public Elements getCrystallBall() 
	{
		return crystallBall;
	}

	public void setCrystallBall(Elements crystallBall) 
	{
		this.crystallBall = crystallBall;
	}
		
	public Elements getOpenGate() 
	{
		return OpenGate;
	}

	public void setOpenGate(Elements openGate) 
	{
		OpenGate = openGate;
	}
		
	public Lorann getLorann() 
	{
		return lorann;
	}
		
	public void setLorann(Lorann lorann_p)
	{
		this.lorann = lorann_p;
	}
		
	public int getNumberOfCrystallBall() 
	{
		return numberOfCrystallBall;
	}

	public void setNumberOfCrystallBall(int numberOfCrystallBall) 
	{
		this.numberOfCrystallBall = numberOfCrystallBall;
	}
		
	public int getScoreLorann() 
	{
		return scoreLorann;
	}

	public void setScoreLorann(int scoreLorann) 
	{
		this.scoreLorann = scoreLorann;
	}
	
	public Monster getMonster1() 
	{
		return Monster1;
	}

	public void setMonster1(Monster monster1) 
	{
		Monster1 = monster1;
	}
	
	public Monster getMonster2() 
	{
		return Monster2;
	}

	public void setMonster2(Monster monster2) 
	{
		Monster2 = monster2;
	}
	
	public Monster getMonster3() 
	{
		return Monster3;
	}

	public void setMonster3(Monster monster3) 
	{
		Monster3 = monster3;
	}
	
	public Monster getMonster4() 
	{
		return Monster4;
	}

	public void setMonster4(Monster monster4) 
	{
		Monster4 = monster4;
	}

	public MagicBall getMagicBall() 
	{
		return magicBall;
	}

	public void setMagicBall(MagicBall magicBall) 
	{
		this.magicBall = magicBall;
	}
}
