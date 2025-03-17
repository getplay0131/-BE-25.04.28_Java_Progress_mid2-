package service;

import model.cart.Cart;
import model.cart.CartItem;
import model.user.User;

import java.util.ArrayList;

/*
 * 장바구니 관련 비즈니스 로직을 처리하는 서비스 클래스
 *
 * 구현 방법:
 * 1. 싱글톤 패턴 적용
 * 2. 사용자별 장바구니를 ArrayList<Cart>로 관리
 * 3. 장바구니 생성/조회 메서드 구현
 * 4. 상품 추가 메서드 구현
 * 5. 상품 제거 메서드 구현
 * 6. 상품 수량 변경 메서드 구현
 * 7. 장바구니 비우기 메서드 구현
 * 8. 장바구니 항목 조회 메서드 구현
 * 9. 총액 계산 메서드 구현 (회원 할인 적용)
 */
public class CartService {
//    * 1. 싱글톤 패턴 적용
    private CartService cartService;
//    * 2. 사용자별 장바구니를 ArrayList<Cart>로 관리
    private ArrayList<Cart> cartArrayList;

    private CartService() {
        this.cartArrayList = new ArrayList<>();
    }

    public CartService getCartService() {
        if (cartService == null) {
            CartService service = new CartService();
            return service;
        }
        return cartService;
    }

    //    null 검사 메서드
    public boolean checkNull(Object object) {
        if (object == null) {
            System.out.println("입력된 값이 null입니다. 값을 확인해주세요!");
            return false;
        }
        return true;
    }

    public boolean findUserId(Cart cart){
        if (!checkNull(cart)) {
            System.out.println("사용자 검색 실패");
            return false;
        } else {
            for (Cart targetCart : cartArrayList) {
                if (targetCart.getUserId().equals(cart.getUserId())) {
                    return true;
                }
            }
            System.out.println("사용자 아이디 검색 성공 일치 및 확인 완료");
        }
        return false;
    }

    //    * 3. 장바구니 생성/조회 메서드 구현
public void createCart(Cart cart){
    if (checkNull(cart)) {
        for (Cart cart1 : cartArrayList) {
            if (cart1 == null) {
            cartArrayList.add(cart);
                System.out.println("장바구니 생성 완료");
            }
        }
    }
}

    public void findCart(Cart cart){
        if (checkNull(cart)) {
            for (Cart cart1 : cartArrayList) {
                    System.out.println("== 장바구니 정보 == ");
                    cart1.displayCart();
                    break;
            }
            System.out.println("장바구니 조회 완료");
        }
    }

//    * 4. 상품 추가 메서드 구현
public void addProduct(Cart cart, CartItem item){
    if (checkNull(cart) && checkNull(item)) {
        if (findUserId(cart)) {
            cart.addItem(item.getProduct(),2);
            System.out.println("장바구니에 상품이 추가되었습니다! : )");
        }
    } else {
        System.out.println("장바구니에 상품 추가가 실패하였습니다.");
    }
}
}
