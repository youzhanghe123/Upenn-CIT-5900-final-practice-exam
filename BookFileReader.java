
package book.file;

import java.io.*;

import java.util.*;


/**
 * Manages the loading of book files.
 * @author lbrandon 20220418
 *
 */
public class BookFileReader {

	/**
	 * Loads the given filename and adds each line to a list.
	 * Ignores lines with only whitespace.
	 * @param fileName to load
	 * @return list of lines from the file
	 */
	public static List<String> parseFile(String fileName) {
		
		// TODO Implement method
		// Hint: Load and read each line in the file.
		// Strip each line of whitespace
		// If a line is made up entirely of whitespace, ignore it and do not add it to the list.
		// Return a list of lines.
		List<String> result= new ArrayList();
		
		File myFile = new File(fileName);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader=new FileReader(myFile);
			bufferedReader=new BufferedReader(fileReader);
			
			String line;
			
			while((line=bufferedReader.readLine())!=null)
			{
				if (line.strip().isEmpty()==false)
				{
				result.add(line.strip());
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
		
		//load and parse book file cat in the hat
		List<String> catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//get first 10 lines of cat in the hat
		System.out.println("GET FIRST 10 LINES FROM CAT IN THE HAT\n");
		int count = 0;
		for (String line : catInTheHat) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
		
		//load and parse book file war and peace
		List<String> warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//get first 10 lines of war and peace
		System.out.println("\n\nGET FIRST 10 LINES FROM WAR AND PEACE\n");
		count = 0;
		for (String line : warAndPeace) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
		//load and parse book file siddhartha
		List<String> siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//get first 10 lines of siddhartha
		System.out.println("\n\nGET FIRST 10 LINES FROM SIDDHARTHA\n");
		count = 0;
		for (String line : siddhartha) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
	}
}