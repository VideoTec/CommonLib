package work.wangxiang.commonlibdemo.VideoList;

import work.wangxiang.rxmpv.PresenterBase;

/**
 * Video List Presenter
 * Created by wangxiang on 2018/3/3.
 */

public class VideoListPresenter
        extends PresenterBase<VideoListContract.Model, VideoListContract.View>
        implements VideoListContract.Presenter{
    @Override
    public void getVideoList() {
        view.updateVideoList(model.getVideoList());
    }
}
