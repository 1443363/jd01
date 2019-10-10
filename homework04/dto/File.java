package homework04.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
    private String fileLocation;
    private String informationFromFile;

    public File(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getInformationFromFile(){
        try {
            for (String line : Files.readAllLines(Paths.get(fileLocation))) {
                informationFromFile += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return informationFromFile;
    }


}
