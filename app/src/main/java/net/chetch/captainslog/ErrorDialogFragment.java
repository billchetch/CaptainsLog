package net.chetch.captainslog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ErrorDialogFragment extends AppCompatDialogFragment implements OnClickListener {

    private int errorType;
    private String errorMessage;
    private Dialog dialog;

    public ErrorDialogFragment(int errorType, String errorMessage){
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public int getErrorType(){ return errorType; }

    public boolean isErrorType(int errorType){
        return this.errorType == errorType;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout

        View contentView = inflater.inflate(R.layout.error_dialog, null);
        TextView details = (TextView)contentView.findViewById(R.id.errorDetails);
        details.setText(errorType + ": " + errorMessage);

        builder.setView(contentView)
                .setTitle(getString(R.string.app_name) + " error!");

        contentView.setOnClickListener(this);

        // Create the AlertDialog object and return it
        dialog = builder.create();

        return dialog;
    }

    @Override
    public void onClick(View v){
        dismiss();
    }


    public boolean isShowing(){
        return dialog != null ? dialog.isShowing() : false;
    }

}
