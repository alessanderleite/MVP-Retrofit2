package br.com.alessanderleite.mvpretrofit2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NoticeList {

    @SerializedName("notice_list")
    private ArrayList<Notice> noticeList;

    public NoticeList(ArrayList<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    public ArrayList<Notice> getNoticeArrayList() {
        return noticeList;
    }

    public void setNoticeArrayList(ArrayList<Notice> noticeArrayList) {
        this.noticeList = noticeArrayList;
    }
}
