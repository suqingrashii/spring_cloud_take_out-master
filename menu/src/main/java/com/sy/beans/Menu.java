package com.sy.beans;

public class Menu
{
    private Long id;
    private String name;
    private Double price;
    private String flavor;
    private Type type;

    public Menu(Long id, String name, Double price, String flavor, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.type = type;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", flavor='" + flavor + '\'' +
                ", type=" + type +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
