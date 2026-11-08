import java.util.Scanner;

/*
 * Class: CMSC203
 * Assignment: 4
 * Description: Runs the Property Management console application.
 * Name: Raiyan Islam
 * Platform/compiler: VS Code, Java 20
 */
public class PropertyDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ManagementCompany company =
                new ManagementCompany("Campus Realty", "123-45-6789");

        int choice = 0;

        while (choice != 4) {

            displayMenu();

            System.out.print("Enter choice (1-4): ");

            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            if (choice == 1) {
                addProperty(input, company);

            } else if (choice == 2) {
                displayProperties(company);

            } else if (choice == 3) {
                System.out.printf("Total rent: $%.2f%n",
                        company.totalRent());

            } else if (choice == 4) {
                System.out.println("Exiting Property Manager.");

            } else {
                System.out.println("Please enter a number from 1 to 4.");
            }

            System.out.println();
        }

        System.out.println("Programmer: Raiyan Islam");

        input.close();
    }

    // Displays the menu
    public static void displayMenu() {
        System.out.println("====================================");
        System.out.println("   Assignment 4: Property Manager");
        System.out.println("====================================");
        System.out.println("1 - Add Property");
        System.out.println("2 - Display All Properties");
        System.out.println("3 - Show Total Rent");
        System.out.println("4 - Exit");
    }

    // Adds a property
    public static void addProperty(Scanner input, ManagementCompany company) {

        System.out.print("Enter property name: ");
        String propertyName = input.nextLine();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        double rentAmount = readRent(input);

        System.out.print("Enter owner name: ");
        String owner = input.nextLine();

        Property property = new Property(
                propertyName, city, rentAmount, owner);

        int index = company.addProperty(property);

        if (index == -1) {
            System.out.println("The management company is full. Property was not added.");
        } else {
            System.out.println("Property added at index " + index + ".");
        }
    }

    // Reads and checks the rent amount
    public static double readRent(Scanner input) {

        while (true) {

            System.out.print("Enter monthly rent: ");

            try {
                double rent = Double.parseDouble(input.nextLine().trim());

                if (rent >= 0) {
                    return rent;
                }

            } catch (NumberFormatException e) {
                // Ask again if the input is invalid.
            }

            System.out.println("Please enter a valid non-negative rent amount.");
        }
    }

    // Displays all properties
    public static void displayProperties(ManagementCompany company) {

        ManagementCompany companyCopy = new ManagementCompany(company);

        System.out.println(companyCopy);
    }
}