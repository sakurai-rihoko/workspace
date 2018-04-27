package annotation;
@AnnoTable("tb_student")
public class AnnoStudent {
	@AnnoField(columnName = "id",type = "int",length = 10)
	private int id;
	@AnnoField(columnName = "sname",type = "varchar",length = 10)
	private String stuName;
	@AnnoField(columnName = "age",type = "int",length = 3)
	private int age;
	
	
	
	
	public AnnoStudent() {
		super();
	}
	public AnnoStudent(int id, String stuName, int age) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
