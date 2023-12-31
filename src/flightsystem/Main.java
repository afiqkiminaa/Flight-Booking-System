
package flightsystem;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        FlightBookingSystem book = new FlightBookingSystem();
        Scanner input = new Scanner(System.in);
        
        int choice=0;
        do{
            System.out.println("\nWelcome to AirEurope Airline Management System.");
            System.out.println("1. Search for flights in any week of your choice e.g 19th November 2023 – 25th November 2023.");
            System.out.println("2. Book a ticket.");
            System.out.println("3. Edit ticket information.");
            System.out.println("4. View ticket status (confirmed/waiting list).");
            System.out.println("5. Cancel a ticket.");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            
            choice = input.nextInt();
            switch(choice){
                case 1:
                    String search = input.next();
                    book.searchFlight(search);
                    break;
                case 2:
                    book.bookTicket();
                    break;
                case 3:
                    book.editTicket();
                    break;
                case 4:
                    book.viewTicket();
                    break;
                case 5:
                    book.cancelTicket();
                    break;   
                case 6:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=6);
    }
}
