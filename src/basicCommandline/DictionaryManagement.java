package basicCommandline;

import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word target: ");
        String target = scanner.nextLine();
        System.out.println("Word explain: ");
        String explain = scanner.nextLine();
        word newWord = new word(target, explain);
        Dictionary.wordArrayList.add(newWord);

    }
}