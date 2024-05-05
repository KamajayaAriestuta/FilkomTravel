public class Guest extends Pelanggan {
    public Guest(String firstName, String lastName, String NIK, String phoneNumber, String gender, String password) {
        super(firstName, lastName, NIK, phoneNumber, gender, password);
    }

    @Override
    public String getFullName() {
        return firstName + (lastName != null ? " " + lastName : "");
    }

    @Override
    public void makeOrder() {
        System.out.println("Guest making an order");
    }

    @Override
    public void confirmPay(int orderNumber) {
        System.out.println("Guest confirming payment for order " + orderNumber);
    }
    @Override
    public boolean isMember() {
        return false;  
    }

}
