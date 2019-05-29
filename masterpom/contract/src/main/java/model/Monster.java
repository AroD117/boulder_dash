package model;

import java.awt.Point;
import java.util.Random;

import showboard.IPawn;

/**
 * <h1> The class Monster. </h1>
 * <p>
 * This class is used to instantiate Monster object. A Monster can move (randomly or stalk the Lorann) through his methods define here
 * </p>
 * <p>
 * The monster class is a public class with 5 private attributes and 13 public methods
 * </p>
 * <p>
 * The monster class extends Elements for his sprite and implements IPawn because he need to move on a IBoard
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 * @see RandomStartPosition
 * @see resetMonster
 * @see RamdomMovingMonster
 * @see monstersTrackingLorann
 * @see monsterTrackingLorannSmarter
 * @see rightMouvementMonster
 * @see leftMouvementMonster
 * @see forwardMouvementMonster
 * @see backwardMouvementMonster
 * @see diagonalRightForwardMouvementMonster
 * @see diagonalLeftForwardMouvementMonster
 * @see diagonalRightBackwardMouvementMonster
 * @see diagonalLeftBackwardMouvementMonster
 *
 */

public class Monster extends Elements implements IPawn
{
	/** Private attribute which define the position of a monster (x,y), this attribute is used by the showboard library*/
	private Point Positon;
	/** Initial x position of a monster */
	private int startX;
	/** Initial y position of a monster */
	private int startY;
	/** Map attribute used by a monster for his movement (he need to know where he can move) */
	private map map;
	/** Attribute use to make a difference between monsters who have been killed and the monsters who are alive */
	private boolean aliveMonster = true;
	
	/** This constructor is used to set the start position of a monsters (random position) */
	public Monster(String nameFile, map Map) 
	{
		super(nameFile);
		this.map = Map;
		this.RandomStartPosition();
		this.setPosition(getStartX(), getStartY());
	}
	
	/** Generate random x and y position (start position of the Monster) */
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
	
	/** this method reset the position of a monster (into a random one) */
	public final void resetMonster()
	{
		this.RandomStartPosition();
		this.setPosition(getStartX(), getStartY());
		this.aliveMonster = true;
	}
	
	/** this method allow a monster to move randomly (9 direction, a direction is choose randomly) */
	public final void RamdomMovingMonster()
	{
		Random Mouvement = new Random();
		int mouvementDirection = 0 + Mouvement.nextInt(9 - 0);
		switch(mouvementDirection)
		{
			case 1:
				this.rightMouvementMonster();
				break;
			case 2:
				this.leftMouvementMonster();
				break;
			case 3:
				this.forwardMouvementMonster();
				break;
			case 4:
				this.backwardMouvementMonster();
				break;
			case 5:
				this.diagonalLeftForwardMouvementMonster();
				break;
			case 6:
				this.diagonalRightForwardMouvementMonster();
				break;
			case 7:
				this.diagonalLeftBackwardMouvementMonster();
				break;
			case 8:
				this.diagonalRightBackwardMouvementMonster();
				break;
		}
		
	}
	
	/** this method allow a monster to stalk Lorann only in the x line (width) and y line (height) */
	public final void monstersTrackingLorann()
	{
		if (this.getX() < this.map.getLorann().getX())
			this.rightMouvementMonster();
		else if(this.getX() > this.map.getLorann().getX())
			this.leftMouvementMonster();
		else if(this.getY() < this.map.getLorann().getY())
			this.backwardMouvementMonster();
		else if(this.getY() > this.map.getLorann().getY())
			this.forwardMouvementMonster();
	}
	
	/** this method allow a monster to stalk Lorann in all direction */
	public final void monsterTrackingLorannSmarter()
	{
		if (this.getX() < this.map.getLorann().getX())
		{
			this.rightMouvementMonster();
		}
		if(this.getX() > this.map.getLorann().getX())
		{
			this.leftMouvementMonster();
		}
		if(this.getY() < this.map.getLorann().getY())
		{
			this.backwardMouvementMonster();
		}
		if(this.getY() > this.map.getLorann().getY())
		{
			this.forwardMouvementMonster();
		}
	}
	
	/** Right movement of the Monster, set the direction and add 1 to the x position */
	public final void rightMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** Left movement of the Monster, set the direction and subtract 1 to the x position */
	public final void leftMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** Forward movement of the Monster, set the direction and subtract 1 to the y position */
	public final void forwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** Backward movement of the Monster, set the direction and add 1 to the y position */
	public final void backwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** DiagonalRightForward movement of the Monster, add 1 to the x and subtract 1 to the y position */
	public final void diagonalRightForwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** DiagonalLeftForward movement of the Monster, subtract 1 to the x and subtract 1 to the y position */
	public final void diagonalLeftForwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** DiagonalRightBackward movement of the Monster, add 1 to the x and add 1 to the y position */
	public final void diagonalRightBackwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	
	/** DiagonalleftForward movement of the Monster, subtract 1 to the x and add 1 to the y position */
	public final void diagonalLeftBackwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' 
				&& this.map.mapRead[NewX][NewY] != 'H' 
				&& this.map.mapRead[NewX][NewY] != 'V' 
				&& this.map.mapRead[NewX][NewY] != 'C' 
				&& this.map.mapRead[NewX][NewY] != 'G' 
				&& this.map.mapRead[NewX][NewY] != 'P' 
				&& this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
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

	public boolean isAliveMonster() 
	{
		return aliveMonster;
	}

	public void setAliveMonster(boolean aliveMonster) 
	{
		this.aliveMonster = aliveMonster;
	}


	
}
