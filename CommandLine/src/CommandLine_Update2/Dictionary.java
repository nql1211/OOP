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


            while (true) {
                System.out.println("1:Add\n2:Delete\n3:LookUp\n4:Show all word\n5:Search\n6:Exit");
                System.out.println("Enter the number: ");
                int selection = sc.nextInt();
                if (selection < 1 || selection > 6)
                    System.out.println("Error!");
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
                    if (selection == 6)
                        break;
                }

            //dm.dictionaryExportToFile();
        }
}

