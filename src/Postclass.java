import java.util.Scanner;

public class Postclass {

	public static void main(String[] args) {
		
		Scanner S = new Scanner(System.in);
	int postnumber = 0;
	String[] P = new String[postnumber];//글목록
	
	while(true) {
		System.out.println("명령어를 입력해주세요");
		String txt = S.nextLine();
		
		if(txt.equals("exit")) {
			System.out.println("시스템 종료");
			break;
		}
		else if (txt.equals("help")) {
			System.out.println("==== 명령어 목록 ====");
			System.out.println("exit - 시스템 종료");
			System.out.println("add - 게시물 정보를 저장");
			System.out.println("list - 게시물 목록 출력");
			System.out.println("=====================");
		}
		else if (txt.equals("add")) {
			postnumber += 1;
			String Save = S.nextLine();
			P[postnumber] = Save;
		}
		else if (txt.equals("list")) {
			for(int i= 0; i < P.length; i++) {
				System.out.println(P[i]);
			}
		}
		else {
			System.out.println("올바른 명령어가 아닙니다.");
		}
		
	}

	}

}
