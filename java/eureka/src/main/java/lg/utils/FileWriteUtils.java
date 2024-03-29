package lg.utils;

import java.io.*;
import java.util.List;

/**
 * author: LG
 * date: 2019-10-16 11:16
 * desc:
 * 读写文件
 */
public class FileWriteUtils {

    public static void writeTiltName(){

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\admin\\Desktop\\tiltName.csv", true)))) {
            for(int i=100;i<=6000;i++){
                out.write("test"+i+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void streamWrite(){

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\admin\\Desktop\\user_10000.csv", true)))) {
            for(int i=10000;i<=10099;i++){
                out.newLine();
                out.write("test"+i+",SqxpDhhD89mcxtO0Gt/om85JvhnINp+m+yrDtSY+BBSOu8hMTG8terSAABFPZtyYE4PnpIitWpHhhkaFv7enVQ==");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(){
        //第一步：设置输出的文件路径
        //如果该目录下不存在该文件，则文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖。
        File writeFile = new File("F:\\user.csv");

        try{
            //第二步：通过BufferedReader类创建一个使用默认大小输出缓冲区的缓冲字符输出流
            BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));

            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            for(int i=100;i<=200;i++){
                writeText.newLine();    //换行
                //调用write的方法将字符串写到流中
                writeText.write("test"+i+",test"+i);

                //使用缓冲区的刷新方法将数据刷到目的地中
                if(i%150 == 0)
                writeText.flush();
            }

            //使用缓冲区的刷新方法将数据刷到目的地中
             writeText.flush();

            //关闭缓冲区，缓冲区没有调用系统底层资源，真正调用底层资源的是FileWriter对象，缓冲区仅仅是一个提高效率的作用
            //因此，此处的close()方法关闭的是被缓存的流对象
            writeText.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
    }

    public static void read(){
        //第一步：先获取csv文件的路径，通过BufferedReader类去读该路径中的文件
        File csv = new File("F:\\write3.csv");

        try{
            //第二步：从字符输入流读取文本，缓冲各个字符，从而实现字符、数组和行（文本的行数通过回车符来进行判定）的高效读取。
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            String lineDta = "";

            //第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出
            while ((lineDta = textFile.readLine()) != null){
                System.out.println(lineDta);
            }

            textFile.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }

    }
}
