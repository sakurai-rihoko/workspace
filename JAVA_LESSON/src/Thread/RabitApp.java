package Thread;

public class RabitApp {
	public static void main(String[] args) {
		Rabbit rab = new Rabbit();
		Tortoise tortoise = new Tortoise();
		rab.start();
		tortoise.start();

	    for(int i = 0;i < 1000 ;i++) {
			System.out.println("main"+i );
    }


	}
}
