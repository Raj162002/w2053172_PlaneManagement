public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person newObj=new Person("Raj","Ramakumar","ram@gmail.com");
        newObj.printall();
        Ticket secondObj=new Ticket('a',23.2,newObj);
        secondObj.printTicket();
    }
}