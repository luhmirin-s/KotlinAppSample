package lv.luhmirin.sampleapp.list;

import android.support.annotation.NonNull;

import java.util.List;

import lv.luhmirin.sampleapp.list.model.ShoppingItem;

class ListPresenter {

    private ListViewContract contract;
    private ListRepository repository;

    ListPresenter(ListViewContract contract, ListRepository repository) {
        this.contract = contract;
        this.repository = repository;
    }

    void getData() {
        repository.getData(new ListRepository.RepoCallback() {
            @Override
            public void onDataReady(@NonNull List<ShoppingItem> items) {
                contract.showData(items);
            }
        });
    }


}
