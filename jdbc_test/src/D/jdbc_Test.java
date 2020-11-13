package D;

import java.util.Scanner;

import jdbc_test.DB;

public class jdbc_Test {

	public static void main(String[] args) {
		DB conn = new DB();
		conn.DBconnect();
	}
}
