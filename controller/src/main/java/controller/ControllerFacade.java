package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import model.IModel;
import view.thread_boulderdash;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 */
public class ControllerFacade implements IController, KeyListener
{

    /** The view. */
    private final IView  view;
    /** The model. */
    private final IModel model;
    
    thread_boulderdash thread;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        this.thread = new thread_boulderdash ("test", this);
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     * @throws InterruptedException 
     */
    public void start() throws SQLException, InterruptedException 
    {
    	this.getView().run();
    	this.thread.start();
    	this.getView().getBoardFrame().addKeyListener(this);
    	this.getView().getBoardFrame().requestFocus();
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

	@Override
	public void keyTyped(KeyEvent e) 
	{
			
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		switch(keyCode)
		{
			case KeyEvent.VK_NUMPAD1:
				this.getModel().getMap().getLorann().leftMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD2:
				this.getModel().getMap().getLorann().backwardMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD3:
				this.getModel().getMap().getLorann().rightMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD5:
				this.getModel().getMap().getLorann().forwardMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD6:
				this.getModel().getMap().getLorann().diagonalRightForwardMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD4:
				this.getModel().getMap().getLorann().diagonalLeftForwardMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_E:
				this.getModel().getMap().getLorann().diagonalRightBackwardMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_Z:
				this.getModel().getMap().getLorann().diagonalLeftBackwardMouvementLorann();
				spotEven();
				this.getView().updateMap();
				break;
			}
	}
	public void spotEven()
	{
		int LorannX = this.getModel().getMap().getLorann().getX();
		int LorannY = this.getModel().getMap().getLorann().getY();
		this.getView().OpenGate(LorannX, LorannY);
		this.getView().getPurse(LorannX, LorannY);
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}
}
