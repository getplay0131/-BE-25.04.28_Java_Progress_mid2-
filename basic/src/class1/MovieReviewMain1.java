package class1;

public class MovieReviewMain1 {
    public static void main(String[] args)  {

        MovieReview movie1 = new MovieReview();
        movie1.title = "인셉션";
        movie1.review = "인생은 무한 루프";

        MovieReview movie2 = new MovieReview();
        movie2.title = "어바웃 타임";
        movie2.review = "인생 시간 영화!";

        System.out.println("영화 제목 : " + movie1.title + ", 리뷰 : " + movie1.review);
        System.out.println("영화 제목 : " + movie2.title + ", 리뷰 : " + movie2.review);
    }
}
