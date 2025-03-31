package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import exception.OutOfStockException;
import model.cart.Cart;
import model.cart.CartItem;
import model.order.Order;
import model.product.Category_Enum;
import model.product.Product;
import model.user.User;
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
        User newUser = null;
        boolean isEndRoop = false;
//        * 3. 메인 메뉴 표시 및 처리 메서드 구현
        while (!isEndRoop) {
            displayMainMenu();
            String choice = reader.readLine();

            //    *TODO : 사용자 선택에 따른 호출 로직 구현하기
//        System.out.println("3. 상품 관리");
//        System.out.println("4. 주문 내역 관리");
            if (choice.contains("5")) {
                System.out.println("쇼핑몰 프로그램을 종료합니다! 오늘도 좋은 하루 보내세요!");
                isEndRoop = true;
                break;
            }
            if (choice.contains("1")) {
//        사용자 정보 관리
                System.out.println("로그인 및 사용자 등록 기능으로 이동합니다.");
                System.out.println("회원 가입과 로그인 중 어떤 기능을 사용하시겠습니까?");
                String choiceUsersWork = reader.readLine();
                if (choiceUsersWork.contains("회원") || choiceUsersWork.contains("가입")) {
                    System.out.println("회원 가입을 진행합니다.");
                    newUser = registNewUser(reader);
//                    checkUser(newUser);
                    System.out.println("회원 가입이 완료되었습니다.");
                } else if (choiceUsersWork.contains("로그인")) {
                    if (userLoginCheck(userLogin(reader))) {
                        System.out.println("로그인 완료되었습니다.");
                    }
                }
            } else if (choice.contains("2")) {
//      장바구니 관리
                System.out.println("장바구니 관리 기능으로 이동합니다.");
                System.out.println("장바구니 표시와 장바구니 관리중 어떤 기능을 사용하시겠습니까?");
                String choiceCartWork = reader.readLine();
                if (choiceCartWork.contains("표시")) {
                    displayCart();
                } else if (choiceCartWork.contains("관리")) {
                    cartManagers(newUser, reader);
                }
            } else if (choice.contains("3")) {
//      상품 관리
                System.out.println("상품 관리 기능으로 이동합니다.");
                System.out.println("목록, 상세 정보 표시 기능 중 어떤 기능을 사용하시겠습니까?");
                String choiceProductWork = reader.readLine();
                if (choiceProductWork.contains("목록")) {
                    productListDisplay();
                } else if (choiceProductWork.contains("정보")) {
                    productInfoDisplay();
                }
            } else if (choice.contains("4")) {
//      주문 관리
                System.out.println("주문 관리 기능으로 이동합니다.");
                orderProcessingGuide(newUser);
            } else {
                System.out.println("올바른 값을 입력해주세요!");
            }
        }
    }
//     ============

    public static void displayMainMenu() {
        System.out.println("안녕하세요! 오늘도 저희 클릭스에 방문하신것을 환영합니다!");
        System.out.println("어떤 기능을 이용하시겠어요?");
        System.out.println("1. 사용자 정보 관리");
        System.out.println("2. 장바구니 관리");
        System.out.println("3. 상품 관리");
        System.out.println("4. 주문 내역 관리");
        System.out.println("5. 종료");
        System.out.println("-- 원하시는 기능의 번호를 입력해주세요! ex)1번 or 1 --");
    }


//     ============

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

//     ============

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

//     ============


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

