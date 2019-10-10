package homework04.finders;

import homework04.dto.File;
import homework04.dto.PatternFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder implements IFinder {
    private PatternFinder patternFinder;
    private File fileLocation;
    private String file;
    private int countOfWordsInFile;

    public Finder(PatternFinder patternFinder, File fileLocation) {
        this.patternFinder = patternFinder;
        this.fileLocation = fileLocation;
    }


    public void getInformationFromFile(String fileLocation){
        try {
            for (String line : Files.readAllLines(Paths.get(this.getFileLocation()))) {
                this.file += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCountOfWordsInFile(){
        Pattern p = Pattern.compile(this.getPatternFinder());
        Matcher m = p.matcher(this.file);

        while(m.find()) {
            countOfWordsInFile++;
        }

        return countOfWordsInFile;
    }

    public void viewCountOfWordsInFile(){
        System.out.println(this.countOfWordsInFile);
    }

    public String getFileLocation() {
        return fileLocation.getFileLocation();
    }

    public String getPatternFinder() {
        return patternFinder.getPatternSpecification();
    }
}
