package main;

import model.Product;
import model.Review;
import service.ReviewSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ReviewSystem reviewSystem = new ReviewSystem();
        System.out.println("Enter product ID: ");
        String productId = scanner.nextLine();
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        Product product = new Product(productId, productName);

        product.addReview(new Review("Deepak", "Amazing product! Highly recommend.", 4.8));
        product.addReview(new Review("Santosh", "Good value for the money.", 4.0));
        product.addReview(new Review("Sami", "Not bad, but could be improved.", 3.5));
        product.addReview(new Review("Shajith", "Not bad, but could be improved.", 3.5));

        reviewSystem.addProduct(product);

        while (true) {
            System.out.println("\nEnter reviewer name (or 'q' to quit): ");
            String reviewerName = scanner.nextLine();
            if (reviewerName.equalsIgnoreCase("q")) {
                break;
            }

            boolean existingUser = product.getReviews().stream()
                    .anyMatch(review -> review.getReviewerName().equalsIgnoreCase(reviewerName));
            if (existingUser) {
                System.out.println("User " + reviewerName + " has already submitted a review.");
                continue;
            }

            System.out.println("Enter review text: ");
            String reviewText = scanner.nextLine();
            System.out.println("Enter rating (e.g., 4.5): ");
            double rating = Double.parseDouble(scanner.nextLine());

            String ratingCategory;
            if (rating > 0 && rating <= 2) {
                ratingCategory = "Poor";
            } else if (rating > 2 && rating <= 4) {
                ratingCategory = "Ok";
            } else if (rating > 4 && rating <= 5) {
                ratingCategory = "Excellent";
            } else {
                ratingCategory = "Invalid rating";
            }

            Review newReview = new Review(reviewerName, reviewText, rating);
            product.addReview(newReview);

            System.out.println("Rating category: " + ratingCategory);
        }

        System.out.println("View Reviews...('y' or 'n')");
        String choice = scanner.nextLine();
        
        if(choice.equals("y")){

            double overallRating = product.calculateOverallRating();
            System.out.println("Overall Rating for " + product.getProductName() + ": " + overallRating);
            
            System.out.println("\nAll reviews for " + product.getProductName() + ":");
            for (Review review : product.getReviews()) {
                System.out.println("Reviewer: " + review.getReviewerName() +
                        ", Rating: " + review.getRating() +
                        ", Feedback: " + review.getReviewText());
            }
        }
    }
}