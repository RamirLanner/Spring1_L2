package ru.pentragon.hw2;

import java.util.List;

public interface MyRepository {

    List<Product> getProductList();

    void add(Product product);

    void updateRecordByID(long id, String newTitle, float newCost);

    Product getByID(long id);

    void deleteRecordByID(long id);

}
