package classes;

import enums.Discount;
import enums.Market;
import enums.Product;
import enums.Profession;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private BigDecimal money;
    private Discount moneyFromBank;
    private Profession typeOfProfession;
    private List<Product>products;
    private Market typeOfMarket;

    public Person(String name, LocalDate dateOfBirth, BigDecimal money, Discount moneyFromBank, Profession typeOfProfession,
                  List<Product> products, Market typeOfMarket) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.money = money;
        this.moneyFromBank = moneyFromBank;
        this.typeOfProfession = typeOfProfession;
        this.products = products;
        this.typeOfMarket = typeOfMarket;
    }

    public Person(String name, LocalDate dateOfBirth, BigDecimal money, Profession typeOfProfession, Market typeOfMarket) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.money = money;
        this.typeOfProfession = typeOfProfession;
        this.typeOfMarket = typeOfMarket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Discount getMoneyFromBank() {
        return moneyFromBank;
    }

    public void setMoneyFromBank(Discount moneyFromBank) {
        this.moneyFromBank = moneyFromBank;
    }

    public Profession getTypeOfProfession() {
        return typeOfProfession;
    }

    public void setTypeOfProfession(Profession typeOfProfession) {
        this.typeOfProfession = typeOfProfession;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Market getTypeOfMarket() {
        return typeOfMarket;
    }

    public void setTypeOfMarket(Market typeOfMarket) {
        this.typeOfMarket = typeOfMarket;
    }

    @Override
    public String toString() {
        return "\nPerson" +
                "\nName" + name +
                "\nDateOfBirth" + dateOfBirth +
                "\nMoney" + money +
                "\nTypeOfProfession" + typeOfProfession +
                "\nProducts=" + products +
                "\nTypeOfMarket=" + typeOfMarket +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
