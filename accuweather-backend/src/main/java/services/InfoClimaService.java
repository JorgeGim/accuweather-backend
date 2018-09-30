package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import model.Application;
import model.InfoClima;

@Service
@RequestMapping("app")
public class InfoClimaService 
{	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private InfoClima instance;
	
	@Value("${app.url}")
	private String url;
	
	public InfoClimaService() {}
	
	public InfoClima getInfo() throws IOException  
	{
		File file = new File("consumingTime.txt");
		
		if(!file.exists())
		{
			return consumeApiAndCreateFile();
		}
		
		else
		{
			BufferedReader bufferedReader = new BufferedReader(new FileReader("consumingTime.txt"));
			String contentFile = readFileAndGetData(bufferedReader);
			
			LocalTime lastTimeSaved = LocalTime.parse(contentFile);
			LocalTime actuallyTime = LocalTime.now();
				
			int minutesDifference = actuallyTime.getMinute() - lastTimeSaved.getMinute();
				
			checkMinutesDifference(file, minutesDifference);
		
			
		}
		
		
		return this.instance;
	}

	private void checkMinutesDifference(File file, int minutesDifference) 
	{
		if(minutesDifference > 15)
		{
			createNewFile(file);
			consumeApi();
		}
	}

	private void consumeApi() 
	{
		String url = getUrl();
		
		RestTemplate restTemplate = new RestTemplate();
		InfoClima infoClima = restTemplate.getForObject(url,
				InfoClima.class);
				log.info(infoClima.toString());
		
		this.instance = infoClima;
	}

	private void createNewFile(File file) 
	{
		file.delete();
		createFile();
	}

	private String readFileAndGetData(BufferedReader bufferedReader) throws IOException {
		try 
		{
			StringBuilder content = new StringBuilder();
			String line = bufferedReader.readLine();
			
			while(line != null)
			{
				content.append(line);
				line = bufferedReader.readLine();
			}
			
			return content.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			bufferedReader.close();
		}
		
		return "";
	}

	private InfoClima consumeApiAndCreateFile() 
	{
		consumeApi();
		System.out.println("CONSUME LA API");
		createFile();
		
		return this.instance;
	}

	private void createFile() {
		LocalTime localTime = LocalTime.now();
		String ret = localTime.toString();
		try {
			File archivo = new File("consumingTime.txt");
			
			FileWriter writer = new FileWriter(archivo, true);
			writer.write(ret);
			writer.close();
		}catch(Exception e)
		{
			System.out.println("fuck");
		}
	}
	
	@GetMapping("/value")
	public String getUrl()
	{
		return url;
	}
}
