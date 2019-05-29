package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import showboard.IPawn;

/**
 * <h1> The class Lorann. </h1>
 * <p>
 * This class is used to instantiate Lorann object. A Lorann can move and use a magic ball through his methods define here
 * </p>
 * <p>
 * The Lorann class is a public class with 7 private attributes and 19 public methods
 * </p>
 * <p>
 * The Lorann class extends Elements for his sprite and implements IPawn because he need to move on a IBoard
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 * @see RandomStartPosition
 * @see animationLorann
 * @see rightMouvementLorann
 * @see leftMouvementLorann
 * @see forwardMouvementLorann
 * @see backwardMouvementLorann
 * @see diagonalRightForwardMouvementLorann
 * @see diagonalLeftForwardMouvementLorann
 * @see diagonalRightBackwardMouvementLorann
 * @see diagonalLeftBackwardMouvementLorann
 *
 */

public class Lorann extends Elements implements IPawn
{
	/** Private attribute which define the position of the Lorann (x,y), this attribute is used by the showboard library*/
	private Point Positon;
	/** Initial x position of the Lorann */
	private int startX = 1;
	/** Initial y position of the Lorann */
	private int startY = 1;
	/** Map attribute used by the Lorann for his movement (he need to know where he can move) */
	private map map;
	/** Direction of the Lorann (0 for right,1 for left, and so on) */
	private int direction;
	/** Every sprite of the Lorann (some of the sprite are used for the movement and others are use for the Lorann animation) */
	private Image imageLorann[];
	/**Int used to select the right sprite */
	private int numberImage = 0;
	
	/** This constructor is used to set the start position of the Lorann (random position) and set all of his sprite on a arraylist*/
	public Lorann(String nameFile, map Map) throws IOException 
	{
		super(nameFile);
		this.map = Map;
		//this.RandomStartPosition();
		this.setPosition(getStartX(), getStartY());
		this.imageLorann = new Image[8];
		int y = 0;
		for (int i = 1; i <= 8;i++)
		{
			this.imageLorann[y] = ImageIO.read(new File("annex/lorann_" + i + ".png"));
			y++;
		}
		
	}

	/** Generate random x and y position (start position of the Lorann) */
	public final void RandomStartPosition()
	{
	int valuesX = 0;
	int valuesY = 0;
	while (map.mapRead[valuesX][valuesY] != 'N')
	{
		Random rX = new Random();
		Random rY = new Random();
		valuesX = 0 + rX.nextInt(19 - 0);
		valuesY = 0 + rY.nextInt(11 - 0);
	}
	this.startX = valuesX;
	this.startY = valuesY;
	}
	
	/** Animation of the Lorann, show sprite one by one through the Lorann thread*/
	public final void animationLorann()
	{
		if (numberImage == 8)
		{
			numberImage = 0;
		}
		this.setImage(imageLorann[numberImage]);
		numberImage++;
	}
	
	/** Right movement of the Lorann, set the direction and add 1 to the x position */
	public final void rightMouvementLorann()
	{
		this.direction = 0;
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[2]);
		}
	}
	
	/** Left movement of the Lorann, set the direction and subtract 1 to the x position */
	public final void leftMouvementLorann()
	{
		this.direction = 1;
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[6]);
		}
	}
	
	/** Forward movement of the Lorann, set the direction and subtract 1 to the y position */
	public final void forwardMouvementLorann()
	{
		this.direction = 2;
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[0]);
		}
	}
	
	/** Backward movement of the Lorann, set the direction and add 1 to the y position */
	public final void backwardMouvementLorann()
	{
		this.direction = 3;
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[4]);
		}
	}
	
	/** DiagonalRightForward movement of the Lorann, add 1 to the x and subtract 1 to the y position */
	public final void diagonalRightForwardMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[1]);
		}
	}
	
	/** DiagonalLeftForward movement of the Lorann, subtract 1 to the x and subtract 1 to the y position */
	public final void diagonalLeftForwardMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[7]);
		}
	}
	
	/** DiagonalRightBackward movement of the Lorann, add 1 to the x and add 1 to the y position */
	public final void diagonalRightBackwardMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[3]);
		}
	}
	
	/** DiagonalleftForward movement of the Lorann, subtract 1 to the x and add 1 to the y position */
	public final void diagonalLeftBackwardMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[5]);
		}
	}
	
	@Override
	public int getX() 
	{
		return this.getPosition().x;
	}

	@Override
	public int getY() 
	{
		return this.getPosition().y;
	}

	@Override
	public Point getPosition() 
	{
		return this.Positon;
	}

	public final void setPosition(Point position)
	{
		this.Positon = position;
	}
	
	public final void setPosition(final int x, final int y)
	{
		this.Positon = new Point(x,y);
	}
	
	public int getStartX() 
	{
		return startX;
	}

	public int getStartY() 
	{
		return startY;
	}


	public int getDirection() 
	{
		return direction;
	}


	public void setDirection(int direction) 
	{
		this.direction = direction;
	}
	
}
