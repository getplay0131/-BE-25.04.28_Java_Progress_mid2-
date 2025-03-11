package model.product;
/*
 * 상품 카테고리를 정의하는 열거형
 *
 * 구현 방법:
 * 1. 카테고리 값 정의 (ELECTRONICS, CLOTHING, FOOD, BOOKS 등)
 * 2. 각 카테고리별 할인율 필드 추가
 * 3. 생성자와 getter 메서드 구현
 * 4. 할인율을 적용한 가격 계산 메서드 구현
 */
public enum Category_Enum {
    ELECTRONICS(10),CLOTHING(5),FOOD(3),BOOKS(5);

    private int discountPercent;

//    생성자
    Category_Enum(int discountPercent) {
        this.discountPercent = discountPercent;
    }

//    getter
    public int getDiscountPercent() {
        return discountPercent;
    }

//    method
    public int calculateDiscount(int price){
        return price - (price * getDiscountPercent() / 100);
    }
}
