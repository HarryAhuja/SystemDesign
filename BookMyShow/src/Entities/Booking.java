package Entities;

public class Booking
{
	String 		  booking_id;
	Date   		  booking_date;
	Member        member;
	Show   		  show;
	// show don't have audi, so add separately
	// show has cinemalHall, so don't add
	Audi   		  audi;
	BookingStatus booking_status;
	double		  total_amount;
	List<Seat>	  seats;			// reserved seats for this booking
	Payment		  payment;
	
	public boolean make_payment(Payment payment);
}
