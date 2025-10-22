package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a)
    public Customers(int size) {
        customers = new Customer[size];
        System.out.println("Kundetabell med størrelse " + size + " opprettet.");
    }

    // b)
    public int countNonNull() {
        int count = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                count++;
            }
        }
        return count;
    }

    // c)
    public Customer getCustomer(int id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].id() == id) {
                return customers[i];
            }
        }
        return null;
    }

    // d)
    public boolean addCustomer(Customer c) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                return true;
            }
        }
        return false;
    }

    // e)
    public Customer removeCustomer(int id) {
        for (int i  = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].id() == id) {
                Customer c = customers[i];
                customers[i] = null;
                return c;
            }
        }
        return null;
    }

    // f)
    public Customer[] getCustomers() {
        Customer[] result = new Customer[countNonNull()];
        int j = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                result[j] = customers[i];
                j++;
            }
        }
        return result;
    }
}
