package DynamicComplile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class JSAPIDemo {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
		//获取脚本引擎
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		//定义变量，存储到引擎上下文中
		engine.put("msg","lovelive SunShine");
		String str = "var user = {name:'hanamaru',age:16,school:'fujixng'};";
		str += "print(user.name);";
		//执行脚本
		engine.eval(str);
		engine.eval("msg = 'svf for return';");
		System.out.println(engine.get("msg"));


		//定义函数
		engine.eval("function add(a,b){var sum = a+b;return sum;}");
		//取得调用接口
		Invocable jsInvoke = (Invocable)engine;
		//执行JS函数
		Object result = jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(result);


		//导入其他的java包，使用其他包中的java类
		String jsCode = "var list = java.util.Arrays.asList([\"北京尚学堂\",\"清华大学\",\"北京大学\"]);";//\"替代“ java8.0以后引入包直接使用之前
		engine.eval(jsCode);
		List<String> list = (List<String>)engine.get("list");
		for(String temp:list) {
			System.out.println(temp);
		}
       //执行一个js文件
		URL urls = JSAPIDemo.class.getClassLoader().getResource("test.js");
		System.out.println(urls.getPath());
		engine.eval(new FileReader(new File(urls.getPath())));
		Object result2 = jsInvoke.invokeFunction("add2",new Object[] {4,5});
		System.out.println(result2);

	}
}
