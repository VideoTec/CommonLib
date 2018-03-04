package work.wangxiang.commonlibdemo.LocalVideo.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import work.wangxiang.commonlibdemo.R;

/**
 * recycler view adapter
 * Created by wangxiang on 2018/2/28.
 */

public class LocalVideoListAdapter extends RecyclerView.Adapter<LocalVideoListAdapter.VideoItemView> {
    private Context context;

    public LocalVideoListAdapter(Context ctx) {
        context = ctx;
    }

    @Override
    public VideoItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoItemView(LayoutInflater.from(context), parent);
    }

    @Override
    public void onBindViewHolder(VideoItemView holder, int position) {
        holder.bind(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class VideoItemView extends RecyclerView.ViewHolder {
        private TextView textView;

        VideoItemView(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_local_video, parent, false));
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        void bind(String text) {
            textView.setText(text);
        }
    }

    private static String[] dataSet = new String[]{
            "first","second","3","four","five"
    };
}
