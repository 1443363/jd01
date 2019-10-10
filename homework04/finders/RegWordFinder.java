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
        int countOfWordsInFile = 0;
        Pattern p = Pattern.compile("\\b" + wordForSearch.getwordForSearch() + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(file.getInformationFromFile());

        while(m.find()) {
            countOfWordsInFile++;
        }

        System.out.println("Слово " + wordForSearch.getwordForSearch() + " встречается в тексте : "
                + countOfWordsInFile + " раз (Использовался поиск по строке при помощие регулярных выражений)");;
    }

}
