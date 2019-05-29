package controller;

import model.IModel;
import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 */
public interface IController 
{
	public IModel getModel();
	public IView getView();
	
}
