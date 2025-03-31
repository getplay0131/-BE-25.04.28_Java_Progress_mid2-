package model.user;

/*
 * 일반 회원 클래스
 *
 * 구현 방법:
 * 1. User 클래스 상속
 * 2. 일반 회원 특성(적립률, 할인율)을 상수로 정의
 * 3. 생성자 구현 (super() 활용)
 * 4. 할인율 계산 메서드 오버라이딩
 * 5. 포인트 적립 메서드 오버라이딩
 */
public class RegularUser extends User {

    private final int accrualRate = 5;
    private final int discountPercent = userGrade.REGULAR.getDiscontPercent();

    public RegularUser(String memberId, String name, String email, String password, String address) {
        super(memberId, name, email, password, address);
    }

    public int getAccrualRate() {
        return accrualRate;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public int calculateDiscountPercent(int price) {
        return price * getDiscountPercent() / 100;
    }

    @Override
    public int pointEarned(int price) {
        return super.pointEarned(price * getAccrualRate());
    }
}

