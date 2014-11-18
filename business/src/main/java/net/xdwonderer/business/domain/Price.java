package net.xdwonderer.business.domain;

import java.math.BigDecimal;

public class Price implements PriceInterface {
    private String amount;

    public Price(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return this.amount;
    }
}
