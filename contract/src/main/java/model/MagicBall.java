package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.IController;
import showboard.IPawn;

/**
 * <h1> the class MagicBall. <h1>
 * <p>
 * this class is use to create MagicBall launch by Lorann
 * </p>
 * <p>
 * the MagicBall class is a public class with 5 public attributes and 7 methods
 * </p>
 * <p>
 * the MagicBall class implement IPawn because he need to move on a IBoard
 * </p>
 * @see magicBallMouvement
 * @see magicBallReachMonster
 * @see animationBallMouvement
 * @see rightMouvementMagicBall
 * @see leftMouvementMagicBall
 * @see forwardMouvementMagicBall
 * @see backwardMouvementMagicBall
 *
 */

public class MagicBall extends Elements implements IPawn
{
	/** Private attribute which define the position of the magic ball (x,y), this attribute is used by the showboard library*/
	private Point Positon;
	/** Map attribute used by the magic ball for his movement (he need to know where he can move) */
	private map map;
	/** Direction of the magic ball (0 for right,1 for left, and so on) */
	private int direction;
	/** Every sprite of the magic ball (these sprites are use for the the magic ball animation) */
	private Image imageMagicBall[];
	/**Int used to select the right sprite */
	private int numberImage = 0;
	
	/** This constructor is used to set all of Magic ball spites on a arraylist*/
	public MagicBall(String nameFile,map Map) throws IOException 
	{
		super(nameFile);
		this.map = Map;
		this.imageMagicBall = new Image[5];
		int y = 0;
		for (int i = 1; i <= 5;i++)
		{
			this.imageMagicBall[y] = ImageIO.read(new File("annex/fireball_" + i + ".png"));
			y++;
		}
	}
	
	/** this method define in which direction the ball will move 
	 *  the right movement method is called in terms of the direction
	 **/
	public void magicBallMouvement()
	{
		switch(this.direction)
		{
			case 0:
				this.rightMouvementMagicBall();
				break;
			case 1:
				this.leftMouvementMagicBall();
				break;
			case 2:
				this.forwardMouvementMagicBall();
				break;
			case 3:
				this.backwardMouvementMagicBall();
				break;
		}
	}
	
	/** this method check if the position of the magic ball (x,y) is the same as a monster */
	public void magicBallReachMonster(IController controller)
	{
		if (this.getX() == this.map.getMonster1().getX() && this.getY() == this.map.getMonster1().getY())
		{
			controller.getView().removeMagicBall(controller);
			controller.getView().removeMonster(1);
		}
			
		if (this.getX() == this.map.getMonster2().getX() && this.getY() == this.map.getMonster2().getY())
		{
			controller.getView().removeMagicBall(controller);
			controller.getView().removeMonster(2);
		}
			
		if (this.getX() == this.map.getMonster3().getX() && this.getY() == this.map.getMonster3().getY())
		{
			controller.getView().removeMagicBall(controller);
			controller.getView().removeMonster(3);
		}
			
		if (this.getX() == this.map.getMonster4().getX() && this.getY() == this.map.getMonster4().getY())
		{
			controller.getView().removeMagicBall(controller);
			controller.getView().removeMonster(4);
		}
	}
	
	/** Animation of the magic ball, show sprite one by one through the magic ball thread*/
	public void animationBallMouvement()
	{
		if (numberImage == 5)
		{
			numberImage = 0;
		}
		this.setImage(imageMagicBall[numberImage]);
		numberImage++;
	}
	
	/** Right movement of the magic ball, set the direction to 1 and add 1 to the x position */
	public final void rightMouvementMagicBall()
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
		else
			this.setDirection(1);
		
	}
	
	/** Left movement of the magic ball, set the direction to 0 and subtract 1 to the x position */
	public final void leftMouvementMagicBall()
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
		else
			this.setDirection(0);
	}
	
	/** Forward movement of the magic ball, set the direction to 3 and subtract 1 to the y position */
	public final void forwardMouvementMagicBall()
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
		else
			this.setDirection(3);
	}
	
	/** Backward movement of the magic ball, set the direction to 2 and add 1 to the y position */
	public final void backwardMouvementMagicBall()
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
		else
			this.setDirection(2);
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

	public int getDirection() 
	{
		return direction;
	}

	public void setDirection(int direction) 
	{
		this.direction = direction;
	}

}
