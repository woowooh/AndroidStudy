package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.myapplication.R;


public class HomeFragment extends Fragment {
    String result_template = "result is:  ";
    EditText number_a;
    EditText number_b;
    TextView result;
    Button button;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        number_a = root.findViewById(R.id.text_home_input_a);
        number_b = root.findViewById(R.id.text_home_input_b);
        result = root.findViewById(R.id.add_result);
        button = root.findViewById(R.id.text_home_input_button);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String s = addTwo();
               String r = result_template + s;
               result.setText(r);
           }
        });
        return root;
    }

    public String addTwo() {
        int a = Integer.parseInt(number_a.getText().toString());
        int b = Integer.parseInt(number_b.getText().toString());
        return String.valueOf(a + b);
    }
}