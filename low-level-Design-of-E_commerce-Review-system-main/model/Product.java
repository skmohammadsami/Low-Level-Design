package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
    private final String productId;
    private final String productName;
    private final List<Review> reviews;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
        this.reviews = new ArrayList<>();
    }

    public List<Review> getReviews() {
        return Collections.unmodifiableList(reviews);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double calculateOverallRating() {
        double totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        return reviews.isEmpty() ? 0.0 : totalRating / reviews.size();
    }
}
