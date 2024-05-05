package com.travel.model.account;

/**
 * Kelas yang merepresentasikan akun pengguna, menyimpan informasi seperti nama
 * lengkap,
 * nomor identitas (NIK), nomor telepon, dan jenis kelamin.
 */
public class UserAccount {
    protected String fullName;
    protected String NIK;
    protected String telpNumber;
    protected String gender;

    /**
     * Konstruktor untuk membuat objek akun pengguna dengan parameter tertentu.
     *
     * @param fullName   Nama lengkap pengguna.
     * @param NIK        Nomor Identitas Kependudukan (NIK) pengguna.
     * @param telpNumber Nomor telepon pengguna.
     * @param gender     Jenis kelamin pengguna.
     */
    public UserAccount(String fullName, String NIK, String telpNumber, String gender) {
        this.fullName = fullName;
        this.NIK = NIK;
        this.telpNumber = telpNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getTelpNumber() {
        return telpNumber;
    }

    public void setTelpNumber(String telpNumber) {
        this.telpNumber = telpNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}