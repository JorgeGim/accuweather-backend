package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoClima {
	
	@JsonProperty(value ="Headline")
	private Headline headline;
	
	@JsonProperty(value="DailyForecasts")
	private List <DailyForecast> DailyForecasts;
	
	public InfoClima() {}
	
	@Override
	public String toString()
	{
		return "HeadLine: " + headline + "\n" +
		"DailyForecasts: " + DailyForecasts;
		
	}

	public Headline getHeadline() {
		return headline;
	}

	public List<DailyForecast> getDailyForecasts() {
		return DailyForecasts;
	}
}
