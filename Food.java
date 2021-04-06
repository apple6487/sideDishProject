package team4;

public interface Food {
	
	
	static int password = 1234; //관리자 비밀번호 상수
	
	
	default void search() {
		//조회 관련 디폴트메소드
	}
	
	default void entering() {
		//입고 관련 디폴트메소드
	}
	
	default void delete() {
		//삭제 관련 디폴트메소드
	}
	
	default void customer() {
		//고객관리 관련 디폴트메소드
	}
	
	default void password() {
		//관리자 암호입력 관련 디폴트메소드
	}
	
	
	
}
