package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day 
{
	@JsonProperty(value="Icon")
	private int icon;
	
	@JsonProperty(value="IconPhrase")
	private String iconPhrase;
	
	public Day() {}
	
	public int getIcon() 
	{
		return icon;
	}
	
	public String getIconPhrase() 
	{
		return iconPhrase;
	}

	@Override
	public String toString() 
	{
		return "Day [icon=" + icon + ", iconPhrase=" + iconPhrase + "]";
	}
}
