package TuDienTiengAnh;

import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary;

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void addWord(String english, String vietnamese) {
        dictionary.addWord(new Word(english, vietnamese));
    }

    public void removeWord(String wordTarget) {
        boolean removed = dictionary.removeWord(wordTarget);
        if (!removed) {
            System.out.println("Word not found!");
        } else {
            System.out.println("Word removed successfully!");
        }
    }

    public void updateWord(String wordTarget, String newMeaning) {
        boolean updated = dictionary.updateWord(wordTarget, newMeaning);
        if (!updated) {
            System.out.println("Word not found for update!");
        } else {
            System.out.println("Word updated successfully!");
        }
    }

    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word to lookup: ");
        String wordTarget = scanner.nextLine();
        dictionary.getWords().stream()
            .filter(w -> w.getWordTarget().equalsIgnoreCase(wordTarget))
            .findFirst()
            .ifPresentOrElse(
                w -> System.out.println("Meaning: " + w.getWordExplain()),
                () -> System.out.println("Word not found!")
            );
        scanner.close();
    }

    public void insertFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\s+", 2);
                if (parts.length == 2) {
                    addWord(parts[0], parts[1]);
                }
            }
            System.out.println("Words imported successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void dictionaryExportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (Word word : dictionary.getWords()) {
                writer.println(word.getWordTarget() + " " + word.getWordExplain());
            }
            writer.flush();
            System.out.println("Words exported successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public void insertFromCommandLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of words to add: ");
        int numberOfGroups = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfGroups; i++) {
            System.out.print("Enter English words separated by commas: ");
            String englishInput = scanner.nextLine();
            System.out.print("Enter Vietnamese meanings separated by commas: ");
            String vietnameseInput = scanner.nextLine();

            String[] englishWords = englishInput.split(",\\s*");
            String[] vietnameseMeanings = vietnameseInput.split(",\\s*");

            if (englishWords.length != vietnameseMeanings.length) {
                System.out.println("Error: The number of English words and Vietnamese meanings do not match.");
                continue;
            }

            for (int j = 0; j < englishWords.length; j++) {
                addWord(englishWords[j], vietnameseMeanings[j]);
            }
        }
    }

}
