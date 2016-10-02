package lv.luhmirin.sampleapp.list;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lv.luhmirin.sampleapp.R;
import lv.luhmirin.sampleapp.list.model.ShoppingItem;

public class ListActivity extends AppCompatActivity implements ListViewContract {

    @BindView(R.id.list_recycler) RecyclerView recyclerView;

    ListPresenter presenter;
    private ShoppingListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        presenter = new ListPresenter(this, new ListRepository());

        adapter = new ShoppingListAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getData();
    }

    @Override
    public void showData(@NonNull final List<ShoppingItem> items) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setItems(items);
            }
        });
    }
}
