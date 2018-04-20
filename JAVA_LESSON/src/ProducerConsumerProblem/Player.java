package ProducerConsumerProblem;
/**
 * 生产者
 * @author tokido_saya
 *
 */
public class Player implements Runnable{
	private Movie m;

	public Player(Movie m) {
		super();
		this.m = m;

	}
	public void run() {
		for(int i = 0;i<20;i++){
			if(i % 2 == 0){
				try {
					m.play("alterX");

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}else{
				try {
					m.play("classicX");

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
