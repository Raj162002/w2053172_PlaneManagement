public class Ticket {
    private String row;
    private double price;
    private Person person;

    public Ticket(String row, double price, Person person) {
        this.row = row;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
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
        System.out.println(row);

        this.person.printall();
    }


}
