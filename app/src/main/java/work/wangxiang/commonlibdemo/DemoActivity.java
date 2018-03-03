package work.wangxiang.commonlibdemo;

import android.Manifest;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import work.wangxiang.commonlibdemo.VideoList.VideoBean;
import work.wangxiang.commonlibdemo.VideoList.VideoListContract;
import work.wangxiang.commonlibdemo.VideoList.VideoListModel;
import work.wangxiang.commonlibdemo.VideoList.VideoListPresenter;
import work.wangxiang.rxmpv.PresenterHolder;

public class DemoActivity extends AppCompatActivity
        implements VideoListContract.View {

    private static final String TAG = "DemoActivity";
    private PresenterHolder<VideoListModel, VideoListPresenter> presenterHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerViewLyMgr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLyMgr);

        recyclerViewAdapter = new MyAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        presenterHolder = new PresenterHolder<VideoListModel, VideoListPresenter>(this){};

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                presenterHolder.presenter().getVideoList();
            }
        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        } else {
            Cursor cr = getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Video.Thumbnails.DATA, MediaStore.Video.Thumbnails.VIDEO_ID},
                    null, null, null);
            if (cr != null) {
                Log.i(TAG, "video thumbnails count: " + cr.getCount());
                if (cr.moveToFirst()) {
                    for (int i = 0; i < cr.getCount(); i++) {
                        Log.i(TAG, cr.getString(0));
                        Log.i(TAG, "video: " + mediaStoreVideoPath(cr.getLong(1)));
                        cr.moveToNext();
                    }
                }
                cr.close();
            }
        }
    }

    private String mediaStoreVideoPath(long videoID) {
        String videoPath = "";
        Uri videoUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, videoID);
        Cursor cr = MediaStore.Video.query(getContentResolver(), videoUri,
                new String[]{MediaStore.Video.Media.DATA});
        if (cr != null) {
            if (cr.moveToFirst()) {
                cr.getLong(0);
                videoPath = cr.getString(0);
            }
            cr.close();
        }
        return videoPath;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLyMgr;

    @Override
    public void updateVideoList(List<VideoBean> videos) {
        for (VideoBean v : videos) {
            Log.i(TAG, v.getVideoPath());
        }
    }
}
