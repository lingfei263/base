package cn.ffb.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by lingfei on 2017/6/6.
 */

public final class ToolbarManager {
    private static int[] ATTRS = {R.attr.windowActionBarOverlay, R.attr.actionBarSize};
    private Context mContext;
    private View mToolbarView;
    private FrameLayout mContentView;
    private View mLayoutView;
    private Toolbar mToolbar;

    private ToolbarManager(Builder builder) {
        this.mContext = builder.context;
        this.mToolbarView = builder.toolbar;
        this.mLayoutView = builder.layoutView;

        mContentView = new FrameLayout(mContext);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView.setLayoutParams(params);
        mContentView.setFitsSystemWindows(true);

        this.addToolbar();
        this.addContentView();
    }

    private void addToolbar() {
        mToolbar = (Toolbar) mToolbarView.findViewById(R.id.toolbar);
        mContentView.addView(mToolbarView);
    }

    private void addContentView() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(ATTRS);
        boolean overly = typedArray.getBoolean(0, false);
        int toolBarSize = (int) typedArray.getDimension(1, (int) mContext.getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        params.topMargin = overly ? 0 : toolBarSize;
        mContentView.addView(mLayoutView, params);
    }

    public FrameLayout getContentView() {
        return mContentView;
    }

    public Toolbar getToolBar() {
        return mToolbar;
    }

    public static class Builder {
        private Context context;
        private View layoutView;
        private View toolbar;
        private LayoutInflater inflater;

        private Builder(Context context) {
            this.context = context;
            this.setContext(context);
        }

        public static Builder builder(Context context) {
            return new Builder(context);
        }

        public Builder setContext(Context context) {
            this.context = context;
            this.inflater = LayoutInflater.from(context);
            return this;
        }

        public Builder setToolbar(Toolbar toolbar) {
            this.toolbar = toolbar;
            return this;
        }

        public Builder setLayoutView(View layoutView) {
            this.layoutView = layoutView;
            return this;
        }

        public Builder setToolbar(int resId) {
            this.toolbar = this.inflater.inflate(resId, null, false);
            return this;
        }

        public Builder setLayoutView(int resId) {
            this.layoutView = this.inflater.inflate(resId, null, false);
            return this;
        }

        public ToolbarManager build() {
            return new ToolbarManager(this);
        }
    }

}
