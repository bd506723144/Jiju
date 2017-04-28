package com.jiju.chat.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.jiju.chat.R;
import com.jiju.chat.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by PC on 2017/4/28.
 */

public class FragmentContacts  extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    public int getLayoutResId() {
        return  R.layout.fragment_chat_list;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {

    }
}
