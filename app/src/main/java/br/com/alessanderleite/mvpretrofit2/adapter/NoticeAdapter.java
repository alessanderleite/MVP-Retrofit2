package br.com.alessanderleite.mvpretrofit2.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alessanderleite.mvpretrofit2.R;
import br.com.alessanderleite.mvpretrofit2.main_activity.RecyclerItemClickListener;
import br.com.alessanderleite.mvpretrofit2.model.Notice;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.EmployeeViewHolder> {

    private ArrayList<Notice> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public NoticeAdapter(ArrayList<Notice> dataList, RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtNoticeTitle.setText(dataList.get(position).getTitle());
        holder.txtNoticeBrief.setText(dataList.get(position).getBrief());
        holder.txtNoticeFilePath.setText(dataList.get(position).getFileSource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder{

        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNoticeTitle = itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief = itemView.findViewById(R.id.txt_notice_brief);
            txtNoticeFilePath = itemView.findViewById(R.id.txt_notice_file_path);
        }
    }
}
