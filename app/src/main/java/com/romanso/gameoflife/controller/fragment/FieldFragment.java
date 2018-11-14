package com.romanso.gameoflife.controller.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romanso.gameoflife.R;
import com.romanso.gameoflife.model.asynctask.GameStepWaiterTask;
import com.romanso.gameoflife.model.game.GameEngine;
import com.romanso.gameoflife.view.FieldView;

public class FieldFragment extends Fragment {

    private FieldView mFieldView;
    private GameEngine mGameEngine;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_field, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFieldView = getView().findViewById(R.id.field_fieldview);
        mGameEngine = new GameEngine(60);

        mFieldView.setGameEngine(mGameEngine);

        GameStepWaiterTask gameStepWaiterTask = new GameStepWaiterTask(mGameEngine);
        gameStepWaiterTask.execute();
    }
}
