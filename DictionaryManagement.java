package CommandLine_Update1;

import java.util.Scanner;
import java.io.File;

public class DictionaryManagement {
    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        int num_word = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num_word; i++) {
            word newWord = new word();
            String target = scanner.nextLine();
            String explain = scanner.nextLine();
            newWord.setWord_target(target);
            newWord.setWord_explain(explain);
            Dictionary.wordArrayList.add(newWord);
        }
    }

    public void insertFromFile(){
        File file = new File("C:\\Users\\quang\\Documents\\OOP-Dictionary\\dictionaries.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                word newWord = new word();
                String target = scanner.next();
                String explain = scanner.nextLine();
                newWord.setWord_target(target);
                newWord.setWord_explain(explain);
                Dictionary.wordArrayList.add(newWord);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void dictionaryLookup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tu can tra: ");
        String wordLookup = scanner.nextLine();
        for(word elemet: Dictionary.wordArrayList){
            if (elemet.getWord_target().equals(wordLookup))
                System.out.println(elemet.getWord_explain());
        }
    }
}