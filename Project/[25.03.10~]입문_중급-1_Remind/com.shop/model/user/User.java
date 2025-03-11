package model.user;

import java.util.Objects;

/*
 * 사용자 정보의 기본 클래스
 *
 * 구현 방법:
 * 1. 멤버 변수(ID, 이름, 이메일, 비밀번호, 주소) private으로 선언
 * 2. 생성자, getter, setter 메서드 구현
 * 3. toString() 메서드 오버라이딩: 사용자 정보 출력
 * 4. equals(), hashCode() 메서드 오버라이딩: 사용자ID 기반으로 동일성 판단
 * 5. 할인율 계산 메서드 구현 (하위 클래스에서 오버라이딩)
 * 6. 포인트 적립 메서드 구현 (하위 클래스에서 오버라이딩)
 */
public class User {
    private String memberId;
    private String name;
    private String email;
    private String password;
    private String address;

//    생성자

    public User(String memberId, String name, String email, String password, String address) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

//    getter

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

//setter

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    override

    @Override
    public String toString() {
        return "User{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(memberId, user.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberId);
    }

//method
    public void calculateDiscountPercent(int price){
    }

    public void pointEarned(int price){
    }
}
