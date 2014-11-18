package net.xdwonderer.business.domain;

public class Name implements NameInterface {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
