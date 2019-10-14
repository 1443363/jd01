package homework04.finders;

import homework04.dto.File;
import homework04.dto.WordForSearch;

public class SimpleWordFinder implements IFinder {
    private WordForSearch wordForSearch;
    private File file;

    public SimpleWordFinder(WordForSearch wordForSearch, File file) {
        this.wordForSearch = wordForSearch;
        this.file = file;
    }

    @Override
    public void countOfWordsInFile() {
       String fileInformation = file.getInformationFromFile().toLowerCase();
       String word = wordForSearch.getWordForSearch().toLowerCase();
       long index = fileInformation.indexOf(word);

       while(index >= 0) {
           wordForSearch.setCount(wordForSearch.getCount() + 1);
           index = fileInformation.indexOf(word);
       }

        System.out.println("Слово " + wordForSearch.getWordForSearch() + " встречается в тексте : "
                + wordForSearch.getCount() + " раз (Использовался обычный поиск по строке)");
    }
}
