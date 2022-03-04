import java.util.Scanner;

/**
 * FileLocker
 */
public class FileLocker {

    private static final String FLASH_SCREEN = "Welcome to Locker We Keep your Privacy"; //Flash Screen like any other Apps
    private static final String MAIN_MENU =  // Main Menu
        "\n MAIN MENU \n" +
            "1 :- List of all file in Folder\n" +
            "2 :- ADD, DELETE or SEARCH FILES \n" + 
            "3 :- EXIT";
    private static final String SECOND_MENU = //Secondary Menu 
        "\n Select any of the Folllowing \n" + 
        " A:- Add the File in Folder \n" +
        " D:- Delete the File from Folder \n" + 
        " S:- Search the File in Folder \n"+
        " M:- Go to Main Menu";

    void mainMenu() { //Creating a Function Main for Accepting Main Menu
        System.out.println(MAIN_MENU);
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch(option){
            case 1: {
                System.out.println("Show Files & Main Menu");
                break;
            }
            case 2: {
                secondMenu();
                System.out.println("Second Menu");
                break;
            }
            case 3: {
                System.out.println("Thank you for using our services");
                break;
            }
            default: mainMenu();
        }
    }

    void secondMenu() {
        System.out.println(SECOND_MENU);
        Scanner sc = new Scanner(System.in);
        char[] sec_opt = sc.nextLine().toUpperCase().trim().toCharArray(); //Value acceptance test Successful
        System.out.println(sec_opt);
    }

    public static void main(String[] args) {
        System.out.println(FLASH_SCREEN);
        FileLocker F1 = new FileLocker(); // Creating an Instance
        F1.mainMenu(); //Calling main menu
    }

}