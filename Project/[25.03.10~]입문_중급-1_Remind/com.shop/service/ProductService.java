package service;

import model.product.Category_Enum;
import model.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
    //  *  1. 싱글톤 패턴 적용 (인스턴스를 하나만 생성하여 공유)
// * 2. 상품 목록을 ArrayList<Product>로 관리
    private static ProductService productService;
    private ArrayList<Product> productList;

//    매개변수가 없는 private 생성자가 싱글톤과 맞다.
    private ProductService() {
        this.productList = new ArrayList<>();
    }

    public static ProductService getProductService() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    //* 3. 상품 추가 메서드 구현
    public void addProduct(Product product) {
        if (!product.getProductId().isEmpty()) {
            productList.add(product);
            System.out.println("상품 추가가 완료되었습니다");
        }
    }

    //* 4. 상품 삭제 메서드 구현
    public void deleteProduct(Product product) {
        if (!product.getProductId().isEmpty()) {
            for (Product products : productList) {
                if (products.getProductId().equals(product.getProductId())) {
                    productList.remove(product);
                    System.out.println("상품 삭제가 완료되었습니다");
                }
            }
        }
    }

    //    * 5. 상품 업데이트 메서드 구현
    public void productUpdate(Product product) {
        if (!product.getProductId().isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductId().equals((product.getProductId()))) {
                    productList.remove(i);
                    productList.add(product);
                }
            }
        }
    }

    //     * 7. 이름으로 상품 검색 메서드 구현 (부분 일치 검색)
    public Product findProductWithName(String name) {
        for (Product product1 : productList) {
            if (product1.getName().equals(name)) {
                return product1;
            }
        }
        return null;
    }

    //    * 6. ID로 상품 검색 메서드 구현
    public Product findProduct(String productId) {
        for (Product product1 : productList) {
            if (product1.getProductId().contains(productId)) {
                return product1;
            }
        }
        return null;
    }

    //    * 오브젝트 null검사 메서드
    public boolean checkValueIsNull(Product product) {
        if (product != null) {
            return true;
        }
        return false;
    }

    //    * 8. 카테고리별 상품 필터링 메서드 구현
    public ArrayList filterByCategory(Category_Enum category) {
        ArrayList<Product> targetCategoryArrays = new ArrayList<>();
        for (Product product1 : productList) {
            if (product1.getCategory() == category) {
                targetCategoryArrays.add(product1);
            }
        }
        if (targetCategoryArrays.size() == 0) {
            System.out.println("해당 카테고리에 맞는 상품이 없습니다.");
        }
        return targetCategoryArrays;
    }

//    * 9. 가격 범위로 상품 필터링 메서드 구현
public ArrayList filterByPrice(int minPrice, int maxPrice, Product product){
    ArrayList<Object> targetPriceArrays = new ArrayList<>();
    if (product.getPrice() >= minPrice && product.getPrice() >= maxPrice ) {
        targetPriceArrays.add(product);
    }
    if (targetPriceArrays.size() == 0) {
        System.out.println("해당 가격 범위에 맞는 상품이 없습니다.");
    }
    return targetPriceArrays;
}

//* 10. 상품 정렬 메서드 구현 (가격 오름차순/내림차순)
public void sortUpList(ArrayList list){
    if (list.size() != 0) {
        list.sort(Comparator.naturalOrder());
        System.out.println("오름 차순 정렬이 완료 되었습니다.");
    }
}

    public void sortDownList(ArrayList list){
        if (list.size() != 0) {
            list.sort(Comparator.reverseOrder());
            System.out.println("내림 차순 정렬이 완료 되었습니다.");
        }
    }

}


