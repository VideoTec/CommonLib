package work.wangxiang.commonlibdemo.LocalVideo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.wangxiang.commonlibdemo.R;

/**
 * local video fragment
 * Created by wangxiang on 2018/3/4.
 */

public class LocalVideoFragment extends Fragment {
    private RecyclerView localVideoView;
    private LocalVideoListAdapter videoListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_local_video, container, false);
        localVideoView = (RecyclerView) rootView.findViewById(R.id.rv_local_video_list);
        localVideoView.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoListAdapter = new LocalVideoListAdapter(getActivity());
        localVideoView.setAdapter(videoListAdapter);
        return rootView;
    }
}
