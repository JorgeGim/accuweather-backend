package model;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) 
	{

		LocalTime localTime = LocalTime.now();
		String ret = localTime.toString();
		try {
			File archivo = new File("hora.txt");
			
			FileWriter writer = new FileWriter(archivo, true);
			writer.write(ret);
			writer.close();
		}catch(Exception e)
		{
			System.out.println("fuck");
		}
		
		File af = new File("hora.txt");
		if(af.exists())
		{
			System.out.println("existe");
		}
		

	}

}
