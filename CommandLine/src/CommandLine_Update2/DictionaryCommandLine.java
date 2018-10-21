package CommandLine_Update2;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine {
    public void showAllWords(){
        int No = 1;
        System.out.println("No\t| English\t| Vietnamese ");
        for(word elementWord: Dictionary.wordArrayList){
            System.out.println(No + "\t| " + elementWord.getWord_target() + "\t| "  + elementWord.getWord_explain());
            No++;
        }
    }

    public void dictionaryBasic(){
        DictionaryManagement dcm = new DictionaryManagement();
        dcm.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        DictionaryManagement dcm = new DictionaryManagement();
        dcm.insertFromFile();
        showAllWords();
        dcm.dictionaryLookup();
    }

    public void dictionarySearcher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhạp tu:");
        String w = scanner.nextLine();
        for( word elementWord : Dictionary.wordArrayList){
            if(elementWord.getWord_target().substring(0, w.length()).equals(w)){
                System.out.println(elementWord.getWord_target());
            }
        }
    }
}
