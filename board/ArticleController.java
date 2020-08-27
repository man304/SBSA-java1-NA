package board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArticleController {
	Scanner sc = new Scanner(System.in);
	ArrayList<Article> articles = new ArrayList<>();
	ArrayList<Reply> replies = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Like> likes = new ArrayList<>();

	int lastId = 9; // 가장 마지막에 추가된 게시물의 게시물 번호
	int lastPage = 2;
	ArticleController() { // 생성자 초기세팅용

		Article article1 = new Article(1, "안녕 지구인들아", "안녕 반가워 내 이름은 민달팽이야", "김민달팽이", "20200817", 2310, 1);
		Article article2 = new Article(2, "JAVA 프로그래밍", "JAVA 프로그래밍 자바 프로그래밍 자바 프로그래밍 자바 프", "익명", "20200817", 1,1);
		Article article3 = new Article(3, "어렵지 않아요", "어렵지 않아요 어렵지 않아요 어렵지 않아요 어렵지 않아요 어렵지 않아", "익명", "20200817", 2,1);
		Article article4 = new Article(4, "2페이지테스트", "페이지테스트", "익명", "TEST", 0 ,1);
		Article article5 = new Article(5, "페이지테스트", "페이지테스트", "익명", "TEST", 0, 1);
		
		Article article6 = new Article(6, "페이지테스트", "페이지테스트", "익명", "TEST", 0, 2);
		Article article7 = new Article(7, "3페이지테스트", "페이지테스트", "익명", "TEST", 0, 2);
		Article article8 = new Article(8, "페이지테스트", "페이지테스트", "익명", "TEST", 0, 2);
		Article article9 = new Article(9, "페이지테스트", "페이지테스트", "익명", "TEST", 0, 2);

		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
		articles.add(article4);
		articles.add(article5);
		
		articles.add(article6);
		articles.add(article7);
		articles.add(article8);
		articles.add(article9);

	}

	void doCommand(String cmd) {

		if (cmd.equals("help")) {

			System.out.println("add : 게시물 등록");
			System.out.println("list : 게시물 목록");
			System.out.println("update : 게시물 수정");
			System.out.println("delete : 게시물 삭제");
			System.out.println("search : 검색");
			System.out.println("read : 상세보기");
			System.out.println("signup : 가입");
			System.out.println("login : 로그인");
			System.out.println("logout : 로그아웃");
			System.out.println("reply : 댓글");

		} else if (cmd.equals("add")) {
			if (App.loginedMember == null) {
				System.out.println("로그인이 필요한 기능입니다.");
			} else {
				Add();
			}
		} else if (cmd.equals("list")) {
			printArticles(articles);

		} else if (cmd.equals("update")) {

			if (App.loginedMember == null) {
				System.out.println("로그인이 필요한 기능입니다.");

			} else {
				System.out.println("수정할 게시물 번호를 입력해주세요.");
				String target = sc.nextLine();
				int targetNo = Integer.parseInt(target);

				int targetIndex = getArticleIndexById(targetNo);

				if (targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				}
				if (App.loginedMember.getUserName().equals(articles.get(targetIndex).getWriter())) {
					Update(targetIndex);

				} else {
					System.out.println("자신의 게시물만 수정 가능합니다.");
				}
			}

		} else if (cmd.equals("delete")) {
			if (App.loginedMember == null) {
				System.out.println("로그인이 필요한 기능입니다.");

			} else {
				System.out.println("삭제할 게시물 번호를 입력해주세요.");
				String target = sc.nextLine();
				int targetNo = Integer.parseInt(target);

				int targetIndex = getArticleIndexById(targetNo);

				if (targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				} else if (App.loginedMember.getUserName().equals(articles.get(targetIndex).getWriter())) {
					Delete(targetIndex);

				} else {
					System.out.println("자신의 게시물만 삭제 가능합니다.");
				}
			}
		} else if (cmd.equals("search")) {
			System.out.println("검색어를 입력해주세요.");
			String keyword = sc.nextLine(); // 1

			ArrayList<Article> searchedList = new ArrayList<>();

			for (int i = 0; i < articles.size(); i++) { // 2
				String title = articles.get(i).getTitle();
				if (title.contains(keyword)) { // 3
					searchedList.add(articles.get(i));
				}
			}

			printArticles(searchedList);

		} else if (cmd.equals("read")) {

			System.out.println("상세보기 할 게시물 번호를 입력해주세요.");
			String target = sc.nextLine();
			int targetNo = Integer.parseInt(target);

			int targetIndex = getArticleIndexById(targetNo);

			if (targetIndex == -1) {
				System.out.println("없는 게시물입니다.");
			} else {
				int currentCount = articles.get(targetIndex).getviewCount();
				articles.get(targetIndex).setviewCount(currentCount + 1);
				printArticle(articles.get(targetIndex), targetIndex);
				viewDetail(targetIndex);
			}
		} else if (cmd.equals("sort")) {
			System.out.println("정렬대상을 선택해주세요. (hit : 조회수,  id : 번호)");
			String target = sc.nextLine();
			System.out.println("정렬방법을 선택해주세요. (asc : 오름차순,  desc : 내림차순)");
			String flag = sc.nextLine();

			MyComparator com = new MyComparator();
			com.setTarget(target);
			com.setFlag(flag);
			Collections.sort(articles, com);
			printArticles(articles);
		}
	}

	// ------------------------->객체
	void Add() {
		lastId++; // 게시물 번호 자동 증가
		int id = lastId;
		int page = lastPage;
		
		
		System.out.println("제목을 입력해주세요");
		String title = sc.nextLine();

		System.out.println("내용을 입력해주세요");
		String body = sc.nextLine();

		Article article = new Article(id, title, body, App.loginedMember.getUserName(), MyUtil.today(), 0, page);
		articles.add(article);
		
		if(lastId % 5 == 0) {
			lastPage ++;
			
		}
	}

	void Delete(int targetIndex) {
		articles.remove(targetIndex);
		System.out.println("삭제했습니다.");
	}

	void Update(int targetIndex) {
		System.out.println("수정할 제목을 입력해주세요.");
		String title = sc.nextLine();
		System.out.println("수정할 내용을 입력해주세요.");
		String body = sc.nextLine();

		Article article = articles.get(targetIndex);
		article.setTitle(title);
		article.setBody(body);
	}

	void viewDetail(int targetIndex) {
		Article article = articles.get(targetIndex);
		System.out.println("상세보기 명령어 입력(back/reply/like/hate)");
		String cmd = sc.nextLine();
		while (true) {
			if (cmd.equals("back")) {
				break;
			} else if (cmd.equals("reply")) {
				if (App.loginedMember == null) {
					System.out.println("로그인이 필요한 기능입니다.");
				} else {
					System.out.println("댓글을 입력해주세요.");
					String rep = sc.nextLine();
					Reply rep1 = new Reply(targetIndex, App.loginedMember.getUserName(), rep, MyUtil.today());
					replies.add(rep1);
					printArticle(articles.get(targetIndex), targetIndex);
				}
				break;
			} else if (cmd.equals("like")) {
				if (App.loginedMember == null) {
					System.out.println("로그인 기능이 필요한 기능입니다.");
				} else {

					System.out.println("좋아요 또는 싫어요를 선택해주세요.( like : 좋아요,  hate : 싫어요)");
					String likeOrHate = sc.nextLine();

					Like target = getLikeByArticleIdAndUserId(article.getId(), App.loginedMember.getLoginId());
					int flag = -1;

					if (likeOrHate.equals("like")) {
						flag = 0;
					} else {
						flag = 1;
					}

					if (target == null) {
						Like like = new Like();
						like.setArticleId(article.getId());
						like.setUserId(App.loginedMember.getLoginId());
						like.setFlag(flag);
						likes.add(like);
					} else {
						if (target.getFlag() == flag) {
							likes.remove(target);
						} else {
							target.setFlag(flag);
						}
					}
					printArticle(article, targetIndex);
					break;
				}
			} else {
				System.out.println("잘못된 명령어");
				break;
			}
		}

	}

	ArrayList<Like> getLikesByAritlceId(int articleId) {

		ArrayList<Like> likeListByArticleId = new ArrayList<Like>();

		for (int i = 0; i < likes.size(); i++) {
			if (likes.get(i).getArticleId() == articleId) {
				likeListByArticleId.add(likes.get(i));
			}
		}

		return likeListByArticleId;

	}

	int getCountOfLikesByAritlceId(int articleId) {
		int count = 0;
		ArrayList<Like> likes = getLikesByAritlceId(articleId);
		for (int i = 0; i < likes.size(); i++) {
			if (likes.get(i).getFlag() == 0) {
				count++;
			}
		}

		return count;
	}

	int getCountOfHatesByAritlceId(int articleId) {
		int countOfLikes = getCountOfLikesByAritlceId(articleId);
		int countOfAll = getLikesByAritlceId(articleId).size();

		return countOfAll - countOfLikes;

	}

	Like getLikeByArticleIdAndUserId(int articleId, String UserId) {
		Like target = null;
		ArrayList<Like> likes = getLikesByAritlceId(articleId);
		for (int i = 0; i < likes.size(); i++) {
			if (likes.get(i).getUserId().equals(UserId)) {
				target = likes.get(i);
			}
		}
		return target;
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
	
	void printArticle(Article article, int targetIndex) {
		System.out.println("======== " + article.getId() + "번 게시물 상세보기 =======");
		System.out.println("제목   : " + article.getTitle());
		System.out.println("내용   : " + article.getBody());
		System.out.println("작성자 : " + article.getWriter());
		System.out.println("조회수 : " + article.getviewCount());
		System.out.println("좋아요 : " + getCountOfLikesByAritlceId(article.getId()));
		System.out.println("싫어요 : " + getCountOfHatesByAritlceId(article.getId()));
		System.out.println("작성일 : " + article.getRegDate());
		printReply(targetIndex);
	}

	void printReply(int targetIndex) {
		System.out.println("===== 댓글 =====");
		int j = 0;
		for (int i = 0; i < replies.size(); i++) {
			if (replies.get(i).getId() == targetIndex) {
				j++;
				System.out.println("댓글" + j + " " + replies.get(i).getWriter() + " " + replies.get(i).getYymmdd());
				System.out.println(replies.get(i).getReply());
			}
		}
		System.out.println("=====================");
	}
}