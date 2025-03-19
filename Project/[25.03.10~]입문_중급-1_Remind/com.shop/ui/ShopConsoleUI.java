package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.product.Product;
import service.*;

/*
 * 콘솔 기반 사용자 인터페이스 클래스
 *
 * 구현 방법:
 * 1. Scanner 객체로 사용자 입력 처리
 * 2. 각 서비스 클래스의 인스턴스 참조
 * 3. 메인 메뉴 표시 및 처리 메서드 구현
 * 4. 상품 목록 표시 메서드 구현
 * 5. 상품 상세 정보 표시 메서드 구현
 * 6. 장바구니 표시 및 관리 메서드 구현
 * 7. 주문 과정 안내 메서드 구현
 * 8. 결제 처리 메서드 구현
 * 9. 사용자 로그인/등록 메서드 구현
 * 10. 입력값 검증 및 예외 처리 메서드 구현
 */
public class ShopConsoleUI {
    public static void main(String[] args) throws Exception {
//        버퍼 리더 호출
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isEndRoop = false;
//        * 3. 메인 메뉴 표시 및 처리 메서드 구현
        while (isEndRoop) {
            displayMainMenu();
            String choice = reader.readLine();


        }
    }

    public static void displayMainMenu() {
        System.out.println("안녕하세요! 오늘도 저희 클릭스에 방문하신것을 환영합니다!");
        System.out.println("어떤 기능을 이용하시겠어요?");
        System.out.println("1. 사용자 정보 관리");
        System.out.println("2. 장바구니 관리");
        System.out.println("3. 상품 관리");
        System.out.println("4. 주문 내역 관리");
        System.out.println("-- 번호를 입력해주세요! ex)1번 or 1 --");
    }

    public static Object returnService(String choice) {
        //         * 2. 각 서비스 클래스의 인스턴스 참조
//        서비스 인스턴스 호출
        UserService userService = UserService.getUserService();
        CartService cartService = CartService.getCartService();
        ProductService productService = ProductService.getProductService();
        OrderService orderService = OrderService.getOrderService();
        if (choice.contains("1")) {
//        사용자 정보 관리
            return userService;
        } else if (choice.contains("2")) {
//      장바구니 관리
            return cartService;
        } else if (choice.contains("3")) {
//      상품 관리
            return productService;
        } else if (choice.contains("4")) {
//      주문 관리
            return  orderService;
        } else {
            System.out.println("올바른 값을 입력해주세요!");
        }
        return null;
    }

//    * 4. 상품 목록 표시 메서드 구현
    public void displayProductList(ArrayList productList){
        if (!productList.isEmpty()) {

        }
    }
}
