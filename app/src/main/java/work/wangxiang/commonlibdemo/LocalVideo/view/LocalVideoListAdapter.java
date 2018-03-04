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

import com.bumptech.glide.Glide;

import java.io.File;
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

    class VideoItemView extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView ivFromId;
        private ImageView ivFromPath;

        VideoItemView(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_local_video, parent, false));
            textView = itemView.findViewById(R.id.textView);
            ivFromId = itemView.findViewById(R.id.iv_thumb_from_id);
            ivFromPath = itemView.findViewById(R.id.iv_thumb_from_path);
        }

        @SuppressLint("SetTextI18n")
        void bind(LocalVideoBean videoBean) {
            File thumbFile = new File(videoBean.getThumbPath());
            textView.setText("video id: " + videoBean.getThumbPath() + "; 是否存在: " + thumbFile.exists());
            if (videoBean.getThumb() != null) {
                ivFromId.setImageBitmap(videoBean.getThumb());
            } else {
                ivFromId.setImageResource(R.mipmap.ic_launcher_round);
            }
            Glide.with(LocalVideoListAdapter.this.context)
                    .load(new File(videoBean.getThumbPath()))
                    .into(ivFromPath);
            Log.i(TAG, "缩略图ID: " + videoBean.getThumbID() + ": " + videoBean.getThumb());
        }
    }
}
