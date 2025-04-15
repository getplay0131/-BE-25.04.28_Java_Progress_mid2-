package Progress_250415.test.ex2;

import java.util.ArrayList;

public class ShoppingCart {
private ArrayList<Item> cart = new ArrayList<>();

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addItem(Item item){
        cart.add(item);
    }

    public void displayItems(){
        System.out.println("장바구니 상품 출력");
        int totalPrce = 0;
        for (Item item : cart) {
            System.out.println("상품명 : " + item.getName() + ", 합계 : " + item.getTotalPrice());
            totalPrce += item.getTotalPrice();
        }
        System.out.println("전체 가격 합 : " + totalPrce);
    }
}
