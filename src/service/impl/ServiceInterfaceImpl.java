package service.impl;

import classes.Person;
import classes.Shop;
import enums.Market;
import enums.Product;
import enums.Profession;
import service.ServiceInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class ServiceInterfaceImpl implements ServiceInterface {
    private List<Person> personList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Shop> shopList = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();

    @Override
    public String createPerson() {
        System.out.println("Let's create new person ");
        try {
            System.out.println("Enter person's name ");
            String name = new Scanner(System.in).next();
            System.out.print("Date of birth (yy-mm-dd) : ");
            String[] birthDateList = new Scanner(System.in).nextLine().trim().split("-");
            LocalDate birthDate = LocalDate.of(
                    Integer.parseInt(birthDateList[0]),
                    Integer.parseInt(birthDateList[1]),
                    Integer.parseInt(birthDateList[2]));
            System.out.println("Enter person's money ");
            BigDecimal money = new Scanner(System.in).nextBigDecimal();
            System.out.println("Enter person's profession ");
            Profession profession = Profession.valueOf(new Scanner(System.in).next().toUpperCase());
            System.out.println("Enter person's market ");
            Market market = Market.valueOf(new Scanner(System.in).next().toUpperCase());
            if (name.matches(".*[0-9].*")) {
                throw new RuntimeException("Name invalid!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "Person is successfully created";
    }

    @Override
    public String addProduct() {
        System.out.println("Enter the person name");
        String name = new Scanner(System.in).next();
        for (Person person : personList) {
            if (person.getName().equalsIgnoreCase(name)) {
                while (true) {
                    System.out.println("Product which want to buy ");
                    Product newProduct = Product.valueOf(new Scanner(System.in).next());
                    productList.add(newProduct);
                    person.setProducts(productList);
                }
            }
        }
        return "Successful added";
    }


    @Override
    public List<Person> getAllPerson() {
        return personList;
    }

    @Override
    public void findCheapestProduct() {
        System.out.println("The cheapest product is " + Collections.min(productList, sortByPrice));

        Collections.sort(productList, sortByPrice);

    }

    public Comparator<Product> sortByPrice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };

    @Override
    public void findExpensiveProduct() {
        System.out.println("The expensive product is " + Collections.max(productList, getSortByPrice));
        Collections.sort(productList, getSortByPrice);
    }

    public Comparator<Product> getSortByPrice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };

    @Override
    public String buyProduct(List<Person> personList, List<Shop> shopList) throws Exception {
        try {
            System.out.print("Enter a buyer : ");
            String buyer = new Scanner(System.in).nextLine().toLowerCase();
            if (buyer.isEmpty()) throw new Exception("Buyer can't be Empty.");

            for (Person person : personList) {
                if (person.getName().toLowerCase().equals(buyer)) {
                    System.out.print("Enter a market name : ");
                    String marketName = new Scanner(System.in).nextLine().toLowerCase();
                    if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

                    for (Shop shop : shopList) {
                        if (shop.getName().toLowerCase().equals(marketName)) {
                            double totalPrice = 0;
                            while (true) {
                                for (Product product : productList) {
                                    System.out.println(product.name() + " : " + product.getPrice() + " som");
                                }
                                System.out.print("Choose your product : ");
                                String productName = new Scanner(System.in).nextLine().toLowerCase();
                                if (productName.isEmpty()) throw new Exception("Product name can't be Empty.");
                                if (productName.equals("exit()")) break;
                                if (productName.equals("checkout()")) {
                                    for (Product product : cart) {
                                        totalPrice += product.getPrice();
                                    }
                                    System.out.println("Your Cart : " + cart);
                                    System.out.println("Total price : " + totalPrice + " som");
                                    System.out.print("Do you have your bonus card? (yes/no) : ");
                                    String bonusCard = new Scanner(System.in).nextLine().toLowerCase();
                                    boolean haveDiscountCard = bonusCard.equals("yes");
                                    System.out.print("Confirm your checkout? (yes/no) : ");
                                    String c = new Scanner(System.in).nextLine().toLowerCase();
                                    if (c.equals("yes")) {
                                        person.setMoney(person.getMoney().subtract(new BigDecimal(totalPrice)));
                                        String invoice = "> > > > > INVOICE < < < < < \n" +
                                                "Customer : " + person.getName() + "\n" +
                                                "Market : " + shop.getName() + "\n" +
                                                "Time of purchase : " + LocalDate.now() + "\n" +
                                                "Total price : " + totalPrice + " KGS." + "\n" +
                                                (haveDiscountCard ? "Total price with discount (%5) : "
                                                        + (totalPrice - (totalPrice * 0.05)) + "\n\n" : "\n") +
                                                "# >>> THANK YOU FOR YOUR PURCHASE! <<< #\n\n";
                                        cart = new ArrayList<>();
                                        shop.setBankAccount(shop.getBankAccount().add(person.getMoney()));
                                        return invoice;
                                    }
                                }

                                for (Product product : productList) {
                                    if (person.getName().toLowerCase().equals(productName)) {
                                        System.out.print("Confirm your choice? (yes/no) : ");
                                        String answer = new Scanner(System.in).next().toLowerCase();
                                        if (answer.isEmpty()) throw new Exception("Confirm answer can't be Empty.");

                                        if (answer.equals("yes")) {
                                            cart.add(product);
                                            System.out.println("Product added to your cart.");
                                        } else break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sorry. Something  went wrong. (buyProduct method.)";
    }

    @Override
    public void getAllProduct() {
        Product[] products = Product.values();
        int counter = 0;
        for (Product product : products) {
            System.out.println(counter++ + "." + product);

        }

    }

    @Override
    public List<Shop> findByTypeOfMarket(List<Shop> shopList) {
        String type = new Scanner(System.in).next();
        List<Shop> newTypeShop = new ArrayList<>();
        for (Shop shop : shopList) {
            if (type.equalsIgnoreCase(shop.getTypeMarket().name())) {
                newTypeShop.add(shop);
            }
        }
        return newTypeShop;
    }

    @Override
    public void findRichestPerson() {
        System.out.println("The Richest person is " + Collections.max(personList, sortByMoney));
        personList.sort(sortByMoney);

    }

    public Comparator<Person> sortByMoney = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getMoney().intValue() - o2.getMoney().intValue();
        }
    };

    @Override
    public String sortByPrice() {
        Collections.sort(productList, sortPrice);
        return "Successful Sorted";
    }

    public Comparator<Product> sortPrice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };

    @Override
    public void getAllMarket() {
        Market[] markets = Market.values();
        int counter = 0;
        for (Market market : markets) {
            System.out.println(counter++ + "." + market);
        }

    }

    @Override
    public void getAllProfession() {
        Profession[] professions = Profession.values();
        int counter = 0;
        for (Profession profession : professions) {
            System.out.println(counter++ + "." + profession);

        }

    }

    @Override
    public List<Shop> findByAddress(List<Shop> shopList) {
        String addressName = new Scanner(System.in).next();
        List<Shop> shops = new ArrayList<>();
        for (Shop shop : shops) {
            if (addressName.equalsIgnoreCase(shop.getAddress())) {
                shops.add(shop);
            }

        }
        return shops;
    }

    @Override
    public List<Shop> getAllShop() {
        return shopList;
    }
}
