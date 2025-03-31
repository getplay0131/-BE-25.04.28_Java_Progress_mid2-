package model.user;
/*
 * VIP 회원 클래스
 *
 * 구현 방법:
 * 1. User 클래스 상속
 * 2. VIP 회원 특성(높은 적립률, 높은 할인율, VIP 혜택)을 상수로 정의
 * 3. 생성자 구현 (super() 활용)
 * 4. 할인율 계산 메서드 오버라이딩 (더 높은 할인율 적용)
 * 5. 포인트 적립 메서드 오버라이딩 (더 높은 적립률 적용)
 * 6. VIP 전용 혜택 메서드 추가
 */
public class VIPUser extends User{
    private final int highAccrualRate = 10;
    private final int highDiscountPercent = userGrade.VIP.getDiscontPercent();
    private final boolean  isVip = true;

    public VIPUser(String memberId, String name, String email, String password, String address) {
        super(memberId, name, email, password, address);
    }

    public int getHighAccrualRate() {
        return highAccrualRate;
    }

    public int getHighDiscountPercent() {
        return highDiscountPercent;
    }

    public boolean isVip() {
        return isVip;
    }

    @Override
    public int calculateDiscountPercent(int price) {
        return price * getHighDiscountPercent() / 100;
    }

    @Override
    public int pointEarned(int price) {
       return super.pointEarned(price * getHighAccrualRate());
    }
}
