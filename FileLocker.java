/**
 * FileLocker
 */
public class FileLocker {

    private static final String FLASH_SCREEN = "Welcome to Locker We Keep your Privacy";
    private static final String MAIN_MENU = 
        "\n MAIN MENU \n" +
            "1 :- List of all file in Folder\n" +
            "2 :- ADD, DELETE or SEARCH FILES \n" + 
            "3 :- EXIT";
    private static final String SECOND_MENU =
        "\n Select any of the Folllowing \n" + 
        " A:- Add the File in Folder \n" +
        " D:- Delete the File from Folder \n" + 
        " S:- Search the File in Folder \n"+
        " M:- Go to Main Menu";

    public static void main(String[] args) {
        System.out.println(FLASH_SCREEN);
        System.out.println(MAIN_MENU);
        System.out.println(SECOND_MENU);
    }
}