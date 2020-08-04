package Postclass;

import java.util.Scanner;

public class Postclass {

	public static void main(String[] args) {
	
		
Scanner S = new Scanner(System.in);
		
		int[] ids = new int[10]; //게시물 번호 저장소
		String title[] = new String[10]; //제목
		String body[] = new String[10];  //본문
		int post_NO = 0;// 게시물 번호(LastIndex)
		int LastId = 1; // 마지막 게시물 번호
		//
		while(true) {
			System.out.println("명령어를 입력해 주세요");
			String txt = S.nextLine();
			
			//종료
			if(txt.equals("exit")) { 
				System.out.println("시스템을 종료합니다.");
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
				LastId ++;
				int id = LastId;
				ids[post_NO] = id;
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
					System.out.println( ids[i] +". "+ title[i]);// 제목
					System.out.println("=====[ 본문 ]=====");
					System.out.println(" ");	 // 본
					System.out.println(body[i]);
					System.out.println(" ");	 // 문
					System.out.println("=================");
					System.out.println(" ");
				}
			}
			// 글 수정
			else if (txt.equals("update")) {	// 1
				System.out.println("수정할 게시글 번호를 입력해주세요");
				String target = S.nextLine();
				int NO = Integer.parseInt(target);
				
				int targetIndex = -1; //찾는게 없을때
				for(int i= 0; i < post_NO; i++) {
					if (ids[i] == NO) {
						targetIndex = i;
					}
				}
				if(targetIndex == -1) {
					System.out.println("없는 게시글 입니다.");
				}
				else {
					System.out.println("제목을 수정해주세요");
					String U_title = S.nextLine();
					System.out.println("분문을 수정해주세요");
					String U_body = S.nextLine();
					title[NO] = U_title;
					body[NO] = U_body;
				}
			}	
			//글 삭제
			else if (txt.equals("delete")) {
				System.out.println("삭제할 게시글 번호를 입력해주세요");
				String target = S.nextLine();
				int NO = Integer.parseInt(target);
				int targetIndex = -1; //찾는게 없을때
				for(int i= 0; i < post_NO; i++) {
					if (ids[i] == NO) {
						targetIndex = i;
					}
				}
				if(targetIndex == -1) {
					System.out.println("없는 게시글 입니다.");
				}
				else {
					System.out.println(NO + "삭제되었습니다.");
					title[NO] = null;
					body[NO] = null;
					post_NO --;
				}
			}
			//막ㅊㅕ
			else {
				System.out.println("잘못된 명령어입니다.");
			}
		
		}
////////
			
	}
}
