package com.walmart.offersservice.domain;

import lombok.Getter;

@Getter
public class Prices {

    public static final int DISCOUNT_LIMIT = 50;

    private Integer original;
    private Integer discounted;
    private Integer appliedDiscount;

    public Prices(Integer original, Integer discounted, Integer appliedDiscount) {
        this.original = original;
        this.discounted = discounted;
        this.appliedDiscount = appliedDiscount;
    }

    public static Prices createPricesBy(Integer amount, Integer discount) {
        discount = validateDiscount(discount);

        return new Prices(amount, calculateDiscounted(amount, discount), discount);
    }

    private static Integer validateDiscount(Integer discount) {
        if (isDiscountMoreThanTheLimit(discount)) {
            discount = DISCOUNT_LIMIT;
        }
        return discount;
    }

    private static boolean isDiscountMoreThanTheLimit(Integer discount) {
        return discount > DISCOUNT_LIMIT;
    }

    private static int calculateDiscounted(Integer amount, Integer discount) {
        return (amount * (100 - discount)) / 100;
    }
}
