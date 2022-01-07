package Entities;

// Admin class is separated from Member bcs of different functionalities
public class Admin extends SystemMember
{
	public boolean add_movie(Movie movie);
	public boolean add_show(Show show);
}
