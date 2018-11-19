package org.zhuzhenxi.test.file;

import com.alibaba.fastjson.JSONObject;
import org.zhuzhenxi.test.random.RandomUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
    public static void readFile(){
        File file = new File("/Users/zhuzhenxi/Downloads/controller.json");
        Long filelength = file.length(); // 获取文件长度
        byte[] filecontent = new byte[filelength.intValue()];
        try
        {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        String[] fileContentArr = new String(filecontent).split("\r\n");

        List<String> stringList = Arrays.asList(fileContentArr);
    }
    public static void writeFile(String fileName){
        File file2 = new File("/Users/zhuzhenxi/Downloads/testfile/"+fileName+".csv");
        Writer write = null;
        try {
            write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "UTF-8"));
            for (int i = 0; i < 100000; i++) {
                write.write(RandomUtil.generateRandomNumber() +"\n");
            }

            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(write != null){
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
