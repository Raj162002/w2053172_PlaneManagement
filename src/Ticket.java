import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private char row;
    private int seat;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    private double price;
    private Person person;

    public Ticket(char row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

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

    public void printTicket(){
        System.out.println("The reserved seat is "+this.row+this.seat);
        System.out.println("The price of this ticket is:- "+this.price+"\u00a3");
        System.out.println(this.person.printall());
    }

    public void save(String path,String content1,String content2){
        try {
            File file = new File(path);
            if(file.createNewFile()){
                fileWriter(path,content1,content2);

            } else if (file.exists()) {
                //This part was added so that it will it get written even though the file exists.
                fileWriter(path,content1,content2);
            }
        } catch(FileNotFoundException e){
            System.out.println("The file was not found");
        } catch(IOException e){
            System.out.println("An error has occurred while creating a file");
        }

    }
    private void fileWriter(String path,String content1,String content2){
        try {
            FileWriter fileWriter=new FileWriter(path);
            fileWriter.write(content1);
            fileWriter.write(content2);
            fileWriter.close();
            System.out.println("Successfully wrote to the file");
        }catch(IOException e){
            System.out.println("An error has occurred while writing to the file");
        }
    }

    public void delete(String path){
        File file = new File(path);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }


}
