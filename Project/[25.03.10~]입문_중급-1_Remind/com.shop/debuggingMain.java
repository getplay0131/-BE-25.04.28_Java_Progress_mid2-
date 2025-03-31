import exception.OutOfStockException;
import model.cart.Cart;
import model.product.Category_Enum;
import model.product.Product;
import model.user.RegularUser;

public class debuggingMain {
    public static void main(String[] args)  {
        Product phone = new Product("P001", "휴대폰 AI", 1250000, 5, Category_Enum.ELECTRONICS);

        RegularUser userNo1 = new RegularUser("U001", "홍길동", "hong@example.com", "hong1234", "경기도 평택시");

        Cart cart = new Cart(userNo1.getMemberId());
        try {
        cart.addItem(phone,2);
        } catch (OutOfStockException e) {
            throw new RuntimeException(e);
        }

        cart.displayCart();
    }
}