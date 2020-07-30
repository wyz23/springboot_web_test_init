package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		if (args.length != 2) { //初始化参数不足2位
			System.out.println("命令执行错误！");
			System.exit(1);
		}
		//如果输入参数正确了，那么应该进行文件的验证
		File inFile = new File(args[0]);  //第一个为源文件的路径
		if (!inFile.exists()) {
			System.out.println("源文件不存在，请确认执行路径。");
			System.exit(1); //程序退出
		}
		//如果此时源文件正确，那么久需要定义输出文件，同时要考虑到输出文件有目录
		File outFile = new File(args[1]);
		if (!outFile.getParentFile().exists()) {	//输出文件路径不存在
			outFile.getParentFile().mkdir();	//创建目录
		}
		//实现文件内容的拷贝
		InputStream input = new FileInputStream(inFile);
		OutputStream output = new FileOutputStream(outFile);
		//实现文件拷贝
		//第一种效率非常慢
	/*	int temp = 0; //保存每次读取的内容
		while((temp = input.read()) != -1) { //每次读取单个字节
			output.write(temp); //输出单个字节
		}*/
		//第二种效率非常快，也是最常用的
		// 下面代码是整个拷贝的精髓所在，一直到output.close()
		int temp = 0; //保存每次读取的个数
		byte data[] = new byte [1024]; // 每次读取1024个字节
		// 将每次读取进来的数据保存在字节数组里面，并且返回读取的个数
		while((temp = input.read(data)) != -1) {
			output.write(data, 0, temp); // 输出数组
		}
		input.close();
		output.close();
		long end = System.currentTimeMillis();
		System.out.println("拷贝所花费的时间： " + (end - start));
	}
}
