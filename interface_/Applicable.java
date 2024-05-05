

public interface Applicable {
    public boolean isCustomerEligible();
    public boolean isMinimumPrizeEligible();
    public boolean isShippingFeeEligible();
    public double totalDiscount();
    public double totalCashback();
    public double totalShippingCost();
}
