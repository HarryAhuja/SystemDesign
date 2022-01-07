package Entities;


// User has been separated from SystemMember bcs
// normal user can do search but don't need any account or address 
// These info is only required if registered for booking
public class SystemMember extends User
{
	Account account;
	String 	name;
	String  email;
	Address address;
}
