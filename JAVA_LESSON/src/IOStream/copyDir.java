package IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件夹拷贝
 * 1.
 * @author tokido_saya
 *
 */
public class copyDir {
	public static void main(String[] args) {

	}
	public static void copyDir(File src,File dest) throws IOException {

		if(src.isFile()) {
			copyFile.copyFile(src.getAbsolutePath(),dest.getAbsolutePath());
		}else if(src.isDirectory()) {
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
				return;
			}//父目录不能拷贝到子目录中
			dest.mkdirs();
			for(File sub:src.listFiles()) {
				copyDir(sub,new File(dest,sub.getName()));
			}
		}


	}
}
