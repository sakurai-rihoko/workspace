package otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;



public class ObjectXStream {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Employee ee = new Employee("rihoko",100000);//name添加了transiant属性屏蔽序列化
		writeObject("/Users/tokido_saya/Downloads/object.txt", ee);
		readObject("/Users/tokido_saya/Downloads/object.txt");

	}
	public static void writeObject(String destPath,Object obj) throws FileNotFoundException, IOException {
		ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(destPath))));
		int[] tmp = {1,2,3,4,5};
		os.writeObject(obj);
		os.writeObject(tmp);
		os.close();
	}
	public static void readObject(String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		//1.7新回收机制不需要close()
		try(
		ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(srcPath))));
		)
		{
		Employee ee = (Employee)is.readObject();
        int[] tmp = (int[])is.readObject();
		System.out.println(ee.toString());
		System.out.println(Arrays.toString(tmp));
		}

	}
}
