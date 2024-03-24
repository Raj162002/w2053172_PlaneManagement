//Importing required libraries
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {

    private static int[][] seats = new int[4][]; // 2D array to store the seats
    private static Scanner s = new Scanner(System.in); // Scanner object to take input from the user

    private static Ticket[] ticketsArray=new Ticket[52]; // Array to store the tickets

    public static void main(String[] args) {
        seats[0] = new int[14]; // Initializing the 2D array for the first row with 14 seats
        seats[1] = new int[12]; // Initializing the 2D array for the second row with 12 seats
        seats[2] = new int[12]; // Like the previous one
        seats[3] = new int[14]; // Like the first one
        System.out.println("Welcome to the Plane Management application ");
        int option;
        //Menu options
        do {

            for (int count1 = 0; count1 < 50; count1++) { //To print the stars
                System.out.print("*");
            }
            System.out.println();
            System.out.print("*");
            for (int count2 = 0; count2 < 18; count2++) { //To print the white spaces
                System.out.print(" ");
            }
            System.out.print("MENU OPTIONS");
            for (int count2 = 0; count2 < 18; count2++) { //To print the white spaces
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
            for (int count1 = 0; count1 < 50; count1++) { //To print the stars
                System.out.print("*");
            }
            System.out.println();
            //Print the available options
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            for (int count1 = 0; count1 < 50; count1++) { //To print the stars
                System.out.print("*");
            }
            System.out.println();
            option = getInt("Please select an option:- "); //To get the option from the user with getInt method
//            s.nextLine(); //To clear the buffer
            switch (option) { //Switch case to select an option
                case 1:
                    buy_seat(); //Calls the method to buy a seat
                    break;
                case 2:
                    cancel_seat(); //Calls the method to cancel a seat
                    break;
                case 3:
                    find_first_available(); //Calls the method to find the first available seat
                    break;
                case 4:
                    show_seating_plan(); //Calls the method to show the seating plan
                    break;
                case 5:
                    print_tickets_info(); //Calls the method to print the tickets information
                    break;
                case 6:
                    search_ticket(); //Calls the method to search for a ticket
                    break;
                case 0:
                    System.out.println("Thank you for using the Plane Management application");
                    break;
                default:
                    System.out.println("Invalid option Try again");
                    break;
            }
        } while (option != 0); //Do-While loop until the user selects 0
        s.close();
    }


    //Method to buy a seat
    private static void buy_seat() {
        boolean validInput= true; //Boolean variable to used for the while loop below
        while(validInput) {
            try {
                int price_seat;
                char rowLetter = getRowletter(); //Getting input from user using a user defined method
                rowLetter = Character.toUpperCase(rowLetter); //Changing it to uppercase
                int rowLetterindex = rowLettercheck(rowLetter);//Getting the index of the row letter using a user defined method
                int maxseatno = getMaxseatno(rowLetterindex);//Getting the maximum seat number for the row
                int seatNo = getInt("Enter the desired seat number"+"("+"1-"+maxseatno+")"+":- ");//Getting the seat number from the user
                if (seats[rowLetterindex][seatNo - 1] == 0) { //Checking if the seat is available
                    System.out.println("The seat is available");
                    while (true) {
                        System.out.println("Would you like to purchase this seat? (Type yes/no)");
                        String purchase = s.next();
                        purchase = purchase.toLowerCase();
                        if (purchase.equals("yes")) {

                            seats[rowLetterindex][seatNo - 1] = 1;
                            System.out.println();
                            //Getting some information about the user
                            System.out.print("Enter your name:- ");
                            String name = s.next();
                            System.out.print("Enter your surname:- ");
                            String surname = s.next();
                            String email = getemail();
                            Person person = new Person(name, surname, email); //Creating the person object
                            //Setting the price of the seat based on the seat number
                            if (seatNo < 6) {
                                price_seat = 200;
                            } else if (seatNo < 10) {
                                price_seat = 150;

                            } else {
                                price_seat = 180;
                            }
                            Ticket ticket = new Ticket(rowLetter, seatNo, price_seat, person); //Creating the ticket object
                            for (int newCount = 0; newCount < ticketsArray.length; newCount++) { //Loop to store the ticket in the array
                                if (ticketsArray[newCount] == null) { //Checking if the array element is empty and adding the ticket
                                    ticketsArray[newCount] = ticket;
                                    String path = String.valueOf(rowLetter) + seatNo + ".txt"; //Creating the path for the ticket file
                                    ticket.save(path, person.printall(), "The reserved seat is " + rowLetter + seatNo); //Saving the ticket information to a file
                                    System.out.println("The price of the ticket is:- "+ticket.getPrice()+"\u00a3");
                                    System.out.println("Your Booking has been reserved");
                                    System.out.println("You will be redirected to the main menu");
                                    break;

                                }
                            }
                            break;


                        } else if (purchase.equals("no")) {
                            System.out.println("You will be redirected to the main menu");
                            break;
                        } else {
                            System.out.println("Invalid prompt try again");

                        }
                    }
                } else if (seats[rowLetterindex][seatNo - 1] == 1) {
                    System.out.println("The seat is unavailable");

                }
                validInput=false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Seat number out of range");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input for row letter");
            }
        }



    }

    //Method to check the row letter and return the index value
    private static int rowLettercheck(char letter1) {
        switch (letter1) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            default:
                throw new IllegalArgumentException("Invalid row letter"); //Throwing an exception if the row letter is invalid and catching it in the main method
        }


    }

    //Method to cancel a seat this is similar to buy seat
    private static void cancel_seat() {
        boolean validInput=true;
        while (validInput) {
            try {

                char rowLetter = getRowletter()
                rowLetter = Character.toUpperCase(rowLetter);
                int rowLetterindex = rowLettercheck(rowLetter);
                int maxseatno = getMaxseatno(rowLetterindex);
                int seatNo = getInt("Enter the desired seat number"+"("+"1-"+maxseatno+")"+":- ");
                if (seats[rowLetterindex][seatNo - 1] == 1) {
                    while (true) {
                        System.out.println("Would you like to cancel this seat? (Type yes/no)");
                        String purchase = s.next();
                        purchase = purchase.toLowerCase();
                        if (purchase.equals("yes")) {
                            seats[rowLetterindex][seatNo - 1] = 0;
                            for (int newCount = 0; newCount < ticketsArray.length; newCount++) {
                                if(ticketsArray[newCount] != null) {
                                    if ((ticketsArray[newCount].getRow() == rowLetter) && (ticketsArray[newCount].getSeat() == seatNo)) {
                                        String path = String.valueOf(rowLetter) + seatNo + ".txt";
                                        ticketsArray[newCount].delete(path); //Delete the ticket txt file
                                        ticketsArray[newCount] = null;
                                        //Delete the ticket

                                    }
                                }
                            }
                            System.out.println("Your cancellation is confirmed");
                            break;


                        } else if (purchase.equals("no")) {
                            System.out.println("You will be redirected to the main menu");
                            break;
                        } else {
                            System.out.println("Invalid prompt try again");

                        }
                    }
                } else if (seats[rowLetterindex][seatNo - 1] == 0) {
                    System.out.println("The seat is available");

                }
                validInput=false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid seat number or row letter");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input for row letter");
            }
        }

    }

    private static int[] linear_search(){ //A simple linear search algorithm
        for(int count1=0;count1<seats.length;count1++ ){
            for(int count2=0; count2<seats[count1].length;count2++){
                if (seats[count1][count2]==0){
                    return new int[]{count1,count2};
                }
            }
        }
        return null;
    }

    private static void find_first_available(){ //Method to find the first available seat
        try {
            int[] seatinfo=linear_search();
            char rowLetter = rownum_converter(seatinfo[0]);
            System.out.println("The first available seat is in " + rowLetter + (seatinfo[1] + 1));
        }catch (NullPointerException e){
            System.out.println("No available seats,Null pointer exception");
        }

    }

    private static char rownum_converter(int rownum){
        switch (rownum) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            default:
                return ' ';
        }
    }
    private static void show_seating_plan(){ //Method to show the seating plan
        int printcount; //Variable to keep track of the number of seats printed so that space can be made
        for(int[] element1: seats){
            System.out.println();
            printcount=1;
            for (int element2: element1){
                if (element2==0){
                    System.out.print(" O ");
                    printcount+=1;
                    if(printcount==7){
                        System.out.print(" O  ");
                        printcount+=1;
                    }
                }
                else {
                    System.out.print(" X ");
                    printcount+=1;
                    if(printcount==7){
                        System.out.print(" X  ");
                        printcount+=1;
                    }
                }
            }
        }
        System.out.println();
    }
    private static void print_tickets_info(){ //Method to print the all tickets information
        double totalSales=0;
        for (int i=0; i<ticketsArray.length; i++){
            if (ticketsArray[i] !=null) {
                System.out.println();
                ticketsArray[i].printTicket();
                totalSales+=ticketsArray[i].getPrice();
                System.out.println("End of this ticket");
            }
        }
        System.out.println("The total sales amount for tickets is "+totalSales+"\u00A3");

    }
    private static void search_ticket() { //Method to search for a ticket
        while (true) {
            try {
                char rowLetter = getRowletter();
                rowLetter = Character.toUpperCase(rowLetter);
                int rowLetterindex = rowLettercheck(rowLetter);
                int seatNo = getInt("Enter the desired seat number:- ");
                if (seats[rowLetterindex][seatNo - 1] == 0) {
                    System.out.println("The seat is available, No ticket has been booked for this seat");
                } else if (seats[rowLetterindex][seatNo - 1] == 1) {
                    System.out.println("The details of the ticket and the person who booked it ");
                    for (Ticket ticket : ticketsArray) {
                        if ((ticket != null)&&(ticket.getRow()==rowLetter)&&(ticket.getSeat()==seatNo)) {
                            System.out.println();
                            ticket.printTicket();
                            System.out.println("End of this ticket");
                        }
                    }
                }

            break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input for row letter");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid seat number or row letter");
            }
        }
    }

    private static int getInt(String prompt) { //Method to get an integer from the user and validate it
        while(true) {
            try {
                System.out.print(prompt);
                int num= s.nextInt();
                return num;
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Invalid input, please enter a number");
            }
        }

    }

    private static String getemail(){ //Method to get the email from the user and validate it
        String email;
        while(true){
            System.out.print("Enter your email:- ");
            email=s.next();
            if (email.contains("@") && email.contains(".")){
                return email;
            }
            else{
                System.out.println("Invalid email, please try again");
            }
        }
    }
    private static int getMaxseatno(int rowLetterindex){ //Method to get the maximum seat number for a row
        return seats[rowLetterindex].length;
    }
    private static char getRowletter(){ //Method to get the row letter from the user and validate it
        String rowLetter_check;
        while(true){
            s.nextLine();
            System.out.print("Enter the row letter(A-D):- ");
            rowLetter_check=s.next();
            if (rowLetter_check.length()==1){
                return rowLetter_check.charAt(0);
            }
            else{
                System.out.println("Please enter one character");
            }
        }
    }


}

