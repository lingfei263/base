package cn.ffb.base.app;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.ffb.adapter.core.ViewHolder;
import cn.ffb.adapter.list.ItemViewProvider2;
import cn.ffb.adapter.list.ListAdapter;
import cn.ffb.base.BaseActivity;

/**
 * Created by lingfei on 2017/6/18.
 */

public class SampleActivity4 extends BaseActivity {

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        ListView listView = this.getView(R.id.listview);
        RadioGroupAdapter adapter = new RadioGroupAdapter(this);
        adapter.setListData(getDataList());
        listView.setAdapter(adapter);
    }

    private List<String> getDataList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("item" + i);
        }
        return list;
    }

    public static class RadioGroupAdapter extends ListAdapter<String> {
        private SparseArray<Integer> mapper = new SparseArray<>();
        private final static SparseArray<Integer> radios = new SparseArray<>();

        public RadioGroupAdapter(Context context) {
            super(context);

            radios.put(R.id.rb_a, 0);
            radios.put(R.id.rb_b, 1);
            radios.put(R.id.rb_c, 2);
            radios.put(R.id.rb_d, 3);

            this.register(new ItemViewProvider2<String>() {
                @Override
                public int getItemViewLayoutId() {
                    return R.layout.listitem_radiogroup;
                }

                @Override
                public void setupView(ViewHolder viewHolder, final int position, String entity) {
                    Integer checkPosition = mapper.get(position);
                    RadioGroup radioGroup = viewHolder.getView(R.id.rb);
                    radioGroup.setTag(position);

                    if (!viewHolder.isRecycler()) {
                        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                int _position = (int) group.getTag();
                                if (checkedId != -1) {
                                    mapper.put(_position, radios.get(checkedId));
                                } else {
                                    mapper.remove(_position);
                                }
                            }
                        });
                    }

                    if (checkPosition != null) {
                        radioGroup.check(radios.keyAt(mapper.get(checkPosition)));
                    } else {
                        radioGroup.clearCheck();
                    }
                    viewHolder.setText(R.id.textView, entity);
                }

                @Override
                public boolean isForProvider(int position, String entity) {
                    return true;
                }
            });
        }


    }
}
