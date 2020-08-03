import java.util.Scanner;

public class Postclass {

	public static void main(String[] args) {
	
		
		Scanner S = new Scanner(System.in);
		String title[] = new String[10]; //제목
		String body[] = new String[10];  //본문
		int post_NO = 0;
		//
		while(true) {
			System.out.println("명령어를 입력해주세요");
			String txt = S.nextLine();
			
			//종료
			if(txt.equals("exit")) { 
				System.out.println("시스템 종료");
				break;
			}
			//명령어안내
			else if (txt.equals("help")) { 
				System.out.println("==== 명령어 목록 ====");
				System.out.println("exit - 시스템 종료");
				System.out.println("add - 게시물 정보를 저장");
				System.out.println("list - 게시물 목록 출력");
				System.out.println("=====================");
			}
			//글작성
			else if (txt.equals("add")) { 
				System.out.println("제목을 입력해주세요");
				title[post_NO] = S.nextLine(); //제목
				System.out.println("내용을 입력해주세요");
				body[post_NO] = S.nextLine();  //본문
				post_NO ++;
			}
			//글목록불러오기
			else if (txt.equals("list")) {
				for(int i = 0; i < post_NO; i++) {
					
					System.out.println("제목 : " + title[post_NO]);
					System.out.println("내용 : " + body[post_NO]);
					System.out.println(" ");
				}
			}
			else {
				System.out.println("올바른 명령어가 아닙니다.");
			}
		
		}

		
	}
}
