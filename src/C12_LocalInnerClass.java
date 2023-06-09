import myobj2.Electronics;

public class C12_LocalInnerClass {

	/*
# 지역 내부 클래스
· 메서드 내부에도 클래스를 만들 수 있다.
· 해당 메서드가 끝나고 나면 사용할 수 없는 설계도
· 메서드 밖에서는 접근 불가능

# 익명 지역 내부 클래스
· 메서드 내부에서 이미 존재하는 클래스를 바로 수정하며 사용하는 방식
	(생성과 동시에 상속)
	 */

	// 일반적인 지역 내부 클래스
	// 메서드 내부에도 클래스를 만들고 인스턴스를 쓸 수 있다.
	public static void main(String[] args) {
		class Grape {
			int qty;
			String grade;

			@Override // Ctrl + Space → toString 오버라이드
			public String toString() {
				return grade + "등급 포도";
			}
		}

		Grape g = new Grape();

		g.qty = 33;
		g.grade = "A+";

		System.out.println(g);

		// ★★★중요★★★
		// 익명 지역 내부 클래스 (한번 쓰고 버릴 일회용 클래스)
		// → 주로 업캐스팅에 많이 사용됨.
		Electronics e = new Electronics("에어컨", 149);
		Electronics e2 = new Electronics("전자렌지", 123) { // 이름이 없어서 익명이라고 부름

			// Electronics 클래스를 마음대로 수정 가능
			// ⇒ 즉시 상속받아서 오버라이딩이 가능
			@Override
			public void start() {
				System.out.println("안에 들어있는 것을 돌리기 시작합니다.");
			}
		};
		e.start(); // ⇒ 에어컨의 스타트
		e2.start(); // ⇒ 전자렌지의 스타트
	}
}
