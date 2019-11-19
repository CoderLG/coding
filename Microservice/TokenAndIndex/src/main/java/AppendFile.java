import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AppendFile {
    public static void appendFile(String fileName, String content,String username) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
            out.write(content +","+username+ "\r\n");
        }
    }
}
