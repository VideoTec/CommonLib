package work.wangxiang.commonlibdemo.LocalVideo;

import java.util.List;

import io.reactivex.Observable;

/**
 * video list contract
 * Created by wangxiang on 2018/3/3.
 */

public class LocalVideoContract {
    public interface Model {
        Observable<List<LocalVideoBean>> getVideoList();
    }
    public interface View {
        void updateVideoList(List<LocalVideoBean> videos);
    }
    public interface Presenter {
        void getVideoList();
    }
}
