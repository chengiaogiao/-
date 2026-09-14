package com.chenyinjie.com;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String content;
    private String sender;
    private String getter;
    private  String sendTime;
    private  String mesType;
    private  byte[] bts;
    private  int len;
    private  String dest;
    private  String src;

    public byte[] getBts() {
        return bts;
    }

    public void setBts(byte[] bts) {
        this.bts = bts;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

//    public Message(String content, String sender, String getter, String sendTime) {
//        this.content = content;
//        this.sender = sender;
//        this.getter = getter;
//        this.sendTime = sendTime;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
