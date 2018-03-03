package work.wangxiang.commonlibdemo.VideoList;

import java.util.LinkedList;
import java.util.List;

/**
 * video list module
 * Created by wangxiang on 2018/3/3.
 */

public class VideoListModel implements VideoListContract.Model {
    @Override
    public List<VideoBean> getVideoList() {
        List<VideoBean> videos = new LinkedList<>();
        videos.add(new VideoBean(0, "1"));
        videos.add(new VideoBean(0, "2"));
        videos.add(new VideoBean(0, "3"));
        videos.add(new VideoBean(0, "4"));
        videos.add(new VideoBean(0, "5"));
        videos.add(new VideoBean(0, "6"));
        return videos;
    }
}
