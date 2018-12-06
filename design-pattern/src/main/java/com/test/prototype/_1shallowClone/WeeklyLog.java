package com.test.prototype._1shallowClone;

import java.util.Date;

/**
 * 工作周报WeeklyLog：具体原型类
 */
public class WeeklyLog implements Cloneable{

    private String name;

    private Date date;

    private String content;

    private Attachment attachment;

    /* 浅复制 */
    @Override
    protected WeeklyLog clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("不支持复制");
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
