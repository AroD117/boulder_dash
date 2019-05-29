package view;

import controller.IController;

/**
 * <h1> The class thread_magicball. </h1>
 * <p>
 * This class is used in the following ways : move the magic ball and his animation independently of the rest of the program until a win or lose condition is trigger
 * </p>
 * <p>
 * The thread_magicball class is a public class with 1 attributes
 * </p>
 * <p>
 * The thread_magicball class extends Thread which allow this class to run independently of the rest of the program
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class thread_magicball extends Thread 
{

	
	IController controller;
	
	
	private final int loop = 10;
	
	/** this constructor define a thread (his name) */
	public thread_magicball  (String name, IController controller_p){
		super(name);
		this.controller = controller_p;
	}
	
	/** this method is run continuously until the thread is stop by a win or lose event*/
	public void run()
	{
			while (controller.getView().getStop() == 0) 
			{
					if (controller.getAnimationMagicBallStatement() == 1)
					{
						controller.getModel().getMap().getMagicBall().magicBallMouvement();
						controller.getModel().getMap().getMagicBall().animationBallMouvement();
						controller.getModel().getMap().getMagicBall().magicBallReachMonster(controller);
						controller.getView().updateMap();
					}
					 
					 try 
					 {
						Thread.sleep(loop);
					 } 
					 catch (InterruptedException e) 
					 {
						e.printStackTrace();
					 }	
			}
		
	} 
	
}