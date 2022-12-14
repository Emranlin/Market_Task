import classes.Person;
import classes.Shop;
import enums.Discount;
import enums.Market;
import enums.Product;
import enums.Profession;
import service.impl.ServiceInterfaceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Product>products1=new ArrayList<>(Arrays.asList(Product.ROMANCE,Product.SCIENCE_FICTION));
        List<Product>products2=new ArrayList<>(Arrays.asList(Product.BREAD,Product.OIL,Product.RICE,Product.VEGETABLE));
        List<Product>products3=new ArrayList<>(Arrays.asList(Product.DOLLS,Product.CREATIVE_TOY));
        List<Product>products4=new ArrayList<>(Arrays.asList(Product.EXTERIOR_PAINT,Product.BUMPERS));

        Person person1=new Person("Jiidegul", LocalDate.of(1993,1,15), BigDecimal.valueOf(20000), Discount.BOOK_SHOP_DISCOUNT_CARD ,Profession.PROGRAMMER,null, Market.BOOK_SHOP);
        Person person2=new Person("Ilim", LocalDate.of(2003,10,15), BigDecimal.valueOf(10000), Discount.SUPERMARKET_DISCOUNT_CARD, Profession.DOCTOR,products2, Market.SUPERMARKET);
        Person person3=new Person("Meerim", LocalDate.of(1983,12,15), BigDecimal.valueOf(30000), Discount.TOY_SHOP_DISCOUNT_CARD,Profession.TEACHER,null, Market.TOY_SHOP);
        Person person4=new Person("Alibek", LocalDate.of(2004,1,15), BigDecimal.valueOf(40000),Discount.CHEMIST_DISCOUNT_CARD ,Profession.PROFESSOR,products4, Market.CHEMIST);

        List<Person>personList=new ArrayList<>(Arrays.asList(person1,person2,person3,person4));

        List<Product>sellingProduct1=new ArrayList<>(Arrays.asList(Product.ROMANCE,Product.SCIENCE_FICTION,Product.FANTASY_BOOK,Product.MEMOIR));
        List<Product>sellingProduct2=new ArrayList<>(Arrays.asList(Product.BREAD,Product.OIL,Product.RICE,Product.VEGETABLE,Product.WATER,Product.FRUITS,Product.SUGAR));
        List<Product>sellingProduct3=new ArrayList<>(Arrays.asList(Product.DOLLS,Product.CREATIVE_TOY,Product.ACTION_FIGURE));
        List<Product>sellingProduct4=new ArrayList<>(Arrays.asList(Product.EXTERIOR_PAINT,Product.BUMPERS));



        Shop shops1=new Shop("Raritet","GUM",BigDecimal.valueOf(10000),Market.BOOK_SHOP,sellingProduct1);
        Shop shops2=new Shop("Baby Toy","Lev tolstoi1 45",BigDecimal.valueOf(20000),Market.TOY_SHOP,sellingProduct3);
        Shop shops3=new Shop("Globus","Chui 120",BigDecimal.valueOf(30000),Market.SUPERMARKET,sellingProduct2);

        List<Shop>shopList=new ArrayList<>(Arrays.asList(shops1,shops2,shops3));
        ServiceInterfaceImpl serviceInterface=new ServiceInterfaceImpl();
        Scanner scanner=new Scanner(System.in);

        System.out.println(serviceInterface.buyProduct(personList, shopList));

        System.out.println("Commands");
        System.out.println("""
                1 -> createPerson,
                2 -> addProduct,
                3 -> getAllPerson,
                4 -> findCheapestProduct, 
                5 -> findExpensiveProduct,
                6 -> buyProduct, 
                7 -> getAllProduct,
                8 -> findByTypeOfMarket,
                9 -> findRichestPerson,
                10 -> sortByPrice,
                11 -> getAllMarket,
                12 -> getAllProfession,
                13 -> findByAddress,
                14 -> getAllShop
                """);
        while (true){
            int number = scanner.nextInt();
            switch (number){
                case 1:
                    System.out.println(serviceInterface.createPerson());
                    break;
                case 2:
                    System.out.println(serviceInterface.addProduct());
                    break;
                case 3:
                    System.out.println(serviceInterface.getAllPerson());
                    break;
                case 4:
                    serviceInterface.findCheapestProduct();
                    break;
                case 5:
                    serviceInterface.findExpensiveProduct();
                    break;
                case 6:
                    System.out.println(serviceInterface.buyProduct(personList,shopList));
                    break;
                case 7:
                    serviceInterface.getAllProduct();
                    break;
                case 8:
                    System.out.println(serviceInterface.findByTypeOfMarket(shopList));
                    break;
                case 9:
                    serviceInterface.findRichestPerson();
                    break;
                case 10:
                    System.out.println(serviceInterface.sortByPrice);
                    break;
                case 11:
                    serviceInterface.getAllMarket();
                    break;
                case 12:
                    serviceInterface.getAllProfession();
                    break;
                case 13:
                    System.out.println(serviceInterface.findByAddress(shopList));
                    break;
                case 14:
                    System.out.println(serviceInterface.getAllShop());


            }
        }


    }
}