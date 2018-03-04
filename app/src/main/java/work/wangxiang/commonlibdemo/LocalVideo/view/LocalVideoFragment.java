package work.wangxiang.commonlibdemo.LocalVideo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import work.wangxiang.commonlibdemo.LocalVideo.LocalVideoBean;
import work.wangxiang.commonlibdemo.LocalVideo.LocalVideoContract;
import work.wangxiang.commonlibdemo.LocalVideo.LocalVideoModel;
import work.wangxiang.commonlibdemo.LocalVideo.LocalVideoPresenter;
import work.wangxiang.commonlibdemo.R;
import work.wangxiang.rxmpv.PresenterHolder;

/**
 * local video fragment
 * Created by wangxiang on 2018/3/4.
 */

public class LocalVideoFragment extends Fragment implements LocalVideoContract.View {
    private LocalVideoListAdapter videoListAdapter;
    private PresenterHolder<LocalVideoModel, LocalVideoPresenter> presenterHolder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterHolder = new PresenterHolder<LocalVideoModel, LocalVideoPresenter>(this){};
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_local_video, container, false);
        RecyclerView localVideoView = rootView.findViewById(R.id.rv_local_video_list);
        localVideoView.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoListAdapter = new LocalVideoListAdapter(getActivity());
        localVideoView.setAdapter(videoListAdapter);
        presenterHolder.presenter().getVideoList();
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenterHolder.onUIStop();
    }

    @Override
    public void updateVideoList(List<LocalVideoBean> videos) {
        videoListAdapter.setLocalVideos(videos);
        videoListAdapter.notifyDataSetChanged();
    }
}
