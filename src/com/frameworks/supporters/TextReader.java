package com.frameworks.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
	private String FilePath;
	private File file;
	private FileReader filereader;
	private BufferedReader bufferedreader;
	private FileWriter filewriter;
	private BufferedWriter bufferedWriter;

	public TextReader(String FilePath) throws IOException   // CONSTRUCTOR
	{
		this.FilePath = FilePath;
		file = new File(FilePath);
		boolean b = file.createNewFile();
		if (b)
			System.out.println("File is created");
		else
			System.out.println("Return existing file");
		
		filereader = new FileReader(file);
		bufferedreader = new BufferedReader(filereader);
		filewriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(filewriter);
		
	}

	public String getData() throws IOException {
			String value="";
			value=bufferedreader.readLine();
			//return bufferedreader.readLine();
		 return value;
	}

	public void writeData(int data) throws IOException {
		bufferedWriter.write(data);
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}

	public void writeData(String data) throws IOException {
		bufferedWriter.write(data);
		bufferedWriter.newLine();
		bufferedWriter.flush();
		
	}
	public void writeData(List<String> data) throws IOException {
		for(String data1:data )
		{
			bufferedWriter.write(data1);
			bufferedWriter.flush();
		}
	}
	
	public List<String> getTotalFileData() throws IOException 
	{
		
		List<String> data=new ArrayList<String>();
		while(bufferedreader.ready()) 
		{
			String value=	bufferedreader.readLine();
			data.add(value);
		}
		return data;
	}
	
	}

