package org.zhuzhenxi.test.file;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.zhuzhenxi.test.random.RandomUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
    public static List<String> readFile(String fileName){
        File file = new File("/Users/zhuzhenxi/Downloads/testfile/"+fileName+".csv");
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

        String[] fileContentArr = new String(filecontent).split("\n");

        List<String> stringList = Arrays.asList(fileContentArr);
        return stringList;

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
