package com.travel.model.reservation;

import java.time.LocalDate;
import java.util.ArrayList;

import com.travel.model.account.Profile;
import com.travel.model.vehicle.BigCar;
import com.travel.model.vehicle.MediumCar;
import com.travel.model.vehicle.SmallCar;
import com.travel.model.vehicle.Vehicle;


/**
 * Kelas yang merepresentasikan sebuah reservasi kendaraan.
 * Memiliki atribut seperti kapasitas kendaraan yang dipilih, jumlah penumpang,
 * tanggal sewa, tanggal pengembalian, dan lainnya.
 * Metode yang dimilikinya adalah:
 * - calculateBill(Profile user): Menghitung total biaya reservasi berdasarkan
 * harga sewa kendaraan, jumlah hari sewa, dan status keanggotaan pengguna.
 * - calculateDays(LocalDate startDate, LocalDate endDate): Menghitung jumlah
 * hari antara dua tanggal.
 * - addToTemporaryReservationList(Vehicle vehicle): Menambahkan kendaraan ke
 * dalam daftar sementara reservasi.
 * - getRentalStartDate(): Mengembalikan tanggal sewa kendaraan.
 * - getRentalEndDate(): Mengembalikan tanggal pengembalian kendaraan.
 * - getChosenCar(): Mengembalikan nama kendaraan yang dipilih untuk reservasi.
 * - getDestination(): Mengembalikan tujuan perjalanan.
 * - getNumberPassengers(): Mengembalikan jumlah penumpang.
 */

public class Reservation {
    public int chooseVehicleCapacity;
    public int numberPassengers;
    private static int reservationCounter = 1000;
    private int reservationNumber;
    public LocalDate rentalStartDate;
    public LocalDate rentalEndDate;
    // public LocalDate checkoutDate;
    public String chosenCar;
    public String destination;
    public ArrayList<Vehicle> temporaryReservationList;
    private LocalDate reservationDate;

    public Reservation(int chooseVehicleCapacity, int numberPassengers, LocalDate rentalStartDate,
        LocalDate rentalEndDate, String chosenCar, String destination, LocalDate reservationDate)
    {
        this.chooseVehicleCapacity = chooseVehicleCapacity;
        this.numberPassengers = numberPassengers;
        this.reservationNumber = generateReservationNumber();
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.chosenCar = chosenCar;
        this.destination = destination;
        this.temporaryReservationList = new ArrayList<>();
        this.reservationDate = reservationDate;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double calculateBill(Profile user) {
        double totalBill = 0.0;

        // Menghitung jumlah hari sewa secara manual
        long days = calculateDays(rentalStartDate, rentalEndDate);

        for (Vehicle vehicle : temporaryReservationList) {
            // Dapatkan harga sewa kendaraan
            double rentPrice = 0.0;
            if (vehicle instanceof SmallCar) {
                rentPrice = ((SmallCar) vehicle).getRentPrice();
            } else if (vehicle instanceof MediumCar) {
                rentPrice = ((MediumCar) vehicle).getRentPrice();
            } else if (vehicle instanceof BigCar) {
                rentPrice = ((BigCar) vehicle).getRentPrice();
            }

            double vehicleTotal = rentPrice * days;
            totalBill += vehicleTotal;
        }

        if (user.isMember() && totalBill > 0) {
            totalBill *= 0.9;
        }

        return totalBill;
    }

    private long calculateDays(LocalDate startDate, LocalDate endDate) {
        long days = 0;
        LocalDate tempDate = startDate;

        while (!tempDate.isEqual(endDate)) {
            tempDate = tempDate.plusDays(1);
            days++;
        }

        return days;
    }

    public void addToTemporaryReservationList(Vehicle vehicle) {
        temporaryReservationList.add(vehicle);
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getChosenCar() {
        return chosenCar;
    }

    public String getDestination() {
        return destination;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }
    // public LocalDate getCheckoutDate() {
    //     return checkoutDate;
    // }

    // public void setCheckoutDate(LocalDate checkoutDate) {
    //     this.checkoutDate = checkoutDate;
    // }

    private static int generateReservationNumber() {
        return ++reservationCounter;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    // public void setReservationNumber(int reservationNumber) {
    //     this.reservationNumber = reservationNumber;
    // }
}
