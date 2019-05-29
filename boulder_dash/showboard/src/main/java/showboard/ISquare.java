package showboard;

import java.awt.Image;
import java.io.IOException;

/**
 * <h1>The Interface ISquare.</h1>
 * <p>
 * A class can implement the ISquare interface when it wants to be show on a IBoard.
 * </p>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.1
 * @see Image
 */
public interface ISquare 
{


	/**
     * Gets the image.
     *
     * @return the image
	 * @throws IOException 
     */
    Image getImage();
}
