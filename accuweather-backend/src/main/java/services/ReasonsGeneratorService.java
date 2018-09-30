package services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReasonsGeneratorService 
{	
	private static final Map<Integer, String> reasonsWhyUnavailable = new HashMap<Integer, String>();
	
	public ReasonsGeneratorService() 
	{
		reasonsWhyUnavailable.put(12, "Showers");
		reasonsWhyUnavailable.put(13, "Mostly Cloudy with Showers");
		reasonsWhyUnavailable.put(14, "Partly sunny with showers");
		reasonsWhyUnavailable.put(15, "Thunderstorms");
		reasonsWhyUnavailable.put(16, "Mostly Cloudy with Showers");
		reasonsWhyUnavailable.put(17, "Partly Sunny with Storms");
		reasonsWhyUnavailable.put(18, "Rain");
		reasonsWhyUnavailable.put(39, "Partly Cloudy with Showers");
		reasonsWhyUnavailable.put(40, "Mostly Cloudy with Showers");
		reasonsWhyUnavailable.put(41, "Party Cloudy with Storms");
		reasonsWhyUnavailable.put(42, "Mostly Cloudy with Storms");
	}
	
	public Map<Integer, String> getReasons(int... numbers) 
	{
		HashMap<Integer, String> aux = new HashMap<Integer, String>();
		aux.putAll(reasonsWhyUnavailable);
		
		for(int item: numbers)
		{
			aux.entrySet().removeIf(entry -> entry.getKey() == item);
		}
		
		return aux;
	}
}
