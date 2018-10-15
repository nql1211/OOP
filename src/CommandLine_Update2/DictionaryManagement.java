package CommandLine_Update2;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.*;

public class DictionaryManagement {
    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word target: ");
        String target = scanner.nextLine();
        System.out.println("Word explain: ");
        String explain = scanner.nextLine();
        word newWord = new word(target, explain);
        Dictionary.wordArrayList.add(newWord);
    }

    public void insertFromFile() throws IOException {
        BufferedReader bufferedReader;
        FileReader fr = new FileReader("dictionaries.txt");
        bufferedReader = new BufferedReader(fr);
        String textInALine = bufferedReader.readLine();
        while (null != textInALine) {
            String[] words = textInALine.split("\\t");
            word newWord = new word(words[0], words[1]);
            Dictionary.wordArrayList.add(newWord);
            textInALine = bufferedReader.readLine();
        }
        bufferedReader.close();
        fr.close();

    }

    public void dictionaryLookup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tu can tra: ");
        String wordLookup = scanner.nextLine();
        for(word element: Dictionary.wordArrayList){
            if (element.getWord_target().equals(wordLookup))
                System.out.println(element.getWord_explain());
        }
    }
    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input word:");
        String word_del = sc.nextLine();
        for(word elementWord:Dictionary.wordArrayList){
            if(elementWord.getWord_target().equals(word_del)) {
                Dictionary.wordArrayList.remove(elementWord);
                System.out.println("Delete Complete!");
                break;
            }
        }
    }
    public void dictionaryExportToFile() throws IOException{
        FileWriter fw = new FileWriter("dictionaries.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for(word elementWord: Dictionary.wordArrayList){
            bw.write(elementWord.getWord_target() + "\t" + elementWord.getWord_explain() + "\n");
        }
        fw.close();
        bw.close();
        System.out.println("Sucessful!");
    }

}
