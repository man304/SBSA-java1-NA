package board;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	static ArrayList<Article> articles = new ArrayList<>();
	static ArrayList<Member> members = new ArrayList<>();
	static int lastId = 0; // 가장 마지막에 추가된 게시물의 게시물 번호

	void start() {
		
		Scanner sc = new Scanner(System.in);
				
		boolean APP = false;
		
		Article article1 = new Article (1, "안녕요", "안녕 지구인들아", "익명", "20200817");
		Article article2 = new Article (2, "하이요", "잘가 안녕안녕", "익명", "20200817");
		articles.add(article1);
		articles.add(article2);
		
		
		System.out.println("게시판 기능은 1번, 회원 기능은 2번을 입력해주세요.");
		String S = sc.nextLine();
		if(S.equals("1")) {
			APP = true;
		}
		else if(S.equals("2")) {
			MemberController MC = new MemberController();
			MC.start();
		}
		else {
			BACK();
		}
		while (APP) {
			System.out.println();
			System.out.println("명령어를 입력해주세요");
			String s = sc.nextLine();
			
			if (s.equals("exit")) {
				
				System.out.println("프로그램 종료!");
				APP = false;
				break;

			} else if (s.equals("help")) {

				System.out.println("== 게시판 기능 명령어 ==");
				System.out.println("add : 게시물 등록");
				System.out.println("list : 게시물 목록");
				System.out.println("update : 게시물 수정");
				System.out.println("delete : 게시물 삭제");
				System.out.println("back : 탈출");
				System.out.println("exit : 프로그램 종료");
				System.out.println("search : 게시물 검색");

			} else if (s.equals("add")) {
				

				
				lastId++; // 게시물 번호 자동 증가
				int id = lastId;

				System.out.println("제목을 입력해주세요");
				String title = sc.nextLine();

				System.out.println("내용을 입력해주세요");
				String body = sc.nextLine();
				
				Article article = new Article (id, title, body,"익명","20200817");
				articles.add(article);	
				APP = false;
				BACK();
				
			} else if (s.equals("list")) {

				for (int i = 0; i < articles.size(); i++) {
					System.out.println("번호 : " + articles.get(i).getId());
					System.out.println("제목 : " + articles.get(i).getTitle());
					//System.out.println("내용 : " + articles.get(i).getBody());
					System.out.println("=====================");
				} 
				APP = false;
				BACK();
			} else if (s.equals("update")) {
				System.out.println("수정할 게시물 번호를 입력해주세요.");
				String target = sc.nextLine();

				int targetNo = Integer.parseInt(target);
				int targetIndex = getArticleIndexById(targetNo);

				
				if (targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					System.out.println("수정할 제목을 입력해주세요.");
					String title = sc.nextLine();
					System.out.println("수정할 내용을 입력해주세요.");
					String body = sc.nextLine();

					Article article = articles.get(targetIndex);
					article.setTitle(title);
					article.setBody(body);
					
				}
				APP = false;
				BACK();
				
			} else if (s.equals("delete")) {
				System.out.println("삭제할 게시물 번호를 입력해주세요.");
				String target = sc.nextLine();
				int targetNo = Integer.parseInt(target);
				
				int targetIndex = getArticleIndexById(targetNo);
				
				if (targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					articles.remove(targetIndex);
				}
				BACK();
			} else if(s.equals("back")) {
				APP = false;
				BACK();
			} else if (s.equals("search")) {
				
				System.out.println("검색");
				
				String Keyword = sc.nextLine();
				
				for (int i = 0; i < articles.size(); i++) {					
					if(articles.get(i).getTitle().contains(Keyword)) {
						
						System.out.println("번호 : " + articles.get(i).getId());
						System.out.println("제목 : " + articles.get(i).getTitle());
						System.out.println("내용 : " + articles.get(i).getBody());
						System.out.println("=====================");
					
					}
					if(articles.get(i).getBody().contains(Keyword)) {
						
						System.out.println("번호 : " + articles.get(i).getId());
						System.out.println("제목 : " + articles.get(i).getTitle());
						System.out.println("내용 : " + articles.get(i).getBody());
						System.out.println("=====================");
					
					}
				}
				APP = false;
				BACK();
								
			} else if(s.equals("read")) {
				System.out.println("조회할 게시물 번호를 입력해주세요.");
				String target = sc.nextLine();

				int targetNo = Integer.parseInt(target);
				int targetIndex = getArticleIndexById(targetNo);

				
				if (targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				}
				else {
					System.out.println("====== " + articles.get(targetIndex).getId()+ "번 게시물 상세보기 ======");
					System.out.println("제목 : " + articles.get(targetIndex).getTitle());
					System.out.println("내용 : " + articles.get(targetIndex).getBody());
					System.out.println("=====================");
				}
				APP = false;
				BACK();
			} else {
				System.out.println("올바른 명령어가 아닙니다.");
				
			}
		}		
	}
	
	int getArticleIndexById(int targetNo) {
		int targetIndex = -1; // 찾는게 없을 때 -1

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == targetNo) {
				targetIndex = i;
			}
		}
		
		return targetIndex;
	}
	static void BACK(){	
		
		App app = new App();
		app.start();
	}
	void printArticle(Article article) {
		System.out.println("====== " + article.getId()+ "번 게시물 상세보기 ======");
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getBody());
		System.out.println("작성자 : " + article.getWriter());
		System.out.println("작성일 : " + article.getRegDate());
		System.out.println("=====================");
	}
}

