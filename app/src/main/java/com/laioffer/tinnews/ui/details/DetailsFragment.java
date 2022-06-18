package com.laioffer.tinnews.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.FragmentDetailsBinding;
import com.laioffer.tinnews.databinding.FragmentSaveBinding;
import com.laioffer.tinnews.model.Article;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailsFragment() {
        // Required empty public constructor
    }


    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Article article = DetailsFragmentArgs.fromBundle(getArguments()).getArticle();
        binding.detailsTitleTextView.setText(article.title);
        binding.detailsAuthorTextView.setText(article.author);
        binding.detailsDateTextView.setText(article.publishedAt);
        binding.detailsDescriptionTextView.setText(article.description);
        binding.detailsContentTextView.setText(article.content);
        Picasso.get().load(article.urlToImage).into(binding.detailsImageView);
    }

}