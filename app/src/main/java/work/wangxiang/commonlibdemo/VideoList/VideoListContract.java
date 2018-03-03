package work.wangxiang.commonlibdemo.VideoList;

import java.util.List;

import io.reactivex.Observable;

/**
 * video list contract
 * Created by wangxiang on 2018/3/3.
 */

public class VideoListContract {
    public interface Model {
        Observable<List<VideoBean>> getVideoList();
    }
    public interface View {
        void updateVideoList(List<VideoBean> videos);
    }
    public interface Presenter {
        void getVideoList();
    }
}
