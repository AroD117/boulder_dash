package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.IPawn;
import showboard.ISquare;

public abstract class Mobile implements ISquare
{
	public Image img;
	public String nameFile;
	
	public Mobile(final String nameFile)
	{
		this.setImageName(nameFile);
	}
	
	@Override
    public Image getImage() 
	{
        return this.img;
    }

    /* Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException 
    {
        this.setImage(ImageIO.read(new File("annex/" + this.getImageName())));
    }

    /* Sets the image.
    *
     * @param image the new image
     */
    public void setImage(Image image) 
    {
        this.img = image;
    }

    /* Gets the image name.
     *
     * @return the image name
     */
    private String getImageName() 
    {
        return this.nameFile;
    }

    /* Sets the image name.
     *
     * @param imageName the imageName to set
     */
    private void setImageName(final String imageName) {
        this.nameFile = imageName;
    }
}
