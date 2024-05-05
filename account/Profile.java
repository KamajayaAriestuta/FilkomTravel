package com.travel.model.account;

import java.time.LocalDate;
import java.util.*;

import com.travel.model.reservation.Reservation;

/**
 * Kelas yang merepresentasikan profil pengguna, yang merupakan turunan dari
 * kelas UserAccount.
 * Kelas ini menyimpan informasi tambahan seperti nama pengguna, kata sandi,
 * status keanggotaan,
 * dan histori pemesanan.
 */
public class Profile extends UserAccount {
    private String username;
    private String password;
    private boolean isMember;
    private ArrayList<Reservation> bookingHistory;

    /**
     * Konstruktor untuk membuat objek profil pengguna dengan parameter tertentu.
     *
     * @param fullName   Nama lengkap pengguna.
     * @param NIK        Nomor Identitas Kependudukan (NIK) pengguna.
     * @param telpNumber Nomor telepon pengguna.
     * @param gender     Jenis kelamin pengguna.
     * @param username   Nama pengguna (username) untuk login.
     * @param password   Kata sandi (password) untuk login.
     */
    public Profile(String fullName, String NIK, String telpNumber, String gender, String username, String password) {
        super(fullName, NIK, telpNumber, gender);
        this.username = username;
        this.password = password;
        this.isMember = false;
        this.bookingHistory = new ArrayList<>();
    }

    /**
     * Metode untuk menampilkan histori pemesanan pengguna.
     * Jika tidak ada histori pemesanan, akan mencetak pesan bahwa histori tidak
     * tersedia.
     * Jika ada, akan mencetak informasi mengenai setiap pemesanan yang dilakukan.
     */
    public void displayBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No booking history available.");
        } else {
            System.out.println("Booking History:");
            for (Reservation reservation : bookingHistory) {
                System.out.println("Customer Name: " + fullName);
                System.out.println("Vehicle: " + reservation.getChosenCar());
                System.out.println("Start Date: " + reservation.getRentalStartDate() + " ("
                + reservation.getRentalStartDate().getDayOfWeek() + ")");
                System.out.println("End Date: " + reservation.getRentalEndDate()+ "("
                + reservation.getRentalEndDate().getDayOfWeek() + ")");
                System.out.println("Reservation Date: " + reservation.getReservationDate() + " ("
                        + reservation.getReservationDate().getDayOfWeek() + ")");
                System.out.println("-------------------------------------");
            }
        }
    }

    /**
     * Metode untuk menambahkan pemesanan ke histori pemesanan pengguna.
     *
     * @param reservation Pemesanan yang akan ditambahkan ke histori.
     */
    public void addToBookingHistory(Reservation reservation) {
        reservation.setReservationDate(LocalDate.now());
        bookingHistory.add(reservation);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public void updateAccount(String fullName, String NIK, String telpNumber, String gender) {
        this.setFullName(fullName);
        this.setNIK(NIK);
        this.setTelpNumber(telpNumber);
        this.setGender(gender);
    }

}
