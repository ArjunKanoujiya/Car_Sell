package carwale;

import java.sql.*;

import java.util.Scanner;

public class Car {

	public static void main(String[] args) {
		
		String fcqn = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";

		System.out.println(" Welcome to Carwale");
		Scanner sc = new Scanner(System.in);

		System.out.println("Press 1: to sell car");

		System.out.println("Press 2: to buy car");

		System.out.println("Press 3: to see car");

		System.out.println("Press 4: to see latest car");
		int input = sc.nextInt();

		if (input == 1) {

			// Scanner sc = new Scanner (System.in);
			System.out.println("enter CNO:-> ");
			int a = sc.nextInt();

			System.out.println("enter CNAME :-> ");
			String a1 = sc.next();

			System.out.println("enter CMODEL :-> ");
			String a2 = sc.next();

			System.out.println("enter CPRICE :-> ");
			String a3 = sc.next();

			System.out.println("enter CPRICE :-> ");
			String a4 = sc.next();

			

			String inquery = " insert into carwale.car values(?,?,?,?,?)";

			try {

				Class.forName(fcqn);

				Connection con = DriverManager.getConnection(url);
				PreparedStatement pstmt = con.prepareStatement(inquery);

				pstmt.setInt(1, a);
				pstmt.setString(2, a1);
				pstmt.setString(3, a2);
				pstmt.setString(4, a3);
				pstmt.setString(5, a4);

				pstmt.execute();

			} catch (Exception e) {

				System.out.println(e);
			}
		}

		else if (input == 2) {

//			String fcqn = "com.mysql.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306?user=root&password=root";

			try {

				Class.forName(fcqn);

				Connection con = DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from carwale.car");
				while (rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2));

				}
			} catch (Exception e) {

				System.out.println(e);
			}
			System.out.println("enter carno  to buy the car ");
			int user_inp = sc.nextInt();
			
			try {

				Class.forName(fcqn);

				Connection con = DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
			   PreparedStatement pstmt = con.prepareStatement("delete from carwale.car where cno = ?");
			   pstmt.setInt(1, user_inp);
			   pstmt.execute();
                    
				
			} catch (Exception e) {

				System.out.println(e);
			}
			
			
		}

		else if (input == 3) {

//			String fcqn = "com.mysql.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306?user=root&password=root";

			try {

				Class.forName(fcqn);

				Connection con = DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from carwale.car");
				while (rs.next()) {
					System.out.println(rs.getString(2));

				}
			} catch (Exception e) {

				System.out.println(e);
			}
		}
		
		else if(input==4) {
			
//			String fcqn = "com.mysql.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306?user=root&password=root";

			try {

				Class.forName(fcqn);

				Connection con = DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from newcar.latestcar");
				while (rs.next()) {
					System.out.println(rs.getString(2));

				}
			} catch (Exception e) {

				System.out.println(e);
			}
			

			
			
			
		}

	}

}
