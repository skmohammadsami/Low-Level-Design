package model;

public class Review {
    private final String reviewerName;
    private final String reviewText;
    private final double rating;

    public Review(String reviewerName, String reviewText, double rating) {
        this.reviewerName = reviewerName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public double getRating() {
        return rating;
    }
}

