package lg.dao;

import org.junit.Test;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 * author: LG
 * date: 2019-10-12 14:27
 * desc:
 */
public class Temp {

    @Test
    public void addCache() {
        String tt = "台湾省台北市万华区";
        System.out.println( tt.indexOf("f"));
        System.out.println(tt.substring(0,tt.indexOf("省")+1));
    }
}
