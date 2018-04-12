package otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import sun.misc.OSEnvironment;

public class SplitFile {
	private String filePath;
	private int size;//块数
	private long blockSize;
	private List<String> blockPath;
	private String destPath;//分割后的目录
	private String fileName;
	private long length;


	public SplitFile() {
		this.blockPath = new ArrayList<String>();
	}

	public SplitFile(String filePath) {
		this();
		this.blockSize = 1024;
		this.filePath= filePath;

	}
	public SplitFile(String filePath,long blockSize,String destPath) {
		this();
		this.blockSize = blockSize;
		this.filePath= filePath;
		this.destPath= destPath;
		init();
	}

	public void init() {
		File src = null;
		if(this.filePath ==null||!((src = new File(filePath)).exists())) {
				return;
		}
		if(src.isDirectory()) {
			return;
		}

		 this.length = src.length();
		if(length < this.blockSize) {
			this.blockSize = length;
		}
		size = (int)Math.ceil(length*1.0/this.blockSize);
		this.fileName = (new File(this.filePath)).getName();
		initFileName();
	}
	private void initFileName() {

		for(int i = 0;i < this.size;i++) {
			this.blockPath.add(this.destPath+"/"+this.fileName+".part"+i);
		}
	}

	/**
	 * 文件分割
	 * 1.起始位置
	 * 2.实际大小
	 * @param destPath
	 * @throws IOException
	 */
	public void split() {
		long beginPos = 0;
		long actualBlockSize = blockSize;//实际分割大小


		for(int i= 0;i < size;i++) {
			if(i == size -1) {//最后一块
				actualBlockSize = this.length - beginPos;
			}
			splitDetail(i, beginPos, actualBlockSize);
			beginPos += blockSize;
		}

	}
	private void splitDetail(int idx,long beginPos,long actualBlockSize)  {
		//创建源
		File src = new File(this.filePath);
		File dest = new File(blockPath.get(idx));
		//创建选择流
		RandomAccessFile rnd = null;
		BufferedOutputStream bos = null;

		try {
			rnd = new RandomAccessFile(src, "r");
			rnd.seek(beginPos);//读取标记
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			//缓存区
			byte[] flush = new byte[1024];
			//接受长度
			int len = 0;
			while((len = rnd.read(flush))!= -1) {
				if(actualBlockSize - len >=0) {//判断单次写的长度是否足够
					bos.write(flush,0,len);
					actualBlockSize-= len;
				}else {
					bos.write(flush,0,(int)actualBlockSize);
					break;
				}
			}
			bos.flush();




		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				rnd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}
	/**文件的合并
	 *
	 * @param destPath
	 */
	public void mergeFile1() {
		File dest = new File(this.destPath);

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));
			for(int i =0;i < this.blockPath.size();i++) {
				bis = new BufferedInputStream(new FileInputStream(this.blockPath.get(i)));
				byte[] flush = new byte[1024];
				int len = 0;
				while(-1 != (len = bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}
	public void mergeFile2() {
		File dest = new File(this.destPath);


		BufferedOutputStream bos = null;
		SequenceInputStream sis =null;//多流组合类
		//创建容器存储流
		Vector<InputStream> vi = new Vector<InputStream>();
		for(int i =0;i < this.blockPath.size();i++) {
			try {
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			  bos = new BufferedOutputStream(new FileOutputStream(dest,true));
			  sis = new SequenceInputStream(vi.elements());

				byte[] flush = new byte[1024];
				int len = 0;
				while(-1 != (len = sis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				sis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public static void main(String[] args) {
		SplitFile file = new SplitFile("/Users/tokido_saya/Downloads/thunder_mac_3.2.1.3518.dmg",1024*1024,"/Users/tokido_saya/Downloads/");
		file.split();
		System.out.println(file.size);
	}


}
