package com.example;

import java.io.*;
import java.util.*;
public class BookService{
	
	public Object readFromStream(File file) {
		
		Object obj = null;
		
		try(ObjectInputStream inStream=
				new ObjectInputStream(new FileInputStream(file))) {
			
			obj=inStream.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();		}
	
		return obj;
		
	}
	public boolean writeToStream(File file, Book book) {
		
		boolean result =false;
		
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
			
	outputStream.writeObject(book);	
	
	result=true;
	
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		return result;
	}

//public class BookService {
//	
//	public boolean writeToFile(File file, Book book) {
//		
//		boolean result=false;
//		
//		try(PrintWriter writer =  new PrintWriter(new FileWriter(file),true);) {
//			
//			writer.println(book);
//			
//			return true;
//		}
//			
//			catch (IOException e) {
//		
//
//			e.printStackTrace();
//		}
//		
//		return result;
//		
	

	public List<Book>readFromFile(File file){
		
		List<Book>bookList= new ArrayList<Book>();
		
		String line=null;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			while((line=reader.readLine())!=null) {
				
				String[] values=line.split(",");
				
				Book book= new Book(Integer.parseInt(values[0]),
						values[1],values[2],
						Double.parseDouble(values[3]));
			}
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
		return bookList;
		
		}
	}
