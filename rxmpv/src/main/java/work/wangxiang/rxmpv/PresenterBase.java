package work.wangxiang.rxmpv;

/**
 * base presenter
 * 1. 持有 model 和 view 接口的实例
 * 2. 管理 RxJava 对象的集合
 *
 * Created by wangxiang on 2018/3/3.
 */

public class PresenterBase<M, V> {
    protected M model;
    protected V view;

    void setMV(M model, V view) {
        this.model = model;
        this.view = view;
    }

    void stop() {
    }
}
