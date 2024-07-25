package TuDienTiengAnh;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine {
    private DictionaryManagement dictManager;

    public DictionaryCommandLine(DictionaryManagement dictManager) {
        this.dictManager = dictManager;
    }

    public void showAllWords() {
        ArrayList<Word> words = dictManager.getDictionary().getWords();
        words.sort((w1, w2) -> w1.getWordTarget().compareToIgnoreCase(w2.getWordTarget()));
        System.out.println("No | English | Vietnamese");
        int no = 1;
        for (Word word : words) {
            System.out.println(no + " | " + word.getWordTarget() + " | " + word.getWordExplain());
            no++;
        }
    }

    public void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the prefix to search: ");
        String prefix = scanner.nextLine();
        ArrayList<Word> results = new ArrayList<>();
        for (Word word : dictManager.getDictionary().getWords()) {
            if (word.getWordTarget().startsWith(prefix)) {
                results.add(word);
            }
        }
        System.out.println("Search results:");
        for (Word word : results) {
            System.out.println(word.getWordTarget() + ": " + word.getWordExplain());
        }
        scanner.close();
    }

    public void dictionaryBasic(int num) {
    	if(num == 1) {
    		dictManager.insertFromCommandLine();
    		return;
    	}
    	else if(num == 4) {
    		showAllWords();
    		return;
    	}
    }

    public void dictionaryAdvanced() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to the Dictionary Management System!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display All Words");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search by Prefix");
            System.out.println("[7] Import from File");
            System.out.println("[8] Export to File");
            System.out.print("Your action: ");

            int action = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (action) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    dictManager.insertFromCommandLine();
                    break;
                case 2:
                    System.out.print("Enter English word to remove: ");
                    String wordToRemove = scanner.nextLine();
                    dictManager.removeWord(wordToRemove);
                    break;
                case 3:
                    System.out.print("Enter English word to update: ");
                    String wordToUpdate = scanner.nextLine();
                    System.out.print("Enter new Vietnamese meaning: ");
                    String newMeaning = scanner.nextLine();
                    dictManager.updateWord(wordToUpdate, newMeaning);
                    break;
                case 4:
                    showAllWords();
                    break;
                case 5:
                    dictManager.dictionaryLookup();
                    break;
                case 6:
                    dictionarySearcher();
                    break;
                case 7:
                    System.out.print("Enter file path to import from: ");
                    String filePath = scanner.nextLine();
                    dictManager.insertFromFile(filePath);
                    break;
                case 8:
                    System.out.print("Enter file name to export to: ");
                    String fileName = scanner.nextLine();
                    dictManager.dictionaryExportToFile(fileName);
                    break;
                default:
                    System.out.println("Action not supported");
                    break;
            }
        }
        scanner.close();
    }

    public void addWord(String english, String vietnamese) {
        Word newWord = new Word(english, vietnamese);
        Dictionary dictionary = dictManager.getDictionary();
        dictionary.addWord(newWord);
        System.out.println("Word added successfully: " + english + ": " + vietnamese);
    }
}
