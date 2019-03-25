/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jpa;

import java.util.Scanner;

/**
 *
 * @author CalumAdmin
 */
public class MyuserApp {

	private MyuserDB mydb;

	public MyuserApp() {
		mydb = new MyuserDB();
	}

	public static void main(String[] args) {
		MyuserApp client = new MyuserApp();
		// assuming inputs from keyboard or any GUI
		testHarness(client.mydb);
		
	}

	public void showCreateResult(boolean result, MyuserDTO myuserDTO) {
		if (result) {
			System.out.println("Record with primary key " + myuserDTO.getUserid()
					+ " has been created in the database table.");
		} else {
			System.out.println("Record with primary key " + myuserDTO.getUserid()
					+ " could not be created in the database table!");
		}
	}

	public boolean createRecord(MyuserDTO myuserDTO) {
		return mydb.createRecord(myuserDTO);
	}
	
	public static void testHarness(MyuserDB mdb) {
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		String userId;
		MyuserDTO record;
		while (!exit) {
			System.out.println("MyDB: What would you like to do?");
			System.out.println("1: Get record");
			System.out.println("2: Update record");
			System.out.println("3: Delete record");
			System.out.println("4: Exit");
			userId = null;
			record = null;
			switch (in.nextInt()) {
				case 1:
					in.nextLine();
					System.out.print("Enter UserID to get record: ");
					userId = in.nextLine();
					record = mdb.getRecord(userId);
					if (record != null) {
						System.out.println("|" + record.getUserid() + "|" + record.getName() + "|" + record.getPassword() + "|" + record.getEmail() + "|" + record.getPhone() + "|" + record.getAddress() + "|" + record.getSecQn() + "|" + record.getSecAns() + "|");
					} else System.out.println("Record " + userId + " doesn\'t exist.");
					break;
				case 2:
					System.out.print("Enter UserID to get record for update: ");
					userId = in.next();
					record = mdb.getRecord(userId);
					System.out.println("Select datum for edit:");
					System.out.println("1: Name");
					System.out.println("2: Password");
					System.out.println("3: Email");
					System.out.println("4: Phone");
					System.out.println("5: Address");
					System.out.println("6: Security Question");
					System.out.println("7: Security Answer");
					switch (in.nextInt()) {
						default:
							System.out.println("Input not valid.");
							break;
						case 1:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), in.next(), record.getPassword(), record.getEmail(), record.getPhone(), record.getAddress(), record.getSecQn(), record.getSecAns()));
							break;
						case 2:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), record.getName(), in.next(), record.getEmail(), record.getPhone(), record.getAddress(), record.getSecQn(), record.getSecAns()));
							break;
						case 3:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), record.getName(), record.getPassword(), in.next(), record.getPhone(), record.getAddress(), record.getSecQn(), record.getSecAns()));
							break;
						case 4:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), record.getName(), record.getPassword(), record.getEmail(), in.next(), record.getAddress(), record.getSecQn(), record.getSecAns()));
							break;
						case 5:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), record.getName(), record.getPassword(), record.getEmail(), record.getPhone(), in.next(), record.getSecQn(), record.getSecAns()));
							break;
						case 6:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), record.getName(), record.getPassword(), record.getEmail(), record.getPhone(), record.getAddress(), in.next(), record.getSecAns()));
							break;
						case 7:
							System.out.print("Enter new value:");
							mdb.updateRecord(new MyuserDTO(record.getUserid(), record.getName(), record.getPassword(), record.getEmail(), record.getPhone(), record.getAddress(), record.getSecQn(), in.next()));
							break;
					}
					record = mdb.getRecord(userId);
					System.out.println("|" + record.getUserid() + "|" + record.getName() + "|" + record.getPassword() + "|" + record.getEmail() + "|" + record.getPhone() + "|" + record.getAddress() + "|" + record.getSecQn() + "|" + record.getSecAns() + "|");
					break;
				case 3:
					System.out.print("Enter UserID to delete:");
					mdb.deleteRecord(in.next());
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("Please enter a number between 1 and 4.");
					break;
			}
		}
	}
}
