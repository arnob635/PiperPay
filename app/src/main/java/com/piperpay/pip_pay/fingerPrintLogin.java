package com.piperpay.pip_pay;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class fingerPrintLogin extends AppCompatActivity {

    TextView mHeadingLabel;
    ImageView mFingerprintImage;
    TextView mParaLabel;
    private FingerprintManager fingerprintManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print_login);

        mHeadingLabel = (TextView) findViewById(R.id.headingLabel);
        mFingerprintImage = (ImageView) findViewById(R.id.fingerprintImage);
        mParaLabel = (TextView) findViewById(R.id.paraLabel);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

            if (!fingerprintManager.isHardwareDetected()) {

                mParaLabel.setText("Fingerprint Scanner not detected in Device");

            } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {

                mParaLabel.setText("Permission not granted to use Fingerprint Scanner");

            } else if (!keyguardManager.isKeyguardSecure()) {

                mParaLabel.setText("Add Lock to your Phone in Settings");

            } else if (!fingerprintManager.hasEnrolledFingerprints()) {

                mParaLabel.setText("You should add atleast 1 Fingerprint to use this Feature");

            } else {

                mParaLabel.setText("Place your Finger on Scanner to Access the App.");

                FingerprintHAndler fingerprintHandler = new FingerprintHAndler(this);

                fingerprintHandler.startAuth(fingerprintManager,null);


            }


        }

    }

}

