package com.project.cl.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jiju.chat.R;
import com.project.cl.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by PC on 2017/4/28.
 */

public class FragmentChatList extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.id123)
    TextView textView;

    @Override
    public int getLayoutResId() {
        return  R.layout.fragment_chat_list;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initData() {
        textView.setText("FragmentChatList");
    }

    @Override
    public void configViews() {

    }
}
