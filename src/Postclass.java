import java.util.Scanner;

public class Postclass {

	public static void main(String[] args) {
	
		
		Scanner S = new Scanner(System.in);
		
		String title[] = new String[10]; //����
		String body[] = new String[10];  //����
		int post_NO = 0;
		//
		while(true) {
			System.out.println("��ɾ �Է��� �ּ���");
			String txt = S.nextLine();
			
			//����
			if(txt.equals("exit")) { 
				System.out.println("�ý��� ����");
				break;
			}
			//��ɾ� �ȳ�
			else if (txt.equals("help")) { 
				System.out.println("==== ��ɾ� ��� ====");
				System.out.println("exit - �ý����� �����մϴ�.");
				System.out.println("add - �Խñ��� �ۼ��մϴ�.");
				System.out.println("list - �Խñ� ����� �ҷ��ɴϴ�.");
				System.out.println("update - �̹� �ۼ��� �Խñ��� �����մϴ�.");
				System.out.println("delete - �̹� �ۼ��� �Խñ��� �����մϴ�.");
				System.out.println("=====================");
			}
			//�Խñ� �ۼ�
			else if (txt.equals("add")) { 
				System.out.println("������ �ۼ��� �ּ���");
				title[post_NO] = S.nextLine(); //����
				System.out.println("������ �ۼ��� �ּ���");
				body[post_NO] = S.nextLine();  //����
				post_NO ++;
			}
			//�Խñ� ���
			else if (txt.equals("list")) {
				for(int i = 0; i < post_NO; i++) {
					System.out.println("=====[ ���� ]=====");
					System.out.println( i +". "+ title[i]);// ����
					System.out.println("=====[ ���� ]=====");
					System.out.println(" ");	 // ��
					System.out.println(body[i]);
					System.out.println(" ");	 // ��
					System.out.println("=================");
					System.out.println(" ");
				}
			}
			else {
				System.out.println("�߸��� ��ɾ��Դϴ�.");
			}
		
		}

		
	}
}
