package info.krushik.android.zummejson.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import info.krushik.android.zummejson.R;
import info.krushik.android.zummejson.view.adapter.AppAdapter;
import info.krushik.android.zummejson.retrofit.RetrofitService;
import info.krushik.android.zummejson.model.RequestUser;
import info.krushik.android.zummejson.model.ResponseOperator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String SAVE_INSTANCE = "instance";
    private Context context;
    private TextView destination;
    private TextView isMobile;
    private ProgressBar progressBar;
    private AppAdapter appAdapter;
    private RecyclerView recyclerView;
    private ResponseOperator responseOperator;
    private Button btnGetPrice;
    private RequestUser requestUser = new RequestUser("usd", "english", "38096589875", "android", 45);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rates_list);
        context = this;
        initFields();
        if (savedInstanceState != null && !savedInstanceState.isEmpty()) {
            responseOperator = (ResponseOperator) savedInstanceState.get(SAVE_INSTANCE);
            setItemsToList(responseOperator);
        }
    }

    public void getPrices(final View view) {

        progressBar.setVisibility(ProgressBar.VISIBLE);
        recyclerView.setVisibility(ProgressBar.GONE);
        btnGetPrice.setClickable(false);

        RetrofitService.getApi().getOperatorApp(requestUser).enqueue(new Callback<ResponseOperator>() {
            @Override
            public void onResponse(Call<ResponseOperator> call, Response<ResponseOperator> response) {
                responseOperator = response.body();
                setItemsToList(response.body());
                hideProgressBar();
            }

            @Override
            public void onFailure(Call<ResponseOperator> call, Throwable t) {
                if (responseOperator != null) {
                    setItemsToList(responseOperator);
                }
                hideProgressBar();
            }
        });
    }

    private void setItemsToList(ResponseOperator currentUser) {
        if (!recyclerView.isShown()) {
            recyclerView.setVisibility(View.VISIBLE);
        }
        destination.setText(currentUser.getDestination());
        isMobile.setText(getResources().getString(R.string.is_mobile).concat(String.valueOf(currentUser.getIsMobile())));
        appAdapter = new AppAdapter(currentUser.getRates());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(appAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (responseOperator != null) {
            outState.putParcelable(SAVE_INSTANCE, responseOperator);
        }
    }

    private void hideProgressBar() {
        progressBar.setVisibility(ProgressBar.GONE);
        btnGetPrice.setClickable(true);
    }

    private void initFields() {
        progressBar = (ProgressBar) findViewById(R.id.loadProgressBar);
        recyclerView = (RecyclerView) findViewById(R.id.rates_list_recycler_view);
        destination = (TextView) findViewById(R.id.destination);
        isMobile = (TextView) findViewById(R.id.isMobile);
        btnGetPrice = (Button) findViewById(R.id.buttonGetPrices);
    }
}

