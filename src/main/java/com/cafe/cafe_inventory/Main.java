package com.cafe.cafe_inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // reading input: provided for you
        Product[] products = new Product[10];  // an array with room for 10 products
        int count = 0;                         // how many products are stored so far
        int choice;
        do {
           // Product p1 = new Product("Tea", 10.5, 5);
           // Product p2 = new Product(p1);
           // p2.name = "Coffee";
            //System.out.println("p1: " + p1.name + ", p2: " + p2.name+", totalProducts: " + Product.totalProducts);
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();   // clears the leftover newline after nextInt()
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    // TODO: if the array is full (count is 10), print a message
                    if(count>=10){
                        System.out.println("Cannot add product: the stock limit has been reached.");
                    }
                    // TODO: else if price <= 0 or quantity < 0, print an error message
                    if(price<=0){
                        System.out.println("Provide the valid price");
                    }
                    if (quantity < 0) {
                        System.out.println("Provide valid quantity");
                    }
                    // TODO: otherwise create the Product with the parameterized
                    //       constructor, store it at products[count] and increase count
                    for(int i=0;i<products.length;i++){
                        if(products[i]==null){
                            products[i] = new Product(name, price, quantity);
                            count++;
                            break;
                        }
                    }
                    break;
                case 2:
                    // TODO: if count is 0 print a message, otherwise loop from 0 to
                    //       count - 1 and call display() on each product
                    //       (print the number i + 1 before each one)
                    if(count==0){
                        System.out.println("No products to display.");
                    }else{
                        for(int i=0;i<count;i++){
                            System.out.print((i+1) + ": ");
                            products[i].display();
                        }
                    }
                    break;
                case 3:
                    // TODO: loop over the stored products, add up stockValue()
                    //       and print the total (message if count is 0)
                    if(count==0){
                        System.out.println("No products to calculate stock value.");
                    }else{
                        double totalStockValue = 0;
                        for(int i=0;i<count;i++){
                            totalStockValue += products[i].stockValue();
                        }
                        System.out.println("Total stock value: Rs " + totalStockValue);
                    }

                    break;
                case 4:
                    // TODO: calculate the average price as a double and print it
                    //       also print it rounded down using an explicit cast
                    if(count==0){
                        System.out.println("No products to calculate average price.");
                    }else {
                        double total_price = 0;
                        for (int i = 0; i < count; i++) {
                            total_price += products[i].price;
                        }
                        double average_price = total_price / count;
                        System.out.println("Average price: Rs " + average_price);
                        System.out.println("Average price (rounded down): Rs " + (int) average_price);
                    }
                    break;
                case 5:
                    System.out.print("Product number: ");
                    int num = sc.nextInt();
                    System.out.print("Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();
                    // TODO: check num is between 1 and count and extra is above 0,
                    //       otherwise print an error; then add extra to the quantity
                    //       of products[num - 1]
                    if(num < 1 || num > count || extra <= 0) {
                        System.out.println("Invalid product number or quantity.");
                    } else {
                        products[num - 1].quantity += extra;
                        System.out.println("Quantity updated successfully.");
                    }
                    break;
                case 6:
                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    // TODO: check n is between 1 and count (and the array is not full)
                    // TODO: create a copy of products[n - 1] with the copy constructor,
                    //       add " (copy)" to the copy's name, store it at
                    //       products[count] and increase count
                    if(n < 1 || n > count || count >= 10) {
                        System.out.println("Invalid product number or stock limit reached.");
                    } else {
                        Product copyProduct = new Product(products[n - 1]);
                        copyProduct.name += " (copy)";
                        products[count] = copyProduct;
                        count++;
                        System.out.println("Product duplicated successfully.");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 0);
        System.out.println("Products created in total: " + Product.totalProducts);
    }
}
