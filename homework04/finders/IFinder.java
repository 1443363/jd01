package homework04.finders;

public interface IFinder {
    void getInformationFromFile(String fileLocation);
    int getCountOfWordsInFile();
    void viewCountOfWordsInFile();
}
