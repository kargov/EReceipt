package net.xdwonderer.business.domain;

public class ReceiptEntry implements ReceiptEntryInterface {
    private NameInterface name;
    private PriceInterface price;
    private Amount amount;

    public ReceiptEntry(NameInterface name, PriceInterface price) {
        this.name = name;
        this.price = price;
    }

    public NameInterface getName() {
        return name;
    }

    public void setName(NameInterface name) {
        this.name = name;
    }

    public PriceInterface getPrice() {
        return price;
    }

    public void setPrice(PriceInterface price) {
        this.price = price;
    }

}
