package com.example.tp4_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyPlayList extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);

        String songs[]={"saveme","sound"};
        listView= findViewById(R.id.listview);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,songs);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String p = parent.getItemAtPosition(pos).toString(); //element cliqué
            }
        });

        registerForContextMenu(listView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choisir une action");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        Button stopButton = (Button) findViewById(R.id.stop2);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MyPlayList.this, ServiceMusique.class);
                stopService(i);
            }
        });
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

      //Obtenir le titre de la chanson objet du long clic
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String title = listView.getItemAtPosition(info.position).toString();
        switch (item.getItemId()) {
            case R.id.stop:
                // do something useful
                Intent i;
                i = new Intent(this, ServiceMusique.class);
                i.putExtra("name",title);

                stopService(i);
                return true;
            case R.id.play:
                Intent i2;
                i2 = new Intent(this, ServiceMusique.class);
                i2.putExtra("name",title);
                startService(i2);


                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }




}