package no71;
public class DiscountRate {
    static double serviceDiscountPremium = 0.2;
    static double serviceDiscountGold = 0.15;
    static double serviceDiscountSilver = 0.1;
    static double productDiscountPremium, productDiscountGold, productDiscountSilver = 0.1;
    
    public static double getServiceDiscountRate(String type) {
        if (type == "Premium") {
            return 0.2;
        } else if (type == "Gold") {
            return 0.15;
        } else if (type == "Silver") {
            return 0.1;
        } else {
            return 0.0;
        }
    }

    public static double getProductDiscountRate(String type) {
        return 0.1;
    }
}
