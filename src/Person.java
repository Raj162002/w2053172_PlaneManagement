public class Person {
    // Declare private variables for name, surname and email
    private String name;
    private String surname;
    private String email;

    // Constructor for Person class
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getter and setter methods for name, surname and email
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to print all the details of a person
    public String printall(){
//        System.out.println("Name:- "+this.name);
//        System.out.println("Surname:- "+this.surname);
//        System.out.println("Email:- "+this.email);
//        System.out.println();
        return ("\n"+"Name:- "+this.name+"\n"+"Surname:- "+this.surname+"\n"+"Email:- "+this.email+"\n");
    }

}
