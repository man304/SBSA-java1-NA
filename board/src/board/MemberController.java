package board;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {

	static ArrayList<Member> members = new ArrayList<>();

	void start() {
		Scanner sc = new Scanner(System.in);

		
		
		while (true) {
			System.out.println("===== 회원 기능 =====");
			System.out.println("명령어를 입력해주세요");
			
			String s = sc.nextLine();
			
			if(s.equals("signup")) {
				
				Member member = new Member();
				
				System.out.println("새 아이디를 입력해주세요");
				member.setAccont(sc.nextLine());

				System.out.println("새 비밀번호를 입력해주세요");
				member.setPassword(sc.nextLine());
				
				System.out.println("이름을 입력해주세요");
				member.setUsername(sc.nextLine());
				
				members.add(member);
				
				BACK();
			} else if (s.equals("help")) {

				System.out.println("== 회원 기능 명령어 ==");
				System.out.println("signup : 회원 가입 기능");
				System.out.println("back : 탈출");
				System.out.println("login: ");
				
			} else if(s.equals("back")) {
				BACK();
			} else if(s.equals("login")) {
				BACK();
			} 
	
			else {
				System.out.println("올바른 명령어가 아닙니다.");
			}
			

		}
	}
	static void BACK(){	
		App app = new App();
		app.start();
	} 
}

