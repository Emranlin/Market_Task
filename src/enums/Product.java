package enums;

public enum Product {
     FANTASY_BOOK("FANTASY_BOOK",300), ROMANCE("ROMANCE",350),MEMOIR("MEMOIR",450),SCIENCE_FICTION("SCIENCE_FICTION",320),
    SUGAR("Sugar",80),BREAD("Bread",30),OIL("Oil",165),WATER("Water",120),RICE("Rice",80),VEGETABLE("Vegetable",100),FRUITS("Fruits",200),
    EXTERIOR_PAINT("Exterior",600),BUMPERS("Bumpers",450),
    DOLLS("Dolls",120),CREATIVE_TOY("Creative",400),ACTION_FIGURE("Action Figure",120);
     private int price;
     private String name;

    Product(String name,int price ) {
        this.price = price;
        this.name = name;
    }

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nProduct" +
                "\nprice " + price +
                "\nname='" + name +
                "~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}



