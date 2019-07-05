package com.example.examplesqlite;

import android.content.Context;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateUpdateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CreateUpdateFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public CreateUpdateFragment() {
        // Required empty public constructor
    }

    private EditText etTitle, etMessage;
    private Spinner spGrade;
    private Button btnAction;

    private Calendar cDate;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_update, container, false);
        // Inflate the layout for this fragment

        etTitle = view.findViewById(R.id.editText_title);
        spGrade = view.findViewById(R.id.spinner_grade);
        btnAction = view.findViewById(R.id.button_date);
        etMessage = view.findViewById(R.id.editText_message);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                Objects.requireNonNull(getContext()),
                R.array.grade,
                android.R.layout.simple_spinner_item
        );
        spGrade.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
