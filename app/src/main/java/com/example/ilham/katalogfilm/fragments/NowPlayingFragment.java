package com.example.ilham.katalogfilm.fragments;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilham.katalogfilm.R;
import com.example.ilham.katalogfilm.adapters.ListFilmAdapter;
import com.example.ilham.katalogfilm.entities.FilmItems;
import com.example.ilham.katalogfilm.utilities.TaskLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<FilmItems>> {

    private ListFilmAdapter nowPlayingFilmAdapter;
    @BindView(R.id.rv_now_playing)
    RecyclerView rvNowPlaying;

    public NowPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);

        // Init adapter before use to Recyclerview
        nowPlayingFilmAdapter = new ListFilmAdapter(getActivity());
        nowPlayingFilmAdapter.notifyDataSetChanged();

        // Recycleview Must setLayoutManager before use
        rvNowPlaying.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNowPlaying.setAdapter(nowPlayingFilmAdapter);

        getLoaderManager().initLoader(0, null, this);

        return view;
    }

    @Override
    public Loader<ArrayList<FilmItems>> onCreateLoader(int id, Bundle args) {
        return new TaskLoader(getActivity(), "", TaskLoader.NOW_PLAYING);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<FilmItems>> loader, ArrayList<FilmItems> data) {
        nowPlayingFilmAdapter.setmFilm(data);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<FilmItems>> loader) {
        nowPlayingFilmAdapter.setmFilm(null);
    }

}
