package Thread;
/**
 * 静态代理 设计模式
 * 1.真实角色
 * 2.代理角色:持有真实角色的引用
 * 3.二者实现相同的接口
 * @author tokido_saya
 *
 */
public class staticProxy {
	public static void main(String[] args) {
		//创建真实角色
		Marry you = new You();	
		//创建代理角色+真实角色的引用
		WeddingCompany wCompany = new WeddingCompany(you);
		//执行任务
		wCompany.marry();
	}
	//接口
	
}
interface Marry{
	public abstract void marry();
}
//真实角色
class You implements Marry{
	public void marry() {

	}
}

//代理角色
class WeddingCompany implements Marry{
	private Marry you;
	public WeddingCompany() {

	}
	public WeddingCompany(Marry you) {
		this.you = you;
	}

	private void before() {
		
	}
	private void after() {
		
	}


	public void marry(){
		before();
		you.marry();
		after();
	}
}
