package ProducerConsumerProblem;
/**
 * 一个场景，共同资源
 * 生产者消费者模式，信号灯法
 * wait()会释放锁，sleep（）不释放锁
 * @author tokido_saya
 *
 */
public class Movie {
    private String pic;
    //信号灯
    //flag->true 生产者生产，消费者等待，唤醒生产者，消费者等待
    //flag->false生产者等待，消费者消费，唤醒消费者，生产者等待。

    private boolean flag = true;
    public boolean getFlag() {
    	return this.flag;
    }
    public void setFlag(boolean flag) {
    	this.flag = flag;
    }
    public synchronized void  play(String pic) throws InterruptedException {
    	if(!flag) {
    		this.wait();
    	}else {
    	   Thread.sleep(500);
    		this.pic = pic;
    		System.out.println("生产了："+this.pic);
    		this.notify();
    		this.flag = false;
    	}


    }
    public synchronized void watch() throws InterruptedException {
    	if(flag) {
    		this.wait();
    	}else {
    		Thread.sleep(200);
    		System.out.println("消费了："+this.pic);
    		this.notify();
    		this.flag = true;

    	}



    }

}
