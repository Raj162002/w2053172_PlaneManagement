import java.util.Scanner;

public class PlaneManagement {
    private static int[][] seats=new int[4][];
    private static Scanner s=new Scanner(System.in);

    public static void main(String[] args){
//        int[][] seats=new int[4][];
        seats[0]=new int[14];
        seats[1]=new int[12];
        seats[2]=new int[12];
        seats[3]=new int[14];
//        Scanner s=new Scanner(System.in);
        System.out.println("Welcome to the Plane Management application ");
        int option;
        do{
            for (int count1=0; count1<50; count1++){
                System.out.print("*");
            }
            System.out.println();
            System.out.print("*");
            for(int count2=0; count2<18; count2++){
                System.out.print(" ");
            }
            System.out.print("MENU OPTIONS");
            for(int count2=0; count2<18; count2++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
            for (int count1=0; count1<50; count1++){
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
            for (int count1=0; count1<50; count1++){
                System.out.print("*");
            }
            System.out.println();
            System.out.println("Please select an option");
            option=s.nextInt();
            switch (option){
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
            }
        }
        }while(option!=0);
    }
    private static void buy_seat(){
        System.out.println("Enter the row Letter:- ");
        char rowLetter=s.next().charAt(0);
        rowLetter=Character.toUpperCase(rowLetter);
        System.out.println("Enter the desired seat number:- ");
        int seatNo=s.nextInt();
        int rowLetterindex= rowLettercheck(rowLetter);
        if(seats[rowLetterindex][seatNo-1]==0){
            System.out.println("The seat is available");
//            System.out.println("Would you like to purchase this seat? (Type yes/no)");
//            String purchase=s.next();
//            purchase=purchase.toLowerCase();
            while (true) {
                System.out.println("Would you like to purchase this seat? (Type yes/no)");
                String purchase=s.next();
                purchase=purchase.toLowerCase();
                if (purchase.equals("yes")) {
                    seats[rowLetterindex][seatNo - 1] = 1;
                    System.out.println("Your Booking has been reserved");
                    break;


                } else if (purchase.equals("no")) {
                    System.out.println("You will be redirected to the main menu");
                    break;
                } else {
                    System.out.println("Invalid prompt try again");

                }
            }
        } else if (seats[rowLetterindex][seatNo-1]==1) {
            System.out.println("The seat is unavailable");

        }


    }
    private static int rowLettercheck(char letter1){
        switch (letter1){
            case 'A':
                return 0;
//                break;
            case 'B':
                return 1;
//                break;
            case 'C':
                return 2;
//                break;
            case 'D':
                return 3;
//                break;
            default:
                return -1;
        }


    }
    private static void cancel_seat(){
        System.out.println("Enter the row Letter:- ");
        char rowLetter=s.next().charAt(0);
        rowLetter=Character.toUpperCase(rowLetter);
        System.out.println("Enter the desired seat number:- ");
        int seatNo=s.nextInt();
        int rowLetterindex= rowLettercheck(rowLetter);
        if(seats[rowLetterindex][seatNo-1]==1){
            System.out.println("The seat is reserved");
//            System.out.println("Would you like to purchase this seat? (Type yes/no)");
//            String purchase=s.next();
//            purchase=purchase.toLowerCase();
            while (true) {
                System.out.println("Would you like to cancel this seat? (Type yes/no)");
                String purchase=s.next();
                purchase=purchase.toLowerCase();
                if (purchase.equals("yes")) {
                    seats[rowLetterindex][seatNo - 1] = 0;
                    System.out.println("Your cancellation is confirmed");
                    break;


                } else if (purchase.equals("no")) {
                    System.out.println("You will be redirected to the main menu");
                    break;
                } else {
                    System.out.println("Invalid prompt try again");

                }
            }
        } else if (seats[rowLetterindex][seatNo-1]==0) {
            System.out.println("The seat is available");

        }

}

