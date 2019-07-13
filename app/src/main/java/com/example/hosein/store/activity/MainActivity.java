package com.example.hosein.store.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.hosein.store.R;
import com.example.hosein.store.adapter.ProductAdapter;
import com.example.hosein.store.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ProductAdapter productAdapter;
    String url = "http://grafik.computertalk.ir/android/product.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lstProduct);
        final ArrayList<Product> productList = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i<response.length(); i++)
                {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        productList.add(new Product(jsonObject.getString("name")
                        ,jsonObject.getString("desc")
                        ,jsonObject.getString("price")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                productAdapter = new ProductAdapter(MainActivity.this,productList);
                listView.setAdapter(productAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,id + "",Toast.LENGTH_LONG).show();
            }
        });


    }
}
