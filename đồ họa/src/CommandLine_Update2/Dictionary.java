package CommandLine_Update2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
        public static ArrayList<word> wordArrayList = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            DictionaryManagement dm = new DictionaryManagement();
            DictionaryCommandLine dcl = new DictionaryCommandLine();
            dm.insertFromFile();
            System.out.println("1:Add\n2:Delete\n3:LookUp\n4:Show all word\n5:Search\n6:Exit");

            while (true) {
                int selection = sc.nextInt();
                switch (selection) {
                    case 1: {
                        dm.insertFromCommandline();
                        break;
                    }
                    case 2: {
                        dm.delete();
                        break;
                    }
                    case 3: {
                        dm.dictionaryLookup();
                        break;
                    }
                    case 4: {
                        dcl.showAllWords();
                        break;
                    }
                    case 5: {
                        dcl.dictionarySearcher();
                        break;
                    }
                    default:
                        break;
                }
                    if(selection == 6)
                        break;
            }
            //dm.dictionaryExportToFile();
        }
}

