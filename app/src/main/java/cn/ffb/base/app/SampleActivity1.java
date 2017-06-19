package cn.ffb.base.app;

import android.os.Bundle;

import cn.ffb.base.BaseActivity;

/**
 * Created by lingfei on 2017/6/18.
 */

public class SampleActivity1 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        this.setTitle("第二个界面");
        this.setFragmentContainer(R.id.main_fragment_container);
        this.addFragment(SampleFragment.class);
        this.changeFragment(0);
    }

}
