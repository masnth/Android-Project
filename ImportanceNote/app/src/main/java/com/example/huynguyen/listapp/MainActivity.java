package com.example.huynguyen.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter itemAdapter;
    private ListView myListView;
    String[] items;
    String[] prices;
    String[] notes;
    String[] descriptions;
    String[] tempItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        String[] res_items = res.getStringArray(R.array.items);
        if (tempItems == null) {
            items = res_items;
        }
        else {
            items = tempItems;
        }

        int len = items.length;

        //prices = res.getStringArray(R.array.prices);
        prices = new String[len];
        for (int i = 0; i < len; i++) {
            prices[i] = "Note " + Integer.toString(i);
        }

        //descriptions = res.getStringArray(R.array.description);
        descriptions = new String[len];
        for (int i = 0; i < len; i++) {
            descriptions[i] = "Importance level: " + Integer.toString(i);
        }

        itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);

        Button additemBtn = (Button) findViewById(R.id.additemBtn);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity =
                        new Intent(getApplicationContext(),DetailActivity.class);
                showDetailActivity.putExtra("example.huynguyen.ITEM_INDEX", position);
                startActivity(showDetailActivity);
            }
        });

        additemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent additemIntent = new Intent(getApplicationContext(), AddItem.class);
                startActivityForResult(additemIntent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String newItem = data.getStringExtra("com.example.huynguyen.NEW_ITEM");
                tempItems = Arrays.copyOf(items, items.length + 1);
                tempItems[items.length] = newItem;
                items = tempItems;
                prices = new String[] {"0.1", "0.2", "0.3", "0.4"};
                descriptions = new String[] {"a", "b", "c", "d"};
                itemAdapter.setItem(items);
                itemAdapter.setPrices(prices);
                itemAdapter.setDescriptions(descriptions);
                itemAdapter.notifyDataSetChanged();
            }
        }
    }
}
