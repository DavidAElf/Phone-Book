package phonebook;

import phonebook.Contact;
import java.util.Scanner;

public class Index {

	static int i = 0;
	public static Contact[] newUserList = new Contact[10];

	public static void main(String[] args) {

		System.out.println("\n\n     You are now entering my phonebook.\n\n");
		mainMenu();

	}

	public static Object mainMenu() {

		Scanner input = new Scanner(System.in);
		int menu = 0;
		String yesOrNo = "";

		// Already created accounts
		Contact newContact0 = new Contact("David", "A", "Elfrink", "100 H", "Villa", "MO", "98645", "6365912432");
		Contact newContact1 = new Contact("Brian", "T", "Jackson", "623 Getter", "Las Vegas", "NV", "97634",
				"3146231429");

		Contact[] newUserList = new Contact[10];
		newUserList[0] = newContact0;
		newUserList[1] = newContact1;

		do {
			System.out.println(" --------------------Menu--------------------");
			System.out.println("| 1.) Add new record                         |");
			System.out.println("| 2.) Delete a record                        |");
			System.out.println("| 3.) Update a record                        |");
			System.out.println("| 4.) Search Database                        |");
			System.out.println("| 5.) Quit                                   |");
			System.out.println("|--------------------------------------------|");
			System.out.println("| Please enter a number from the menu above. |");
			System.out.println(" --------------------------------------------");

			menu = input.nextInt();

			Contact temp;

			// Sorts the contacts as they are input
			for (int i = 0; i < newUserList.length; i++) {
				if (newUserList[i] != null) {
					for (int i2 = i + 1; i2 < newUserList.length; i2++) {
						if (newUserList[i2] != null) {
							if (newUserList[i2].toString().compareTo(newUserList[i].toString()) < 0) {
								temp = newUserList[i];
								newUserList[i] = newUserList[i2];
								newUserList[i2] = temp;
							}
						}
					}
				}
			}

			switch (menu) {

//***********************************************************************************************************************************************
// Creating a new contact
//***********************************************************************************************************************************************

			case 1:

				String userFirstName = "";
				String userMiddleName = "";
				String userLastName = "";
				String streetName = "";
				String city = "";
				String state = "";
				String zipCode = "";
				String phoneNumber = "";

				for (; i < 10;) {
					System.out.println(" --------------------------------------------------- ");
					System.out.println("|                    New Record:                    |");
					System.out.println(" --------------------------------------------------- ");
					System.out.println("Input your first name: ");
					userFirstName = input.next();
					System.out.println("Do you have a middle name?");
					yesOrNo = input.next();
					input.nextLine();
					yesOrNo = yesOrNo.toLowerCase();
					for (int i2 = 0; i2 < i2 + 1;) {
						if (yesOrNo.equals("yes")) {
							System.out.println("Input your middle name: ");
							userMiddleName = input.nextLine();
							i2 = i2 - 1;
						}
						if (yesOrNo.equals("no")) {
							userMiddleName = " ";
							i2 = i2 - 1;
						} else {
							if (yesOrNo.equals("yes"))
								i2 = i2 - 1;
							else {
								System.out.println("Invalid entry: Please enter yes or no.");
								yesOrNo = input.next();
								input.nextLine();
								yesOrNo = yesOrNo.toLowerCase();
								if (yesOrNo.equals("yes")) {
									System.out.println("Input your middle name: ");
									userMiddleName = input.nextLine();
									i2 = i2 - 1;
								}
								if (yesOrNo.equals("no")) {
									userMiddleName = " ";
									i2 = i2 - 1;
								} else {
									if (yesOrNo.equals("yes"))
										i2 = i2 - 1;
									else {
										System.out.println("Invalid entry again. Please restart program.");
										System.exit(0);
									}
								}
							}
						}
						System.out.println("Input your last name: ");
						userLastName = input.nextLine();

						// Retrieve the user's address
						System.out.println("Input your street name: ");
						streetName = input.nextLine();
						System.out.println("Input your city: ");
						city = input.nextLine();
						System.out.println("Input your state: ");
						System.out.println("(Abbriviate - For example: Missouri - MO");
						state = input.nextLine();
						state = state.toUpperCase();
						System.out.println("Input your zipcode: ");
						zipCode = input.nextLine();
						System.out.println("Input your phone number: ");
						phoneNumber = input.nextLine();

						// Creating a new contact from user input
						Contact newContact2 = new Contact(userFirstName, userMiddleName, userLastName, streetName, city,
								state, zipCode, phoneNumber);
						for (int i = 2; i < newUserList.length; i++) {
							if (newUserList[i] == null) {
								newUserList[i] = newContact2;
								break;
							}
						}
						break;
					}

					break;
				}
				System.out.println("\n\nPlease press enter to continue.");
				yesOrNo = input.nextLine();
				break;

//***********************************************************************************************************************************************
// Delete by phone number
//***********************************************************************************************************************************************

			case 2:

				System.out.println("Please input your phone number to find your information");

				String userSearch = input.next();
				input.nextLine();

				try {
					System.out.println("---------------------------------------------------");
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i].getPhoneNumber().equals(userSearch)) {
							System.out.println(newUserList[i].toString());
							System.out.println(" --------------------------------------------------- ");
							System.out.println("|*******Verify that this is your information.*******|");
							System.out.println(" --------------------------------------------------- ");
							System.out.println("Would you like to proceed in deleting?");
							yesOrNo = input.nextLine();
							yesOrNo.toLowerCase();
							if (yesOrNo.equals("no")) {
								break;
							}
							if (yesOrNo.equals("yes")) {
								newUserList[i] = null;
							}
						}
					}
				} catch (NullPointerException y) {

				}

