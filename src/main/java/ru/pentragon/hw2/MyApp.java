package ru.pentragon.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        ProductService productService = context.getBean("productService",ProductService.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("Pls insert command:");
        System.out.println("/***/\nread idProduct\nupdate idProduct newTitle newCost\n" +
                "delete idProduct\ncount\navg\nall\n/***/");
        String cmd = sc.nextLine();
        if(cmd.startsWith("create")){
            String[] data = cmd.split(" ");
            productService.add(
                    new Product(
                            productService.countProductListSize()+1,
                            data[1],
                            Float.parseFloat(data[2])
                    ));
            System.out.println("Product added");
        }
        if(cmd.startsWith("read")){
            String[] data = cmd.split(" ");
            System.out.println(
                    productService.getByID(Long.parseLong(data[1]))
            );
        }
        if(cmd.startsWith("update")){
            String[] data = cmd.split(" ");
            productService.updateRecordByID(
                    Long.parseLong(data[1]),
                    data[2],
                    Float.parseFloat(data[3])
            );
            System.out.println("Product modified");
        }
        if(cmd.startsWith("delete")){
            String[] data = cmd.split(" ");
            productService.deleteRecordByID(
                    Long.parseLong(data[1])
            );
            System.out.println("Product deleted");
        }
        if(cmd.startsWith("count")){
            System.out.println("Количество товаров списке: "+productService.countProductListSize());
        }
        if(cmd.startsWith("avg")){
            System.out.println("Средняя цена за продукт: " + productService.calcAverageProductCost());
        }
        if(cmd.startsWith("all")){
            for (Product product : productService.getAllRecords()) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Press ENTER to close application))");
        sc.nextLine();

        context.close();
    }
}
