package service;

import model.cart.Cart;
import model.cart.CartItem;
import model.order.Order;
import model.order.OrderItem;
import model.user.User;

import java.util.ArrayList;

/*
 * 주문 관련 비즈니스 로직을 처리하는 서비스 클래스
 *
 * 구현 방법:
 * 1. 싱글톤 패턴 적용
 * 2. 주문 목록을 ArrayList<Order>로 관리
 * 3. 새로운 주문 생성 메서드 구현
 * 4. 장바구니 항목을 주문으로 변환 메서드 구현
 * 5. 주문 상태 업데이트 메서드 구현
 * 6. 주문 취소 메서드 구현
 * 7. 사용자별 주문 내역 조회 메서드 구현
 * 8. 주문ID로 주문 검색 메서드 구현
 * 9. 결제 처리 메서드 구현
 * 10. 영수증 생성 메서드 구현
 */
public class OrderService {
    //    * 1. 싱글톤 패턴 적용
    private static OrderService orderService;
    //    * 2. 주문 목록을 ArrayList<Order>로 관리
    public ArrayList<Order> ordersList;

    private OrderService() {
        this.ordersList = new ArrayList<>();
    }

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderService();
            return orderService;
        }
        return orderService;
    }

    //    null 검사 메서드
    public boolean checkNull(Object object) {
        if (object == null) {
            System.out.println("입력된 값이 null입니다. 값을 확인해주세요!");
            return false;
        }
        return true;
    }

    //    * 3. 새로운 주문 생성 메서드 구현
    public void createOrder(Order order) {
        if (CartService.getCartService().checkNull(order)) {
            for (Order order1 : ordersList) {
                if (order1 == null) {
                    ordersList.add(order);
                }
                System.out.println("신규 주문 생성 완료");
            }
        }
    }

    //     * 4. 장바구니 항목을 주문으로 변환 메서드 구현
    public Order changeCartItemToOrder(CartItem item, Order order, User user) {
        if (CartService.getCartService().checkNull(item) && CartService.getCartService().checkNull(order) && CartService.getCartService().checkNull(user)) {
            OrderItem orderItem = new OrderItem(item.getProduct(), item.productPriceCalculate(), item.getProduct().getPrice());
            order.addOrderItem(orderItem);
            return order;
        }
        return null;
    }

    //     * 5. 주문 상태 업데이트 메서드 구현
    public void updateOrderStat(Order order, Cart cart) {
        if (CartService.getCartService().checkNull(order) && CartService.getCartService().checkNull(cart)) {
            int orderPrice = order.updateTotalPrice();
            boolean isCheckprice = (orderPrice == cart.calculateTotalPrice());
            order.checkpayed(isCheckprice);
        }
    }

    //    * 6. 주문 취소 메서드 구현
    public void cancelOrder(Order order) {
        if (CartService.getCartService().checkNull(order)) {
            order.orderCancelled("단순 변심");
        }
    }

    //    * 7. 사용자별 주문 내역 조회 메서드 구현
    public void findUserOrderContent(UserService userService) {
        for (User user : userService.userList) {
            for (Order order : ordersList) {
                user.getMemberId().equals(order.getUserId());
                order.createReceipt();
            }
        }
    }
//    * 6. 주문 취소 메서드 구현
    public void orderCancelled(User user){
        for (Order order : ordersList) {
            user.getMemberId().equals(order.getUserId());
            order.orderCancelled("단순 변심");
        }
    }

}

