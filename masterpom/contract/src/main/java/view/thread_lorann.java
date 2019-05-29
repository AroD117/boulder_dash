package view;

import controller.IController;

/**
 * <h1> The class thread_lorann. </h1>
 * <p>
 * This class is used in the following ways : run LorannaAimation independently of the rest of the program until a win or lose condition is trigger
 * </p>
 * <p>
 * The thread_lorann class is a public class with 1 attributes
 * </p>
 * <p>
 * The thread_lorann class extends Thread which allow this class to run independently of the rest of the program
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class thread_lorann extends Thread {

	
	IController controller;
	
	
	private final int loop = 100;
	
	/** this constructor define a thread (his name) */
	public thread_lorann (String name, IController controller_p){
		super(name);
		this.controller = controller_p;
	}
	
	/** this method is run continuously until the thread is stop by a win or lose event*/
	public void run(){
		  
		while (controller.getView().getStop() == 0) 
		{
		
				 controller.getModel().getMap().getLorann().animationLorann();
				 controller.getView().updateMap();
				 
				 try {
					Thread.sleep(loop);
				} catch (InterruptedException e) {
					e.printStackTrace();
			}			
		}
	  } 
	
}
