package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test {
	public static void main(String[] args) throws Exception {
		// String str = "Hello %$ World!!!"; //小写转大写，，，内存流
		// InputStream input = new ByteArrayInputStream(str.getBytes());
		// OutputStream output = new ByteArrayOutputStream();
		// int temp = 0;
		// while ((temp = input.read()) != -1) {
		// output.write(Character.toUpperCase(temp));
		// }
		// System.out.println(output);
		// input.close();
		// output.close();
//		**********************************************************************
//		File fileA = new File("F:" + File.separator + "infoa.txt");
//		File fileB = new File("F:" + File.separator + "infob.txt");
//		InputStream inputA = new FileInputStream(fileA);
//		InputStream inputB = new FileInputStream(fileB);
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		int temp =0;
//		while ((temp = inputA.read()) != -1) {
//			output.write(temp);
//		}
//		while ((temp = inputB.read()) != -1) {
//			output.write(temp);
//		}
//		//现在所有的内容都保存在了内存输出流里面，所有的内容变为字符数组取出
//		byte data[] = output.toByteArray();
//		output.close();
//		inputA.close();
//		inputB.close();
//		System.out.println(new String(data));
//		**********************************************************************
//		System.in是InputStream类对象
//		BufferedReader的构造方法里面需要接受Reader类对象
//		利用InputStreamReader将字节流变为字符流
//		BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("请输入数据：");
//		String str = buf.readLine();  //以回车作为换行
//		if(str.matches("\\d{1,3}") ) {
//			System.out.println("是数字");
//		}
//		System.out.println("输入的内容：" + str);
//		**********************************************************************
		//BufferedReader 读文件速度比InputStream方便
		//readLine(); 每次只能读取一行数据，my.txt有很多行数据
		File file = new File("F:" + File.separator + "my.txt");
		BufferedReader buf  = new BufferedReader(new FileReader(file));
		String str = null;
		//(str = buf.readLine()) != null ；  读到最后为null是才停止读
		while ((str = buf.readLine()) != null) {
			System.out.println(str);
		}
		buf.close();
	}
}
