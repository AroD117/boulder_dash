package view;

import controller.IController;

public class thread_boulderdash extends Thread {

	
	IController controller;
	
	
	private final int loop = 100;
	
	
	public thread_boulderdash (String name, IController controller_p){
		super(name);
		this.controller = controller_p;
	}
	
	
	public void run(){
		  
		while (true) {
		
				 controller.getModel().getMap().getLorann().animationLorann();
				 controller.getView().updateMap();
				 
				 try {
					Thread.sleep(loop);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}			
		}
	  } 
	
}
