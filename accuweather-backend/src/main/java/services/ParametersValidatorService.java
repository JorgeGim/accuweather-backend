package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.BadRequestException;
import model.SportFrontEnd;

@Service
public class ParametersValidatorService 
{
	@Autowired
	SportsListService sportListService;
	
	public void validate(String sportName, int numberOfDays)
	{
		List<SportFrontEnd> sports = sportListService.getSportsFrontEnd();
		boolean isFounded = false;
		boolean numberOfDaysAreOutOfRange = false;
		
		for(SportFrontEnd sport: sports)
		{
			if(sportName.equals(sport.getName()))
			{
				isFounded = true;
			}
		}
		
		if(numberOfDays < 1 || numberOfDays > 5)
		{
			numberOfDaysAreOutOfRange = true;
		}
		
		if(!isFounded || numberOfDaysAreOutOfRange)
		{
			throw new BadRequestException();
		}
		
	}
}
