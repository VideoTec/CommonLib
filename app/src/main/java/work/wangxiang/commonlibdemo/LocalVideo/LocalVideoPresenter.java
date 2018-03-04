package work.wangxiang.commonlibdemo.LocalVideo;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import work.wangxiang.rxmpv.PresenterBase;

/**
 * Video List Presenter
 * Created by wangxiang on 2018/3/3.
 */

public class LocalVideoPresenter
        extends PresenterBase<LocalVideoContract.Model, LocalVideoContract.View>
        implements LocalVideoContract.Presenter {
    @Override
    public void getVideoList() {
        model.getVideoList().subscribe(new Observer<List<LocalVideoBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(List<LocalVideoBean> localVideoBeans) {
                view.updateVideoList(localVideoBeans);
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
