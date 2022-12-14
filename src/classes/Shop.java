package classes;

import enums.Market;
import enums.Product;

import java.math.BigDecimal;
import java.util.List;

public class Shop {
    private String name;
    private String address;
    private BigDecimal bankAccount;
    private Market typeMarket;
    private List<Product> sellingProduct;

    public Shop(String name, String address, BigDecimal bankAccount, Market typeMarket,List<Product> sellingProduct) {
        this.name = name;
        this.address = address;
        this.bankAccount = bankAccount;
        this.typeMarket = typeMarket;
        this.sellingProduct = sellingProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BigDecimal bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Market getTypeMarket() {
        return typeMarket;
    }

    public void setTypeMarket(Market typeMarket) {
        this.typeMarket = typeMarket;
    }

    public List<Product> getSellingProduct() {
        return sellingProduct;
    }

    public void setSellingProduct(List<Product> sellingProduct) {
        this.sellingProduct = sellingProduct;
    }

    @Override
    public String toString() {
        return "\nShop" +
                "\nName='" + name +
                "\nAddress='" + address +
                "\nBankAccount=" + bankAccount +
                "\nTypeMarket=" + typeMarket +
                "\nSellingProduct=" + sellingProduct +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
