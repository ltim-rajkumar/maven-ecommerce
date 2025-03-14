package com.lt.ecommerce.repository;

import com.lt.ecommerce.model.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    public static final Map<Integer, Product> productMap = new HashMap<>();

    public void createProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public Map<Integer, Product> getAllProdcuts() {
        return productMap;
    }

    public Product getProduct(int productId) {
        if(this.containsProduct(productId)) {
            return productMap.get(productId);
        }
        System.out.println("Product id: " + productId + " not found !!!");
        return null;
    }

    public int getProductsSize() {
        return productMap.size();
    }

    public boolean removeProduct(int productId) {
        if(this.containsProduct(productId)) {
            productMap.remove(productId);
            return true;
        }
        System.out.println("ProductId: " + productId + " not found to delete !!!");
        return false;
    }

    public void removeAllProducts() {
        if(!productMap.isEmpty()) {
            productMap.clear();
            return;
        }
        System.out.println("Product's not found to delete !!!");
    }

    public boolean containsProduct(int productId) {
        return productMap.containsKey(productId);
    }


}
