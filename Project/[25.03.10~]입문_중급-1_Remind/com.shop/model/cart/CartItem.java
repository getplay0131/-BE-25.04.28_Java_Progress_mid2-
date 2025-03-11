package model.cart;

import model.product.Product;

/*
 * 장바구니 내 개별 상품 항목을 나타내는 클래스
 *
 * 구현 방법:
 * 1. 멤버 변수(상품, 수량) private으로 선언
 * 2. 생성자, getter, setter 메서드 구현
 * 3. 수량 증가/감소 메서드 구현
 * 4. 소계(상품가격 × 수량) 계산 메서드 구현
 * 5. toString() 메서드 오버라이딩: 장바구니 항목 정보 출력
 */
public class CartItem {

    private Product product;
    private int stockCount;

    public CartItem(Product product, int stockCount) {
        this.product = product;
        this.stockCount = stockCount;
    }

    public Product getProduct() {
        return product;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public void countIncrease(){
        this.stockCount++;
    }

    public void countReduction(){
        this.stockCount--;
    }

    public int productPriceCalculate(){
        // 수정 후: 장바구니에 담긴 수량 사용
        return product.getPrice() * this.stockCount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", stockCount=" + stockCount +
                '}';
    }
}
