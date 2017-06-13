package com.example.logonrm.alarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.etTempo)
    EditText etTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btIniciar)
    public void onClick() {
        int i = Integer.parseInt(etTempo.getText().toString());
        Intent intent = new Intent(this, AlarmeReceiver. class);

        PendingIntent pendingIntent = PendingIntent. getBroadcast(
                this.getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE);

        alarmManager.set(AlarmManager. RTC_WAKEUP,
                System. currentTimeMillis() + (i * 1000),
                pendingIntent);
        Toast.makeText(this, "Alarm set in " +i+ " seconds",Toast.LENGTH_LONG).show();
    }
}
