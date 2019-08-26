package me.HDFS;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * author: LG
 * date: 2019-07-08 14:26
 * desc:
 */
public class ReadHDdfs {
    public static void main(String[] args) throws Exception {


        String path = "hdfs://192.168.5.141:8020/did/taskengine/APP-PATH-e5ee8801-69ae-4554-bb4b-99df2ba74fe0/d7694710-0139-f1b0-ce57-e0e96a275f30/33121bdd-5fc7-4f8e-91b9-20603480e6ac/file" ;

        Configuration conf = new Configuration();
        FileSystem fs = null;
        try {
            conf.set("fs.defaultFS", "hdfs://nobida122:8020");
            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
            conf.set("ipc.client.connect.max.retries.on.timeouts", "5");
            conf.set("fs.hdfs.impl",   org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());

          /*  if (EngineConfigConstants.security.equals("kerberos")) {
                conf.addResource(new Path(EngineConfigConstants.confPath + "/core-site.xml"));
                conf.addResource(new Path(EngineConfigConstants.confPath + "/hdfs-site.xml"));
                conf.addResource(new Path(EngineConfigConstants.confPath + "/yarn-site.xml"));
                conf.addResource(new Path(EngineConfigConstants.confPath + "/mapred-site.xml"));
            }*/
            fs = FileSystem.get(URI.create("hdfs://192.168.5.141:8020"), conf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        FileStatus[] status = fs.listStatus(new Path(path));
        for (FileStatus file : status) {
//            if (!file.getPath().getName().startsWith("newsMap")) {
//                continue;
//            }
//            FSDataInputStream hdfsInStream = fs.open(file.getPath());
//            InputStreamReader isr = new InputStreamReader(hdfsInStream, "utf-8");
//            BufferedReader br = new BufferedReader(isr);
//            String line;
//            // int k = 0;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
            System.out.println(file.getPath().getName());

        }
    }
}
