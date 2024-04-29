package com.travel.model.vehicle;
import java.util.*;
/**
 * Kelas yang merepresentasikan sebuah mobil sedang.
 * Kelas ini merupakan turunan dari kelas Vehicle.
 * Memiliki atribut tambahan seperti kapasitas dan harga sewa.
 * Metode yang dimilikinya adalah:
 * - getCapacity(): untuk mendapatkan kapasitas mobil sedang.
 * - getRentPrice(): untuk mendapatkan harga sewa mobil sedang.
 * - displayHeader(): untuk menampilkan header saat menampilkan daftar mobil
 * sedang.
 * - display(): untuk menampilkan detail mobil sedang.
 */
public class MediumCar extends Vehicle {
    private int capacity;
    private double rentPrice;
    private ArrayList<MediumCar> mediumCars = new ArrayList<>();

    public MediumCar(String name, String brand, String type, String registrationNumber, int capacity,
            double rentPrice) {
        super(name, brand, type, registrationNumber);
        this.capacity = capacity;
        this.rentPrice = rentPrice;

    }

    public ArrayList<MediumCar> getMediumCars() {
        return mediumCars;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public static void displayHeader() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                "Name", "Brand", "Type", "Reg. Number", "Capacity", "Rent Price");
    }

    public void display() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                name, brand, type, registrationNumber, capacity, rentPrice);
    }
}
