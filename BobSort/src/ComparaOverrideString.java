/**
 * 排序规则业务类
 * @author tokido_saya
 *
 */
import java.util.*;
public class ComparaOverrideString implements Comparator<String>{
	public int compare(String arr,String arr2) {
		int len1 = arr.length();
		int len2 = arr.length();
		
		return len1-len2;
	}
}
