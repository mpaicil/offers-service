package com.walmart.offersservice.domain;

import lombok.Getter;

@Getter
public class Prices {

    private Integer original;
    private Integer discounted;
    private Integer appliedDiscount;

    public Prices(Integer original, Integer discounted, Integer appliedDiscount) {
        this.original = original;
        this.discounted = discounted;
        this.appliedDiscount = appliedDiscount;
    }

    public static Prices createBy(Integer amount, Integer discount) {
        return new Prices(amount, calculateDiscounted(amount, discount), discount);
    }

    private static int calculateDiscounted(Integer amount, Integer discount) {
        return (amount * (100 - discount)) / 100;
    }
}
