//Importing some libraries for file,file writing and exception handling
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    //Constructor for the ticket class
    private char row;
    private int seat;
    private double price;
    private Person person;

    //Getter and setter methods for seat
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

//    Constructor for the ticket class
    public Ticket(char row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

//    Getter and setter methods for row, price and person
    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

//    Method to print the ticket information
    public void printTicket(){
        System.out.println("The reserved seat is "+this.row+this.seat);
        System.out.println("The price of this ticket is:- "+this.price+"\u00a3");
        System.out.println(this.person.printall()); //This line will print the details of the person
    }
    //Method to save the ticket information to a file when buying a seat
    public void save(String path,String content1,String content2){
        try {
            File file = new File(path);
            if(file.createNewFile()){
                fileWriter(path,content1,content2);

            } else if (file.exists()) {
                //This part was added so that it will it get written even though the file exists.
                fileWriter(path,content1,content2);
            }
        } catch(FileNotFoundException e){ //To fix the exception when the file already exists
            System.out.println("The file was not found");
        } catch(IOException e){ //To catch the exception when path is invalid
            System.out.println("An error has occurred while creating a file");
        }

    }
    //Method to write to the file when buying a seat
    private void fileWriter(String path,String content1,String content2){
        try {
            FileWriter fileWriter=new FileWriter(path); //This line will create a file writer object
            //These lines will write the content to the file
            fileWriter.write(content1);
            fileWriter.write(content2);
            fileWriter.close(); //Closing the file writer
            System.out.println("Successfully wrote to the file");
        }catch(IOException e){  //To catch the exception when writing to the file
            System.out.println("An error has occurred while writing to the file");
        }
    }

    //Method to delete the file when cancelling a seat
    public void delete(String path){
        File file = new File(path);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }


}
