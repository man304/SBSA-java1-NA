package board;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
	Scanner sc = new Scanner(System.in);
	ArrayList<Article> articles = new ArrayList<>();
	ArrayList<Reply> replies = new ArrayList<>();
	
	int lastId = 3; // ���� �������� �߰��� �Խù��� �Խù� ��ȣ
	
	ArticleController() { //������ �ʱ⼼�ÿ�
		
		Article article1 = new Article(1, "�ȳ� �����ε��", "�ȳ� �ݰ��� �� �̸��� �δ����̾�", "��δ�����", "20200817");
		Article article2 = new Article(2, "JAVA ���α׷���", "JAVA ���α׷��� �ڹ� ���α׷��� �ڹ� ���α׷��� �ڹ� ��", "�͸�", "20200817");
		Article article3 = new Article(3, "����� �ʾƿ�", "����� �ʾƿ� ����� �ʾƿ� ����� �ʾƿ� ����� �ʾƿ� ����� �ʾ�", "�͸�", "20200817");
		
		articles.add(article1);
		articles.add(article2);
		articles.add(article3);
		
	}
	
	void doCommand(String cmd) {
	
		if (cmd.equals("help")) {

			System.out.println("add : �Խù� ���");
			System.out.println("list : �Խù� ���");
			System.out.println("update : �Խù� ����");
			System.out.println("delete : �Խù� ����");
			System.out.println("search : �˻�");
			System.out.println("read : �󼼺���");
			System.out.println("signup : ����");
			System.out.println("login : �α���");
			System.out.println("logout : �α׾ƿ�");
			System.out.println("reply : ���");
			
		} else if (cmd.equals("add")) {
			if(App.loginedMember == null) {
				System.out.println("�α����� �ʿ��� ����Դϴ�.");
			} else {
				lastId++; // �Խù� ��ȣ �ڵ� ����
				int id = lastId;

				System.out.println("������ �Է����ּ���");
				String title = sc.nextLine();

				System.out.println("������ �Է����ּ���");
				String body = sc.nextLine();
				
				Article article = new Article(id, title, body, "�͸�", "20200817");
				articles.add(article);
			}
		} else if (cmd.equals("list")) {
			printArticles(articles);
		} else if (cmd.equals("update")) {
			System.out.println("������ �Խù� ��ȣ�� �Է����ּ���.");
			String target = sc.nextLine();
			int targetNo = Integer.parseInt(target);

			int targetIndex = getArticleIndexById(targetNo);

			if (targetIndex == -1) {
				System.out.println("���� �Խù��Դϴ�.");
			} else {
				System.out.println("������ ������ �Է����ּ���.");
				String title = sc.nextLine();
				System.out.println("������ ������ �Է����ּ���.");
				String body = sc.nextLine();

				Article article = articles.get(targetIndex);
				article.setTitle(title);
				article.setBody(body);

			}

		} else if (cmd.equals("delete")) {
			System.out.println("������ �Խù� ��ȣ�� �Է����ּ���.");
			String target = sc.nextLine();
			int targetNo = Integer.parseInt(target);

			int targetIndex = getArticleIndexById(targetNo);

			if (targetIndex == -1) {
				System.out.println("���� �Խù��Դϴ�.");
			} else {
				articles.remove(targetIndex);
			}
		} else if (cmd.equals("search")) {
			System.out.println("�˻�� �Է����ּ���.");
			String keyword = sc.nextLine();	//1
			
			ArrayList<Article> searchedList = new ArrayList<>();
			
			for(int i = 0; i < articles.size(); i++) {	//2
				String title = articles.get(i).getTitle();
				if(title.contains(keyword)) {	//3
					searchedList.add(articles.get(i));
				}
			}
			
			printArticles(searchedList);
			
		} else if (cmd.equals("read")) {
			
			System.out.println("�󼼺��� �� �Խù� ��ȣ�� �Է����ּ���.");
			String target = sc.nextLine();
			int targetNo = Integer.parseInt(target);

			int targetIndex = getArticleIndexById(targetNo);

			if (targetIndex == -1) {
				System.out.println("���� �Խù��Դϴ�.");
			} else {
				printArticle(articles.get(targetIndex), targetIndex);
				viewDetail(targetIndex);
			}
		} /*else if (cmd.equals("reply")) {
			
		} */
	} 
	
	void viewDetail(int targetIndex) {
		System.out.println("�󼼺��� ��ɾ� �Է�(back/reply)");
		String cmd = sc.nextLine();
		while(true){
			if(cmd.equals("back")) {
				break;
			} 
			else if(cmd.equals("reply")) {
				System.out.println("����� �Է����ּ���.");
					String rep = sc.nextLine();
					Reply rep1 = new Reply(targetIndex, rep);
					replies.add(rep1);
					printArticle(articles.get(targetIndex), targetIndex);				
					break;
			}				
		}
		
	}
	int getArticleIndexById(int targetNo) {
		int targetIndex = -1; // ã�°� ���� �� -1

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == targetNo) {
				targetIndex = i;
			}
		}

		return targetIndex;
	}
	void printArticles(ArrayList<Article> articles) {
		for (int i = 0; i < articles.size(); i++) {
			System.out.println("��ȣ : " + articles.get(i).getId());
			System.out.println("���� : " + articles.get(i).getTitle());
			System.out.println("=====================");
			
		}
	}
	void printArticle(Article article, int targetIndex) {
		System.out.println("======== " + article.getId() + "�� �Խù� �󼼺��� =======");
		System.out.println("��ȣ   : " + article.getId());
		System.out.println("����   : " + article.getTitle());
		System.out.println("����   : " + article.getBody());
		System.out.println("�ۼ��� : " + article.getWriter());
		System.out.println("�ۼ��� : " + article.getRegDate());
		printReply(targetIndex);
	}
	void printReply(int targetIndex) {
		System.out.println("===== ��� =====");
		for(int i = 0;i < replies.size(); i++) {
			if(replies.get(i).getId() == targetIndex) {
				System.out.println( "���" + (i + 1) + " : " + replies.get(i).getReply());
			}
		}
		System.out.println("=====================");
	}
}