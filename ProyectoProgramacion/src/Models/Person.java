package Models;

public class Person {

    private String idPatient;
    private String namePatient;
    private String firstLastName;
    private String secondLastName;
    private String nationality;
    private String birthdate;
    private String phoneNumber;
    private String address;

    //  Constructors
    public Person() {

        this.idPatient = null;
        this.namePatient = null;
        this.firstLastName = null;
        this.secondLastName = null;
        this.nationality = null;
        this.birthdate = null;
        this.phoneNumber = null;
        this.address = null;

    }

    public Person(String idPatient, String namePatient, String firstLastName, 
            String secondLastName, String nationality, String birthdate, 
            String phoneNumber, String address) {

        this.idPatient = idPatient;
        this.namePatient = namePatient;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.nationality = nationality;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    //  Setter's
    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //  Getter's
    public String getIdPatient() {
        return this.idPatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

}
