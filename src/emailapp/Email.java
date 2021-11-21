package emailapp;
import java.util.*;
import java.io.*;
public class Email {
	public static Scanner input = new Scanner(System.in);
	
	private String firstName,lastName,email,password,alterEmail,department;
	
	private List<String> departments = new ArrayList<String>(Arrays.asList("None","Sales","Marketing","Management"));
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = this.generatePassword(20);
		//this.changePassword();
		this.email = this.generateEmail();
		this.department = this.assignDepartments();
		//this.setAlterEmail();
		this.printInfo();
		this.storeInFile();
		this.readFile();
	}
	public void changeDepartment() {
		boolean validInput = false;
		int selectedDepartment = 0;
		do {
			System.out.println("Enter the order of the belonging department:\n"
					+ "\n1. Sales"
					+ "\n2. Marketing"
					+ "\n3. Management");
			var choice = input.nextInt();
			switch(choice) {
			case 1:
			case 2:
			case 3:
				selectedDepartment = choice;
				validInput = true;
				break;
			default:
		        System.out.println("Choice is invalid.Enter something between 1 and 3 according to the department you want to assign the member...");
		        break;
			}
		}while(!validInput);
		this.department =  this.departments.get(selectedDepartment);
		this.printInfo();
		this.storeInFile();
	}
	private String assignDepartments() {
		boolean validInput = false;
		int selectedDepartment = 0;
		do {
			System.out.println("Enter the order of the belonging department:\n"
					+ "\n1. Sales"
					+ "\n2. Marketing"
					+ "\n3. Management");
			var choice = input.nextInt();
			switch(choice) {
			case 1:
			case 2:
			case 3:
				selectedDepartment = choice;
				validInput = true;
				break;
			default:
		        System.out.println("Choice is invalid.Enter something between 1 and 3 according to the department you want to assign the member...");
		        break;
			}
		}while(!validInput);
		return this.departments.get(selectedDepartment);
	}
	private String generatePassword(int length) {
		String password = "";
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smalls = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String chars = "@#!$%^-+_";
		String possibleCharacters = caps + smalls + numbers + chars;
		Random rand = new Random();
		for(int i = 0;i < length; i++) {
			password += possibleCharacters.charAt(rand.nextInt(possibleCharacters.length()));
		}
		return password;
	}
	private String generateEmail() {
		return this.firstName + "_" + this.lastName + "@company.com";
	}
	public void changePassword() {
		System.out.println("Do you want to change the password? Y/N");
		boolean validInput = false;
		do {
			var decission = input.next().charAt(0);
			if(decission == 'y' || decission == 'Y') {
				validInput = true;
				System.out.println("Enter current password: ");
				var currentPassword = input.next();
				if(this.password.equals(currentPassword)) {
					System.out.println("Enter the new password : ");
					var newPassword = input.next();
					this.password = newPassword;
					this.storeInFile();
				}else {
					System.out.println("Incorrect Password");
				}
			}else if(decission == 'n' || decission == 'N') {
				validInput = true;
				System.out.println("Password change option cancelled");
			}else {
				System.out.println("Enter a valaid choice");
			}
		}while(!validInput);
		this.printInfo();
	}
	public void setAlterEmail() {
		System.out.println("Enter the alter email : ");
		this.alterEmail = input.next();
		System.out.println("Alter email changed");
		this.printInfo();
	}
	public void printInfo() {
		System.out.println("Employee details...\n"
				+ "Email:"+ this.firstName + " " + this.lastName + "\n"
						+ "Department: " + this.department + "\n"
								+ "Email : " + this.email + "\n"
										+ "Password : " + this.password + "\n"
												+ "Alter Email : " + this.alterEmail + "\n");
	}
	private void storeInFile() {
		try {
			FileWriter file = new FileWriter(System.getProperty("user.dir") + "/info.txt");
			file.write("\nFirst Name: " + this.firstName);
			file.append("\nLast Name : " + this.lastName);
			file.append("\nEmail : " + this.email);
			file.append("\nAlter Email: " + this.alterEmail);
			file.append("\nPassword : " + this.password);
			file.append("\nDepartment : " + this.department);
			file.close();
			System.out.println("Output stored.");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void readFile() {
		System.out.println("From file : ");
		try {
			FileReader file = new FileReader(System.getProperty("user.dir") + "/info.txt");
			int i;
			while((i = file.read()) != -1) {
				System.out.print((char)i);
			}
			System.out.println();
			file.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
