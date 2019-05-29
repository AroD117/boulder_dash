package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class map 
{
	//Sprites
	private final Elements Bone = new Elements("/bone.png");
		
	private final Elements H_Bone = new Elements("/horizontal_bone.png");
		
	private final Elements V_Bone = new Elements("/vertical_bone.png");

	private final Elements Nothing = new Elements("/void.png");
		
	private Elements closeGate = new Elements("/gate_closed.png");
	
	private Elements purse = new Elements("/purse.png");
	
	private Elements crystallBall = new Elements("/crystal_ball.png");
	
	private Elements OpenGate = new Elements("/gate_open.png");
	
	private boulder_dash lorann;
	
	File f = new File("annex/MAP6.txt");
    FileReader fileReader;
    public char choice;
    public char mapRead[][] = new char[width][height];
    private final static int height = 12;
	private final static int width = 20;
	
	public map() throws IOException
    {
    	readMap();
    	this.lorann = new boulder_dash("/lorann_1.png", this);
    }
    
	public void readMap()
	{
		try
	    {
	        fileReader = new FileReader(f);
	    }
	    catch (FileNotFoundException exception)
	    {
	        System.out.println("File not found");
	    }
	    //Lecture
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
	        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
	    }
	}
	
	
	public static int getHeight() 
	{
		return height;
	}
	public static int getWidth() 
	{
		return width;
	}
		public Elements getBone() {
			return Bone;
		}
		public Elements getH_Bone() {
			return H_Bone;
		}
		public Elements getV_Bone() {
			return V_Bone;
		}
		public Elements getNothing() {
			return Nothing;
		}
		public Elements getCloseGate() {
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
		
		public boulder_dash getLorann() 
		{
			return lorann;
		}
		
		public void setLorann(boulder_dash lorann_p)
		{
			this.lorann = lorann_p;
		}
}
