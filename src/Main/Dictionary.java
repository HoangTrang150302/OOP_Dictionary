package Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    private Map<String, String> data = new TreeMap<>();

    public void add_word()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input keyword: ");
        String keyWord = sc.nextLine();
        System.out.println("Input meaning and end input with a character @ ");
        System.out.println("Input meaning: ");
        String meaning = "";

        while (!sc.hasNext("@"))
        {
            meaning += "\n";
            meaning += sc.nextLine();
        }
        data.put(keyWord, meaning);
    }

    public void insertFromFile() throws FileNotFoundException {
        Scanner sc = null;
        String keyWord = null;
        String meaning = null;
        int d = 0;
        try {
            sc = new Scanner(new FileReader("D:\\Nam_hai\\Semester_1\\OOP\\Project_Dictionary\\src\\dictionary109K.txt"));
            while (sc.hasNext()) {
                String in = sc.next();
                if (in.charAt(0) == '@' && meaning == null) {
                    meaning = in.substring(1);
                }
                else if (in.charAt(0) == '@' && meaning != null) {
                    data.put(meaning,keyWord);
                    meaning = in.substring(1);
                    d = 0;
                }
                else if (in.charAt(0) == '/') {
                    keyWord = in;
                    d = 1;
                }
                else {
                    if (in.charAt(0) == '*') keyWord += '\n' + in + " ";
                    else if (in.charAt(0) == '-' || in.charAt(0) == '=')
                    {
                        if (d == 0) meaning += ' ' + in;
                        else keyWord += '\n' + in;
                    }
                    else if (d == 0) meaning += " " + in;
                    else keyWord += " " + in;
                }
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        data.put(meaning,keyWord);
    }

    public void deleteWord()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which word you want to delete: ");
        String keyWord = sc.nextLine();
        data.remove(keyWord);
    }

    public void lookUp()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which word you want to search for: ");
        String keyWord = sc.nextLine();
        //sc.nextLine();
        String result = this.data.get(keyWord);
        System.out.println(result);
    }

    public void printAllWord()
    {
        Set<Map.Entry<String, String>> result = this.data.entrySet();
        int count = 1;
        for(String key : data.keySet())
        {
            System.out.println(count + " | " + key.toString() + " : " + data.get(key).toString());
            count++;
        }
    }

    public void numberOfWord()
    {
        int count = this.data.size();
        System.out.println("The total number of word is: " + count);
    }

    public void deleteAll()
    {
        this.data.clear();
        System.out.println("Delete all word");
    }

    public void modifyWord()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which word you want to modify: ");
        String keyWord = sc.nextLine();
        System.out.println("Input new meaning and end input with a character @ ");
        System.out.println("Input new meaning: ");
        String newMeaning = "";
        while (!sc.hasNext("@"))
        {
            newMeaning += "\n";
            newMeaning += sc.nextLine();
        }
        data.put(keyWord, newMeaning);
    }
}
