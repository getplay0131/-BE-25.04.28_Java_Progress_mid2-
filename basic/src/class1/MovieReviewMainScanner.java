package class1;

import java.io.*;

public class MovieReviewMainScanner {
    public static void main(String[] args) throws IOException {
        BufferedReader scan  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.print("리뷰를 작성할 영화 제목을 입력헤 주세요 : ");
        String movieTitle = scan.readLine();
        System.out.print("해당 영화의 리뷰를 입력헤 주세요 : ");
        String movieReview = scan.readLine();

        MovieReview movie = new MovieReview();
        movie.title = movieTitle;
        movie.review = movieReview;

        System.out.println("영화 제목 : " + movie.title + ", 리뷰 : " + movieReview);
    }
}
