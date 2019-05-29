package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * <h1> The class ActionButton. </h1>
 * <p>
 * This class is used to catch mouse action by the user (when he click at "play")
 * </p>
 * <p>
 * The ActionButton class is a public class with 2 private attributes and 7 public methods
 * </p>
 * <p>
 * The ActionButton class extends JButton for the button interaction and implements MouseListener for the user's clicks
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 * @see mouseClicked
 * @see mousePressed
 * @see mouseReleased
 * @see mouseReleased
 * @see mouseEntered
 * @see mouseExited
 */

public class ActionButton extends JButton implements MouseListener 
{

	private static final long serialVersionUID = 1L;
	private int choice = 0;
	
	/** set the size, color and message of the button */
	public ActionButton (String str, int i, int y) {
		
		super (str);
		this.setFont(new Font("Serif", Font.PLAIN, 40));
		this.setBounds(i, y, 250, 100);
		this.setBackground(Color.red);
		this.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.setBackground(Color.orange);
		this.setChoice(1);
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.green);
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.red);
		
	}
	
	public int getChoice() {
		return choice;
	}



	public void setChoice(int choice) {
		this.choice = choice;
	}
	
}
