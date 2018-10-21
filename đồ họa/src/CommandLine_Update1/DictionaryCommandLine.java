package CommandLine_Update1;

import java.io.IOException;

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
}
