package Commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/**
 * 函数式编程Closure闭包，封装特定的业务功能
 * CollectionUtils.forAllDo();
 * @author tokido_saya
 *
 */
public class Demo03 {
	public static void main(String[] args) {
	basic();
	ifClosure();
	whileClosure();
	chairedClosure();
	}


	/**
	 * 先打9折，满百再减20
	 */
	public static void chairedClosure() {
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(new Goods("Persona5",428,true));
		goodsList.add(new Goods("valkitra4",400,false));
		goodsList.add(new Goods("MHW", 330, false));
		Closure<Goods> subtract = new Closure<Goods>() {

			@Override
			public void execute(Goods arg0) {
				// TODO Auto-generated method stub
				if(arg0.getPrice() > 100) {
				arg0.setPrice((arg0.getPrice()-20));
				}
			}
		};

		Closure<Goods> discount  = new Closure<Goods>() {

			@Override
			public void execute(Goods arg0) {
				// TODO Auto-generated method stub
				arg0.setPrice(arg0.getPrice() * 0.9);
			}
		};
		//链式操作
		Closure<Goods> chainclo = ChainedClosure.chainedClosure(discount,subtract);
		CollectionUtils.forAllDo(goodsList, chainclo);
		Iterator<Goods> iter =  goodsList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}


	public static void whileClosure() {

		/**
		 * 保证所有employee工资大于20000
		 */
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("田中美海", 18000));
		empList.add(new  Employee("种田梨纱", 25000));
		empList.add(new Employee("佐仓绫音", 20000));

		//闭包
		Closure<Employee> cols= new Closure<Employee>() {

			@Override
			public void execute(Employee arg0) {
				// TODO Auto-generated method stub
				arg0.setSalary(arg0.getSalary()*1.2);
			}
		};
		Predicate<Employee> upPre = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee arg0) {
				// TODO Auto-generated method stub
				return arg0.getSalary() < 20000;
			}
		};

		//false表示while结构 先判断后执行     true do..while 先执行后判断
		Closure<Employee> whileCols = WhileClosure.whileClosure(upPre, cols, false);

		//工具类
		CollectionUtils.forAllDo(empList, cols);
		//操作后的数据
		Iterator<Employee> empIt =  empList.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
		}


	}



	public static void ifClosure() {
		/**
		 * 二选一操作
		 */
		List<Goods> goodsList = new ArrayList<Goods>();
		goodsList.add(new Goods("Persona5",428,true));
		goodsList.add(new Goods("valkitra4",400,false));
		goodsList.add(new Goods("MHW", 330, false));
		Closure<Goods> subtract = new Closure<Goods>() {

			@Override
			public void execute(Goods arg0) {
				// TODO Auto-generated method stub
				arg0.setPrice((arg0.getPrice()-20));
			}
		};

		Closure<Goods> discount  = new Closure<Goods>() {

			@Override
			public void execute(Goods arg0) {
				// TODO Auto-generated method stub
				arg0.setPrice(arg0.getPrice() * 0.9);
			}
		};


		Predicate<Goods> pre = new Predicate<Goods>() {

			@Override
			public boolean evaluate(Goods arg0) {
				// TODO Auto-generated method stub
				return arg0.isDiscount();
			}
		};
		//二选一判断 ture:discount false:subtaract
		Closure<Goods> ifClo  = IfClosure.ifClosure(pre, discount,subtract);
		CollectionUtils.forAllDo(goodsList, ifClo);
		Iterator<Goods> iter =  goodsList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}


	}



	public static void basic(){
		List<Idol> empList = new ArrayList<Idol>();
		empList.add(new Idol("田中美海", 24));
		empList.add(new  Idol("种田梨纱", 27));
		empList.add(new Idol("佐仓绫音", 26));

		//闭包
		Closure<Idol> cols= new Closure<Idol>() {

			@Override
			public void execute(Idol arg0) {
				// TODO Auto-generated method stub
				arg0.setAge(arg0.getAge() + 1);
			}
		};

		//工具类
		CollectionUtils.forAllDo(empList, cols);
		//操作后的数据
		Iterator<Idol> empIt =  empList.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
		}
	}
}
