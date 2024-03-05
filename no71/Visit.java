package no71;
import java.util.Date;

public class Visit {
    private Customer customer;
    private Date date;
    double serviceExpense, productExpense;

    public Visit(Date date, String name) {
        this.date = date;
        customer = new Customer(name);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());

        double discountedServiceTotal = serviceExpense - (serviceExpense * serviceDiscount);
        double discountedProductTotal = productExpense - (productExpense * productDiscount);

        return discountedServiceTotal + discountedProductTotal;
    }


    @Override
    public String toString() {
        return "Visit [customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense
                + ", productExpense=" + productExpense + "]";
    }
}
