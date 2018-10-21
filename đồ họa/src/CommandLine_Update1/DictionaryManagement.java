package CommandLine_Update1;

import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        int num_word = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num_word; i++) {
            String target = scanner.nextLine();
            String explain = scanner.nextLine();
            word newWord = new word(target, explain);
            Dictionary.wordArrayList.add(newWord);
        }
    }

    public void insertFromFile() throws IOException {
            FileReader fr = new FileReader("dictionaries.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);
            String textInALine = bufferedReader.readLine();
            while (null != textInALine){
                String[] words = textInALine.split("\\t");
                word newWord = new word(words[0], words[1]);
                Dictionary.wordArrayList.add(newWord);
                textInALine = bufferedReader.readLine();
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