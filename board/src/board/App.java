package board;

import java.util.Scanner;

public class App {

	static Member loginedMember = null;
	
	MemberController mc = new MemberController();
	ArticleController ac = new ArticleController();
	
	void start() {
		Scanner sc = new Scanner(System.in);

		while (true) {			
			System.out.println("기능을 선택해주세요.(article : 게시물 기능, member : 회원 기능, help : 명령어 목록, exit : 종료)");
			
			String module = sc.nextLine();
			if (module.equals("exit")) {
				System.out.println("프로그램 종료!");
				break;
			} else if (module.equals("help")) {
				
				System.out.println("== 게시물 기능 (article) ==");
				System.out.println("add : 게시물 등록");
				System.out.println("list : 게시물 목록");
				System.out.println("update : 게시물 수정");
				System.out.println("delete : 게시물 삭제");
				System.out.println("search : 검색");
				System.out.println("read : 상세보기");
				System.out.println("== 회원 기능 (member) ==");
				System.out.println("signup : 가입");
				System.out.println("login : 로그인");
				System.out.println("logout : 로그아웃");
				
				continue;
			}
			System.out.println("명령어를 입력해주세요");
			String s = sc.nextLine();
			if(module.equals("article")) {
				ac.doCommand(s);
			} else if(module.equals("member")) {
				mc.doCommand(s);
			} else if (module.equals("exit")) {
				System.out.println("프로그램 종료!");
				break;
			} else {
				System.out.println("올바른 명령어가 아닙니다.");
			}
		} 
	}

	
	
}