				System.out.println("\n\nPlease press enter to continue.");
				yesOrNo = input.nextLine();
				break;

//***********************************************************************************************************************************************
// Updating a record
//***********************************************************************************************************************************************

			case 3:

				int updateMenu = 0;

				System.out.println("Please input your phone number.");
				userSearch = input.next();

				try {
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i].getPhoneNumber().equals(userSearch)) {
							System.out.println(
									"Hello " + newUserList[i].getUserFirstName() + ". What would you like to edit?");

							String[] tempString = newUserList[i].toString().split(", ");

							userFirstName = tempString[0];
							userMiddleName = tempString[1];
							userLastName = tempString[2];
							streetName = tempString[3];
							city = tempString[4];
							state = tempString[5];
							zipCode = tempString[6];
							phoneNumber = tempString[7];

							System.out.println(" ----------------Update Menu----------------- ");
							System.out.println("| 1.) First Name                             |");
							System.out.println("| 2.) Middle Name                            |");
							System.out.println("| 3.) Last Name                              |");
							System.out.println("| 4.) Phone Number                           |");
							System.out.println("| 5.) Address                                |");
							System.out.println("| 6.) Return to Main Menu                    |");
							System.out.println("|--------------------------------------------|");
							System.out.println("| Please enter a number from the menu above. |");
							System.out.println(" --------------------------------------------");

							updateMenu = input.nextInt();
							input.nextLine();

							switch (updateMenu) {

							// ******************************************************************************************************************************
							// Update first name
							// ******************************************************************************************************************************

							case 1:

								System.out.println("Input your new first name:");
								
								userFirstName = input.next();
								Contact update = new Contact(userFirstName, userMiddleName, userLastName, streetName,
										city, state, zipCode, phoneNumber);
								newUserList[i] = update;

								System.out.println("Your new information is:");
								System.out.println(newUserList[i].toString());
								System.out.println("---------------------------------------------------");
								break;

							// ******************************************************************************************************************************
							// Update middle name
							// ******************************************************************************************************************************

							case 2:

								System.out.println("Input your new middle name:");
								
								userMiddleName = input.nextLine();
								update = new Contact(userFirstName, userMiddleName, userLastName, streetName, city,
										state, zipCode, phoneNumber);
								newUserList[i] = update;

								System.out.println("Your new information is:");
								System.out.println(newUserList[i].toString());
								System.out.println("---------------------------------------------------");
								break;

							// ******************************************************************************************************************************
							// Update last name
							// ******************************************************************************************************************************

							case 3:

								System.out.println("Input your new last name:");
								
								userLastName = input.nextLine();
								update = new Contact(userFirstName, userMiddleName, userLastName, streetName, city,
										state, zipCode, phoneNumber);
								newUserList[i] = update;

								System.out.println("Your new information is:");
								System.out.println(newUserList[i].toString());
								System.out.println("---------------------------------------------------");
								break;

							// ******************************************************************************************************************************
							// Update phone number
							// ******************************************************************************************************************************

							case 4:

								System.out.println("Input your new phone number:");
								
								phoneNumber = input.next();
								update = new Contact(userFirstName, userMiddleName, userLastName, streetName, city,
										state, zipCode, phoneNumber);
								newUserList[i] = update;

								System.out.println("Your new information is:");
								System.out.println(newUserList[i].toString());
								System.out.println("---------------------------------------------------");
								break;

							// ******************************************************************************************************************************
							// Update address
							// ******************************************************************************************************************************

							case 5:

								System.out.println("Input your new address:\n");
								
								System.out.println("Street -");
								streetName = input.nextLine();
								System.out.println("City -");
								city = input.nextLine();
								System.out.println("State -");
								state = input.nextLine();
								state = state.toUpperCase();
								System.out.println("Zipcode -");
								zipCode = input.nextLine();
								update = new Contact(userFirstName, userMiddleName, userLastName, streetName, city,
										state, zipCode, phoneNumber);
								newUserList[i] = update;

								System.out.println("Your new information is:");
								System.out.println(newUserList[i].toString());
								System.out.println("---------------------------------------------------");
								break;

							// ******************************************************************************************************************************
							// Update first name
							// ******************************************************************************************************************************

							case 6:

								break;

							default:
								System.out.println("Invalid Input: Please reenter the update function and input 1-6");

							}

						}
					}
				} catch (NullPointerException getOuttaHere) {

				}

				System.out.println("\n\nPlease press enter to continue.");
				input.nextLine();
				yesOrNo = input.nextLine();
				break;

