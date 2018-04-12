package IOpattern;

public class Voice {
	private int vol = 10;

	public Voice() {
		super();
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
	public void say() {
		System.out.println(vol);
	}
}
