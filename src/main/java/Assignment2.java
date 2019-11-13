import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

import java.util.List;

import java.util.stream.Collectors;

public class Assignment2 {

	public void readFile(File f) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(f));

		String line = br.readLine();

		LinkedList<String> list = new LinkedList<String>();

		List<String> data = null;

		while(line!=null) {

			list.add(line);

			data = list.stream().map(p->p.toUpperCase()).collect(Collectors.toList());

			for(String t : list) {

               String s = new StringBuffer(t).reverse().toString();

               System.out.println(s);
 
			}

			line = br.readLine();

		}

		br.close();

	}
	
	
	
	public void readdFile(File f) throws IOException {

		if(f.isDirectory() || !f.getName().endsWith("txt")) {
			
			throw new RuntimeException("This Is Not A Valid File");
		}
		
		List<String> allLines = Files.readAllLines(Paths.get(f.getAbsolutePath()));
		allLines.stream().map(str->str.toUpperCase()).forEach(s->System.out.println(s));

	}
	
	
	public void reversee(File f) throws IOException {
		
		if(f.isDirectory() || !f.getName().endsWith("txt")) {
		
			throw new RuntimeException("This Is Not A Valid File");
		}
		
		List<String> allLines = Files.readAllLines(Paths.get(f.getAbsolutePath()));
		allLines.stream().map(str->new StringBuffer(str).reverse()).forEach(s->System.out.println(s));

	}

	public static void main(String[] args) throws IOException {

		Assignment2 a = new Assignment2();

		a.reversee(new File(System.getProperty("user.dir")+"/data.txt"));

	}

}