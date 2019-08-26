package rember.remotesubmit;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 远程通过ssh
 * 走ssh 协议
 * 提交submit
 */
public class SSHSubmit {

    private Connection conn;
    private String ipAddr;
    private String charset = Charset.defaultCharset().toString();
    private String userName;
    private String password;

    public SSHSubmit(String ipAddr, String userName, String password, String charset) {
        this.ipAddr = ipAddr;
        this.userName = userName;
        this.password = password;
        if(charset !=null){
            this.charset = charset;
        }
    }
    public boolean login() throws IOException {
        conn = new Connection(ipAddr);
        //连接
        conn.connect();
        //认证
        return  conn.authenticateWithPassword(userName,password);
    }

    public String exec(String cmds) {
        InputStream in = null;
        String result = "";
        try {
            if(this.login()){
                //打开一个会话
                Session session = conn.openSession();
                session.execCommand(cmds);
                in = session.getStdout();
                result = this.processStdout(in,this.charset);
                conn.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String processStdout(InputStream in, String charset) {
        byte[]  buffer = new byte[1024];
        StringBuffer sb = new StringBuffer();
        try {
            while (in.read(buffer)!=-1){
                sb.append(new String(buffer,charset));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  sb.toString();
    }

    public static void main(String[] args) {

       // SSHSubmit rst = new SSHSubmit("192.168.4.226","root","htxt`12","utf-8");
        SSHSubmit rst = new SSHSubmit("192.168.5.141","root","123456","utf-8");

     //  System.out.println(rst.exec("ls /opt/"));
        System.out.println(rst.exec("spark-submit --master yarn-cluster --name testPI  --class org.apache.spark.examples.SparkPi  /opt/spark-2.3.1-bin-hadoop2.7/examples/jars/spark-examples_2.11-2.3.1.jar 10"));
        //System.out.println(rst.exec("spark-submit --master yarn --deploy-mode cluster  --name tt --class cn.test.Short /opt/did_1.0/did/DiD/testShort.jar"));
       // System.out.println(rst.exec("/opt/spark-2.3.1-bin-hadoop2.7/bin/run-example SparkPi"));



    }

}
