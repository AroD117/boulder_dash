package view;

import javax.swing.JFrame;

/**
 * <h1> The class HomeFrame. </h1>
 * <p>
 * This class is used to displays a home Frame
 * </p>
 * <p>
 * The HomeFrame class is a public class with 1 private attribute
 * </p>
 * <p>
 * The HomeFrame class extends JFrame because he need to displays an image
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class HomeFrame extends JFrame  
{

	private static final long serialVersionUID = 1L;

	private HomePanel PanEdit;
	/** This constructor set the size of the home window, his color and put a panel into it*/
	public HomeFrame () {
		
		this.setTitle("Home");
	    this.setSize(700, 1000);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    
	    this.PanEdit = new HomePanel ();
	    this.setContentPane(this.PanEdit);
	    
	    
	    
	    this.setVisible(true);
		
		
		
	}

	public HomePanel getPanEdit() {
		return PanEdit;
	}

	public void setPanEdit(HomePanel panEdit) {
		PanEdit = panEdit;
	}
	
}
