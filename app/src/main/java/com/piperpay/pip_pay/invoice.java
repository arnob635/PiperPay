package com.piperpay.pip_pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.branch.referral.Branch;

public class invoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        // Initialize the Branch object
        Branch.getAutoInstance(this);
    }
}
