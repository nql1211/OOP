package CommandLine_Update1;

import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    public static ArrayList<word> wordArrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        DictionaryCommandLine dcc = new DictionaryCommandLine();
        dcc.dictionaryAdvanced();
    }
}
