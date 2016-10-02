package lv.luhmirin.sampleapp.list;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import lv.luhmirin.sampleapp.App;
import lv.luhmirin.sampleapp.list.model.ShoppingItem;
import lv.luhmirin.sampleapp.list.model.ShoppingItemList;

class ListRepository {

    void getData(RepoCallback callback) {
        InputStreamReader reader = null;
        List<ShoppingItem> result = new ArrayList<>(0);

        try {
            InputStream stream = App.getAppContext().getAssets().open("MOCK_DATA.json");
            reader = new InputStreamReader(stream);

            result = new GsonBuilder().create().fromJson(reader, ShoppingItemList.class);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        callback.onDataReady(result);
    }

    interface RepoCallback {

        void onDataReady(@NonNull List<ShoppingItem> items);

    }
}
