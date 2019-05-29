package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * <h1> The class HomePanel. </h1>
 * <p>
 * This class is used to create a panel with contents (image)
 * </p>
 * <p>
 * The HomePanel class is a public class with 1 private attribute and one image
 * </p>
 * <p>
 * The HomePanel class extends JPanl because he need to create a JPanel
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */

public class HomePanel extends JPanel 
{

private static final long serialVersionUID = 1L;
	
	private ActionButton button_choice_1_home;
	
	Image img_home;
	
	/** This constructor create a button into the panel and load an image into it*/
	public HomePanel () {
		this.setLayout(null);
		this.button_choice_1_home = new ActionButton ("Play", 230, 320);
		
		try {
			this.img_home = ImageIO.read(getClass().getResourceAsStream("/LorannHome.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		};	
	}
	
	
	/** paint the Panel create (set the size) and add the button create previously */
	public void paintComponent(Graphics g){ 
		
		g.drawImage(this.img_home, 0, 0, this.getWidth(), this.getHeight(), this);
		
		
		this.add(button_choice_1_home);
	}



	public ActionButton getButton_choice_1_home() {
		return button_choice_1_home;
	}



	public void setButton_choice_1_home(ActionButton button_choice_1_home) {
		this.button_choice_1_home = button_choice_1_home;
	}

}
	
