package work.wangxiang.commonlibdemo.LocalVideo;

import android.graphics.Bitmap;
import android.provider.MediaStore;

import work.wangxiang.common.android.utils.App;

/**
 * video file bean
 * Created by wangxiang on 2018/2/28.
 */

public class LocalVideoBean {
    private long videoID;
    private long thumbID;
    private String videoPath;
    private Bitmap thumb;

    LocalVideoBean(long videoID, long thumbID, String path) {
        this.videoID = videoID;
        this.thumbID = thumbID;
        this.videoPath = path;
        this.thumb = null;
    }

    public long getVideoID() {
        return videoID;
    }

    public void setVideoID(long videoID) {
        this.videoID = videoID;
    }

    public long getThumbID() {
        return thumbID;
    }

    public void setThumbID(long thumbID) {
        this.thumbID = thumbID;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Bitmap getThumb() {
        if (thumb == null) {
            thumb = MediaStore.Video.Thumbnails.getThumbnail(App.getCtx().getContentResolver(),
                    thumbID, MediaStore.Video.Thumbnails.MICRO_KIND, null);
        }
        return thumb;
    }

    public void setThumb(Bitmap thumb) {
        this.thumb = thumb;
    }
}