//     ============

    //    if vs try - catch
    public static boolean cartManagers(User user, BufferedReader reader) throws Exception {
        if (UserService.getUserService().checkNull(user)) {
            System.out.println("입력값이 올바르지 않습니다.");
            return false;
        }
        //        어떤 사용자의 장바구니에 추가할지 > 사용자 검증
        if (UserService.getUserService().checkLoginData(user)) {
            System.out.println("사용자 검증 완료");
        } else {
            System.out.println("사용자 검증 실패");
            return false;
        }
//        장바구니 찾기
        Cart cart = CartService.getCartService().findCart(user);
        if (cart == null) {
            cart = new Cart(user.getMemberId());
            System.out.println("징바구니 생성이 완료되었습니다.");
        } else {

        }


//        상품 정보 입력 받기
        ArrayList<Object> productInfos = new ArrayList<>();
        Category_Enum newProductCategoryName = null;
        System.out.println("-- 상품 정보 입력 -- ");
        System.out.println("추가할 상품의 아이디를 입력해주세요");
        String newProductId = reader.readLine();
        productInfos.add(newProductId);
        System.out.println("추가할 상품명을 입력해주세요");
        String newProductName = reader.readLine();
        productInfos.add(newProductName);
        System.out.println("추가할 가격을 입력해주세요");
        int newProductPrice = 0;
        try {
        newProductPrice = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e){
            System.out.println("숫자 형식으로 입력해주세요");
            return false;
        }
        productInfos.add(newProductPrice);
        System.out.println("추가할 카테고리를 입력해주세요");
        String newProductCategory = reader.readLine();
        productInfos.add(newProductCategory);
        System.out.println("-- 상품 정보 검증 시작 --");
        for (int i = 0; i < productInfos.size(); i++) {
            if (!checkValue(productInfos.get(i))) {
                System.out.println("검증에 실패하였습니다. 다시 시도해 주세요");
                return false;
            }
        }
        newProductCategoryName = matchForCategory(newProductCategory);
        System.out.println("-- 상품 정보 검증 완료 --");

//        상품 객체 생성 하기
        Product newProduct = new Product(newProductId, newProductName, newProductPrice, 3, newProductCategoryName);

//        상품 > 카트 아이템으로 변환 > 카트에 추가
        CartService cartService = CartService.getCartService();
        CartItem cartItem = new CartItem(newProduct, 1);
//        아직 실질적 주문완료 상태가 아니기에 아래 코드는 아직은 불필요
//        for (int i = 0; i < cartItem.getStockCount(); i++) {
//        cartItem.countReduction();
//        }
        try {
        cart.addItem(newProduct, 1);
        }catch (OutOfStockException e) {
            System.out.println(e.getMessage());
            return false;
        }

        System.out.println("== 장바구니 관리 종료 ==");
        return true;
    }

    //    * 7. 주문 과정 안내 메서드 구현
    public static boolean orderProcessingGuide(User user) {
        if (!checkUser(user)) {
            System.out.println("유저 검증 실패");
            return false;
        }
//        유저의 주문 서비스에서 주문 상태 정보를 읽어와서 각 상태에 맞는 메시지 표출
        for (Order order : OrderService.getOrderService().getOrdersList()) {
            if (order.findAndMatchUserId(order, user)) {
                order.orderStatToKor(order.getOrderStats());
            }
        }
        System.out.println(" -- 주문 과정 안내 완료 -- ");
        return true;
    }


//     ---------------------

    // * 8. 결제 처리 메서드 구현
    public static boolean checkPaied(User user) {
        if (!checkUser(user)) {
            System.out.println("유저 검증 실패");
            return false;
        } else {
            for (Order order : OrderService.getOrderService().getOrdersList()) {
                order.findAndMatchUserId(order, user);
                OrderService.getOrderService().checkedPaid(order.getTotalPrice(), order);
            }
        }
        System.out.println(" -- 결제 확인 완료 -- ");
        return true;
    }
