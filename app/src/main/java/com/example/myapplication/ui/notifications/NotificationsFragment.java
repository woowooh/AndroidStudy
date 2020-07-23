package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.ui.adapters.ListViewAdapter;
import com.example.myapplication.ui.bean.ListViewData;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private View root;
    private RecyclerView mlistView;
    private ListViewAdapter mlistViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        notificationsViewModel =
//                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        root = inflater.inflate(R.layout.fragment_notifications, container, false);
        // 1. find view
        mlistView = root.findViewById(R.id.list_view);
        // set layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mlistView.setLayoutManager(linearLayoutManager);
        // set adapters
        mlistViewAdapter = new ListViewAdapter();
        mlistView.setAdapter(mlistViewAdapter);
        getData();
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }

    public void getData() {
        // request io
        List<ListViewData> listViewDataList = new ArrayList<>();
        int dataLength = 10;
        for (int i = 0; i < dataLength; i++) {
            ListViewData d = new ListViewData();
            d.title = String.valueOf(i);
            d.content = String.valueOf(i);
            listViewDataList.add(d);
        }
        updateUIbyData(listViewDataList);
    }

    public void updateUIbyData(List<ListViewData> listViewDataList) {
        mlistViewAdapter.setData(listViewDataList);
    }
}