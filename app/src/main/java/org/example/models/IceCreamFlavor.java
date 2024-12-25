package org.example.models;

public class IceCreamFlavor {

    private String name;
    private Integer quantity;

    public IceCreamFlavor(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public IceCreamFlavor() {
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
