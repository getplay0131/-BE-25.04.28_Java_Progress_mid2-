package service;

import model.user.RegularUser;
import model.user.User;
import model.user.VIPUser;

import java.util.ArrayList;

/*
 * 사용자 관련 비즈니스 로직을 처리하는 서비스 클래스
 *
 * 구현 방법:
 * 1. 싱글톤 패턴 적용
 * 2. 사용자 목록을 ArrayList<User>로 관리
 * 3. 사용자 등록 메서드 구현
 * 4. 사용자 정보 업데이트 메서드 구현
 * 5. 사용자 삭제 메서드 구현
 * 6. 로그인 검증 메서드 구현
 * 7. ID로 사용자 검색 메서드 구현
 * 8. 회원 등급 업그레이드 메서드 구현
 */
public class UserService {
    //    == 필드 ==
//    * 1. 싱글톤 패턴 적용
//    * 2. 사용자 목록을 ArrayList<User>로 관리
    public static UserService userService;
    public ArrayList<User> userList;

    //    == 생성자 ==
    private UserService() {
        this.userList = new ArrayList<>();
    }

    //    null 검사 메서드
    public boolean checkNull(Object object) {
        if (object == null) {
            System.out.println("입력된 값이 null입니다. 값을 확인해주세요!");
            return false;
        }
        return true;
    }

    //    목록에서 대상 값 찾기 및 바꾸기 유틸리티 메서드
    public void findArrayDataAndChange(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (findUserId(user)) {
            userList.remove(i);
            userList.add(user);
            }
            System.out.println("사용자 정보 업데이트 완료");
        }
    }

//    * 7. ID로 사용자 검색 메서드 구현
public boolean findUserId(User user){
        if (!checkNull(user)) {
        System.out.println("사용자 검색 실패");
        return false;
    } else {
        for (User user1 : userList) {
            if (user1.getMemberId().equals(user.getMemberId())) {
            return true;
            }
        }
        System.out.println("사용자 아이디 검색 성공 일치 및 확인 완료");
    }
    return false;
}

    public boolean findUserPw(User user){
        if (!checkNull(user)) {
            System.out.println("사용자 검색 실패");
            return false;
        } else {
            for (User user1 : userList) {
                if (user1.getPassword().equals(user.getPassword())) {
                return true;
                }
            }
            System.out.println("사용자 비밀번호 검색 성공 및 일치 확인 완료");
        }
        return false;
    }

    //    == 자신의 인스턴스 호출 메서드 ==
    public static UserService getUserService() {
        if (userService == null) {
            UserService userService = new UserService();
            return userService;
        }
        return userService;
    }

    //    * 3. 사용자 등록 메서드 구현
    public void userRegistration(User user) {
        if (!checkNull(user)) {
            System.out.println("사용자 등록 실패");
            return;
        }
        for (User user1 : userList) {
            if (user1 == null) {
                userList.add(user);
                System.out.println("사용자 등록이 완료되었습니다.");
                return;
            }
        }
    }

    //* 4. 사용자 정보 업데이트 메서드 구현
    public void userInfoUpdate(User user) {
        if (!checkNull(user)) {
            System.out.println("사용자 정보 업데이트 실패");
        }
        findArrayDataAndChange(user);
        System.out.println("사용자 정보 업데이트 완료");
    }

    // * 5. 사용자 삭제 메서드 구현
    public void userDelete(User user) {
        if (!checkNull(user)) {
            for (int i = 0; i < userList.size(); i++) {
                if (findUserId(user)) {
                    userList.remove(i);
                }
                System.out.println("사용자 정보 업데이트 완료");
            }
            System.out.println("사용자 삭제 실패");
        }


        System.out.println("사용자 삭제 완료");
    }

    // * 6. 로그인 검증 메서드 구현
    public void checkLoginData(User user) {
        if (!checkNull(user)) {
            System.out.println("로그인 검증 실패");
        }

        boolean isMatchId = false;
        boolean isMatchPw = false;
        for (User user1 : userList) {
            if (findUserId(user1)) {
                isMatchId = true;
                System.out.println("아이디 확인 완료");
            }

            if (findUserPw(user)) {
                isMatchPw = true;
                System.out.println("비밀번호 확인 완료");
            }

            if (isMatchPw && isMatchId) {
                System.out.println("로그인이 완료 되었습니다.");
            } else {
                System.out.println("아이디 또는 비밀번호를 확인해주세요!");
            }
        }
    }

//    * 8. 회원 등급 업그레이드 메서드 구현
    public void userGradeUpgrade(User user){
        if (checkNull(user) && user.checkPoint()) {
            findArrayDataAndChange(user);
            if (user instanceof RegularUser regularUser) {
                VIPUser vipUser = new VIPUser(regularUser.getMemberId(), regularUser.getName(), regularUser.getEmail(),
                        regularUser.getPassword(), regularUser.getAddress());
                    if (findUserId(user)) {
                        userDelete(user);
                        userRegistration(vipUser);
                    }
                System.out.println(regularUser.getName() + " 님께서 VIP 회원으로 등급이 상승하였습니다.");
            }
        } else {
            System.out.println("이미 VIP회원이거나, 업그레이드가 불가합니다.");
        }
    }
}
