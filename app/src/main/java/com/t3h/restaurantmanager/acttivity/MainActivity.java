package com.t3h.restaurantmanager.acttivity;

import android.app.ProgressDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.t3h.restaurantmanager.Food;
import com.t3h.restaurantmanager.FoodAdapter;
import com.t3h.restaurantmanager.R;
import com.t3h.restaurantmanager.Server;
import com.t3h.restaurantmanager.api.ApiBuilder;
import com.t3h.restaurantmanager.api.FoodResponsive;
import com.t3h.restaurantmanager.base.BaseActivity;
import com.t3h.restaurantmanager.databinding.ActivityMainBinding;
import com.t3h.restaurantmanager.fragment.FragmentFish;
import com.t3h.restaurantmanager.fragment.FragmentMeat;
import com.t3h.restaurantmanager.fragment.FragmentRice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity<ActivityMainBinding>
        implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener, Callback<FoodResponsive> {
    private FoodAdapter adapter;
    private List<Food> data;
    private SearchView searchView;
    private ProgressDialog dialog;
    String urlGetData = "http://192.168.10.107/chat1902e/getfood.php";

    @Override
    protected void initAct() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new FragmentFish()).commit();
    }

//    private void getData(String url) {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        data.add(new Food(
//                                object.getString("id"),
//                                object.getString("picture"),
//                                object.getString("price")
//                        ));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                adapter.notifyDataSetChanged();
//
//            }
//        }, new com.android.volley.Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
//
//            }
//        }
//        );
//        requestQueue.add(jsonArrayRequest);
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.menu_search);
        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fm_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new FragmentFish()).commit();
                break;
            case R.id.fm_fish:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new FragmentRice()).commit();
                break;
            case R.id.fm_meat:
                getSupportFragmentManager().beginTransaction().replace(R.id.main, new FragmentMeat()).commit();
                break;
            case R.id.nav_tools:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        String keySearch = searchView.getQuery().toString();

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onResponse(Call<FoodResponsive> call, Response<FoodResponsive> response) {

    }

    @Override
    public void onFailure(Call<FoodResponsive> call, Throwable t) {

    }
}
