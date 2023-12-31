
package flightsystem;

import java.util.Scanner;

public class FlightBookingSystem {
    private static final int MAX_SEATS = 40;
    private static final int WAITING_LIST_SIZE = 10;

    private static Passenger[] confirmedTicket = new Passenger[MAX_SEATS];
    private static QueueWaitingList waitingList = new QueueWaitingList(WAITING_LIST_SIZE);
    
    private static boolean isFlightFull(){
        for(Passenger ticket: confirmedTicket){
            if(ticket == null){
                return false;
            }
        }
        return true;
    }
    public static void searchFlight(String search){
        Scanner input = new Scanner(System.in);
        System.out.println("Searching for flights between "+search);
        //code//
        
    }
    public static void bookTicket(){
        if(isFlightFull()){
            System.out.println("Sorry, the flight is full. Adding to the waiting list.");
            addToWaitingList();
        }
        else{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter passenger's name: ");
            String name = input.next();
            System.out.print("Enter passenger's passport number: ");
            String passportNum = input.next();
            
            Passenger passenger = new Passenger(name,passportNum);
            for(int i=0; i<MAX_SEATS; i++){
                if(confirmedTicket[i] == null){
                    confirmedTicket[i] = passenger;
                    System.out.println("Ticket booked successfully.");
                    return;
                }
            }
        }
    }
    public static void addToWaitingList() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter passenger's name for waiting list: ");
        String name = input.nextLine();
        System.out.print("Enter passport number for waiting list: ");
        String passportNum = input.nextLine();
        
        String passengerInfo = name + "," + passportNum;
        waitingList.enqueue(passengerInfo);
        System.out.println("Passenger added to the waiting list.");
    }
    public static void editTicket(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter passport number to edit ticket information: ");
        String passportNum = input.nextLine();
        
        boolean found = false;
        
        for(int i=0; i<MAX_SEATS; i++){
            if(confirmedTicket[i] != null && confirmedTicket[i].passportNum.equals(passportNum)){
                System.out.println("Enter new passenger's name: ");
                String newName = input.next();
                confirmedTicket[i].name = newName;
                System.out.println("Ticket information updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Ticket not found with the provided passport number.");
        }
    }
    public static void viewTicket(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter passport number to view ticket status: ");
        String passportNum = input.next();
        
        for(int i=0; i<MAX_SEATS; i++){
            if(confirmedTicket[i] != null && confirmedTicket[i].passportNum.equals(passportNum)){
                System.out.println("Ticket Confirmed: " + confirmedTicket[i]);
                return;
            }
        }
        if (waitingList.containsPassenger(passportNum)) {
            System.out.println("Passenger is in the waiting list.");
        } 
        else {
            System.out.println("Ticket not found with the provided passport number.");
        }
    }
    public static void cancelTicket(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter passport number to cancel ticket: ");
        String passportNum = input.next();
        
        for(int i=0; i<MAX_SEATS; i++){
            if(confirmedTicket[i] != null && confirmedTicket[i].passportNum.equals(passportNum)){
                System.out.println("Ticket Cancelled: " + confirmedTicket[i]);
                confirmedTicket[i] = null;
                
                // If waiting list is not empty, move the first passenger to confirmed tickets
                if (!waitingList.isEmpty()) {
                    String nextPassengerInfo = (String) waitingList.dequeue();
                    String[] parts = nextPassengerInfo.split(",");
                    Passenger nextPassenger = new Passenger(parts[0], parts[1]);
                    confirmedTicket[i] = nextPassenger;
                    System.out.println("Passenger from waiting list added to confirmed tickets.");
                }
                return;
            }
        }
        System.out.println("Ticket not found with the provided passport number.");
    }    
}

