package model.order;

import model.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
 * 주문 정보를 나타내는 클래스
 *
 * 구현 방법:
 * 1. 멤버 변수(주문ID, 사용자ID, 주문 항목 목록, 주문일시, 총액, 상태) 선언
 *    - 주문 항목 목록은 ArrayList<OrderItem>으로 구현
 * 2. 생성자 구현 (현재 시간으로 주문일시 초기화)
 * 3. 주문 상태 Enum 내부 정의 (PENDING, PAID, SHIPPED, DELIVERED, CANCELLED)
 * 4. 주문 항목 추가 메서드 구현
 * 5. 총액 계산 메서드 구현
 * 6. 주문 상태 변경 메서드 구현
 * 7. 주문 취소 메서드 구현
 * 8. 영수증 생성 메서드 구현
 * 9. toString() 메서드 오버라이딩: 주문 정보 출력
 */
public class Order {
    private String orderId;
    private String userId;
    private ArrayList<OrderItem> orderItems;
    private LocalDateTime orderTime;
    private int totalPrice;
    private orderStats orderStats;
    private boolean isCheckPayed;


    //    2. 생성자 구현 (현재 시간으로 주문일시 초기화)
    public Order(String orderId, String userId) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.totalPrice = 0;
        this.orderStats = orderStats.PENDING;
        this.isCheckPayed = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public orderStats getOrderStats() {
        return orderStats;
    }

    public boolean isCheckPayed() {
        return isCheckPayed;
    }

    //    4. 주문 항목 추가 메서드 구현
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    //    5. 총액 계산 메서드 구현
    public int updateTotalPrice() {
        totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.calculateTotalPrice();
        }
        return totalPrice;
    }

    //    6. 주문 상태 변경 메서드 구현
    public boolean checkpayed(boolean isCheck) {
        if (isCheck == false) {
            this.isCheckPayed = true;
            this.orderStats = orderStats.PAID;
        }
        return isCheck;
    }

    public orderStats orderStatChange(boolean isCheck) {
        if (checkpayed(isCheckPayed) == true) {
            return orderStats.PAID;
        }
        System.out.println("결제 정보가 없거나, 정보 불러오기에 실패하였습니다.");
        return orderStats.PENDING;
    }

    //    7. 주문 취소 메서드 구현
    public orderStats orderCancelled(String content) {
        if (this.orderStats != orderStats.DELIVERED){
            this.orderStats = orderStats.CANCELLED;
            System.out.println("주문이 취소되었습니다. 사유 :  " + content);
        } else {
            System.out.println("배송 시작 이후에는 주문 취소가 불가합니다.");
        }
        return orderStats;
    }

    //    PENDING, PAID, SHIPPED, DELIVERED, CANCELLED;
    public void orderStatToKor(orderStats oredrStats) {
        System.out.print("주문 상태 : ");
        if (oredrStats.equals("PENDING")) {
            System.out.println("주문 대기중");
        } else if (oredrStats.equals("PAID")) {
            System.out.println("결제 완료");
        } else if (oredrStats.equals("SHIPPED")) {
            System.out.println("택배사 전달 대기중");
        } else if (oredrStats.equals("DELIVERED")) {
            System.out.println("배송중");
        } else {
            System.out.println("취소됨");
        }
    }

    //    8. 영수증 생성 메서드 구현
    public void createReceipt() {
        System.out.println("== 영수증 정보 ==");
        System.out.println("주문 ID : " + orderId);
        System.out.println("= 주문 목록 = ");
        for (OrderItem orderItem : orderItems) {
            System.out.println("상품명 : " + orderItem.getProduct());
            System.out.println("수량 : " + orderItem.getCounts() + "개");
            System.out.println("가격 : " + orderItem.getPriceAtPurchase());
        }
        System.out.println("주문 일시 : " + orderTime.toString());
        System.out.println("총액 : " + totalPrice + "(원)");
        orderStatToKor(orderStats);
    }

//    9. toString() 메서드 오버라이딩: 주문 정보 출력


    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderItems=" + orderItems +
                ", orderTime=" + orderTime +
                ", totalPrice=" + totalPrice +
                ", orderStats=" + orderStats +
                ", isCheckPayed=" + isCheckPayed +
                '}';
    }

    //    3. 주문 상태 Enum 내부 정의 (PENDING, PAID, SHIPPED, DELIVERED, CANCELLED)
    public enum orderStats {
        PENDING, PAID, SHIPPED, DELIVERED, CANCELLED;
    }


}
