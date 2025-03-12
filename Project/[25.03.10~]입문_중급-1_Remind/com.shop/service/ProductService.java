package service;

import model.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
 * 상품 관련 비즈니스 로직을 처리하는 서비스 클래스
 *
 * 구현 방법:
 * 1. 싱글톤 패턴 적용 (인스턴스를 하나만 생성하여 공유)
 * 2. 상품 목록을 ArrayList<Product>로 관리
 * 3. 상품 추가 메서드 구현
 * 4. 상품 삭제 메서드 구현
 * 5. 상품 업데이트 메서드 구현
 * 6. ID로 상품 검색 메서드 구현
 * 7. 이름으로 상품 검색 메서드 구현 (부분 일치 검색)
 * 8. 카테고리별 상품 필터링 메서드 구현
 * 9. 가격 범위로 상품 필터링 메서드 구현
 * 10. 상품 정렬 메서드 구현 (가격 오름차순/내림차순)
 */

public class ProductService {
    private Product product;
    private ArrayList<Product> productList;

    public ProductService(Product product) {
        this.product = product;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (!product.getProductId().isEmpty()) {
            productList.add(product);
            System.out.println("상품 추가가 완료되었습니다");
        }
    }

    public void deleteProduct(Product product) {
        if (!product.getProductId().isEmpty()) {
            for (Product products : productList) {
                if (products.getProductId().equals(product.getProductId())) {
                    productList.remove(product);
                    System.out.println("상품 추가가 완료되었습니다");
                }
            }
        }
    }

    public void productUpdate(Product product){
        if (!product.getProductId().isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductId().equals((product.getProductId()))) {
                    productList.remove(i);
                    productList.add(product);
                }
            }
        }
    }

    public Product findProduct(String productId) {
        for (Product product1 : productList) {
            if (product1.getProductId().equals(productId)) {
                return product1;
            }
        }
        return null;
    }

    public boolean checkValueIsNull(Product product){
        if (product != null) {
            return true;
        }
        return false;
    }


    }


