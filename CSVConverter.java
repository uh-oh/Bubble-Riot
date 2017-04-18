/**This class takes a csv file and converts it into a Java 
*ArrayList<ArrayList<String>> object and vice versa takes a Java 
*ArrayList<ArrayList<String>> object and converts it to a csv file*/

import java.io.*;
import java.util.*;

public class CSVConverter
{

    //constructor
	public CSVConverter(){}
	
	//Public Method Convert to Array List
	/**this method converts a csv file to a java ArrayList<ArrayList<String>>
	*object
	*@param fileToBeConverted this is the file that will be converted to a java
	*ArrayList<String[]> object
	*@param FR this is a file reader object
	*@param BR this is a buffered file reader object
	*@param tempArrayList is a the temporary ArrayList Object used by this
	*@param line
	*@param Stuff is the string[] value
	*method*/
	public ArrayList<ArrayList<String>> ConvertToArrayList(File fileToBeConverted)
	{
		ArrayList<String> tempArrayList1 = new ArrayList<String>();
        ArrayList<ArrayList<String>> tempArrayList2= new ArrayList<ArrayList<String>>();
		FileReader FR = getFR(fileToBeConverted);
		BufferedReader BR = new BufferedReader(FR);
		String line = "";
		line = getLine(BR);
		
		if (line == null)
		{
			//Do Nothing
		}
		else
		{
			int a = countElements(line);
			String[] Stuff = new String[a];
			Stuff = line.split(",");
			tempArrayList1 = AtoA(Stuff);
            tempArrayList2.add(tempArrayList1);
		}
		
		while (line != null)
		{
		line = getLine(BR);
		
		if (line == null)
		{
			//Do Nothing
		}
		else
		{
			int a = countElements(line);
			String[] Stuff = new String[a];
			Stuff = line.split(",");
			tempArrayList1 = AtoA(Stuff);
            tempArrayList2.add(tempArrayList1);
		}
		
		}
		
		return tempArrayList2;
		
	}
	
	private ArrayList<String> AtoA (String[] a)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i<a.length;i++)
		{
			temp.add(a[i]);
		}
		return temp;
	}
	
	/**this method catches the exceptions that the FileReader Constructor throws
	*@param file the file that the FileReader object is made from
	*@param tempFileReader is a temporary file Reader object this method uses
	*@param e this is the standard exception variable*/
	private FileReader getFR(File file)
	{
		FileReader tempFileReader = null;
		try
		{
			tempFileReader = new FileReader(file);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
			System.exit(0);
		}
		return tempFileReader;
	}
	
	/**this method catches the IOException that the readLine() method throws*/
	private String getLine(BufferedReader bfrd)
	{
		String tempString = "";
		try
		{
			tempString = bfrd.readLine();
			return tempString;
		}
		catch (IOException e)
		{
			return null;	
		}
		
	}
	
	private int countElements(String s)
	{
		int count = 0;
		for(int i = 0; i<s.length();i++)
		{
			if(s.charAt(i) == ',')
			{
				count++;
			}
			else
			{
				//do nothing
			}
		}
		count++;// the number of elements in a csv line is the number of commas 
		        //plus one
		        
		return count;
	}
	
	//Public Method ConvertToCSW
	/**this method converts a csv file to a java ArrayList<String[]> object
	*@param arrayListToBeConverted this is the ArrayList<String[]> object that 
	*will be converted to a csv file
	*@param fileName this is the name of the file that the ArrayList<String[]>
	*object will be written to
	*@param FW file writer
	*@param file file
	*@param PW printwriter
	*@param length fdg
	*@param fff sfgdgd
	*/
	public File ConvertToCSV(ArrayList<ArrayList<String>> arrayListToBeConverted, String
	fileName)
	{
		File file = new File(fileName);
		FileWriter FW = getFileWriter(file);       
		PrintWriter PW = new PrintWriter(FW);
		
		
		int arrayListLength = arrayListToBeConverted.size();
		int arrayLength;
        int i;
		
		for (i = 0; i< arrayListLength; i++)
		{
			arrayLength = arrayListToBeConverted.get(i).size();
			
			for(int k = 0; k< arrayLength; k++)
			{
				PW.print(arrayListToBeConverted.get(i).get(k));
				PW.print(",");
			}
			
			PW.println();
		}
		PW.close();
		return file;
	}
	
	/** this method catches the IOException that the FileWriter Constructor
	*throws*/
	private FileWriter getFileWriter(File f)
	{
		FileWriter tempFileWriter = null;
		try
		{
			tempFileWriter = new FileWriter(f);
		}
		catch(IOException e)
		{
			System.out.println("IOException getting a FileWriter");
			System.exit(0);
		}
		return tempFileWriter;
	}
			
}
	
	
