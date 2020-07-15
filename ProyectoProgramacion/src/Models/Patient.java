package Models;

/**
 * @author JD101
 * 
 * Su función es tomar a un paciente y sus características para convertirlo en 
 * un objeto Java. 
 */
public class Patient extends Person{
    
    private String testDay;
    private String testStatus;
    private String observations;

    //  Constructors
    /**
     * Este constructor inicializa todos sus atributos nulos.
     */
    public Patient() {

        this.testDay = null;
        this.testStatus = null;
        this.observations = null;
        
    }

    /**
     * Este constructor inicializa los atributos de acuerdo a los parámetros 
     * ingresados.
     * @param testday
     * @param teststatus
     * @param observations 
     */
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
