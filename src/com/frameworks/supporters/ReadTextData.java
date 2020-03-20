package com.frameworks.supporters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextData {
public static void main(String[] args) throws IOException {
	File file = new File("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\supporters\\Text.txt");
boolean b=	file.createNewFile();
if(b)
	System.out.println("File is created");
else
	System.out.println("Return existing file");
FileReader filereader=new FileReader(file);
BufferedReader bf=new BufferedReader(filereader);
while(bf.ready())
	System.out.println(bf.readLine());
}
}
