package lg;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * author: LG
 * date: 2019-10-18 17:16
 * desc:
 */
public class TAI {
    public static void appendFile(String fileName, String content,String username) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
            out.write(content +","+username+ "\r\n");
        }
    }

}
