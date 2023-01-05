public class Person {
    private String firstname;
    private String lastName;
    private String eMail;
    private int age;

    public Person(String firstname,String lastName,String eMail,int age) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.eMail = eMail;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }
    public String geteMail() {
        return eMail;
    }
}
