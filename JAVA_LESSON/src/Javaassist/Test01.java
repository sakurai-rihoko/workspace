package Javaassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试Javaassist生成一个新的类
 * @author tokido_saya
 *
 */
public class Test01 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("Javaassist.LoveiveLMemberAssist");

		//创建属性
		CtField f1 = CtField.make("private String memberName;", cc);
		CtField f2= CtField.make("private int age;",cc);
		CtField f3 = CtField.make("private int length;",cc);
		cc.addField(f1);
		cc.addField(f2);
		cc.addField(f3);

		//创建方法
		CtMethod m1 = CtMethod.make("public String getMemberName() {\n" +
				"		return memberName;\n" +
				"	}", cc);
		CtMethod m2 = CtMethod.make("public void setMemberName(String memberName) {\n" +
				"		this.memberName = memberName;\n" +
				"	}", cc);
		CtMethod m3 = CtMethod.make("public int getAge() {\n" +
				"		return age;\n" +
				"	}", cc);
		CtMethod m4 = CtMethod.make("public void setAge(int age) {\n" +
				"		this.age = age;\n" +
				"	}", cc);
		CtMethod m5 = CtMethod.make("public int getLength() {\n" +
				"		return length;\n" +
				"	}", cc);
		CtMethod m6 = CtMethod.make("public void setLength(int length) {\n" +
				"		this.length = length;\n" +
				"	}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		cc.addMethod(m3);
		cc.addMethod(m4);
		cc.addMethod(m5);
		cc.addMethod(m6);

		//添加构造器
		CtConstructor constructor1  = new CtConstructor(null,cc);
				CtConstructor constructor2  = new CtConstructor(new CtClass[] {pool.get("java.lang.String"),
				CtClass.intType,
				CtClass.intType

		}, cc);
		constructor1.setBody("{super();}");
		constructor2.setBody("{\n" +
				"		super();\n" +
				"		this.memberName = memberName;\n" +
				"		this.age = age;\n" +
				"		this.length = length;\n" +
				"	}");
		cc.addConstructor(constructor1);
		cc.addConstructor(constructor2);
	//写类
	cc.writeFile("/Users/tokido_saya/Downloads/");
    System.out.println("create class success!");
	}


}
