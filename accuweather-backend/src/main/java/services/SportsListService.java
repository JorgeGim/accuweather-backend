package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Maximum;
import model.Minimum;
import model.Sport;
import model.SportFrontEnd;
import model.Temperature;

@Service
public class SportsListService 
{
	private List<SportFrontEnd> sportsFrontEndList = new ArrayList<SportFrontEnd>();
	private List<Sport> sportsList = new ArrayList<Sport>();
	
	@Autowired
	SportService sportService;
	
	@Autowired
	ReasonsGeneratorService reasonsGeneratorService;
	
	public List<SportFrontEnd> generateAndReturnSportsList() 
	{	
		checkIfSportFrontEndListIsNotEmpty();
		generateSports();
		return sportsFrontEndList;
	}

	private void checkIfSportFrontEndListIsNotEmpty() 
	{
		if(!sportsFrontEndList.isEmpty())
		{
			sportsFrontEndList.clear();
			sportsList.clear();
		}
	}

	private void generateSports() 
	{	
		generateAndSaveSport("Volleyball", new Temperature(new Minimum(10, "C", 17), new Maximum(23, "C", 17)),
				reasonsGeneratorService.getReasons());
		
		generateAndSaveSport("Football", new Temperature(new Minimum(5, "C", 17), new Maximum(30, "C", 17)),
				reasonsGeneratorService.getReasons(16, 14));
		
		generateAndSaveSport("Tennis", new Temperature(new Minimum(15, "C", 17), new Maximum(26, "C", 17)),
				reasonsGeneratorService.getReasons(16, 14, 13));
		
		generateAndSaveSport("Running", new Temperature(new Minimum(10, "C", 17), new Maximum(23, "C", 17)),
				reasonsGeneratorService.getReasons(18, 39, 40));
		
		generateAndSaveSport("Swimming", new Temperature(new Minimum(20, "C", 17), new Maximum(35, "C", 17)), 
				reasonsGeneratorService.getReasons());
	}
	
	private void generateAndSaveSport(String sportName, Temperature temperatureAccepted, Map<Integer, String> reasons)
	{
		Sport sport = sportService.createAndReturnSport(sportName, temperatureAccepted, reasons);
		sportsList.add(sport);
		sportsFrontEndList.add(new SportFrontEnd(sportName));
	}

	public List<SportFrontEnd> getSportsFrontEnd()
	{	
		return sportsFrontEndList;
	}
	
	public Sport getSport(String sportName) 
	{	
		if(sportsList.isEmpty()) 
		{
			generateSports();
		}
		
		for(Sport sportSearched: sportsList) 
		{
			if(sportSearched.getName().equals(sportName)) 
			{
				return sportSearched;
			}
		}
		
		return null;
	}
}
