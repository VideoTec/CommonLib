package work.wangxiang.commonlibdemo.LocalVideo;

import android.database.Cursor;
import android.provider.MediaStore;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import work.wangxiang.common.android.utils.App;


/**
 * video list module
 * Created by wangxiang on 2018/3/3.
 */

public class LocalVideoModel implements LocalVideoContract.Model {
    @Override
    public Observable<List<LocalVideoBean>> getVideoList() {
        return Observable.create(e -> {
            List<LocalVideoBean> videos = new LinkedList<>();
            Cursor cr = App.getCtx().getContentResolver().query(
                    MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                    new String[] {MediaStore.Video.Thumbnails.VIDEO_ID},
                    null, null, null);
            if(cr != null) {
                if (cr.moveToFirst()) {
                    do {
                        videos.add(new LocalVideoBean(cr.getLong(0), "path"));
                    } while (cr.moveToNext());
                }
                cr.close();
            }
            e.onNext(videos);
            e.onComplete();
        });
    }
}
