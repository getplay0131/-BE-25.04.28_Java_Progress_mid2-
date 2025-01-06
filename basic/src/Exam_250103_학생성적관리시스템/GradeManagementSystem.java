package Exam_250103_학생성적관리시스템;

public class GradeManagementSystem {
    // ❗ 필드 구성
    // - 최대 학생 수: 배열 크기 제한을 위한 상수
    private int MAX_STUDENTS = 10;
    // - 학생 배열: 전체 학생 관리를 위해 필요
    private Student_imp1[] students = new Student_imp1[MAX_STUDENTS];
    // - 현재 등록된 학생 수: 배열 관리를 위한 카운터
    private int currentStudentCounter;

    /* 1. 학생 관리 기능 */

    // 1-1. 학생 등록
    public void registerStudent(/* 필요한 매개변수 */) {
        // ✓ 구현 단계:
        // 1. 입력받은 학생 정보 유효성 검증
        // 2. 배열에 여유 공간 있는지 확인
        // 3. 학생 타입(일반/편입) 구분하여 객체 생성
        // 4. 배열에 추가하고 카운터 증가
    }

    // 1-2. 학생 삭제
    public void removeStudent(String studentId) {
        // ✓ 구현 단계:
        // 1. 학번으로 학생 찾기
        // 2. 해당 학생 배열에서 제거
        // 3. 뒤의 요소들을 앞으로 이동
        // 4. 카운터 감소
    }

    /* 2. 성적 관리 기능 */

    // 2-1. 성적 입력
    public void addScore(String studentId, /* 성적 정보 */) {
        // ✓ 구현 단계:
        // 1. 학생 찾기
        // 2. 과목과 점수 유효성 검증
        // 3. Score 객체 생성
        // 4. 학생의 성적 배열에 추가
    }

    // 2-2. 성적 수정
    public void updateScore(String studentId, /* 성적 정보 */) {
        // ✓ 구현 단계:
        // 1. 학생과 과목 찾기
        // 2. 새로운 점수 유효성 검증
        // 3. 성적 정보 업데이트
    }

    /* 3. 성적 조회 기능 */

    // 3-1. 학생 검색
    public Student_imp1 findStudent(String studentId) {
        // ✓ 구현 단계:
        // 1. 배열 순회하며 학번 비교
        // 2. 일치하는 학생 반환
        // 3. 없으면 null 반환
    }

    // 3-2. 성적표 출력
    public void printGradeReport(String studentId) {
        // ✓ 구현 단계:
        // 1. 학생 찾기
        // 2. 기본 정보 출력 (학번, 이름 등)
        // 3. 과목별 성적 출력
        // 4. 평균과 장학금 여부 출력
    }

    /* 4. 통계 기능 */

    // 4-1. 학년별 통계
    public void printGradeStatistics() {
        // ✓ 구현 단계:
        // 1. 학년별로 학생 그룹화
        // 2. 각 학년의 평균 계산
        // 3. 결과 출력
    }

    // 4-2. 장학금 대상자 조회
    public void printScholarshipStudents() {
        // ✓ 구현 단계:
        // 1. 전체 학생 순회
        // 2. 학생 타입별로 기준 적용
        // 3. 대상자 목록 출력
    }

    /* 유틸리티 메서드 */

    // 배열 관리
    private int findEmptySpot() {
        // 배열에서 빈 자리 찾기
    }

    private void compactArray() {
        // 삭제된 자리 처리하여 배열 정리
    }

    // 데이터 검증
    private boolean validateStudent(/* 학생 정보 */) {
        // 학생 정보 유효성 검사
    }

    private boolean validateScore(int score) {
        // 점수 범위 검사 (0-100)
    }
}
