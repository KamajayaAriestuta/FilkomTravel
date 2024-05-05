/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project.car;

/**
 *
 * @author imadekamajaya
 */

/**
 * Kelas yang merepresentasikan sebuah kendaraan.
 * Kelas ini memiliki atribut-atribut seperti nama, merek, tipe, dan nomor
 * registrasi kendaraan.
 * Metode yang dimilikinya adalah:
 * - getType(): untuk mendapatkan tipe kendaraan.
 * - getName(): untuk mendapatkan nama kendaraan.
 * - getBrand(): untuk mendapatkan merek kendaraan.
 * - getRegistrationNumber(): untuk mendapatkan nomor registrasi kendaraan.
 */
public class Vehicle {
    protected String name;
    protected String brand;
    protected String type;
    protected String registrationNumber;

    public Vehicle(String name, String brand, String type, String registrationNumber) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

