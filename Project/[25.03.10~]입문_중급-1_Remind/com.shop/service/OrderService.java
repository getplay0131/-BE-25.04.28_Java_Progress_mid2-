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

    public ArrayList<Order> getOrdersList() {
        return ordersList;
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
    //    이 코드는 ordersList 내에 null인 Order가 있는 경우에만 새 주문을 추가하는 것처럼 보입니다. ArrayList에는 보통 null 값이 포함되지 않으므로 이 부분이 의도대로 동작하지 않을 수 있습니다.
    public void createOrder(Order order) {
        if (CartService.getCartService().checkNull(order)) {
            ordersList.add(order);
            System.out.println("신규 주문 생성 완료");
        } else {
            System.out.println("입력값이 올바르지 않아 주문 생성에 실패하였습니다.");
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
    public void orderCancelled(User user) {
        if (CartService.getCartService().checkNull(user)) {
            for (Order order : ordersList) {
                if (user.getMemberId().equals(order.getUserId())) {
                    order.orderCancelled("단순 변심");
                    break;
                } else {
                    System.out.println("사용자를 찾지 못했습니다.");
                }
            }
        }
    }

    //    * 7. 사용자별 주문 내역 조회 메서드 구현
    public ArrayList findUserOrderContent(User user) {
        ArrayList<Order> findUserOrders = new ArrayList<>();
        if (CartService.getCartService().checkNull(user)) {
            for (Order order : ordersList) {
                if (order.getUserId().equals(user.getMemberId())) {
                    findUserOrders.add(order);
                }
            }
            if (!findUserOrders.isEmpty()) {
            for (Order findUserOrder : findUserOrders) {
                System.out.println("== 주문 내역 == ");
                System.out.println("사용자 ID : " + findUserOrder.getUserId());
                System.out.println("주문 상태 : " + findUserOrder.getOrderStats());
                System.out.println("총 결제 금액 : " + findUserOrder.getTotalPrice() + "원");
                System.out.println("----------------");
            }
            } else {
                System.out.println(user.getName() + "님의 주문 내역이 없습니다");
            }
        }
        return findUserOrders;
    }

    //     * 8. 주문ID로 주문 검색 메서드 구현
    //     equals() 메서드의 결과를 확인하지 않고 있습니다. 또한 검색된 주문을 반환하지 않고 있어 메서드의 실용성이 낮아 보입니다.
    public Order findOrederWithId(String orderId) {
        Order tempOrder = null;
        for (Order order : ordersList) {
            if (CartService.getCartService().checkNull(order)) {
                if (order.getOrderId().equals(orderId)) {
                    System.out.println("주문 검색에 성공하였습니다.");
                    tempOrder = order;
                } else {
                    System.out.println("주문 검색에 실패하였습니다.");
                }
            }
        }
        return tempOrder;
    }

    //    * 9. 결제 처리 메서드 구현
    public void checkedPaid(int price, Order order) {
        boolean isPaid = false;
        if (CartService.getCartService().checkNull(order)) {
            if (price == 0 && !order.isCheckPayed()) {
                System.out.println("결제가 진행되지 않았습니다.");
            } else if (price > 0 && order.isCheckPayed()) {
                System.out.println("결제가 완료 되었습니다. 주문 상태가 결제 완료 상태로 변경되었습니다.");
                order.orderStatChange(order.isCheckPayed());
            }
        }
    }

    //     * 10. 영수증 생성 메서드 구현
    public void createReceiptAndDisplay(Order order) {
        if (CartService.getCartService().checkNull(order)) {
            order.createReceipt();
        }
    }

}

