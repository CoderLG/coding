package lg.utils;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 * author: LG
 * date: 2019-09-05 13:31
 * desc:
 */
@RestController
@Api(tags = "读取系统资源")
@Slf4j
public class OshiUtils {


    public static void checkSystem() {
        System.out.println("start");
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        System.out.println(os);
        log.info("检查 CPU...");
        CentralProcessor processor = hal.getProcessor();
        double[] loadAverage = processor.getSystemLoadAverage(3);
        System.out.println(loadAverage);
        System.out.println(loadAverage.clone().toString());
        System.out.println(loadAverage.length);
        System.out.println(loadAverage[0]);
        System.out.println(loadAverage[1]);
        System.out.println(loadAverage[2]);
    }


}
