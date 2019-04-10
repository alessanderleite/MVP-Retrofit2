package br.com.alessanderleite.mvpretrofit2.main_activity;

import java.util.ArrayList;

import br.com.alessanderleite.mvpretrofit2.model.Notice;

public interface MainContract {

    interface presenter {
        void onDestroy();
        void onRefreshButtonClick();
        void requestDataFromServer();
    }

    interface MainView {
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(ArrayList<Notice> noticeArrayList);
        void onResponseFailure(Throwable throwable);
    }

    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Notice> noticeArrayList);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}
