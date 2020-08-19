package board;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Member loginedMember = null;
	
	ArrayList<Article> articles = new ArrayList<>();
	MemberController mc = new MemberController();
	void start() {
		Scanner sc = new Scanner(System.in);
		
		Article article1 = new Article(1, "안녕하세요", "안녕하세요", "익명", "20200817");
		Article article2 = new Article(2, "JAVA 프로그래밍", "JAVA 프로그래밍", "익명", "20200817");
		Article article3 = new Article(3, "어렵지 않아요", "어렵지 않아요", "익명", "20200817");
		
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
	
		int lastId = 3; // 가장 마지막에 추가된 게시물의 게시물 번호

		while (true) {			
			System.out.println("명령어를 입력해주세요");
			String s = sc.nextLine();

			if (s.equals("exit")) {

				System.out.println("프로그램 종료!");
				break;

			} else if (s.equals("help")) {

				System.out.println("add : 게시물 등록");
				System.out.println("list : 게시물 목록");
				System.out.println("update : 게시물 수정");
				System.out.println("delete : 게시물 삭제");
				System.out.println("search : 검색");
				System.out.println("read : 상세보기");
				System.out.println("signup : 가입");
				System.out.println("login : 로그인");
				System.out.println("logout : 로그아웃");
			} else if (s.equals("add")) {
				if(loginedMember == null) {
					System.out.println("로그인이 필요한 기능입니다.");
				} else {
					lastId++; // 게시물 번호 자동 증가
					int id = lastId;

					System.out.println("제목을 입력해주세요");
					String title = sc.nextLine();

					System.out.println("내용을 입력해주세요");
					String body = sc.nextLine();
					
					Article article = new Article(id, title, body, "익명", "20200817");
					articles.add(article);
				}
			} else if (s.equals("list")) {
				printArticles(articles);
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
			} else if (s.equals("search")) {
				System.out.println("검색어를 입력해주세요.");
				String keyword = sc.nextLine();	//1
				
				ArrayList<Article> searchedList = new ArrayList<>();
				
				for(int i = 0; i < articles.size(); i++) {	//2
					String title = articles.get(i).getTitle();
					if(title.contains(keyword)) {	//3
						searchedList.add(articles.get(i));
					}
				}
				
				printArticles(searchedList);
				
			} else if (s.equals("read")) {
				
				System.out.println("상세보기 할 게시물 번호를 입력해주세요.");
				String target = sc.nextLine();
				int targetNo = Integer.parseInt(target);

				int targetIndex = getArticleIndexById(targetNo);

				if (targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					printArticle(articles.get(targetIndex));
				}
			} else if (s.equals("signup")) {
				mc.doCommand(s);
			} else if (s.equals("login")) {
				mc.doCommand(s);
			} else if (s.equals("logout")) {
				mc.doCommand(s);
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
	
	void printArticles(ArrayList<Article> articles) {
		for (int i = 0; i < articles.size(); i++) {
			System.out.println("번호 : " + articles.get(i).getId());
			System.out.println("제목 : " + articles.get(i).getTitle());
			System.out.println("=====================");
			
		}
	}
	
	void printArticle(Article article) {
		System.out.println("======== " + article.getId() + "번 게시물 상세보기 =======");
		System.out.println("번호   : " + article.getId());
		System.out.println("제목   : " + article.getTitle());
		System.out.println("내용   : " + article.getBody());
		System.out.println("작성자 : " + article.getWriter());
		System.out.println("작성일 : " + article.getRegDate());
	}
	
}