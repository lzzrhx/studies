package no.hvl.dat100.javel.oppgave3;

public class Customer {
    private static int num = 0;
    private int id;
    private String name;
    private String email;
    private PowerAgreementType agreement;

    public Customer(String name, String email, PowerAgreementType agreement, boolean verbose) {
        this(name, email, agreement);
        if (verbose) { 
            System.out.println("Ny kunde lagt til:\n" + toString() + "\n");
        }
    }

    public Customer(String name, String email, PowerAgreementType agreement) {
        Customer.num++;
        this.id = Customer.num;
        name(name);
        email(email);
        agreement(agreement);
    }

    // Getter for id
    public int id() {
        return this.id;
    }

    // Getter for name
    public String name() {
        return this.name;
    }

    // Setter for name
    public void name(String name) {
        this.name = name;
    }

    // Getter for email
    public String email() {
        return this.email;
    }

    // Setter for email
    public void email(String email) {
        this.email = email;
    }

    // Getter for agreement
    public PowerAgreementType agreement() {
        return this.agreement;
    }

    // Setter for agreement
    public void agreement(PowerAgreementType agreement) {
        this.agreement = agreement;
    }

    // Returner tekststreng med brukerinfo
    public String toString() {
        return "id:        " + id + "\nname:      " + name + "\nemail:     " + email + "\nagreement: " + agreement;
    }

}
