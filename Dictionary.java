package TuDienTiengAnh;

import java.util.ArrayList;
import java.util.Optional;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<>();

    public ArrayList<Word> getWords() {
        return new ArrayList<>(words);  
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public boolean removeWord(String wordTarget) {
        return words.removeIf(w -> w.getWordTarget().equalsIgnoreCase(wordTarget));
    }

    public boolean updateWord(String wordTarget, String newMeaning) {
        Optional<Word> foundWord = words.stream()
            .filter(w -> w.getWordTarget().equalsIgnoreCase(wordTarget))
            .findFirst();
        foundWord.ifPresent(w -> w.setWordExplain(newMeaning));
        return foundWord.isPresent();
    }
}
