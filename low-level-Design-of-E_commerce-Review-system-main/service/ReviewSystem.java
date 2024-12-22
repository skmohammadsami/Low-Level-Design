package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ReviewSystem {
    private final List<Product> products;

    public ReviewSystem() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProduct(String productId) {
        return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}