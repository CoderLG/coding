package lg.temp;

import com.lg.utils.SystemUtils;

/**
 * author: LG
 * date: 2020-01-08 15:21
 * desc:
 */
public class SystemMain {
    public static void main(String[] args) {
        SystemUtils.getBaseSystem(1024*1024);
        SystemUtils.getSystemTotalThread();
    }
}
