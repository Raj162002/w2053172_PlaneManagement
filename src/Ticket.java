import java.io.File;
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
        System.out.println(this.person.printall());
        String path=String.valueOf(this.row)+this.seat+".txt";
        //Since this.row is a char we had to use String.valueOf to convert it to string.
        System.out.println(path);
        save(path,this.person.printall(),"The reserved seat is "+this.row+this.seat);
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
        }catch(IOException e){
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
            System.out.println("An error has occurred while creating a file");
        }
    }


}
