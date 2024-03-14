import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {
    private static int[][] seats = new int[4][];
    private static Scanner s = new Scanner(System.in);

    private static Ticket[] ticketsArray=new Ticket[52];

    public static void main(String[] args) {
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];
        System.out.println("Welcome to the Plane Management application ");
        int option;
        do {

            for (int count1 = 0; count1 < 50; count1++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.print("*");
            for (int count2 = 0; count2 < 18; count2++) {
                System.out.print(" ");
            }
            System.out.print("MENU OPTIONS");
            for (int count2 = 0; count2 < 18; count2++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
            for (int count1 = 0; count1 < 50; count1++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            for (int count1 = 0; count1 < 50; count1++) {
                System.out.print("*");
            }
            System.out.println();
            option = getInt("Please select an option");
            switch (option) {
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                default:
                    System.out.println("Invalid option Try again");
                    break;
            }
        } while (option != 0);
        s.close();
    }


    private static void buy_seat() {
        boolean validInput= true;
        while(validInput) {
            try {
                int price_seat;
                System.out.println("Enter the row Letter:- ");
                char rowLetter = s.next().charAt(0);
                rowLetter = Character.toUpperCase(rowLetter);
                int rowLetterindex = rowLettercheck(rowLetter);
                int seatNo = getInt("Enter the desired seat number:- ");
                if (seats[rowLetterindex][seatNo - 1] == 0) {
                    System.out.println("The seat is available");
                    while (true) {
                        System.out.println("Would you like to purchase this seat? (Type yes/no)");
                        String purchase = s.next();
                        purchase = purchase.toLowerCase();
                        if (purchase.equals("yes")) {

                            seats[rowLetterindex][seatNo - 1] = 1;
                            System.out.println();
                            System.out.println("Enter your name:- ");
                            String name = s.next();
                            System.out.println("Enter your surname:- ");
                            String surname = s.next();
                            System.out.println("Enter your email:- ");
                            String email = s.next();
                            Person person = new Person(name, surname, email);
                            if (seatNo < 6) {
                                price_seat = 200;
                            } else if (seatNo < 10) {
                                price_seat = 150;

                            } else {
                                price_seat = 180;
                            }
                            Ticket ticket = new Ticket(rowLetter, seatNo, price_seat, person);
                            for (int newCount = 0; newCount < ticketsArray.length; newCount++) {
                                if (ticketsArray[newCount] == null) {
                                    ticketsArray[newCount] = ticket;
                                    System.out.println("Your Booking has been reserved");
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
                System.out.println("Invalid seat number or row letter");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input for row letter");
            }
        }



    }

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
                throw new IllegalArgumentException("Invalid row letter");
        }


    }

    private static void cancel_seat() {
        boolean validInput=true;
        while (validInput) {
            try {
                System.out.println("Enter the row Letter:- ");
                char rowLetter = s.next().charAt(0);
                rowLetter = Character.toUpperCase(rowLetter);
                int rowLetterindex = rowLettercheck(rowLetter);
                int seatNo = getInt("Enter the desired seat number:- ");
                if (seats[rowLetterindex][seatNo - 1] == 1) {
                    System.out.println("The seat is reserved");
                    while (true) {
                        System.out.println("Would you like to cancel this seat? (Type yes/no)");
                        String purchase = s.next();
                        purchase = purchase.toLowerCase();
                        if (purchase.equals("yes")) {
                            seats[rowLetterindex][seatNo - 1] = 0;
                            for (int newCount = 0; newCount < ticketsArray.length; newCount++) {
                                if ((ticketsArray[newCount].getRow() == rowLetter) && (ticketsArray[newCount].getSeat() == seatNo)) {
                                    ticketsArray[newCount] = null;

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

    private static int[] linear_search(){
        for(int count1=0;count1<seats.length;count1++ ){
            for(int count2=0; count2<seats[count1].length;count2++){
                if (seats[count1][count2]==0){
                    return new int[]{count1,count2};
                }
            }
        }
        return null;
    }

    private static void find_first_available(){
        int[] seatinfo=new int[2];
        seatinfo=linear_search();
        char rowLetter=rownum_converter(seatinfo[0]);
        System.out.println("The first available seat is in "+ rowLetter+(seatinfo[1]+1));

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
    private static void show_seating_plan(){
        for(int[] element1: seats){
            System.out.println();
            for (int element2: element1){
                if (element2==0){
                    System.out.print("O");
                }
                else {
                    System.out.print("X");
                }
            }
        }
        System.out.println();
    }
    private static void print_tickets_info(){
        double totalSales=0;
        for (int i=0; i<ticketsArray.length; i++){
            if (ticketsArray[i] !=null) {
                System.out.println();
                ticketsArray[i].printTicket();
                totalSales+=ticketsArray[i].getPrice();
                System.out.println("End of this ticket");
            }
        }
        System.out.println("The total sales amount for tickets is "+totalSales);

    }
    private static void search_ticket() {
        while (true) {
            try {
                System.out.println("Enter the row letter ");
                char rowLetter = s.next().charAt(0);
                rowLetter = Character.toUpperCase(rowLetter);
                int rowLetterindex = rowLettercheck(rowLetter);
                int seatNo = getInt("Enter the desired seat number:- ");
                if (seats[rowLetterindex][seatNo - 1] == 0) {
                    System.out.println("The seat is available, No ticket has been booked for this seat");
                } else if (seats[rowLetterindex][seatNo - 1] == 1) {
                    System.out.println("The details of the ticket and the person who booked it ");
                    for (Ticket ticket : ticketsArray) {
                        if (ticket != null) {
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

    private static int getInt(String prompt) {
        while(true) {
            try {
                System.out.println(prompt);
                int num= s.nextInt();
                return num;
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Invalid input, please enter a number");
            }
        }

    }


}

