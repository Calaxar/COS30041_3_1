/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jpa;

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
		MyuserDTO myuserDTO = new MyuserDTO("000001", "Wei Lai", "123456",
				"wlai@swin.edu.au", "9876543210", "Swinburne EN510b",
				"What is my name?", "Wei");
		boolean result = client.createRecord(myuserDTO);
		client.showCreateResult(result, myuserDTO);
		// assuming inputs from keyboard or any GUI
		MyuserDTO myuserDTO2 = new MyuserDTO("000006", "Man Lai", "654321",
				"wlai@swin.edu.au", "9876543210", "Swinburne EN510b",
				"What is my name?", "Man");
		result = client.createRecord(myuserDTO2);
		client.showCreateResult(result, myuserDTO2);
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
}
