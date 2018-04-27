package Javaassist;

public class LoveLiveMember {
	private String memberName;
	private int age;
	private int length;
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}


	public void sayHey(int a ) {
		System.out.println("Freesia"+ a);
	}


	public LoveLiveMember() {
		super();
	}
	public LoveLiveMember(String memberName, int age, int length) {
		this();
		this.memberName = memberName;
		this.age = age;
		this.length = length;
	}

}
