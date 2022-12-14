package service;

import classes.Person;
import classes.Shop;
import enums.Product;

import java.util.List;

public interface ServiceInterface {
    String createPerson();
    String addProduct();
    List<Person>getAllPerson();
    void findCheapestProduct();
    void findExpensiveProduct();
    String buyProduct(List<Person>personList,List<Shop>shopList) throws Exception;
    void getAllProduct();
    List<Shop> findByTypeOfMarket(List<Shop>shopList);
    void findRichestPerson();
    String sortByPrice();
    void getAllMarket();
    void getAllProfession();
    List<Shop>findByAddress(List<Shop>shopList);
    List<Shop>getAllShop();



}
