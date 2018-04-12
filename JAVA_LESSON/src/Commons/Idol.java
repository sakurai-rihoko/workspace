package Commons;

public class Idol {
	private String name;
	private int age;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "姓名:" + this.name +"\t"+ "年龄" + this.age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Idol(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	



}
