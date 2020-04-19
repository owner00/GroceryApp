package com.example.groceryapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.app.DialogFragment;

public class SampleDialogFragment extends DialogFragment  {


    public interface SampleDialogFragmentListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    SampleDialogFragmentListener listener;
    private View form=null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Verify that the host activity implements the callback interface
        try {
            //instantiate the SampleDialogFragmentLidtener so we can send events to the host
            listener = (SampleDialogFragmentListener)context;
        }
        catch (ClassCastException e) {
            //The activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()
                + " must implement SampleDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        form=
            getActivity().getLayoutInflater()
                         .inflate(R.layout.dialog, null);

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        return(builder.setTitle(R.string.dlg_title).setView(form)
                      .setIcon(R.drawable.add_grocery_item)
                      .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              listener.onDialogPositiveClick(SampleDialogFragment.this);
                          }
                      })
                      .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              listener.onDialogNegativeClick(SampleDialogFragment.this);
                          }
                      }).create());
    }

}
