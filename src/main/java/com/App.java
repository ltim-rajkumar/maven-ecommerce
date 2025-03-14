package com;

import com.lt.ecommerce.controller.OrderDeliveryController;
import com.lt.ecommerce.controller.ShopController;
import com.lt.ecommerce.controller.UserController;
import com.lt.ecommerce.service.ConnectionService;
import com.lt.ecommerce.service.OrderService;
import com.lt.ecommerce.service.ProductService;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private  static final ConnectionService connectionService = new ConnectionService();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        int option;
        do {
            System.out.println("--------Ecommerce--------");
            System.out.println("Please choose the option");
            System.out.println("1 Go to customer section");
            System.out.println("2 Go to shop section");
            System.out.println("3 Go to product section");
            System.out.println("4 Go to order section");
            System.out.println("5 Go to order delivery section");
            System.out.println("9 Exit");
            option = Integer.parseInt(scanner.nextLine());

            UserController userController = new UserController();
            OrderDeliveryController orderDeliveryController = new OrderDeliveryController();
            ShopController shopController = new ShopController();
            ProductService productService = new ProductService();
            OrderService orderService = new OrderService();

            switch (option) {
                case 1: {
                    userController.run();
                    break;
                }
                case 2: {
                    shopController.run();
                    break;
                }
                case 3: {
                    productService.createProduct();
                    break;
                }
                case 4: {
                    orderService.createOrder();
                    break;
                }
                case 5: {
                    orderDeliveryController.run();
                    break;
                }
            }

        } while(option != 9);
    }
}
