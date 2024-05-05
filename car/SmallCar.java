/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project.car;

/**
 *
 * @author imadekamajaya
 */
import java.util.*;

/**
 * Kelas yang merepresentasikan sebuah mobil kecil.
 * Kelas ini merupakan turunan dari kelas Vehicle.
 * Memiliki atribut tambahan seperti kapasitas dan harga sewa.
 * Metode yang dimilikinya adalah:
 * - getCapacity(): untuk mendapatkan kapasitas mobil kecil.
 * - getRentPrice(): untuk mendapatkan harga sewa mobil kecil.
 * - displayHeader(): untuk menampilkan header saat menampilkan daftar mobil
 * kecil.
 * - display(): untuk menampilkan detail mobil kecil.
 */

public class SmallCar extends Vehicle {
    private int capacity;
    private double rentPrice;
    private ArrayList<SmallCar> smallCars = new ArrayList<>();

    public SmallCar(String name, String brand, String type, String registrationNumber, int capacity, double rentPrice) {
        super(name, brand, type, registrationNumber);
        this.capacity = capacity;
        this.rentPrice = rentPrice;

    }

    public ArrayList<SmallCar> getSmallCars() {
        return smallCars;
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
