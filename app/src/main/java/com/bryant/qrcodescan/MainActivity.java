package com.bryant.qrcodescan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lcrd.qrscan.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private static final int QR_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CameraUtils.isCameraCanUse()) {
                    Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                    startActivityForResult(intent, QR_REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "请打开此应用的摄像头权限！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvResult = findViewById(R.id.tv_scan_result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == QR_REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                String scanResult = bundle.getString(CaptureActivity.INTENT_EXTRA_KEY_QR_SCAN);
                Log.i("tag", "scanResult=" + scanResult);
                tvResult.setText(scanResult);
            }
        }
    }

}
