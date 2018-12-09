package com.test.structural.mode.componsite;

import com.test.structural.mode.componsite.component.AbstractFile;
import com.test.structural.mode.componsite.composite.Folder;
import com.test.structural.mode.componsite.leaf.ImagelFile;
import com.test.structural.mode.componsite.leaf.TextFile;
import com.test.structural.mode.componsite.leaf.VideoFile;

/**
 * Sunny软件公司欲开发一个杀毒(AntiVirus)软件，该软件既可以对某个文件夹(Folder)杀毒，也
 * 可以对某个指定的文件(File)进行杀毒。该杀毒软件还可以根据各类文件的特点，为不同类型
 * 的文件提供不同的杀毒方式，例如图像文件(ImageFile)和文本文件(TextFile)的杀毒方式就有所差异。
 */
public class Client {

    public static void main(String[] args) {
        //针对抽象构件编程
        AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3, folder4;
        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");
        folder4 = new Folder("视频文件");
        file1 = new ImagelFile("小龙女.jpg");
        file2 = new ImagelFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.doc");
        file5 = new VideoFile("笑傲江湖.rmvb");
        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);
        //从"Sunny的资料"节点开始进行杀毒操作
        folder1.killVirus();
    }
}
