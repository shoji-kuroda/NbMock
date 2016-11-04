package com.github.shoji.nbmock.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.shoji.nbmock.R;

/**
 * Created by shoji.kuroda on 2016/09/06.
 */
public class TestFragment extends Fragment implements View.OnClickListener {
    private static final String KEY_CONTENT = "TestFragment:Content";
    ViewGroup header;

    public static TestFragment newInstance(int content) {
        TestFragment fragment = new TestFragment();
        fragment.content = content;

        return fragment;
    }

    private int content = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            content = savedInstanceState.getInt(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_test, container, false);
        header = (ViewGroup) layout.findViewById(R.id.header);
        switch (content) {
            case 1:
                header.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_blue_dark));
                break;
            case 2:
                header.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_dark));
                break;
            case 3:
                header.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_orange_dark));
                break;
            case 4:
                header.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_dark));
                break;
            default:
                header.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_purple));
                break;
        }
        header.setOnClickListener(this);
        this.header.setY((float)300.0);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTENT, content);
    }

    @Override
    public void onClick(View view) {
        this.header.bringToFront();
        this.header.setY((float)0);
    }
}
