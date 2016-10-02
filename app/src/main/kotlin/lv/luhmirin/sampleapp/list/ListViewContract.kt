package lv.luhmirin.sampleapp.list

import lv.luhmirin.sampleapp.list.model.ShoppingItem

internal interface ListViewContract {
    fun showData(items: List<ShoppingItem>)
}
