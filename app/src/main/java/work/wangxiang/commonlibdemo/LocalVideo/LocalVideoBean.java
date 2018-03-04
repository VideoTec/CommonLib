package work.wangxiang.commonlibdemo.LocalVideo;

import android.graphics.Bitmap;

/**
 * video file bean
 * Created by wangxiang on 2018/2/28.
 */

public class LocalVideoBean {
    private long videoID;
    private String videoPath;
    private Bitmap thumb;

    public LocalVideoBean(long id, String path) {
        this.videoID = id;
        this.videoPath = path;
        this.thumb = null;
    }

    public long getVideoID() {
        return videoID;
    }

    public void setVideoID(long videoID) {
        this.videoID = videoID;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Bitmap getThumb() {
        return thumb;
    }

    public void setThumb(Bitmap thumb) {
        this.thumb = thumb;
    }
}
