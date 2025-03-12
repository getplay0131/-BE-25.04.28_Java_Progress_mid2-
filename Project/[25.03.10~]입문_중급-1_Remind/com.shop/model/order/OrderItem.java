package model.order;

import model.product.Product;

/*
 * 주문 내 개별 상품 항목을 나타내는 클래스
 *
 * 구현 방법:
 * 1. 멤버 변수(상품, 수량, 구매 당시 가격) 선언
 * 2. 생성자, getter 메서드 구현
 * 3. 소계 계산 메서드 구현
 * 4. toString() 메서드 오버라이딩: 주문 항목 정보 출력
 */
public class OrderItem {
    private Product product;
    private int counts;
    private int priceAtPurchase;

    public OrderItem(Product product, int counts, int priceAtPurchase) {
        this.product = product;
        this.counts = counts;
        this.priceAtPurchase = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getCounts() {
        return counts;
    }

    public int getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public int calculateTotalPrice(){
        return priceAtPurchase * counts;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", counts=" + counts +
                ", priceAtPurchase=" + priceAtPurchase +
                '}';
    }
}
