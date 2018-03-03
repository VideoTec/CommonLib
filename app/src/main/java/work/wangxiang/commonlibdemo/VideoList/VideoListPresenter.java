package work.wangxiang.commonlibdemo.VideoList;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import work.wangxiang.rxmpv.PresenterBase;

/**
 * Video List Presenter
 * Created by wangxiang on 2018/3/3.
 */

public class VideoListPresenter
        extends PresenterBase<VideoListContract.Model, VideoListContract.View>
        implements VideoListContract.Presenter {
    @Override
    public void getVideoList() {
        model.getVideoList().subscribe(new Observer<List<VideoBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(List<VideoBean> videoBeans) {
                view.updateVideoList(videoBeans);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
