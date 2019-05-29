package view;

import controller.IController;

/**
 * <h1> The class thread_monster. </h1>
 * <p>
 * This class is used in the following ways : move the monsters independently of the rest of the program until a win or lose condition is trigger
 * </p>
 * <p>
 * The thread_monster class is a public class with 1 attributes
 * </p>
 * <p>
 * The thread_monster class extends Thread which allow this class to run independently of the rest of the program
 * </p>
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class thread_monster extends Thread
{
	IController controller;
	
	
	private final int loop = 400 ;
	
	/** this constructor define a thread (his name) */
	public thread_monster (String name, IController controller_p)
	{
		super(name);
		this.controller = controller_p;
	}
	
	/** this method is run continuously until the thread is stop by a win or lose event, in this method the monster can move only if he is alive*/
	public void run()
	{
		  
		while (controller.getView().getStop() == 0) 
		{
			if (controller.getModel().getMap().getMonster1().isAliveMonster() == true)
			{
				controller.getModel().getMap().getMonster1().monstersTrackingLorann();
				controller.getView().monsterReachingLorann();
			}
			if (controller.getModel().getMap().getMonster2().isAliveMonster() == true)
			{
				controller.getModel().getMap().getMonster2().RamdomMovingMonster();
				controller.getView().monsterReachingLorann();
			}
			if (controller.getModel().getMap().getMonster3().isAliveMonster() == true)
			{
				controller.getModel().getMap().getMonster3().RamdomMovingMonster();
				controller.getView().monsterReachingLorann();
			}
			if (controller.getModel().getMap().getMonster4().isAliveMonster() == true)
			{
				controller.getModel().getMap().getMonster4().monsterTrackingLorannSmarter();
				controller.getView().monsterReachingLorann();
			}
			controller.getView().updateMap(); 
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
