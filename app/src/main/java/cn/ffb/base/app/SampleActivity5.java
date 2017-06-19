package cn.ffb.base.app;

import android.os.Bundle;
import android.view.View;

import cn.ffb.base.BaseActivity;
import cn.ffb.base.MessageEvent;

/**
 * Created by lingfei on 2017/6/18.
 */
public class SampleActivity5 extends BaseActivity {
    private View mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_sample5;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        this.setTitle("EventBus");
        this.mButton = this.getView(R.id.button);
        this.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageEvent(1, "接收到了一个消息");
            }
        });
    }

    @Override
    public void handleMainThreadMessage(MessageEvent event) {
        super.handleMainThreadMessage(event);
        this.showToast("当前界面" + event.obj.toString());
    }

    @Override
    protected void onConfig(Config config) {
        super.onConfig(config);
        config.setEventBusEnable(true);
    }
}
