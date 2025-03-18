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
    //    cartService 필드가 static이 아니어서 싱글톤으로 동작하지 않습니다.
    private static CartService cartService;
    //    * 2. 사용자별 장바구니를 ArrayList<Cart>로 관리
    private ArrayList<Cart> cartArrayList;

    private CartService() {
        this.cartArrayList = new ArrayList<>();
    }

    //    getCartService() 메서드도 static이 아니기 때문에 외부에서 인스턴스 없이 호출할 수 없습니다.
    public static CartService getCartService() {
        if (cartService == null) {
            cartService = new CartService();
            return cartService;
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

    public boolean findUserId(Object object) {
        if (object instanceof Cart cart) {
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
        }
        return false;
    }

    //    * 3. 장바구니 생성/조회 메서드 구현
    public Cart createCart(User user) {
        Cart cart = findCart(user);
        if (checkNull(user)) {
            if (cart == null) {
                cart = new Cart(user.getMemberId());
                cartArrayList.add(cart);
                System.out.println("장바구니 생성 완료");
            }
        }
        return cart;
    }

    //    findCart 메서드에서 첫 번째 장바구니만 출력하고 break 하는 것으로 보입니다.
    public Cart findCart(User user) {
        if (checkNull(user) && findUserId(user)) {
            for (Cart cart1 : cartArrayList) {
                System.out.println("== 장바구니 정보 == ");
                cart1.displayCart();
                return cart1;
            }
            System.out.println("장바구니 조회 완료");
        }
        return null;
    }

    //    * 4. 상품 추가 메서드 구현
    public void addProduct(Cart cart, CartItem item) {
        if (checkNull(cart) && checkNull(item)) {
            if (findUserId(cart)) {
                cart.addItem(item.getProduct(), 2);
                System.out.println("장바구니에 상품이 추가되었습니다! : )");
            }
        } else {
            System.out.println("장바구니에 상품 추가가 실패하였습니다.");
        }
    }

    // * 5. 상품 제거 메서드 구현
    public void deleteProduct(Cart cart, CartItem item) {
        if (checkNull(cart) && checkNull(item)) {
            if (findUserId(cart)) {
                cart.removeItem(item);
                System.out.println("장바구니에서 상품이 삭제 되었습니다! : )");
            }
        } else {
            System.out.println("장바구니에 상품 삭제가 실패 하였습니다.");
        }
    }

    //* 6. 상품 수량 변경 메서드 구현
    public void updateProductCount(Cart cart, CartItem item) {
        if (checkNull(cart) && checkNull(item)) {
            if (findUserId(cart)) {
                cart.updateQuantity(item.getProduct().getProductId(), 3);
                System.out.println("장바구니에서 상품 수량이 변경 되었습니다! : )");
            }
        } else {
            System.out.println("장바구니에 상품 수량 변경이 실패 하였습니다.");
        }
    }

    //* 7. 장바구니 비우기 메서드 구현
    public void clearCart(Cart cart) {
        if (checkNull(cart)) {
            if (findUserId(cart)) {
                cart.clearCart();
                System.out.println("장바구니가 비우기 완료! : )");
            }
        } else {
            System.out.println("장바구니 비우기 실패! : (");
        }
    }

    //* 8. 장바구니 항목 조회 메서드 구현
    public void findCartItem(CartItem item) {
        if (checkNull(item)) {
            if (findUserId(item)) {
                item.getProduct().toString();
            }
        }
    }

    //    * 9. 총액 계산 메서드 구현 (회원 할인 적용)
    public int calculateTotalPrice(Cart cart, User user) {
        if (checkNull(cart) && checkNull(user)) {
        int totalPrice = cart.calculateTotalPrice();
        int discountPrice = user.calculateDiscountPercent(totalPrice);
        int finalPrice = totalPrice - discountPrice;

            System.out.println(user.getName() + "님의 총액 " + totalPrice + "(원)에서 " + discountPrice + "(원)이 할인되어 총" + finalPrice +
                    "(원) 입니다.");
        }
        return 0;
    }
}
