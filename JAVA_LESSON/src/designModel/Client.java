package designModel;

public class Client {
	public static void main(String[] args) {
		HungryMan hm = HungryMan.getInstance();
		HungryMan hm1 = HungryMan.getInstance();
		LazyMan lz = LazyMan.getInstance();

		System.out.println(hm);
		System.out.println(hm1);

	}

}
