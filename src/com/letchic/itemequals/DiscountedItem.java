package com.letchic.itemequals;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject.getClass() == Item.class) return super.equals(otherObject);
        DiscountedItem other = (DiscountedItem) otherObject;
        return Math.abs(discount-other.discount)<=0.00001;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}