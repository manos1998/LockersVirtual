import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.io.IOException;

/**
 * FileLocker
 */
public class FileLocker {
    static String DIRECTORY;
    File folder_name;

    public  FileLocker() {
        DIRECTORY = System.getProperty("user.dir");
        folder_name = new File(DIRECTORY+"/files");
        if (!folder_name.exists())
            folder_name.mkdirs();
        System.out.println("DIRECTORY : "+ folder_name.getAbsolutePath());
    }

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

    /*********************************************************************/

    void addFile(String filename) throws IOException {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equalsIgnoreCase(file)) {
                System.out.println("File " + filename + " File is Already Present At" + folder_name);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+filename+" added to "+ folder_name);
    }

    void deleteFile(String filename) {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file) && filepath.delete()) {
                System.out.println("File " + filename + " deleted from " + folder_name);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String filename) {
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file)) {
                System.out.println("FOUND : File " + filename + " exists at " + folder_name);
                return;
            }
        }
        System.out.println("File NOT found (FNF)");
    }

    void showFiles() {
        if (folder_name.list().length==0)
            System.out.println("No File Present");
        else {
            String[] list = folder_name.list();
            System.out.println("The files in "+ folder_name +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }

    /**********************************************************************************/


    void mainMenu() { //Creating a Function Main for Accepting Main Menu
        System.out.println(MAIN_MENU);
        try(Scanner sc = new Scanner(System.in)){
        int option = sc.nextInt();
        switch(option){
            case 1: {
                System.out.println("Show Files & Main Menu");
                showFiles();
                mainMenu();
            }
            case 2: {
                secondMenu();
            }
            case 3: {
                System.out.println("Thank you for using our services");
                break;
            }
            default: mainMenu();
        }}
        catch(Exception e){
            System.out.println("Enter your options");
        }
    }

    void secondMenu() {
        System.out.println(SECOND_MENU);
        try (Scanner sc = new Scanner(System.in)) {
        char[] sec_opt = sc.nextLine().toUpperCase().trim().toCharArray(); //Value acceptance test Successful
        char secndry_opt = sec_opt[0];
        switch (secndry_opt) {
            case 'A':{
                System.out.println("\nFile is being added \n Enter File Name: \n" );
                String filename = sc.next().trim().toLowerCase();
                addFile(filename);
                // System.out.println("File Added with file name "+ filename);
                break;
            }
            case 'D': {
                System.out.println("\n File is being deleted \n Enter File Name: \n" );
                String filename = sc.next().trim();
                deleteFile(filename);
                // System.out.println("File Deleted with file name "+ filename);
                break;
            }
            case 'S': {
                System.out.println("\n File is being Search \n Enter File Name: \n" );
                String filename = sc.next().trim();
                searchFile(filename);
                // System.out.println("File is being search with file name "+ filename);
                break;
            }
            case 'M': {
                System.out.println("Going Back to Main Menu");
                mainMenu();
                break;
            }
            default:
                System.out.println("Please Enter Right Values Only");
            }
        secondMenu();
        }
        catch (Exception e){
            System.out.println("Enter your choice a,d,s,m");
            secondMenu();
        }
    }

    public static void main(String[] args) {
        System.out.println(FLASH_SCREEN);
        FileLocker F1 = new FileLocker(); // Creating an Instance
        F1.mainMenu(); //Calling main menu
    }

}