//     ---------------------

    //    * 9. 사용자 로그인/등록 메서드 구현

    public static User userLogin(BufferedReader reader) throws Exception {
        System.out.print("아이디를 입력해 주세요 : ");
        String inputId = reader.readLine();
        System.out.println();
        System.out.print("비밀번호를 입력해 주세요 : ");
        String inputPw = reader.readLine();
        System.out.println();


        if (checkValue(inputId) && checkValue(inputPw)) {
            System.out.println("사용자 정보 확인 중입니다. 잠시 기다려 주세요.");
            for (User user : UserService.getUserService().userList) {
                if (UserService.getUserService().findUserId(inputId) && UserService.getUserService().findUserPw(inputPw)) {
                    if (user.getMemberId().equals(inputId) && user.getPassword().equals(inputPw)) {
                        System.out.println("로그인 완료!");
                        return user;

                    }
                }
            }
        }
        System.out.println("로그인 실패! 아이디와 비말번호를 다시 확인해 주세요!");
        return null;
    }

    public static User registNewUser(BufferedReader reader) throws Exception {
        User newUser = null;

        System.out.println(" -- 유저 등록 시작 -- ");
        //        상품 정보 입력 받기
        ArrayList<Object> userInfos = new ArrayList<>();
        System.out.println("고객님이 사용할 아이디를 입력해주세요");
        String newUserId = reader.readLine();
        userInfos.add(newUserId);
        System.out.println("고객님의 성함을 입력해주세요");
        String newUserName = reader.readLine();
        userInfos.add(newUserName);
        System.out.println("사용할 이메일을 입력해주세요");
        String newUserEmail = reader.readLine();
        userInfos.add(newUserEmail);
        System.out.println("사용할 비밀번호를 입력해주세요");
        String newUserPw = reader.readLine();
        userInfos.add(newUserPw);
        System.out.println("거주하시는 주소를 입력해주세요");
        String newUserAddress = reader.readLine();
        userInfos.add(newUserAddress);
        System.out.println("-- 유저 정보 검증 시작 --");
        for (int i = 0; i < userInfos.size(); i++) {
            if (!checkValue(userInfos.get(i))) {
                System.out.println("검증에 실패하였습니다. 다시 시도해 주세요");
                return null;
            }
        }
        newUser = new User(newUserId, newUserName, newUserEmail, newUserPw, newUserAddress);
        System.out.println("-- 유저 정보 검증 완료 --");
        System.out.println("-- 유저 등록 완료 --");
//        유저 서비스에 사용자 정보 저장
        UserService.getUserService().userRegistration(newUser);
        return newUser;
    }

    public static boolean userLoginCheck(User user) {
        if (!checkUser(user) && !UserService.getUserService().checkNull(user)) {
            System.out.println("유저의 데이터가 없거나, 가입한 회원이 아닙니다.");
            return false;
        }

        return true;
    }


//    utility method ======

    public static boolean checkValue(Object value) {
        if (value instanceof String str) {
            if (str.isEmpty()) {
                System.out.println("상품명이나 상품 아이디의 입력값이 올바르지 않습니다.");
                return false;
            }
        } else if (value instanceof Integer nums) {
            if (nums == 0 || nums < 0) {
                System.out.println("상품 가격이나, 재고의 값이 올바르지 않습니다.");
                return false;
            }
        }
        System.out.println("입력값 검증에 성공하였습니다.");
        return true;
    }

    public static Category_Enum matchForCategory(String target) {
        Category_Enum categoryEnum = null;
        if (target.contains("전자")) {
            categoryEnum = Category_Enum.ELECTRONICS;
        } else if (target.contains("의류")) {
            categoryEnum = Category_Enum.CLOTHING;
        } else if (target.contains("음식") || target.contains("식") || target.contains("식품")) {
            categoryEnum = Category_Enum.FOOD;
        } else if (target.contains("도서") || target.contains("책")) {
            categoryEnum = Category_Enum.BOOKS;
        }
        if (categoryEnum == null) {
            System.out.println("카테고리명이 올바르지 않습니다.");
        }
        return categoryEnum;
    }

    public static boolean checkUser(User user) {
        if (!UserService.getUserService().checkNull(user)) {
            System.out.println("입력값이 올바르지 않습니다.");
            return false;
        }
        //        어떤 사용자의 장바구니에 추가할지 > 사용자 검증
        if (UserService.getUserService().checkLoginData(user)) {
            System.out.println("사용자 검증 완료");
        } else {
            System.out.println("사용자 검증 실패");
            return false;
        }
        return true;
    }

//     ---------------------

}
