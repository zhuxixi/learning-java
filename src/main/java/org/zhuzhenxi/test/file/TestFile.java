package org.zhuzhenxi.test.file;

public class TestFile {


    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            FileUtil.writeFile("number"+i);
        }

    }


}
