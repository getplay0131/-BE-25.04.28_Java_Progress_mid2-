package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.cart.Cart;
import model.product.Category_Enum;
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
        while (!isEndRoop) {
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
        System.out.println("-- 원하시는 기능의 번호를 입력해주세요! ex)1번 or 1 --");
    }

    public static Object returnService(String choice) {
        //         * 2. 각 서비스 클래스의 인스턴스 참조
//        서비스 인스턴스 호출
        UserService userService = UserService.getUserService();
        OrderService orderService = OrderService.getOrderService();
        if (choice.contains("1")) {
//        사용자 정보 관리
            return userService;
        } else if (choice.contains("2")) {
//      장바구니 관리
        } else if (choice.contains("3")) {
//      상품 관리

        } else if (choice.contains("4")) {
//      주문 관리
            return orderService;
        } else {
            System.out.println("올바른 값을 입력해주세요!");
        }
        return null;
    }

    //    * 4. 상품 목록 표시 메서드 구현
    public static void productListDisplay() {
        ProductService productService = ProductService.getProductService();

        ArrayList<Product> productList = productService.getProductList();
        if (!productList.isEmpty()) {
            System.out.println(" == 상품 목록 == ");
            for (Product product : productService.getProductList()) {
                for (int i = 0; i < productList.size(); i++) {
                    System.out.println((i + 1) + "번 상품 : " + product.getName());
                }
            }
            System.out.println(" == 상품 목록 출력 종료 == ");
        } else {
            System.out.println("등록된 상품이 없습니다.");
        }
    }


    //    * 5. 상품 상세 정보 표시 메서드 구현
    public static void productInfoDisplay() {
        ProductService productService = ProductService.getProductService();

        ArrayList<Product> productList = productService.getProductList();
        if (!productList.isEmpty()) {
            System.out.println(" == 상품 상세 정보 == ");
            for (Product product : productService.getProductList()) {
                System.out.println(product.toString());

            }
            System.out.println(" == 상품 상세 정보 출력 종료 == ");
        } else {
            System.out.println("등록된 상품이 없습니다.");
        }
    }

    //* 6. 장바구니 표시 및 관리 메서드 구현
    public static void displayCart() {
        CartService cartService = CartService.getCartService();
        ArrayList<Cart> cartList = cartService.getCartArrayList();
        if (!cartList.isEmpty()) {
            System.out.println("== 장바구니입니다! ==");
            for (Cart cart : cartList) {
                cart.displayCart();
            }
            System.out.println("== 장바구니 표시 종료 ==");
        }
    }

//    if vs try - catch
    public static void cartManagers(BufferedReader reader) throws Exception {
        CartService cartService = CartService.getCartService();
        ArrayList<Cart> cartList = cartService.getCartArrayList();
        boolean isCheckInputValueError = false;
        if (!cartList.isEmpty()) {
            System.out.println("== 장바구니 관리 시스템입니다! ==");
            System.out.println("무슨 작업을 진행할까요?");
            System.out.println("상품을 추가하려면 '추가', 삭제하려면 '삭제'라고 입력해주세요!");
            String choiceWork = reader.readLine();

            if (choiceWork.contains("추가")) {
                System.out.println("추가할 상품의 아이디를 입력해주세요");
                String newProductId = reader.readLine();
                if (newProductId.isEmpty()) {

                }
                System.out.println("추가할 상품의 상품명를 입력해주세요");
                String newProductName = reader.readLine();
                System.out.println("추가할 상품의 상품 가격을 입력해주세요");
                int newPrice = Integer.parseInt(reader.readLine());
                System.out.println("추가할 상품의 상품 재고를 입력해주세요");
                int newStock = Integer.parseInt(reader.readLine());
                System.out.println("추가할 상품의 카테고리를 입력해주세요");
                String newCategory = reader.readLine();
                ProductService.getProductService().addProduct(new Product());
                for (Cart cart : cartList) {
                    cart.addItem();
                }

            }
            System.out.println("== 장바구니 표시 종료 ==");
        }
    }
}
