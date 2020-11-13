package jdbc_test;

import java.util.Scanner;

public class CRUD_Main {


	public static void main(String[] args) {
		//		crud_Main 클래스만 main()함수 생성
		//		crud_DTO, crud_SQL은 생성x

		//		crud
		//		create
		//		read retreve
		//		update
		//		delete

		CRUD_SQL crud = new CRUD_SQL();

		CRUD_DTO stu = new CRUD_DTO();

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int menu = 0;
		while(run) {
			System.out.println();
			System.out.println("1.접속		2.해제");
			System.out.println("3.등록		4.조회");
			System.out.println("5.수정		6.삭제");
			System.out.println("7.종료");
			System.out.println("==================");
			System.out.println("메뉴선택 : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				crud.connect();
				break;
			case 2:
				crud.conClose();
				break;
			case 3:
				System.out.println("학생정보를 입력해주세요");
				System.out.println("이름 : ");
				String s_Name = sc.next();
				stu.setStuName(s_Name);
				System.out.println("나이 : ");
				int s_age = sc.nextInt();
				stu.setStAge(s_age);
				crud.stuJoin(stu);
				break;
			case 4:
				crud.select();
				break;
			case 5:
				System.out.println("이름 : ");
				String name = sc.next();
				System.out.println("변경 할 이름 : ");
				String name2 = sc.next();
				System.out.println("변경 할 나이 : ");
				int age = sc.nextInt();
				crud.modify(name, name2, age);
				break;
			case 6:
				System.out.println("삭제할 이름을 입력하세요 : ");
				String name3 = sc.next();
				stu.setStuName(name3);
				crud.delete(name3);
				break;
			case 7:
				run = false;
				System.out.println("시스템 종료");
				break;

			}

		}

	}

}
