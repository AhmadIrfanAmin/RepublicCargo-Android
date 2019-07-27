package com.logixcess.republiccargo.agent.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.agent.adapters.BoxesAdapter;
import com.logixcess.republiccargo.customer.activities.BoxesActivity;
import com.logixcess.republiccargo.models.Box;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickupLocationsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickupLocationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickupLocationsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PickupLocationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickupLocationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickupLocationsFragment newInstance(String param1, String param2) {
        PickupLocationsFragment fragment = new PickupLocationsFragment();
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
        getActivity().setTitle("Customers Locations");
        getActivity().setTitleColor(getActivity().getResources().getColor(R.color.white));
        //getActionBar().setIcon(R.drawable.my_icon);
    }

    Spinner sp_sort_types;
    RecyclerView rv_locations;
    ArrayList<Box> boxArrayList = new ArrayList<>();
    BoxesAdapter boxesAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pickup_locations, container, false);
        sp_sort_types = view.findViewById(R.id.sp_sort_types);
        rv_locations = view.findViewById(R.id.rv_locations);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,getResources().getStringArray(R.array.locations_sort_by));
        sp_sort_types.setAdapter(adapter);

        boxesAdapter = new BoxesAdapter(getActivity(),boxArrayList);//flights);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_locations.setLayoutManager(mLayoutManager);
        rv_locations.setItemAnimator(new DefaultItemAnimator());
        rv_locations.setAdapter(boxesAdapter);
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
