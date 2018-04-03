package GUAVA;

import java.util.Set;

//import com.google.common.base.Preconditions;
//import com.google.common.collect.Constraint;
//import com.google.common.collect.Constraints;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.base.Preconditions;

import com.google.common.collect.Sets;

/**
 * 加入约束条件；非空，长度验证
 * constraint
 * Preconditions
 * Constraints
 * @author tokido_saya
 *
 */

public class Test03 {

	public static void main(String[] args) {
		 Set<String> testSet = Sets.newHashSet("njsxt","good","iriya","rin","sakura","arutoriya");

		 Constraint<String> constraintTest = new Constraint<String>() {

			@Override
			public String checkElement(String element) {
				// TODO Auto-generated method stub
				//非空验证
				Preconditions.checkNotNull(element);
				//长度验证5-20
				Preconditions.checkArgument(element.length() >= 5&&element.length() <= 20);
				return element;
			}
		 };

			Set<String> cs =  Constraints.constrainedSet(testSet, constraintTest);
			for(String temp:testSet) {
				System.out.println(temp);
			}
	}
}
