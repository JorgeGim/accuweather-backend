package model;

public class DayFrontEnd 
{
	private String dayName;
	private String messageAboutMinimumTemperature;
	private String messageAboutMaximumTemperature;
	private String messageAboutRains;
	private boolean statusToPractice;

	public DayFrontEnd(String dayName) 
	{
		this.dayName = dayName;
		this.statusToPractice = false;
	}
	
	public boolean isStatusToPractice() 
	{
		return statusToPractice;
	}

	public void setStatusToPractice(boolean statusToPractice) 
	{
		this.statusToPractice = statusToPractice;
	}

	public String getDayName() 
	{
		return dayName;
	}

	public void setDayName(String dayName) 
	{
		this.dayName = dayName;
	}

	public String getMessageAboutMinimumTemperature() 
	{
		return messageAboutMinimumTemperature;
	}

	public void setMessageAboutMinimumTemperature(String messageAboutMinimumTemperature) 
	{
		this.messageAboutMinimumTemperature = messageAboutMinimumTemperature;
	}

	public String getMessageAboutMaximumTemperature()
	{
		return messageAboutMaximumTemperature;
	}

	public void setMessageAboutMaximumTemperature(String messageAboutMaximumTemperature) 
	{
		this.messageAboutMaximumTemperature = messageAboutMaximumTemperature;
	}

	public String getMessageAboutRains() 
	{
		return messageAboutRains;
	}

	public void setMessageAboutRains(String messageAboutRains) 
	{
		this.messageAboutRains = messageAboutRains;
	}
}
