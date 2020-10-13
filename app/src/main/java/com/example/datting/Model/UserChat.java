package com.example.datting.Model;

public class UserChat {
    int imgUserChat, imgChamXanh;
    String nameUserChat;
    String textUserChat;
    String timeUserChat;
    String numberUserChat;

    public UserChat(int imgUserChat, int imgChamXanh, String nameUserChat, String textUserChat, String timeUserChat, String numberUserChat) {
        this.imgUserChat = imgUserChat;
        this.imgChamXanh = imgChamXanh;
        this.nameUserChat = nameUserChat;
        this.textUserChat = textUserChat;
        this.timeUserChat = timeUserChat;
        this.numberUserChat = numberUserChat;
    }

    public int getImgUserChat() {
        return imgUserChat;
    }

    public void setImgUserChat(int imgUserChat) {
        this.imgUserChat = imgUserChat;
    }

    public int getImgChamXanh() {
        return imgChamXanh;
    }

    public void setImgChamXanh(int imgChamXanh) {
        this.imgChamXanh = imgChamXanh;
    }

    public String getNameUserChat() {
        return nameUserChat;
    }

    public void setNameUserChat(String nameUserChat) {
        this.nameUserChat = nameUserChat;
    }

    public String getTextUserChat() {
        return textUserChat;
    }

    public void setTextUserChat(String textUserChat) {
        this.textUserChat = textUserChat;
    }

    public String getTimeUserChat() {
        return timeUserChat;
    }

    public void setTimeUserChat(String timeUserChat) {
        this.timeUserChat = timeUserChat;
    }

    public String getNumberUserChat() {
        return numberUserChat;
    }

    public void setNumberUserChat(String numberUserChat) {
        this.numberUserChat = numberUserChat;
    }
}
