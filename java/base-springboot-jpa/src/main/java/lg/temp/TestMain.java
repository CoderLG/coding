package lg.temp;

/**
 * author: LG
 * date: 2020-01-07 10:00
 * desc:
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {

        String lockStr = "md5";
        int index = 0;
        synchronized (lockStr){
            index ++;
            if (index == 1){
                Thread.sleep(10000);
            }else
                Thread.sleep(1000);
            System.out.println(index + " --- "+lockStr);
        }
    }
}
