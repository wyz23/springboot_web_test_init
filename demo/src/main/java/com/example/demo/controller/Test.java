package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
public static void main(String[] args) throws Exception {
	String str = "Hello %$ World!!!"; //小写转大写，，，内存流
	InputStream input = new ByteArrayInputStream(str.getBytes());
	OutputStream output = new ByteArrayOutputStream();
	int temp = 0;
	while ((temp = input.read()) != -1) {
		output.write(Character.toUpperCase(temp));
	}
	System.out.println(output);
	input.close();
	output.close();
}
}
