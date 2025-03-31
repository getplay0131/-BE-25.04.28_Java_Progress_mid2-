package model.cart;

import exception.OutOfStockException;
import model.product.Product;
import model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 사용자의 장바구니를 나타내는 클래스
 *
 * 구현 방법:
 * 1. 멤버 변수(사용자ID, 상품 목록) 선언
 *    - 상품 목록은 ArrayList<CartItem>으로 구현
 * 2. 생성자 구현 (빈 ArrayList 초기화)
 * 3. 상품 추가 메서드 구현 (이미 있는 상품이면 수량만 증가)
 * 4. 상품 제거 메서드 구현
 * 5. 상품 수량 변경 메서드 구현
 * 6. 장바구니 비우기 메서드 구현
 * 7. 총액 계산 메서드 구현
 * 8. 장바구니 내용 출력 메서드 구현
 */
public class Cart {
    private String userId;
    private ArrayList<CartItem> items = new ArrayList<>(); // 상품ID를 키로 사용

    public Cart(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

//    getter, setter
    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void addItem(Product product, int quantity) throws OutOfStockException {
        if (product.getStockCount() < quantity) {
            throw new OutOfStockException("상품 ' " +product.getName() + " ' 의 재고가 부족합니다." );
        }

        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
//                기존 수량에추가
                item.setStockCount(item.getStockCount() + quantity);
                return;
            }
        }

//        새 상품이면 추가
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(CartItem cartItem) {
//        삭제할 상품 찾기
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId().equals(cartItem.getProduct().getProductId())) {
                items.remove(i);
                break;
            }
        }
    }

    public void updateQuantity(String productId, int newQuantity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId().equals(productId)) {
                items.get(i).getProduct().setStockCount(newQuantity);
                break;
            }
        }
    }

    public int calculateTotalPrice(){
        int total = 0;
        for (CartItem item : items) {
            total += item.productPriceCalculate() ;
        }
        return total;
    }

    public void clearCart(){
        items.clear();
    }

    public void displayCart(){
        System.out.println("== 장바구니 내역 ==");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.println("총액 : " + calculateTotalPrice() + "원");
    }
}
