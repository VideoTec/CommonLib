package work.wangxiang.commonlibdemo.LocalVideo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import work.wangxiang.commonlibdemo.LocalVideo.LocalVideoBean;
import work.wangxiang.commonlibdemo.R;

/**
 * recycler view adapter
 * Created by wangxiang on 2018/2/28.
 */

public class LocalVideoListAdapter extends RecyclerView.Adapter<LocalVideoListAdapter.VideoItemView> {
    private static final String TAG = "LocalVideoListAdapter";
    private Context context;
    private List<LocalVideoBean> localVideos;

    public LocalVideoListAdapter(Context ctx) {
        context = ctx;
    }

    public void setLocalVideos(List<LocalVideoBean> videos) {
        localVideos = videos;
    }

    @Override
    public VideoItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoItemView(LayoutInflater.from(context), parent);
    }

    @Override
    public void onBindViewHolder(VideoItemView holder, int position) {
        holder.bind(localVideos.get(position));
    }

    @Override
    public int getItemCount() {
        return localVideos == null ? 0 : localVideos.size();
    }

    static class VideoItemView extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        VideoItemView(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_local_video, parent, false));
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @SuppressLint("SetTextI18n")
        void bind(LocalVideoBean videoBean) {
            textView.setText("video id: " + videoBean.getThumbID());
            if (videoBean.getThumb() != null) {
                imageView.setImageBitmap(videoBean.getThumb());
            } else {
                imageView.setImageResource(R.mipmap.ic_launcher_round);
            }
            Log.i(TAG, "缩略图ID: " + videoBean.getThumbID() + ": " + videoBean.getThumb());
        }
    }
}
