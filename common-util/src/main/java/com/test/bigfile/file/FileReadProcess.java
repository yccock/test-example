package com.test.bigfile.file;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileReadProcess {

    /**
     * 传统IO读取数据，使用虚拟机堆内存
     * @param fileName
     * @param skipFirstLine
     * @return
     */
    public static List<String> readFileByLines(String fileName, boolean skipFirstLine) {
        long start = System.currentTimeMillis();
        List<String> list = new LinkedList<>();
        File file = new File(fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (skipFirstLine && i == 0) continue;
                if (line !=null && line.length() > 0) list.add(line);
            }
            System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
            System.out.println("list size:" + list.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    /**
     * 传统IO读取数据,指定缓冲区大小，性能较高
     * @param fileName
     */
    public static List<String> readFile(String fileName) {
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        try {
            fileInputStream = new FileInputStream(new File(fileName));
            fileChannel = fileInputStream.getChannel();
            int bufSize = 1024;
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufSize);
            byte[] bytes = new byte[bufSize];
            String tempString = null;
            while (fileChannel.read(byteBuffer) != -1) {//每次读2M到缓冲区
                int rSize = byteBuffer.position();
                byteBuffer.rewind();
                byteBuffer.get(bytes);
                byteBuffer.clear();
                tempString = new String(bytes, 0, rSize);
                int fromIndex = 0;
                int endIndex = 0;
                while ((endIndex = tempString.indexOf("\n", fromIndex)) != -1 ||
                        (endIndex = tempString.indexOf("\r", fromIndex)) != -1) {
                    String line = tempString.substring(fromIndex, endIndex);//换一行
                    if (line != null && line.length() > 0) {
                        list.add(line);
                        System.out.println(line);
                    }
                    fromIndex = endIndex + 1;
                }
            }
            System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
            System.out.println("list size:" + list.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 当逐行读写大文件，指定缓冲区
     * @param path
     * @return
     */
    public static List<String> largeFileIO(String path) {
        long start = System.currentTimeMillis();
        List<String> list = new LinkedList<>();
        BufferedInputStream bis = null;
        BufferedReader bufferedReader = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(path)));
            bufferedReader = new BufferedReader(new InputStreamReader(bis, "utf-8"), 2 * 1024 * 1024);// 5M缓存
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                list.add(line);
            }
            System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
            System.out.println("list size:" + list.size());
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    private static List<String> getInfoFromFileSystem(String fileName) {
        long start = System.currentTimeMillis();
        List<String> infoList = new ArrayList<String>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(fileName));
            int len = fis.available();
            byte[] buffer = new byte[len];
            fis.read(buffer, 0, len);
            String fileContent = new String(buffer);
            for(String infoStr : fileContent.split("\n")) {
                if (infoStr != null && infoStr.trim().length() > 0) {
                    infoList.add(infoStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
        System.out.println("list size:" + infoList.size());
        return infoList;
    }

    private static List<String> getInfoFromFileSystem2(String fileName) {
        long start = System.currentTimeMillis();
        List<String> infoList = new ArrayList<String>();
        FileInputStream fis = null;
        Scanner sc = null;
        try {
            fis = new FileInputStream(new File(fileName));
            sc = new Scanner(fis, "utf-8");
            while (sc.hasNext()){
                infoList.add(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) fis.close();
                if(sc != null) sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
        System.out.println("list size:" + infoList.size());
        return infoList;
    }

    private static List<String> getInfoFromFileSystem3(String fileName) {
        long start = System.currentTimeMillis();
        List<String> infoList = new ArrayList<String>();
        LineIterator iterator = null;
        try {
            iterator = FileUtils.lineIterator(new File(fileName), "utf-8");
            while (iterator.hasNext()){
                infoList.add(iterator.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            LineIterator.closeQuietly(iterator);
        }
        System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
        System.out.println("list size:" + infoList.size());
        return infoList;
    }

    private static List<String> getInfoFromFileSystem4(String fileName) {
        long start = System.currentTimeMillis();
        List<String> infoList = new ArrayList<String>();
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(new File(fileName));
            bufferedReader = new BufferedReader(reader, 10*1024*1024);
            while (bufferedReader.ready()){
                infoList.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cost time:" + (System.currentTimeMillis() - start)/1000);
        System.out.println("list size:" + infoList.size());
        return infoList;
    }

    public static void main(String[] args) {
//        List<String> list = FileProcess.readFile(args[0]);
//        List<String> list2 = FileProcess.readFileByLines(args[0], false);
//        List<String> list3 = FileProcess.largeFileIO(args[0]);

        List<String> list = FileReadProcess.getInfoFromFileSystem3("c:/test.jtl");
        System.out.println(list.size());
//        List<String> list2 = FileReadProcess.readFileByLines("c:/test.jtl", false);
//        List<String> list3 = FileReadProcess.largeFileIO("c:/test.jtl");

//        List<String> list4 = FileReadProcess.readFile(args[0]);
//        List<String> list5 = FileReadProcess.getInfoFromFileSystem(args[0]);

    }

}
