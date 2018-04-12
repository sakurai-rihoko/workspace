package otherStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 文件分割思路
 * 1.分割的块数size n块
 * 2.每一块的大小blocksize
 * 最后；总的文件大小（
 * @author tokido_saya
 *
 */
public class RandAccess {
	public static void main(String[] args) throws IOException {
		try(
		RandomAccessFile rnd = new RandomAccessFile(new File("/Users/tokido_saya/Desktop/curl.py"), "r");
				){
		rnd.seek(40);
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=rnd.read(flush))) {
			if(len >= 200) {
			System.out.println(new String(flush,0,200));
			break;
			  }else {
				System.out.println(new String(flush,0,len));
			}
		}
		}

	}
}
