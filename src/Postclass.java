import java.util.Scanner;

public class Postclass {

	public static void main(String[] args) {
	
		
		Scanner S = new Scanner(System.in);
		
		String title[] = new String[10]; //제목
		String body[] = new String[10];  //본문
		int post_NO = 0;
		//
		while(true) {
			System.out.println("명령어를 입력해 주세요");
			String txt = S.nextLine();
			
			//종료
			if(txt.equals("exit")) { 
				System.out.println("시스템 종료");
				break;
			}
			//명령어 안내
			else if (txt.equals("help")) { 
				System.out.println("==== 명령어 목록 ====");
				System.out.println("exit - 시스템을 종료합니다.");
				System.out.println("add - 게시글을 작성합니다.");
				System.out.println("list - 게시글 목록을 불러옵니다.");
				System.out.println("update - 이미 작성한 게시글을 수정합니다.");
				System.out.println("delete - 이미 작성한 게시글을 삭제합니다.");
				System.out.println("=====================");
			}
			//게시글 작성
			else if (txt.equals("add")) { 
				System.out.println("제목을 작성해 주세요");
				title[post_NO] = S.nextLine(); //제목
				System.out.println("본문을 작성해 주세요");
				body[post_NO] = S.nextLine();  //본문
				post_NO ++;
			}
			//게시글 목록
			else if (txt.equals("list")) {
				for(int i = 0; i < post_NO; i++) {
					System.out.println("=====[ 제목 ]=====");
					System.out.println( i +". "+ title[i]);// 제목
					System.out.println("=====[ 본문 ]=====");
					System.out.println(" ");	 // 본
					System.out.println(body[i]);
					System.out.println(" ");	 // 문
					System.out.println("=================");
					System.out.println(" ");
				}
			}
			else {
				System.out.println("잘못된 명령어입니다.");
			}
		
		}

		
	}
}
