package homework04.dto;

public class WordForSearch {
    private String wordForSearch;
    private int count;

    public WordForSearch(String wordForSearch) {
        this.wordForSearch = wordForSearch;
    }

    public String getWordForSearch() {
        return wordForSearch;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }
}
