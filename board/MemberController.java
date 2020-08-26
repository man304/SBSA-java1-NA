package board;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();
	
	MemberController() { //생성자 초기세팅용
		
		Member member1 = new Member ("t1", "t1", "TEST");
		Member member2 = new Member ("t2", "t2", "T-34");
		Member member3 = new Member ("t3", "t3", "김성능");
		members.add(member1);
		members.add(member2);
		members.add(member3);
		
	}
	
	
	void doCommand(String cmd) {
		
		
		if(cmd.equals("signup")) {
			
			
			Member member = new Member();
			
			
			
			System.out.println("아이디를 입력해주세요");
			member.setLoginId(sc.nextLine());
			
			System.out.println("비밀번호를 입력해주세요");
			member.setLoginPw(sc.nextLine());
			
			System.out.println("이름을 입력해주세요");
			member.setUserName(sc.nextLine());

			members.add(member);
		}
		else if(cmd.equals("login")) {
			if(App.loginedMember != null) {
				System.out.println("로그아웃해주세요");
			} else {
				System.out.println("아이디를 입력해주세요.");
				String ACCOUNT = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				String PASSWORD = sc.nextLine();
				
				int ID = getMemberIndexById(ACCOUNT);
				
				if(ID == -1) {
					System.out.println("없는 ID입니다.");
				} else {
					Member member = members.get(ID);
					if(PASSWORD.equals(member.getLoginPw())) {
						App.loginedMember = member;
						System.out.println(member.getUserName()+ "님 반갑습니다!");
					} else {
						System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
					}				
				}
			}
		}
		else if(cmd.equals("logout")) {
			if(App.loginedMember == null) {
				System.out.println("로그인이 필요한 기능입니다.");
			}
			else if(App.loginedMember != null) {
				System.out.println("로그아웃되었습니다.");
				App.loginedMember = null;
			}
		}
	}
	
	int getMemberIndexById(String loginId) {
		int targetIndex = -1; // 찾는게 없을 때 -1
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getLoginId().equals(loginId)) {
				targetIndex = i;
			}
		}
		return targetIndex;
	}
	
}