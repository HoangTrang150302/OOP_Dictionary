package Main;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainDictionary
{
    public static void main(String [] args) throws FileNotFoundException
    {
        Dictionary dictionary = new Dictionary();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Wait for the system to input database...");
        dictionary.insertFromFile();
        System.out.println("Done");

        do
        {
            System.out.println("____________________");
            System.out.println("MENU");
            System.out.println("1. Add word\n" +
                    "2. Delete word \n" +
                    "3. Find meaning of word\n" +
                    "4. Print all words\n" +
                    "5. Print number of words\n" +
                    "6. Delete all words\n" +
                    "7. Modify word\n" +
                    "0. Quit");

            System.out.println("Choose a number option from menu: ");

            choice = sc.nextInt();
            sc.nextLine();



            if(choice == 1)
            {
                dictionary.add_word();
            }
            else if(choice == 2 || choice == 3)
            {
                if(choice == 2)
                {
                    dictionary.deleteWord();
                }
                else
                {
                    dictionary.lookUp();
                }
            }
            else if(choice == 4)
            {
                dictionary.printAllWord();
            }
            else if(choice == 5)
            {
                dictionary.numberOfWord();
            }
            else if(choice == 6)
            {
                dictionary.deleteAll();
            }
            else if(choice == 7)
            {
                dictionary.modifyWord();
            }
        }
        while (choice != 0);
    }
}
