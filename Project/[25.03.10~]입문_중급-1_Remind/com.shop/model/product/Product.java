package model.product;

import java.util.Objects;

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
    private Category_Enum category;

// 생성자
    public Product(String productId, String name, int price, int stockCount, Category_Enum category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockCount = stockCount;
        this.category = category;
    }

//    getter

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public Category_Enum getCategory() {
        return category;
    }

//    setter

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public void setCategory(Category_Enum category) {
        this.category = category;
    }

//    오버라이드

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }

//    method
    public void deductingInventory(){
        this.stockCount--;
    }
}
