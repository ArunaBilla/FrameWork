package com.frameworks.supporters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextData {
public static void main(String[] args) throws IOException {
	File file=new File("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\supporters\\Text.txt");
	boolean b=file.createNewFile();
	if(b)
		System.out.println("File is created");
	else
		System.out.println("Return existing file");
	FileWriter fw=new FileWriter(file);
	BufferedWriter bw=new BufferedWriter(fw);
	bw.write("Hello");
	bw.newLine();
	bw.write("java with selenium");
	bw.newLine();
	bw.write("practice");
	bw.flush();
}
}
