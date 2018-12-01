package com.test.bigfile.file;


import java.io.*;
import java.util.List;

public class FileWriteProcess {

    private BufferedWriter bufferedWriter = null;
    private OutputStreamWriter outputStreamWriter = null;
    private FileOutputStream fileOutputStream = null;

    public FileWriteProcess(String fileName, Boolean append) {
        try {
            fileOutputStream = new FileOutputStream(fileName, append);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(List<String> contents) {
        try {
            for (String content : contents){
                this.bufferedWriter.write(content);
                this.bufferedWriter.write("\n");
            }
            this.bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String content) {
        try {
            this.bufferedWriter.write(content);
            this.bufferedWriter.write("\n\r");
            this.bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy(){
        if (fileOutputStream != null){
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStreamWriter != null){
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bufferedWriter != null){
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
