package ru.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "coffee_machine")
public class coffeeMachine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nameofthedrink")
    @NotEmpty(message = "Name of the drink should not be empty")
    private String nameOfTheDrink;
    @Column(name = "sortofcoffee")
    @NotEmpty(message = "sort of coffee should not be empty")
    private String sortOfCoffee;
    @Column(name = "kindofmilk")
    private String kindOfMilk;
    @Column(name = "amountofdrink")
    private double amountOfDrink;
    @Column(name = "amountofcoffee")
    private int amountOfCoffee;

    public coffeeMachine() {

    }

    public coffeeMachine(String nameOfTheDrink, String sortOfCoffee, String kindOfMilk, double amountOfDrink, int amountOfCoffee) {
        this.nameOfTheDrink = nameOfTheDrink;
        this.sortOfCoffee = sortOfCoffee;
        this.kindOfMilk = kindOfMilk;
        this.amountOfDrink = amountOfDrink;
        this.amountOfCoffee = amountOfCoffee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTheDrink() {
        return nameOfTheDrink;
    }

    public void setNameOfTheDrink(String nameOfTheDrink) {
        this.nameOfTheDrink = nameOfTheDrink;
    }

    public String getSortOfCoffee() {
        return sortOfCoffee;
    }

    public void setSortOfCoffee(String sortOfCoffee) {
        this.sortOfCoffee = sortOfCoffee;
    }

    public String getKindOfMilk() {
        return kindOfMilk;
    }

    public void setKindOfMilk(String kindOfMilk) {
        this.kindOfMilk = kindOfMilk;
    }

    public double getAmountOfDrink() {
        return amountOfDrink;
    }

    public void setAmountOfDrink(double amountOfDrink) {
        this.amountOfDrink = amountOfDrink;
    }

    public int getAmountOfCoffee() {
        return amountOfCoffee;
    }

    public void setAmountOfCoffee(int amountOfCoffee) {
        this.amountOfCoffee = amountOfCoffee;
    }
}
