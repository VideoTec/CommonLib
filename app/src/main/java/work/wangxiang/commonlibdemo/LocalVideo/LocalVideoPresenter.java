package work.wangxiang.commonlibdemo.LocalVideo;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import work.wangxiang.rxmpv.PresenterBase;

/**
 * Video List Presenter
 * Created by wangxiang on 2018/3/3.
 */

public class LocalVideoPresenter
        extends PresenterBase<LocalVideoContract.Model, LocalVideoContract.View>
        implements LocalVideoContract.Presenter {
    private static final String TAG = "LocalVideoPresenter";

    @Override
    public void getVideoList() {
        model.getVideoList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LocalVideoBean>>() {

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
                        Log.e(TAG, "获取本地视频列表异常", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
