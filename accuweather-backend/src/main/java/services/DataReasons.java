package services;

import java.util.HashMap;
import java.util.Map;

public class DataReasons {
	
	private static final Map<Integer, String> reasonsWhyUnavailable = new HashMap<Integer, String>();
	
	public static Map<Integer, String> getReasonswhyunavailable() {
		return reasonsWhyUnavailable;
	}

	public DataReasons() 
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
	
	public static Map<Integer, String> getReasonsFor(String sportName)
	{
		switch(sportName) {
		case "Tennis":
			reasonsWhyUnavailable.entrySet().removeIf(entry -> entry.getKey() == 16 || entry.getKey() == 14 || entry.getKey() == 13);
			return reasonsWhyUnavailable;
		
		case "Volleyball":
			return reasonsWhyUnavailable;
			
		default:
			return null;
		}
			
				
	}

}
