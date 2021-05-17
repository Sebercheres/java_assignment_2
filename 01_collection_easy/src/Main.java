import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu = 0, counter = 0;
		ArrayList<Integer> shareNumber = new ArrayList<Integer>();
		ArrayList<String> userName = new ArrayList<String>();
		while(menu != 4) {
			System.out.println(" _______      ___              _______  __   __  _______  ______    _______");
			System.out.println("|   _   |    |   |            |       ||  | |  ||   _   ||    _ |  |       |");
			System.out.println("|  |_|  |    |   |    ____    |  _____||  |_|  ||  |_|  ||   | ||  |     __|");
			System.out.println("|       |    |   |   |____|   | |_____ |       ||       ||   |_||_ |    |_");
			System.out.println("|   _  |  ___|   |            |_____  ||       ||       ||    __  ||     __|");
			System.out.println("|  |_|  ||       |             _____| ||   _   ||   _   ||   |  | ||    |__");
			System.out.println("|_______||_______|            |_______||__| |__||__| |__||___|  |_||_______| ");
			System.out.println("+======================+");
			System.out.println("+Options               +");
			System.out.println("+======================+");
			System.out.println("+1. Start Sharing      +");
			System.out.println("+2. Update Participant +");
			System.out.println("+3. Delete Participant +");
			System.out.println("+4. Close App          +");
			System.out.println("+======================+");
			System.out.println("Choice >> ");
			menu = scan.nextInt();
			scan.nextLine();
			if(menu == 1) {
				Integer shareTemp = null;
				String userTemp;
		        boolean isBoolean = false;
		        do {
		        	System.out.println("Input a number [0-100]: ");
		            try {
		                shareTemp = scan.nextInt();
		                isBoolean = true;
		            } catch (InputMismatchException hacukololo) {
		            	System.out.println("input must be numeric");
		                isBoolean = false;
		                scan.nextLine();
		            }
		        }while (!isBoolean || shareTemp <= 0 || shareTemp >= 100);
				do {
					System.out.println("Could you give me your username [5 - 20 Characters]? ");
					userTemp = scan.nextLine();
					if(userName.contains(userTemp)) {
						System.out.println("username has already been taken!!");
					}
				}while(userTemp.length() <=5 || userTemp.length() >= 20 || userName.contains(userTemp));
				userName.add(userTemp);
				shareNumber.add(shareTemp);
				counter++;
			}else if(menu == 2) {
				
				Integer input = null;
				
				if(counter == 0) {
					continue;
				}else{
					System.out.println("+===========================================+");
					System.out.println("+ Share List                                +");
					System.out.println("+===========================================+");
					for(int i = 1 ;i <= counter; i++) {
						System.out.printf("| %-3d | %-17s | %-2d |+\n",i,userName.get(i-1),shareNumber.get(i-1));
					}
					System.out.println("+===========================================+");
					boolean isBoolean = false;
			        while (!isBoolean || input < 0 || input > counter) {
			        	System.out.printf("Which participant you would like to update[1 - %d][0 to exit]?",counter);
			            try {
			                input= scan.nextInt();
			                isBoolean = true;
			            } catch (InputMismatchException haiya) {
			            	System.out.println("input must be numeric");
			                isBoolean = false;
			                scan.nextLine();
			            }
			        }
					if(input == 0 || input == -1) {
						continue;
					}else {
						int temp = 0;
						do {
							System.out.println("Input a number[0-100]: ");
							input = scan.nextInt();
						}while(temp<=1 || temp>=100);
						shareNumber.set(input-1,temp);
						System.out.println("Update Successful!");
						scan.nextLine();
					}
				}
				
			}else if(menu == 3) {
				Integer input = null;
				if(counter == 0) {
					continue;
				}else {
					boolean isBoolean = false;
			        while (!isBoolean || input < 0 || input > counter) {
						System.out.println("+===========================================+");
						System.out.println("+ Share List                                +");
						System.out.println("+===========================================+");
						for(int i = 1 ;i <= counter; i++) {
							System.out.printf("| %-3d | %-17s | %-2d |+\n",i,userName.get(i-1),shareNumber.get(i-1));
						}
						System.out.println("+===========================================+");
			        	System.out.printf("Which participant you would like to delete[1 - %d][0 to exit]?",counter);
			            try {
			                input= scan.nextInt();
			                isBoolean = true;
			            } catch (InputMismatchException haiya) {
			            	System.out.println("input must be numeric");
			                isBoolean = false;
			                scan.nextLine();
			            }
			        }
					if(input == 0) {
						continue;
					}else {
						userName.remove(input - 1);
						shareNumber.remove(input - 1);
						System.out.println("Participant succesfully removed from event");
						scan.nextLine();
					}
				}
			}else if(menu == 4) {
				System.out.println("Here's the completed share list");
				System.out.println("Remember, sharing is caring, happy sharing :D");
				System.out.println("+===========================================+");
				System.out.println("+ Share List                                +");
				System.out.println("+===========================================+");
				System.out.println("+ Username                 | Before | After +");
				System.out.println("+===========================================+");
				Collections.sort(userName);
				Collections.shuffle(shareNumber);
				ArrayList<Integer> shareNumberReverse = shareNumber;
				Collections.reverse(shareNumberReverse);
				for(int i=0 ; i<counter;i++) {
					System.out.printf("| %-25s | %-5d| %-5d|\n",userName.get(i),shareNumber.get(i),shareNumberReverse.get(i));
				}
				System.out.println("+===========================================+");
				scan.nextLine();
				break;
			}

		}
		scan.close();
	}

}
