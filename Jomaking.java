package front;

import java.util.Arrays;


public class Jomaking {

	public static void main(String[] args) {
		//27명 7개조 편성
		String[] member = new String[27];
		String[][] team = new String[7][];

		//1조 부터 6조까지 4명 7조는 3명
		team[0] = new String[4];
		team[1] = new String[4];
		team[2] = new String[4];
		team[3] = new String[4];
		team[4] = new String[4];
		team[5] = new String[4];
		team[6] = new String[3];

		//1번 부터 27번까지 부여
		for (int i = 0; i < member.length; i++) {
			if(i<9) {
				member[i] = "0" + (i+1) + "번";
			}else {
				member[i] = (i+1) + "번";
			}
		}
		//(1) 24명에 대해 랜덤으로 조 편성
		//조편성이 된 인원들은 중복방지를 위해 x로 표시

		for (int j = 0; j < team.length-1;) {
			int k = (int)(Math.random() * 100 %27);

			if(!member[k].equals("x")) {
				team[j][3] = member[k];
				member[k] = "x";
				j++;
			}

		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < team.length;) {
				int k = (int)(Math.random() * 100 %27);
				
				System.out.println(Math.random()*100);
				if(!member[k].equals("x")) {
					team[j][i%4] = member[k];
					member[k] = "x";
					j++;
				}

			}


		}

		for (int i = 0; i < team.length; i++) {
			System.out.println((i+1)+"조" +Arrays.toString(team[i]));
		}
	}
}
