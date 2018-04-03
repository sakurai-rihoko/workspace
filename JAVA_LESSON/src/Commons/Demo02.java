package Commons;
/**
 * 函数式编程 Transformer类型转化
 * new Transformer<Long, String>()
 * override transform
 * @author tokido_saya
 *
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

public class Demo02 {
	public static void main(String[] args) {
		Predicate<Employee> isLow = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee arg0) {
				// TODO Auto-generated method stub
				return arg0.getSalary() < 10000;
			}

		};

		Predicate<Employee> isHigh = new Predicate<Employee>() {

			@Override
			public boolean evaluate(Employee arg0) {
				// TODO Auto-generated method stub
				return arg0.getSalary() >= 10000;
			}

		};
		//转换

		Predicate[] pres = {isLow,isHigh};


		Transformer<Employee, level> lowTrans  = new Transformer<Employee, level>() {

			@Override
			public level transform(Employee arg0) {
				// TODO Auto-generated method stub
				return new level(arg0.getName(), "卖身等级");
			}

		};

		Transformer<Employee, level> highTrans = new Transformer<Employee, level>() {

			@Override
			public level transform(Employee arg0) {
				// TODO Auto-generated method stub
				return new level(arg0.getName(), "养生等级");
			}

		};

		Transformer[] trans = {lowTrans,highTrans};

		Transformer switchTrans = new SwitchTransformer<>(pres, trans, null);

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("老马", 12000));
		list.add(new Employee("老高", 9000));

		Collection<level> levelList = CollectionUtils.collect(list, switchTrans);

		for(level temp:levelList) {
			System.out.println(temp);
		}



	}

	public static void selfTrans01() {
		//内置类型转换，长整型时间日期，转成指定格式的字符串

		Transformer<Long, String> trans01 = new Transformer<Long, String>() {

			@Override
			public String transform(Long arg0) {
				// TODO Auto-generated method stub
				return new SimpleDateFormat("yyyy年MM月dd日").format(arg0);
			}

		};
		List<Long> list = new ArrayList<Long>();
		list.add(100000L);
		list.add(300000000L);
		//工具类
		Collection<String> result = CollectionUtils.collect(list, trans01);
		for(String temp:result) {
			System.out.println(temp);
		}
	}
}
