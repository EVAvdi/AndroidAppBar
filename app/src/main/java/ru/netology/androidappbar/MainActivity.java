package ru.netology.androidappbar;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ru.netodology.androidappbar.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_open_notes) {
            Toast.makeText(MainActivity.this, "Открыть записную книжку", Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
        }
        if (id == R.id.action_open_pay) {
            Toast.makeText(MainActivity.this, "Открыть способы оплаты", Toast.LENGTH_LONG).show();
            Intent intentPay = new Intent(MainActivity.this, PayActivity.class);
            startActivity(intentPay);
        }
        if (id == R.id.action_open_address) {
            Toast.makeText(MainActivity.this, "Открыть адреса", Toast.LENGTH_LONG).show();
            Intent intentAddress = new Intent(MainActivity.this, AddressActivity.class);
            startActivity(intentAddress);
        }
        if (id == R.id.action_open_calendar) {
            Toast.makeText(MainActivity.this, "Открыть календарь", Toast.LENGTH_LONG).show();
            Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intentCalendar);
        }
        return super.onOptionsItemSelected(item);
    }
}
