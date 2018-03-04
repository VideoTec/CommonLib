package work.wangxiang.commonlibdemo.LocalVideo.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import work.wangxiang.common.android.view.SingleFragmentActivity;

public class LocalVideoActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LocalVideoFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
