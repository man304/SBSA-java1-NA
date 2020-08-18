package board;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	
	Member loginedMember = new Member();
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();
	
	
	
	void doCommand(String cmd) {
		
		Member member1 = new Member ("123", "123", "TEST");
		members.add(member1);
		
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
					loginedMember = member;
					System.out.println(member.getUserName()+ "님 반갑습니다!");
				} else {
					System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
				}				
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