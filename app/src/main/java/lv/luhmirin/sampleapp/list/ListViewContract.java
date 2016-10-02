package lv.luhmirin.sampleapp.list;

import android.support.annotation.NonNull;

import java.util.List;

import lv.luhmirin.sampleapp.list.model.ShoppingItem;

interface ListViewContract {
    void showData(@NonNull List<ShoppingItem> items);
}
