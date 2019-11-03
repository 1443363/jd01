package homework09;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader implements IReader {
    @Override
    public void read() {
        try {
            FileInputStream fis = new FileInputStream("topStudentsFile.txt");
            DataInputStream reader = new DataInputStream(fis);
            System.out.println(reader.readUTF());
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
