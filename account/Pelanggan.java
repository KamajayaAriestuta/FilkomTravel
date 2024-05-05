/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project.account;

/**
 *
 * @author imadekamajaya
 */
import Project.reservasi.Reservation;
import java.util.ArrayList;

public abstract class Pelanggan {
    protected String firstName;
    protected String lastName;
    protected String NIK;
    protected String phoneNumber;
    protected String gender;
    private String password;
    protected ArrayList<Reservation> bookingHistory = new ArrayList<>();

    public Pelanggan(String firstName, String lastName, String NIK, String phoneNumber, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.NIK = NIK;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.password = password;
    }

    public abstract String getFullName();
    public abstract void makeOrder();
    public abstract void confirmPay(int orderNumber);

    public void addToBookingHistory(Reservation reservation) {
        bookingHistory.add(reservation);
    }

    public void displayBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("Booking History:");
            for (Reservation reservation : bookingHistory) {
                System.out.println("Reservation ID: " + reservation.getReservationNumber());
                System.out.println("Vehicle: " + reservation.getChosenCar());
                System.out.println("Start Date: " + reservation.getRentalStartDate());
                System.out.println("End Date: " + reservation.getRentalEndDate());
                System.out.println("Passengers: " + reservation.getNumberPassengers() + "\n");
            }
        }
    }


    public String getNIK() {
        return NIK;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public boolean isMember(){
        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Reservation> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(ArrayList<Reservation> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
