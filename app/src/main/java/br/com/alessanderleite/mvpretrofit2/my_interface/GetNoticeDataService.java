package br.com.alessanderleite.mvpretrofit2.my_interface;

import br.com.alessanderleite.mvpretrofit2.model.NoticeList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNoticeDataService {

    @GET("bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
    
}
