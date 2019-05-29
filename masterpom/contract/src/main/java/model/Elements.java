package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import showboard.ISquare;

/**
 * <h1> the class Elements. <h1>
 * <p>
 * this class is use to create every elements of the game like bone, vertical bone and so on
 * </p>
 * <p>
 * the Elements class is a public class with 2 public attributes and 6 methods
 * </p>
 * <p>
 * the Elements class implement ISquare because he need to be show on a IBoard
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 * @see Elements
 * @see getImage
 * @see loadImage
 * @see setImage
 * @see getImageName
 * @see setImageName
 *
 */

public class Elements implements ISquare
{
	/**Image of an elements */
	public Image img_ob;
	/**Name the file which contain the sprite needed*/ 
	public String nameFile;
	
	/**This constructor is used to set a sprite for each elements of the game (bone, lorann, and so on*/ 
	public Elements(final String nameFile)
	{
		this.setImageName(nameFile);
	}
	
	/** Override method use to get the sprite of an element*/
	@Override
    public final Image getImage() 
	{
        return this.img_ob;
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
    protected void setImage(final Image image) 
    {
        this.img_ob = image;
    }

    /* Gets the image name.
     *
     * @return the image name
     */
    protected String getImageName() 
    {
        return this.nameFile;
    }

    /* Sets the image name.
     *
     * @param imageName the imageName to set
     */
    protected void setImageName(final String imageName) {
        this.nameFile = imageName;
    }
}