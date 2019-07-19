package game;

public class Loader extends Thread{
	
	private Thread t;
	private String threadName;
	private boolean pom, cleanstart;
	
	public Loader(String name){
		threadName=name;
		cleanstart=true;
	}
	
	 public void run() {
	    while(cleanstart){
	    pom=true;
	    try {
	    	ImageLoader.loadMedia();
	    } catch (Exception e) {
	         System.out.println(e);
	         pom=false;
	     }cleanstart=!pom;
	     }
	     System.out.println("Thread " +  threadName + " has finished.");
	     Intro.letTheMenuLoad();
	     
	     try {
	     join();
	     }catch (Exception e) {
	    	 System.out.println(e);
	     }
	   }
	   
	   public void start (){
	      System.out.println("Starting " +  threadName + " thread.");
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
}
