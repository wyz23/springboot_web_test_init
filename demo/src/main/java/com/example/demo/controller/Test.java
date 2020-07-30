package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		File fileA = new File("F:" + File.separator + "infoa.txt");
		File fileB = new File("F:" + File.separator + "infob.txt");
		InputStream inputA = new FileInputStream(fileA);
		InputStream inputB = new FileInputStream(fileB);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int temp =0;
		while ((temp = inputA.read()) != -1) {
			output.write(temp);
		}
		while ((temp = inputB.read()) != -1) {
			output.write(temp);
		}
		//现在所有的内容都保存在了内存输出流里面，所有的内容变为字符数组取出
		byte data[] = output.toByteArray();
		output.close();
		inputA.close();
		inputB.close();
		System.out.println(new String(data));
	}
}
