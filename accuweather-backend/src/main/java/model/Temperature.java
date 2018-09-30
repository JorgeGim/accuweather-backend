package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature 
{
	@JsonProperty(value="Minimum")
	private Minimum mininum;
	
	@JsonProperty(value="Maximum")
	private Maximum maximum;
	
	public Temperature() {}
	
	public Temperature(Minimum minimum, Maximum maximum) 
	{
		this.mininum = minimum;
		this.maximum = maximum;
	}
	
	public Minimum getMininum() 
	{
		return mininum;
	}
	
	public Maximum getMaximum() 
	{
		return maximum;
	}

	@Override
	public String toString() 
	{
		return "Temperature [mininum=" + mininum + ", maximum=" + maximum + "]";
	}
}
