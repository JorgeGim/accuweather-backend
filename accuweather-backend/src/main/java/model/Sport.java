package model;

import java.util.Map;

public class Sport 
{
	private String name;
	private Temperature temperatureAccepted;
	private Map<Integer, String> reasonsWhyUnavailable;
	
	public Sport(String name, Temperature temperatureAccepted, Map<Integer, String> reasonsWhyUnavailable) 
	{
		this.name = name;
		this.temperatureAccepted = temperatureAccepted;
		this.reasonsWhyUnavailable = reasonsWhyUnavailable;
	}
	
	public Sport(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public Temperature getTemperatureAccepted()
	{
		return temperatureAccepted;
	}
	
	public Map<Integer, String> getReasonsWhyUnavailable()
	{
		return reasonsWhyUnavailable;
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == this) {
			return true;
		}
		
		if(other == null) {
			return false;
		}
		
		if(!(other instanceof Sport)) {
			return false;
		}
		
		Sport sport  = (Sport) other;
		return this.name == sport.name;
	}
}
