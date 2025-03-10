package model.product;
///*
// * 상품 정보를 나타내는 클래스
// *
// * 구현 방법:
// * 1. 필요한 멤버 변수(상품ID, 이름, 가격, 재고량, 카테고리)를 private으로 선언
// * 2. 생성자, getter, setter 메서드 구현
// * 3. toString() 메서드 오버라이딩: 상품 정보 출력 형식 지정
// * 4. equals(), hashCode() 메서드 오버라이딩: 상품ID 기반으로 동일성 판단
// * 5. 상품 재고 확인/감소 기능 메서드 구현
// */
public class Product {

    private String productId ;
    private String name;
    private int price;
    private int stockCount;
    private Category_Enum categorys;
    
}
