package Project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Member extends Pelanggan {
    private LocalDate joinDate;
    private ArrayList<String> orders;
    private boolean member;
    public Member(String firstName, String lastName, String NIK, String phoneNumber, String gender, LocalDate joinDate, String password) {
        super(firstName, lastName, NIK, phoneNumber, gender, password);
        this.joinDate = joinDate;
        this.orders = new ArrayList<>();
    }

    @Override
    public String getFullName() {
        return firstName + (lastName != null ? " " + lastName : "");
    }

    public long getMembershipDuration() {
        return ChronoUnit.DAYS.between(joinDate, LocalDate.now());
    }

    @Override
    public void makeOrder() {
        System.out.println("Member making an order");
    }

    @Override
    public void confirmPay(int orderNumber) {
        System.out.println("Member confirming payment for order " + orderNumber);
    }

    public void addOrder(String orderID) {
        orders.add(orderID);
    }
    public boolean isMember(){
        return true;
    }
}