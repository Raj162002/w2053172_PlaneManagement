public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person newObj=new Person("Rajeevan","Ramakumar","ram@gmail.com");
        Ticket secondObj=new Ticket('A',12,23.3,newObj);
        secondObj.printTicket();
        String raj="Raj";
//        raj= Character.toChars(raj);
    }
}