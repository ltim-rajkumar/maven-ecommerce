package com.lt.ecommerce.service;
import com.lt.ecommerce.model.Product;
import com.lt.ecommerce.repository.ProductRepository;

public class ProductService {

    private static final ProductRepository orderDeliveryRepository = new ProductRepository();

    public void createProduct() {
        Product product = new Product();
        product.setId(3001);
        product.setShopId(4001);
        product.setProductName("Laptop");
        product.setProductDesc("intel i10, 11th Gen, 64GB RAM, 2TB SSD");
        product.setProductImage("Image path");
        product.setPrice(79999.90);

        orderDeliveryRepository.createProduct(product);

        System.out.println("product = " + product);
    }

    public void getProduct(int productId) {
        Product product = orderDeliveryRepository.getProduct(productId);
        if(product != null) {
            System.out.println("Product details: " + product);
        }
    }

    public void displayAllProducts() {
        if(!orderDeliveryRepository.getAllProdcuts().isEmpty()) {
            orderDeliveryRepository.getAllProdcuts().forEach((productId, product) -> {
                System.out.println("Product id: " + productId + " and Product details are: " + product);
            });
        }
    }


    public void removeProduct(int productId) {
        if(orderDeliveryRepository.containsProduct(productId)) {
            System.out.println("Removed shop details = " + orderDeliveryRepository.removeProduct(productId));
        } else {
            System.out.println("Product id: " + productId + " found to remove!!");
        }
    }

    public void removeAllProducts() {
        if(orderDeliveryRepository.getProductsSize() > 0) {
            orderDeliveryRepository.removeAllProducts();
            System.out.println("Removed all shop's");
        } else {
            System.out.println("No shop's found to remove!!");
        }
    }

}