//***********************************************************************************************************************************************
// Search records
//***********************************************************************************************************************************************

			case 4:

				System.out.println("---------------------------------------------------");
				for (int i = 0; i < newUserList.length; i++) {
					if (newUserList[i] != null) {
						System.out.println(newUserList[i].toString());
						System.out.println("---------------------------------------------------");
					}
				}

				int menu2 = 0;

				System.out.println(" ----------------Search Menu----------------- ");
				System.out.println("| 1.) Existing Entry                         |");
				System.out.println("| 2.) First Name                             |");
				System.out.println("| 3.) Last Name                              |");
				System.out.println("| 4.) Full Name                              |");
				System.out.println("| 5.) Phone Number                           |");
				System.out.println("| 6.) City                                   |");
				System.out.println("| 7.) State                                  |");
				System.out.println("| 8.) Return to Main Menu                    |");
				System.out.println("|--------------------------------------------|");
				System.out.println("| Please enter a number from the menu above. |");
				System.out.println(" --------------------------------------------");
				menu2 = input.nextInt();

				switch (menu2) {

				// ******************************************************************************************************************************
				// Search existing entry
				// ******************************************************************************************************************************

				case 1:

					System.out.println("Please input your phone number to find your information");

					userSearch = input.next();

					try {
						for (int i = 0; i < newUserList.length; i++) {
							if (newUserList[i].getPhoneNumber().equals(userSearch)) {
								System.out.println(newUserList[i].toString());
							}
						}
					} catch (NullPointerException y) {

					}

					break;

				// ******************************************************************************************************************************
				// Search by first name
				// ******************************************************************************************************************************

				case 2:

					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							for (int i2 = i + 1; i2 < newUserList.length; i2++) {
								if (newUserList[i2] != null) {
									if (newUserList[i2].getUserFirstName()
											.compareTo(newUserList[i].getUserFirstName()) < 0) {
										temp = newUserList[i];
										newUserList[i] = newUserList[i2];
										newUserList[i2] = temp;
									}
								}
							}
						}
					}
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							System.out.println(newUserList[i].toString());
							System.out.println("---------------------------------------------------");
						}
					}
					break;

				// ******************************************************************************************************************************
				// Search by last name
				// ******************************************************************************************************************************

				case 3:

					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							for (int i2 = i + 1; i2 < newUserList.length; i2++) {
								if (newUserList[i2] != null) {
									if (newUserList[i2].getUserLastName()
											.compareTo(newUserList[i].getUserLastName()) < 0) {
										temp = newUserList[i];
										newUserList[i] = newUserList[i2];
										newUserList[i2] = temp;
									}
								}
							}
						}
					}
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							System.out.println(newUserList[i].toString());
							System.out.println("---------------------------------------------------");
						}
					}

					break;

				// ******************************************************************************************************************************
				// Search by full name
				// ******************************************************************************************************************************

				case 4:

					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							for (int i2 = i + 1; i2 < newUserList.length; i2++) {
								if (newUserList[i2] != null) {
									if (newUserList[i2].getUserFullName()
											.compareTo(newUserList[i].getUserFullName()) < 0) {
										temp = newUserList[i];
										newUserList[i] = newUserList[i2];
										newUserList[i2] = temp;
									}
								}
							}
						}
					}
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							System.out.println(newUserList[i].toString());
							System.out.println("---------------------------------------------------");
						}
					}

					break;

				// ******************************************************************************************************************************
				// Search by phone number
				// ******************************************************************************************************************************

				case 5:

					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							for (int i2 = i + 1; i2 < newUserList.length; i2++) {
								if (newUserList[i2] != null) {
									if (newUserList[i2].getPhoneNumber()
											.compareTo(newUserList[i].getPhoneNumber()) < 0) {
										temp = newUserList[i];
										newUserList[i] = newUserList[i2];
										newUserList[i2] = temp;
									}
								}
							}
						}
					}
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							System.out.println(newUserList[i].toString());
							System.out.println("---------------------------------------------------");
						}
					}

					break;

				// ******************************************************************************************************************************
				// Search by city
				// ******************************************************************************************************************************

				case 6:

					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							for (int i2 = i + 1; i2 < newUserList.length; i2++) {
								if (newUserList[i2] != null) {
									if (newUserList[i2].getCity().compareTo(newUserList[i].getCity()) < 0) {
										temp = newUserList[i];
										newUserList[i] = newUserList[i2];
										newUserList[i2] = temp;
									}
								}
							}
						}
					}
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							System.out.println(newUserList[i].toString());
							System.out.println("---------------------------------------------------");
						}
					}

					break;

				// ******************************************************************************************************************************
				// Search by state
				// ******************************************************************************************************************************

				case 7:

					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							for (int i2 = i + 1; i2 < newUserList.length; i2++) {
								if (newUserList[i2] != null) {
									if (newUserList[i2].getState().compareTo(newUserList[i].getState()) < 0) {
										temp = newUserList[i];
										newUserList[i] = newUserList[i2];
										newUserList[i2] = temp;
									}
								}
							}
						}
					}
					for (int i = 0; i < newUserList.length; i++) {
						if (newUserList[i] != null) {
							System.out.println(newUserList[i].toString());
							System.out.println("---------------------------------------------------");
						}
					}

					break;

				// ******************************************************************************************************************************
				// Reenters Main Menu
				// ******************************************************************************************************************************

				case 8:
					break;

				default:
					System.out.println("Invalid Input: Please reenter the search function and input 1-8");

				}

				System.out.println("\n\nPlease press enter to continue.");
				input.nextLine();
				yesOrNo = input.nextLine();
				break;

//***********************************************************************************************************************************************
// Exiting the program
//***********************************************************************************************************************************************

			case 5:
				System.exit(0);
				break;

//***********************************************************************************************************************************************
// Catch and loop if there is an incorrect input at mainMenu
//***********************************************************************************************************************************************

			default:
				System.out.println("You have now exited the program.");
				return mainMenu();

			}

		} while (menu != 5);

		return mainMenu();
	}

}
