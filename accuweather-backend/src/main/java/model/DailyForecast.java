package model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
	
	@JsonProperty(value="Date")
	private Date date;
	
	@JsonProperty(value="EpochDate")
	private int epochDate;
	
	@JsonProperty(value="Temperature")
	private Temperature temperature;
	
	@JsonProperty(value="Day")
	private Day day;
	
	@JsonProperty(value="Night")
	private Night night;
	
	@JsonProperty(value="Sources")
	private List<String> sources;
	
	@JsonProperty(value="MobileLink")
	private String mobileLink;
	
	@JsonProperty(value="Link")
	private String link;
	
	public DailyForecast() {
		
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getEpochDate() {
		return epochDate;
	}
	
	public Temperature getTemperature() {
		return temperature;
	}
	
	public Day getDay() {
		return day;
	}
	
	public Night getNight() {
		return night;
	}
	
	public List<String> getSources() {
		return sources;
	}
	
	public String getMobileLink() {
		return mobileLink;
	}
	
	public String getLink() {
		return link;
	}

	@Override
	public String toString() {
		return "DailyForecast [date=" + date + ", epochDate=" + epochDate + ", temperature=" + temperature + ", day="
				+ day + ", night=" + night + ", sources=" + sources + ", mobileLink=" + mobileLink + ", link=" + link
				+ "]";
	}
	
	

}
