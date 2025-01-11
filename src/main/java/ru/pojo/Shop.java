package ru.pojo;

public class Shop {
    public static int index0fNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int count = index0fNull(products) == -1 ? products.length : index0fNull(products);
        for (int i = 0; i < count; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
    }
}
