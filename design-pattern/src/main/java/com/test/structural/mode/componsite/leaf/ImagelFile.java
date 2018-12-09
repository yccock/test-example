package com.test.structural.mode.componsite.leaf;

import com.test.structural.mode.componsite.component.AbstractFile;

/**
 * /图像文件类：叶子构件
 */
public class ImagelFile extends AbstractFile {

    private String name;

    public ImagelFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile abstractFile) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(AbstractFile abstractFile) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对图像文件'"	+	name	+	"'进行杀毒");
    }
}
