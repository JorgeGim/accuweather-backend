package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline 
{
	@JsonProperty(value="EffectiveDate")
	private Date effectiveDate;
	
	@JsonProperty(value="EffectiveEpochDate")
	private int effectiveEpochDate;
	
	@JsonProperty(value="Severity")
	private int severity;
	
	@JsonProperty(value="Text")
	private String text;
	
	@JsonProperty(value="Category")
	private String category;
	
	@JsonProperty(value="EndDate")
	private Date endDate;
	
	@JsonProperty(value="EndEpochDate")
	private int endEpochDate;
	
	@JsonProperty(value="MobileLink")
	private String mobileLink;
	
	@JsonProperty(value="Link")
	private String link;
	
	public Headline() {}

	public Date getEffectiveDate() 
	{
		return effectiveDate;
	}

	public int getEffectiveEpochDate() 
	{
		return effectiveEpochDate;
	}

	public int getSeverity() 
	{
		return severity;
	}

	public String getText() 
	{
		return text;
	}

	public String getCategory() 
	{
		return category;
	}

	public Date getEndDate() 
	{
		return endDate;
	}

	public int getEndEpochDate() 
	{
		return endEpochDate;
	}

	public String getMobileLink() 
	{
		return mobileLink;
	}

	public String getLink()
	{
		return link;
	}
	
	@Override
	public String toString() 
	{
		return "Headline [EffectiveDate=" + effectiveDate + ", EffectiveEpochDate=" + effectiveEpochDate + ", Severity="
				+ severity + ", text=" + text + ", category=" + category + ", endDate=" + endDate + ", endEpochDate="
				+ endEpochDate + ", mobileLink=" + mobileLink + ", link=" + link + "]";
	}
}
