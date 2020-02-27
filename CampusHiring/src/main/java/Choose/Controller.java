package Choose;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public class Controller {

	public void getchoice(int choose, File file) throws IOException {

		switch (choose) {
		case 1:
			try {

			} catch (InputMismatchException e) {
				System.out.println("Wrong Input");
			}
			break;
		case 2:
			try {
			} catch (Exception e) {
				System.out.println("Wrong Input");
			}

			break;
		case 3:
			try {

			} catch (Exception e) {

				e.printStackTrace();
			}
			break;

		case 4:
			try {

			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Adios Amigo");
			System.exit(0);
		default:
			System.out.println("Wrong Option, Please select Correct Option");
		}
	}
}