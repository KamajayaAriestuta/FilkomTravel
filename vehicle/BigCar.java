package com.travel.model.vehicle;
import java.util.*;
/**
 * Kelas yang merepresentasikan sebuah mobil besar.
 * Kelas ini merupakan turunan dari kelas Vehicle.
 * Memiliki atribut tambahan seperti kapasitas dan harga sewa.
 * Metode yang dimilikinya adalah:
 * - getCapacity(): untuk mendapatkan kapasitas mobil besar.
 * - getRentPrice(): untuk mendapatkan harga sewa mobil besar.
 * - displayHeader(): untuk menampilkan header saat menampilkan daftar mobil
 * besar.
 * - display(): untuk menampilkan detail mobil besar.
 */
public class BigCar extends Vehicle {
    private int capacity;
    private double rentPrice;
    private ArrayList<BigCar> bigCars = new ArrayList<>();

    public BigCar(String name, String brand, String type, String registrationNumber, int capacity, double rentPrice) {
        super(name, brand, type, registrationNumber);
        this.capacity = capacity;
        this.rentPrice = rentPrice;
    }

    public ArrayList<BigCar> getBigCars() {
        return bigCars;
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
