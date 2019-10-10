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
       String word = wordForSearch.getwordForSearch().toLowerCase();
       long index = fileInformation.indexOf(word);
       int count = 0;

       while(index >= 0) {
           count++;
           index = fileInformation.indexOf(word);
       }

        System.out.println("Слово " + wordForSearch.getwordForSearch() + " встречается в тексте : "
                + count + " раз (Использовался обычный поиск по строке)");
    }
}
