package jdbc_test;

import java.util.Scanner;

public class CRUD_Main {


	public static void main(String[] args) {
		//		crud_Main Ŭ������ main()�Լ� ����
		//		crud_DTO, crud_SQL�� ����x

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
			System.out.println("1.����		2.����");
			System.out.println("3.���		4.��ȸ");
			System.out.println("5.����		6.����");
			System.out.println("7.����");
			System.out.println("==================");
			System.out.println("�޴����� : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				crud.connect();
				break;
			case 2:
				crud.conClose();
				break;
			case 3:
				System.out.println("�л������� �Է����ּ���");
				System.out.println("�̸� : ");
				String s_Name = sc.next();
				stu.setStuName(s_Name);
				System.out.println("���� : ");
				int s_age = sc.nextInt();
				stu.setStAge(s_age);
				crud.stuJoin(stu);
				break;
			case 4:
				crud.select();
				break;
			case 5:
				System.out.println("�̸� : ");
				String name = sc.next();
				System.out.println("���� �� �̸� : ");
				String name2 = sc.next();
				System.out.println("���� �� ���� : ");
				int age = sc.nextInt();
				crud.modify(name, name2, age);
				break;
			case 6:
				System.out.println("������ �̸��� �Է��ϼ��� : ");
				String name3 = sc.next();
				stu.setStuName(name3);
				crud.delete(name3);
				break;
			case 7:
				run = false;
				System.out.println("�ý��� ����");
				break;

			}

		}

	}

}
