package work.wangxiang.commonlibdemo.LocalVideo;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/**
 * video list module
 * Created by wangxiang on 2018/3/3.
 */

public class LocalVideoModel implements LocalVideoContract.Model {
    @Override
    public Observable<List<LocalVideoBean>> getVideoList() {
        return Observable.create(e -> {
                List<LocalVideoBean> videos = new LinkedList<>();
                videos.add(new LocalVideoBean(0, "1"));
                videos.add(new LocalVideoBean(0, "2"));
                videos.add(new LocalVideoBean(0, "3"));
                videos.add(new LocalVideoBean(0, "4"));
                videos.add(new LocalVideoBean(0, "5"));
                videos.add(new LocalVideoBean(0, "6"));
                e.onNext(videos);
                e.onComplete();
        });
    }
}
