package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Minimum 
{
	@JsonProperty(value="Value")
	private double value;
	
	@JsonProperty(value="Unit")
	private String unit;
	
	@JsonProperty(value="UnitType")
	private int unitType;
	
	public Minimum() {}
	
	public Minimum(double value, String unit, int unitType) 
	{
		this.value = value;
		this.unit = unit;
		this.unitType = unitType;
	}
	
	public double getValue() 
	{
		return value;
	}
	
	public String getUnit() 
	{
		return unit;
	}
	
	public int getUnitType() 
	{
		return unitType;
	}

	@Override
	public String toString() 
	{
		return "Minimum [value=" + value + ", unit=" + unit + ", unitType=" + unitType + "]";
	}
}
