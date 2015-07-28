package com.example.chenhongyuan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

<<<<<<< HEAD
import butterknife.Bind;
import butterknife.ButterKnife;

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
/**
 * Created by chenhongyuan on 15/7/9.
 */
public class ViewPagerFragment extends Fragment {
<<<<<<< HEAD
    @Bind(R.id.image_title) public ImageView imageView;
=======
    private ImageView imageView;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
<<<<<<< HEAD
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        ButterKnife.bind(this, view);
=======
        View view = inflater.inflate(R.layout.layout1, container, false);
        imageView = (ImageView)view.findViewById(R.id.image1);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        Picasso.with(getActivity())
                .load(getArguments().getString("ImageUri"))
                .into(imageView);
        return view;
    }
}
