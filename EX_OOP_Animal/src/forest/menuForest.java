package forest;

public class menuForest
{
	public static int menu() 
	    {
	        System.out.println("--------------MENU----------------");
	        System.out.println("| 1. View zoo information        |");
	        System.out.println("| 2. View all animals infor      |");
	        System.out.println("| 3. Sort all animals            |");
	        System.out.println("| 4. Filter animal               |");
	        System.out.println("| 5. Add an animal               |");
	        System.out.println("| 6. View an animal              |");
	        System.out.println("| 7. Edit an animal              |");
	        System.out.println("| 8. Delete an animal            |");
	        System.out.println("| 9. Exit                        |");
	        System.out.println("----------------------------------");
	        System.out.print("Enter your choice[1-9]: ");
	        int choice = Validation.checkinputintLimit(1, 9);
	        return choice;
	    }

}