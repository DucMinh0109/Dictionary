package TuDienTiengAnh;

public class Word {
    private String wordTarget;  // Từ vựng tiếng anh
    private String wordExplain; //Giải thích tiếng việt

    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    public String getWordTarget() {
        return wordTarget;
    }
    
    public void setWordTarget(String wordTarget) {
    	this.wordTarget = wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }
    
    public void setWordExplain(String wordExplain) {
    	this.wordExplain = wordExplain;
    }
}
