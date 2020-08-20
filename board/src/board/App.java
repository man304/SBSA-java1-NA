package board;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Member loginedMember = null;
	
	ArrayList<Article> articles = new ArrayList<>();
	
	MemberController mc = new MemberController();
	ArticleController ac = new ArticleController();
	
	void start() {
		Scanner sc = new Scanner(System.in);
		
		Article article1 = new Article(1, "안녕하세요", "안녕하세요", "익명", "20200817");
		Article article2 = new Article(2, "JAVA 프로그래밍", "JAVA 프로그래밍", "익명", "20200817");
		Article article3 = new Article(3, "어렵지 않아요", "어렵지 않아요", "익명", "20200817");
		
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
	
		

		while (true) {			
			System.out.println("기능을 선택해주세요.(article : 게시물 기능, member : 회원 기능, exit : 종료)");
			
			String module = sc.nextLine();
			if (module.equals("exit")) {
				System.out.println("프로그램 종료!");
				break;
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