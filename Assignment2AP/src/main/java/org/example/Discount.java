package org.example;
public class Discount {
    private String category;
    private int percentage;

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    private String discountCode;

    public Discount(String category, int percentage) {
        this.category = category;
        this.percentage = percentage;
        this.discountCode = category.toUpperCase() + percentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        this.discountCode = category.toUpperCase() + percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
        this.discountCode =category.toUpperCase() + percentage;
    }
}
