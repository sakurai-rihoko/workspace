package ProducerConsumerProblem;

public class Watcher implements Runnable{
	private Movie m;

	public Watcher(Movie m){
	    super();
	    this.m = m;
	    
    }
    public void run(){
        for(int i= 0;i < 20;i++){
            try {
				m.watch();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
    }
}
