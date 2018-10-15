package basicCommandline;

import java.util.ArrayList;
public class Dictionary {
    public static ArrayList<word> wordArrayList = new ArrayList<>();

    public static void main(String[] args) {
        DictionaryCommandline dcc = new DictionaryCommandline();
        dcc.dictionaryBasic();
    }
}