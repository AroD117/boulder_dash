package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import showboard.IPawn;

public class boulder_dash extends Mobile implements IPawn
{
	private Point Positon;
	private int startX;
	private int startY;
	private map map;
	private Image imageLorann[];
	private int numberImage = 0;

	public Lorann(String nameFile, map Map) throws IOException 
	{
		super(nameFile);
		this.map = Map;
		this.RandomStartPosition();
		this.setPosition(getStartX(), getStartY());
		this.imageLorann = new Image[8];
		int y = 0;
		for (int i = 1; i <= 8;i++)
		{
			this.imageLorann[y] = ImageIO.read(new File("annex/lorann_" + i + ".png"));
			y++;
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
	
	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}
	
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
	
	public final void animationLorann()
	{
		if (numberImage == 8)
		{
			numberImage = 0;
		}
		this.setImage(imageLorann[numberImage]);
		numberImage++;
	}
	
	public final void rightMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[2]);
		}
	}
	public final void leftMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[6]);
		}
	}
	public final void forwardMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[0]);
		}
	}
	public final void backwardMouvementLorann()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V')
		{
			this.setPosition(NewX, NewY);
			this.setImage(imageLorann[4]);
		}
	}
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
}
