package com.travel;

import java.util.Scanner;

import com.travel.model.account.*;
import com.travel.model.reservation.*;
import com.travel.model.vehicle.*;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class Project {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Profile> accounts = new HashMap<>();
        Map<String, Reservation> reservations = new LinkedHashMap<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<String> login = new ArrayList<>();
        boolean stop = true;

        vehicles.add(new SmallCar("Ayla", "Daihatsu", "Hatchback", "N 1244 KK", 4, 350000));
        vehicles.add(new SmallCar("Agya", "Toyota", "Hatchback", "N 4231 EP", 4, 350000));
        vehicles.add(new SmallCar("Brio Satya", "Daihatsu", "Hatchback", "N 3241 OB", 4, 350000));
        vehicles.add(new MediumCar("Avanza", "Toyota", "MPV", "N 3212 RE", 8, 650000));
        vehicles.add(new MediumCar("Xenia", "Daihatsu", "MPV", "N 4414 AN", 8, 650000));
        vehicles.add(new MediumCar("Ertiga", "Suzuki", "MPV", "N 2341 EL", 8, 650000));
        vehicles.add(new BigCar("Hiace", "Toyota", "Minivan", "N 5313 HE", 14, 1500000));

        System.out.println("Command Help:");
        System.out.println("- To login: login|<username> ");
        System.out.println("- To create account: create account|username");
        System.out.println("- To update profile: update profile = <username>");
        System.out.println("- To become a member: member registration = <username>");
        System.out.println("- To make reservation: make reservation");
        System.out.println("- To check bill: check bill");
        System.out.println("- To logout: logout");
        System.out.println("- To quit program: quit program\n");

        while (stop) {
            while (true) {
                String command = in.nextLine().toLowerCase();
                if (command.startsWith("create account")) {
                    String username = command.substring(15);
                    if (accounts.containsKey(username)) {
                        System.err.println("CREATE MEMBER FAILED: " + username + " IS EXISTS\n");
                    } else {
                        System.out.print("enter your password: ");
                        String password = in.nextLine();
                        System.out.print("enter your name: ");
                        String name = in.nextLine();
                        System.out.print("enter your NIK: ");
                        String NIK = in.nextLine();
                        System.out.print("enter your phone number: ");
                        String phoneNumber = in.nextLine();
                        System.out.print("Enter gender: ");
                        System.out.println("Pilih Gender");
                        System.out.println("Male = 1");
                        System.out.println("Female = 2");
                        System.out.print("Choose your gender: ");
                        String gender = in.nextLine();

                        if (gender.equalsIgnoreCase("1")) {
                            gender = "Male";
                        } else if (gender.equalsIgnoreCase("2")) {
                            gender = "Female";
                        } else {
                            // Jika input tidak valid, Anda dapat menetapkan nilai default atau melakukan
                            // penanganan khusus
                            System.err.println("Gender not valid");
                            gender = "Not Found";
                        }
                        Profile account = new Profile(name, NIK, phoneNumber, gender, username, password);
                        accounts.put(username, account);
                        System.out.println("CREATE ACCOUNT SUCCESS, HELLO " + username
                                + ", welcome to Travel FILKOM UB " + name + "\n");
                    }
                } else if (command.startsWith("login")) {
                    String username = command.substring(6);
                    if (accounts.isEmpty()) {
                        System.err.println("LOGIN FAILED: " + " NO ACCOUNT REGISTERED\n");
                    } else if (accounts.containsKey(username)) {
                        System.out.print("enter your password: ");
                        isPassword(username, accounts.get(username).getPassword());
                        login.add(username);
                        break;
                    }
                } else if (command.startsWith("update profile")) {
                    String username = command.substring(15);
                    System.out.print("enter username: ");
                    String name = in.nextLine();
                    System.out.print("enter your NIK: ");
                    String NIK = in.nextLine();
                    System.out.print("enter your phone number: ");
                    String phoneNumber = in.nextLine();
                    System.out.println("enter your gender: ");
                    System.out.println("Male = 1");
                    System.out.println("Female = 2");
                    System.out.print("Choose your gender: ");
                    String gender = in.nextLine();

                    if (gender.equalsIgnoreCase("1")) {
                        gender = "Male";
                    } else if (gender.equalsIgnoreCase("2")) {
                        gender = "Female";
                    } else {
                        // Jika input tidak valid, Anda dapat menetapkan nilai default atau melakukan
                        // penanganan khusus
                        System.err.println("Gender not valid");
                        gender = "Not Found";
                    }

                    if (accounts.isEmpty()) {
                        System.err.println("UPDATE PROFILE FAILED: " + " NO ACCOUNT REGISTERED\n");
                    } else if (accounts.containsKey(username)) {
                        accounts.get(username).updateAccount(name, NIK, phoneNumber, gender);
                        System.out.println("UPDATE PROFILE SUCCESS :" + username + " "
                                + accounts.get(username).getFullName() + "\n");
                    } else {
                        System.err.println("UPDATE PROFILE FAILED: " + username + " NOT FOUND\n");
                    }
                } else if (command.startsWith("quit program")) {
                    System.out.println("YOU QUIT THE PROGRAM");
                    stop = false;
                    break;
                }

            }

            if (stop) {
                while (true) {
                    String command = in.nextLine().toLowerCase();
                    String username = login.get(0);
                    if (command.startsWith("member registration")) {
                        if (accounts.containsKey(username)) {
                            accounts.get(username).setMember(true);
                            System.out.println("REGISTRATION SUCCESS: " + username + " IS A MEMBER\n");
                        } else {
                            System.out.println("REGISTRATION FAILED: " + username + " NOT FOUND\n");
                        }
                    } else if (command.startsWith("make reservation")) {
                        System.out.println("List type mobil:");
                        System.out.println("1. Small Car");
                        System.out.println("2. Medium Car");
                        System.out.println("3. Big Car");
                        System.out.print("Choose car type: ");
                        int type = Integer.parseInt(in.nextLine());
                    
                        switch (type) {
                            case 1:
                                System.out.println("List Small Car:");
                                SmallCar.displayHeader();
                                for (Vehicle vehicle : vehicles) {
                                    if (vehicle instanceof SmallCar) {
                                        SmallCar display = (SmallCar) vehicle;
                                        display.display();
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("List Medium Car:");
                                MediumCar.displayHeader();
                                for (Vehicle vehicle : vehicles) {
                                    if (vehicle instanceof MediumCar) {
                                        MediumCar display = (MediumCar) vehicle;
                                        display.display();
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("List Big Car:");
                                BigCar.displayHeader();
                                for (Vehicle vehicle : vehicles) {
                                    if (vehicle instanceof BigCar) {
                                        BigCar display = (BigCar) vehicle;
                                        display.display();
                                    }
                                }
                                break;
                            default:
                                System.err.println("Invalid type!\n");
                                break;
                        }
                    
                        System.out.print("choose car: ");
                        String chosenCar = in.nextLine();
                    
                        Vehicle chosenVehicle = null;
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle.getName().equalsIgnoreCase(chosenCar)) {
                                chosenVehicle = vehicle;
                                break;
                            }
                        }
                    
                        if (chosenVehicle != null) {
                            int capacity = 0;
                    
                            if (chosenVehicle instanceof SmallCar) {
                                capacity = ((SmallCar) chosenVehicle).getCapacity();
                            } else if (chosenVehicle instanceof MediumCar) {
                                capacity = ((MediumCar) chosenVehicle).getCapacity();
                            } else if (chosenVehicle instanceof BigCar) {
                                capacity = ((BigCar) chosenVehicle).getCapacity();
                            }
                    
                            System.out.print("enter number of passengers: ");
                            int numPassengers = Integer.parseInt(in.nextLine());
                            System.out.print("enter destination: ");
                            String destination = in.nextLine();
                            System.out.print("Enter rental date (YYYY-MM-DD): ");
                            String startDateString = in.nextLine();
                            LocalDate startDate = LocalDate.parse(startDateString);
                            System.out.print("Enter rental duration (in days): ");
                            long duration = Integer.parseInt(in.nextLine());
                            LocalDate endDate = startDate.plusDays(duration);
                    
                            // Generate reservation number automatically
                            int reservationNumber = 0; // Temporary value
                            Reservation newReservation = new Reservation(capacity, numPassengers, startDate, endDate,
                            chosenCar, destination, LocalDate.now());
                        
                    
                            newReservation.addToTemporaryReservationList(chosenVehicle);
                            reservations.put(login.get(0), newReservation);
                            System.out.println("Reservation made successfully for " + login.get(0) + "\n");
                            accounts.get(login.get(0)).addToBookingHistory(newReservation);
                        } else {
                            System.out.println("Invalid car choice.\n");
                        }
                    }
                     else if (command.startsWith("check bill")) {
                        if (reservations.containsKey(username)) {
                            System.out.println("-------- Reservation Details --------");
                            System.out.printf("| %-20s | %-15s |%n", "Username:", username);
                            System.out.printf("| %-20s | %-15s |%n", "Full Name:", accounts.get(username).getFullName());
                            System.out.printf("| %-20s | %-15s |%n", "NIK:", accounts.get(username).getNIK());
                            System.out.printf("| %-20s | %-15s |%n", "Phone Number:",
                                    accounts.get(username).getTelpNumber());
                            System.out.printf("| %-20s | %-15s |%n", "Gender:", accounts.get(username).getGender());
                            System.out.println("-------------------------------------");
                            System.out.printf("| %-20s | %-15s |%n", "Reservation Number:",
                            reservations.get(username).getReservationNumber());
                            System.out.printf("| %-20s | %-15s |%n", "Vehicle:",
                                    reservations.get(username).getChosenCar());
                            System.out.printf("| %-20s | %-15s |%n", "Destination:",
                                    reservations.get(username).getDestination());
                            System.out.printf("| %-20s | %-15s |%n", "Start Date:",
                                    reservations.get(username).getRentalStartDate());
                            System.out.printf("| %-20s | %-15s |%n", "End Date:",
                                    reservations.get(username).getRentalEndDate());
                            System.out.printf("| %-20s | %-15s |%n", "Passengers:",
                                    reservations.get(username).getNumberPassengers());
                            System.out.println("-------------------------------------");

                            double totalBill = reservations.get(username).calculateBill(accounts.get(username));
                            System.out.printf("| Total Bill: %-10.2f |%n", totalBill);
                            System.out.println("----------------------");
                        } else {
                            System.out.println("Reservation for " + username + "Not Found!");
                        }
                    } else if (command.startsWith("booking history")) {
                        if (accounts.containsKey(username) && accounts.get(username).isMember()) {
                            accounts.get(username).displayBookingHistory();
                        } else {
                            System.out.println("Access denied. Only members can access booking history.");
                        }
                    } else if (command.startsWith("logout")) {
                        login.clear();
                        System.out.println("LOGOUT SUCCES: " + username + "\n");
                        break;

                    } else if (command.startsWith("quit program")) {
                        stop = false;
                        break;
                    }

                }
            } else {
                break;
            }
        }
        in.close();
    }

    public static void isPassword(String username, String password) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String passwordInput = in.nextLine();
            if (password.equals(passwordInput)) {
                System.out.println("PASSWORD CORRECT" + "\n");
                System.out.println("LOGIN SUCCESS, Welcome " + username + "\n");
                break;
            } else {
                System.out.println("PASSWORD INCORRECT" + "\n");
            }
        }
    }
}
