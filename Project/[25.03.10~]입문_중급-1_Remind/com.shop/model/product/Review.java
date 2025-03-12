package model.product;

import java.time.LocalDateTime;

/*
 * 상품 리뷰를 나타내는 클래스
 *
 * 구현 방법:
 * 1. 멤버 변수(리뷰ID, 사용자ID, 상품ID, 내용, 평점, 리뷰 날짜) 선언
 * 2. 생성자, getter, setter 메서드 구현
 * 3. 평점 검증 메서드 구현 (1~5 사이 값만 허용)
 * 4. toString() 메서드 오버라이딩: 리뷰 정보 출력
 */
public class Review {
    private String reviewId;
    private String userId;
    private String productId;
    private String content;
    private int score;
    private LocalDateTime reviewDate;

    public Review(String reviewId, String userId, String productId, String content, int score, LocalDateTime reviewDate) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.content = content;
        checkScore(score);
        this.reviewDate = LocalDateTime.now();
    }

    private void checkScore(int score) {
        if (score >= 1 && score <= 5) {
            this.score = score;
        } else {
            System.out.println("리뷰 평점이 올바르지 않습니다.");
        }
    }

    public String getReviewId() {
        return reviewId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProductId() {
        return productId;
    }

    public String getContent() {
        return content;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
