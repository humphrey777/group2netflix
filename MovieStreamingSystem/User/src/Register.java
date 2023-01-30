import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: Register Package: register Description:
 *
 * @Author: Yateng
 * @Create: 2022-12-16 - 11:45 p.m.
 * @Version: v1.0
 */
public class Register {

	public static void Register() {
		Account myAccount = new Account();
		Scanner enter = new Scanner(System.in);
		System.out.println(("Welcome to our Registration system\nEnter your User name please: "));
		myAccount.setUserName(enter.nextLine());
		if (userIsExisted(myAccount.getUserName())) {
			System.out.println(
					"We are sorry, the user name you just entered in not available, please try another one  and try again\n\n");
			Register();
			return;
		}

		System.out.println("Enter your pass word please: ");
		myAccount.setPassWord(enter.nextLine());

		System.out.println(("Enter your first name please: "));
		myAccount.setfName(enter.nextLine());

		System.out.println("Enter your last name please: ");
		myAccount.setlName(enter.nextLine());

		System.out.println(("Enter your date of birth please: "));
		myAccount.setDateOfBirth(enter.nextLine());

		System.out.println("Enter your gender please: ");
		myAccount.setGender(enter.nextLine());

		String[] arrAccount = { myAccount.getUserName(), myAccount.getPassWord(), myAccount.getfName(),
				myAccount.getlName(), myAccount.getDateOfBirth(), myAccount.getGender() };

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("MovieStreamingSystem/Register.txt", true));
			for (int i = 0; i < arrAccount.length; i++) {
				writer.append(arrAccount[i] + "\t");
				if (i == (arrAccount.length - 1)) {
					writer.write("\r\n");
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Account> accountMap = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("MovieStreamingSystem/Register.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] arr = line.split("\t");
				Account newAccount = new Account();
				newAccount.setUserName(arr[0]);
				newAccount.setPassWord(arr[1]);
				newAccount.setfName(arr[2]);
				newAccount.setlName(arr[3]);
				newAccount.setDateOfBirth(arr[4]);
				newAccount.setGender(arr[5]);
				accountMap.put(newAccount.getUserName(), newAccount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Check user existed or not before write down into the file
	public static boolean userIsExisted(String userName) {

		Map<String, Account> accountMap = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("MovieStreamingSystem/Register.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] arr = line.split("\t");
				if (arr[0].equalsIgnoreCase(userName)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
}
