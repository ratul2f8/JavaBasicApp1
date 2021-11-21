package emailapp;
import emailapp.Email;
import java.util.*;
public class Main {
	public static Scanner input = new Scanner(System.in);
	public static void showOptions() {
		System.out.println("Enter the number of choice to perform these operations: "
				+ "\n1. Change Password"
				+ "\n2. Change Alter Email"
				+ "\n3. Change department"
				+ "\n4. Exit");
	}
	public static void main(String args[]) {
		System.out.println("Enter first name of the employee");
		String firstName = input.next();
		System.out.println("Enter last name name of the employee");
		String lastName = input.next();
		Email entity = new Email(firstName, lastName);
		//entity.printInfo();
		
		var exit = false;
		do {
		    Main.showOptions();
			var choice = input.nextInt();
			switch(choice) {
			case 1:
				entity.changePassword();
				break;
			case 2:
				entity.setAlterEmail();
				break;
			case 3:
				entity.changeDepartment();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Enter a valid choice : ");
			}
		}while(!exit);
	}
}
