package org.zhuzhenxi.test.file;

import org.zhuzhenxi.test.random.RandomUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * 读文件工具类
 */
public class FileUtil {
    public static List<String> readFile(String fileName){
        File file = new File("/Users/zhuzhenxi/Downloads/testfile/"+fileName+".csv");
        Long fileLength = file.length(); // 获取文件长度
        byte[] filecontent = new byte[fileLength.intValue()];
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