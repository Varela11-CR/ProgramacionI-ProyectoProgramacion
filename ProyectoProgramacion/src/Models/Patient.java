package Models;

public class Patient extends Person{
    
    private String testDay;
    private String testStatus;
    private String observations;

    //  Constructors
    public Patient() {

        this.testDay = null;
        this.testStatus = null;
        this.observations = null;
        
    }

    public Patient(String testday, String teststatus, String observations) {
        
        this.testDay = testday;
        this.testStatus = teststatus;
        this.observations = observations;
    }
    
    //  Setter's
    public void setTestDay(String testday) {
        this.testDay = testday;
    }

    public void setTestStatus(String teststatus) {
        this.testStatus = teststatus;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    //  Getter's
    public String getTestDay() {
        return testDay;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public String getObservations() {
        return observations;
    }
            
}
