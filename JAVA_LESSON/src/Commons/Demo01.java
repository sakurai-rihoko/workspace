package Commons;
import java.util.ArrayList;
import java.util.List;

/**
 * 函数式编程之Predicate断言
 * 封装条件或判别式if..else替代
 * 1.new EqualPredicate<类型>(值）
 * EqualPredicate.equalPredicate(值)
 *2.NotNullPredicate
 *3.UniquePredicate.uniquePredicate()
 *4.自定义
 *5.组合
 *PredicateUtil.allPredicate/andPredicate/anyPredicate
 *工具类
 *PredicateXXX.predicateXXX()
 * @author tokido_saya
 *
 *
 *
 */
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;
public class Demo01 {
	public static void main(String[] args) {
	
	}

	public static void equal_Predicate() {
		//相等判断
				Predicate<String> pre = new EqualPredicate<String>("rihoko");
				Predicate<String> pre2 = EqualPredicate.equalPredicate("rihoko");
				boolean flag = pre.evaluate("ko");
				boolean flag2 = pre2.evaluate("rihoko");
				System.out.println(flag);
				System.out.println(flag2);
	}
	public static void notnull() {
		//非空判断

				Predicate notNull = NotNullPredicate.INSTANCE;
				Predicate notNull2 = NotNullPredicate.notNullPredicate();

				String str = null;
				String str2 = "rihoko";
				System.out.println(notNull2.evaluate(str));
				System.out.println(notNull2.evaluate(str2));
				List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
				list.add(1000L);
				list.add(null);//出现异常
	}
	public static void uniquePre() {
		//唯一判断
				Predicate<Long> uniquePre= UniquePredicate.uniquePredicate();
				List<Long> list = PredicatedList.predicatedList(new ArrayList(), uniquePre);
				list.add(100L);
				list.add(199L);
				list.add(100L);
	}
	public static void selfPre() {
		//自定义判断和组合
		//举例
		Predicate<String> selfPre = new Predicate<String>() {

			@Override
			public boolean evaluate(String arg0) {
				// TODO Auto-generated method stub
				return arg0.length() >= 5 && arg0.length() <= 20;

			}

		};
		Predicate notNull2 = NotNullPredicate.notNullPredicate();
		//组合
		Predicate newPred= PredicateUtils.allPredicate(selfPre,notNull2);
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), newPred);
		list.add("sakurt");
		//list.add(null);
		//list.add("sakurai_rihokopppppppppppppppp");

	}
}
