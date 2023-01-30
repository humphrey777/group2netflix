
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ClassName: ${NAME} Package: Description:
 *
 * @Author: Yateng
 * @Create: ${DATE} - ${TIME}
 * @Version: v1.0
 */
public class MainUser {
	public static void main(String[] args) throws FileNotFoundException {
		MainUser.User();
	}

	public static void User() throws FileNotFoundException {
		Scanner enter = new Scanner(System.in);
		int choice = 0;

		System.out.println("Welcome to NetPlix");
		System.out.println("Please choose the option you want to do from the shown list:");
		System.out.println("1- Login\n" + "2- Register\n" + "3- Exit");
		choice = enter.nextInt();
		while (true) {
			// prompt users to choose one option
			if (choice == 1) {
				LogIn.Login();
				MainUser.AdminMainMenu();

			} else if (choice == 2) {
				Register.Register();
				LogIn.Login();
				MainUser.MainMenu();
			} else if (choice == 3) {
				System.out.println("Thank you for using NetPlix!!");
				System.exit(0);
			} else {
				System.out.println("Invalid Keyword!!");
				break;
			}
		}
	}

	public static void MainMenu() {
		Scanner enter = new Scanner(System.in);

		System.out.println("Please choose the option you want to do from the shown list:");
		System.out.println(
				"1- \n" + "2- \n" + "3- \n" + "4- Search User\n" + "5- Watch History\n" + "6- Exit the System");
		int option = enter.nextInt();
		switch (option) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			SearchingUser.SearchingUser();
			break;
		case 5:
			WatchHistoryCheck.watchHistoryMenu();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Input error, please input again.");
			break;
		}
	}

	public static void AdminMainMenu() throws FileNotFoundException {
		Scanner enter = new Scanner(System.in);

		System.out.println("Please choose the option you want to do from the shown list:");
		System.out.println("1- Adding Movie\n" + "2- Delete Movie\n" + "3- Edit Movie\n" + "4- Search Movie\n"
				+ "5- Search User\n" + "6- Exit the System");
		int option = enter.nextInt();
		switch (option) {
		case 1:
			AddingMovie.AddingMovie();
			break;
		case 2:
			DeleteMovie.deleteMovie();
			break;
		case 3:
			EditMovie.editMovie();
			break;
		case 4:
			SearchingMovie.SearchingMovie();
			break;
		case 5:
			SearchingUser.SearchingUser();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Input error, please input again.");
			break;
		}
	}
}
