package services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.DailyForecast;
import model.DayFrontEnd;
import model.InfoClima;
import model.Sport;
import model.Temperature;

@Service
public class SportService 
{
	@Autowired
	InfoClimaService infoClimaService;
	
	@Autowired
	SportsListService sportsListService;
	
	@Autowired
	DayFrontEndService dayFrontEndService;
	
	public SportService() {}
	
	public Sport createAndReturnSport(String name, Temperature temperatureAccepted,
			Map<Integer, String> reasonsWhyUnavailable) 
	{
		Sport sport = new Sport(name, temperatureAccepted, reasonsWhyUnavailable);
		return sport;
	}
	
	public List<DayFrontEnd> getAvailableDaysToPractice(String sportName, int numberOfDays) throws IOException 
	{
		InfoClima infoClima = infoClimaService.getInfo();
		List<DailyForecast> dailyForecasts = infoClima.getDailyForecasts();
		List<DayFrontEnd> daysFrontEnd = new ArrayList<DayFrontEnd>();
		Sport sport = sportsListService.getSport(sportName);
		
		List<DailyForecast> dailyForecastsToIterate = new ArrayList<DailyForecast>(dailyForecasts.subList(0, numberOfDays));
		
		for(DailyForecast dailyForecastToIterate: dailyForecastsToIterate) 
		{
				int iconDay = dailyForecastToIterate.getDay().getIcon();
				int iconNight = dailyForecastToIterate.getNight().getIcon();
				Date actuallyDate = dailyForecastToIterate.getDate();
				String dayName = getDayName(actuallyDate);
				
				DayFrontEnd dayFrontEnd = new DayFrontEnd(dayName);
				
				boolean thereIsMinimumTemperatureCondition = getSportMinimumTemperatureCondition(sport, dailyForecastToIterate);
				boolean thereIsMaximumTemperatureCondition = getSportMaximumTemperatureCondition(sport, dailyForecastToIterate);
				String possibleMessageAboutRains = getWeatherCondition(iconDay, iconNight, sport);
				
				dayFrontEndService.checkWeatherConditions(dayFrontEnd, thereIsMinimumTemperatureCondition, thereIsMaximumTemperatureCondition
						, possibleMessageAboutRains);
						
				daysFrontEnd.add(dayFrontEnd);
		}
		
		return daysFrontEnd;
	}
	
	private String getDayName(Date actuallyDate)
	{
		DateFormat f = new SimpleDateFormat("EEEE");
		try
		{
			return f.format(actuallyDate);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}

	private boolean getSportMinimumTemperatureCondition(Sport sport, DailyForecast dailyForecast) 
	{
		return  dailyForecast.getTemperature().getMininum().getValue() >= sport.getTemperatureAccepted().getMininum().getValue();		
	}
	
	private boolean getSportMaximumTemperatureCondition(Sport sport, DailyForecast dailyForecast) 
	{
		return sport.getTemperatureAccepted().getMaximum().getValue() >= dailyForecast.getTemperature().getMaximum().getValue();
	}
	
	private String getWeatherCondition(int iconDay, int iconNight, Sport sport)
	{
		Map<Integer, String> sportUnavailableReasons = sport.getReasonsWhyUnavailable();
		
		for(Map.Entry<Integer, String> entry: sportUnavailableReasons.entrySet())
		{
			if(entry.getKey().equals(iconDay) || entry.getKey().equals(iconNight)) 
			{
				return entry.getValue();
			}
		}
		
		return "";
	}
}
