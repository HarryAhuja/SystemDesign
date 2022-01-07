package Entities;

public class Show
{
	int   show_id;
	// change to eventType for extensible
	// Movie will be child class of eventType
	// * Strategy Pattern and inheritence used *
	Movie movie;
	Date  start_time;
	Date  end_time;
	
	// change to event for extensible
	CinemaHall cinema_played_at;
	
	// Bcs different show can have different status/price of seats, so its declared here
	// not in audi. Since show is part of audi, therefore seats become part of audi(association)
	List<Seat> seats;
}
