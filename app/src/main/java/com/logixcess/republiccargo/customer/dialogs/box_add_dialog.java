package com.logixcess.republiccargo.customer.dialogs;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.interfaces.SaveNewBox;
import com.logixcess.republiccargo.models.Box;

public class box_add_dialog extends Dialog implements
        android.view.View.OnClickListener {
    SaveNewBox newBoxAdded;
    public Activity c;
    public Dialog d;
    public Button btn_add_box, btn_cancel_box;
    Box box;
    public box_add_dialog(Activity a, SaveNewBox svb) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.newBoxAdded = svb;
        box = new Box();
    }
    EditText
            et_sender_name,et_sender_address_text,et_sender_location_map,et_sender_contact_number,et_receiver_name,
            et_receiver_address_text,et_receiver_location_map,et_receiver_contact_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_box_dialog);
        et_sender_name = findViewById(R.id.et_sender_name);
        et_sender_address_text = findViewById(R.id.et_sender_address_text);
        et_sender_location_map = findViewById(R.id.et_sender_location_map);
        et_sender_contact_number = findViewById(R.id.et_sender_contact_number);
        et_receiver_name = findViewById(R.id.et_receiver_name);
        et_receiver_address_text = findViewById(R.id.et_receiver_address_text);
        et_receiver_location_map = findViewById(R.id.et_receiver_location_map);
        et_receiver_contact_number = findViewById(R.id.et_receiver_contact_number);
        btn_add_box = (Button) findViewById(R.id.btn_add_box);
        btn_cancel_box = (Button) findViewById(R.id.btn_cancel_box);
        btn_add_box.setOnClickListener(this);
        btn_cancel_box.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_box:
                box.setSender_phone(et_sender_contact_number.getText().toString());
                box.setSender_name(et_sender_name.getText().toString());
                box.setSender_address_map(et_sender_location_map.getText().toString());
                box.setSender_address(et_sender_address_text.getText().toString());
                box.setReceiver_phone(et_receiver_contact_number.getText().toString());
                box.setReceiver_name(et_receiver_name.getText().toString());
                box.setReceiver_address_map(et_receiver_location_map.getText().toString());
                box.setReceiver_address(et_receiver_address_text.getText().toString());
                newBoxAdded.addNewBox(box);
                dismiss();
                //c.finish();
                break;
            case R.id.btn_cancel_box:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
