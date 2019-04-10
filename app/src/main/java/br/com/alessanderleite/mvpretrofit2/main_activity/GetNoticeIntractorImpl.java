package br.com.alessanderleite.mvpretrofit2.main_activity;

import android.util.Log;

import br.com.alessanderleite.mvpretrofit2.model.NoticeList;
import br.com.alessanderleite.mvpretrofit2.my_interface.GetNoticeDataService;
import br.com.alessanderleite.mvpretrofit2.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNoticeIntractorImpl implements MainContract.GetNoticeIntractor {
    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {

        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        Call<NoticeList> call = service.getNoticeData();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
