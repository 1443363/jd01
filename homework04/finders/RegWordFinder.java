package homework04.finders;

import homework04.dto.File;
import homework04.dto.WordForSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegWordFinder implements IFinder {
    private WordForSearch wordForSearch;
    private File file;

    public RegWordFinder(WordForSearch wordForSearch, File file) {
        this.wordForSearch = wordForSearch;
        this.file = file;
    }

    public void countOfWordsInFile(){
        Pattern p = Pattern.compile("\\b" + wordForSearch.getWordForSearch() + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(file.getInformationFromFile());

        while(m.find()) {
            wordForSearch.setCount(wordForSearch.getCount() + 1);
        }

        System.out.println("Слово " + wordForSearch.getWordForSearch() + " встречается в тексте : "
                + wordForSearch.getCount() + " раз (Использовался поиск по строке при помощие регулярных выражений)");;
    }

}
