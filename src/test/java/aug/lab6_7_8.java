package aug;

public class lab6_7_8 {

    private String fName;
    private String lName;
    private Gender gen;
    private String phone;

    enum Gender {
        M, F
    }

    public void setDetails(String fName, String lName, Gender gender, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.gen = gender;
        this.phone = phone;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public Gender getGender() {
        return gen;
    }

    public String getPhone() {
        return phone;
    }

    public void display() {
        System.out.println("Person Details:");
        System.out.println("--------------------");
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        System.out.println("Gender: " + gen);
        System.out.println("Phone Number: " + phone);
    }

    // Main method to test the class
    public static void main(String[] args) {
    	lab6_7_8 person = new lab6_7_8();
        person.setDetails("TUMMALA", "VENKATESH", Gender.M, "9876543210");
        person.display();
    }
}
