package cn.ffb.base.app;

import android.os.Bundle;
import android.view.View;

import cn.ffb.base.BaseActivity;

/**
 * Created by lingfei on 2017/6/18.
 */
public class SampleActivity3 extends BaseActivity {
    private View mButton;

    @Override
    protected void onConfig(Config config) {
        super.onConfig(config);
        config.setSwipeBackWrapper(false);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_sample3;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        this.setTitle("第三个界面");
        this.mButton = this.getView(R.id.button);
        this.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishSharedElementActivity();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishSharedElementActivity();
    }
}
