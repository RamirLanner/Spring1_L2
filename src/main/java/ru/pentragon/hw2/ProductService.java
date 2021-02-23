package ru.pentragon.hw2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private MyRepository productRepository;

    @Value("12234-42342-6677766")
    private String identifier;

    public ProductService(MyRepository productRepository) {
        this.productRepository = productRepository;
    }

    public float calcAverageProductCost(){
        List<Product> productList= productRepository.getProductList();
        if(productList.size()==0) return 0;
        float avg = 0;
        for (Product product : productList) {
            avg+=product.getCost();
        }
        return avg/productList.size();
    }

    public int countProductListSize(){
        return productRepository.getProductList().size();
    }

    //create
    public void add(Product product){
        productRepository.add(product);
    }

    //read
    public Product getByID(long id){
        return productRepository.getByID(id);
    }

    //update
    public void updateRecordByID(long id, String newTitle, float newCost){
        productRepository.updateRecordByID(id, newTitle, newCost);
    }

    //delete
    public void deleteRecordByID(long id){
        productRepository.deleteRecordByID(id);
    }

    public List<Product> getAllRecords(){
        return productRepository.getProductList();
    }

}
