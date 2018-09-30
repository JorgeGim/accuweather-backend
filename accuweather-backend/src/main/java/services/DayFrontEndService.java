package services;

import org.springframework.stereotype.Service;

import model.DayFrontEnd;

@Service
public class DayFrontEndService 
{
	public void checkWeatherConditions(DayFrontEnd dayFrontEnd, boolean thereIsMinimumTemperatureCondition,
			boolean thereIsMaximumTemperatureCondition, String possibleMessageAboutRains) 
	{
		if(!thereIsMinimumTemperatureCondition)
		{
			dayFrontEnd.setMessageAboutMinimumTemperature("Low Temperature");
		}
		
		if(!thereIsMaximumTemperatureCondition)
		{
			dayFrontEnd.setMessageAboutMaximumTemperature("High Temperature");
		}
		
		if(!possibleMessageAboutRains.isEmpty())
		{
			dayFrontEnd.setMessageAboutRains(possibleMessageAboutRains);
		}
		
		if(thereIsMinimumTemperatureCondition && thereIsMaximumTemperatureCondition && possibleMessageAboutRains.isEmpty())
		{
			dayFrontEnd.setStatusToPractice(true);
		}
	}
}
