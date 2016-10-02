package lv.luhmirin.sampleapp.list

import com.google.gson.GsonBuilder
import com.pawegio.kandroid.runAsync
import lv.luhmirin.sampleapp.App
import lv.luhmirin.sampleapp.list.model.ShoppingItem
import lv.luhmirin.sampleapp.list.model.ShoppingItemList
import java.io.IOException
import java.io.InputStreamReader

internal class ListRepository {

    fun getData(callback: (items: List<ShoppingItem>) -> Any) {
        runAsync {
            var result: List<ShoppingItem> = emptyList()

            try {
                val stream = App.context!!.assets.open("MOCK_DATA.json")
                val reader = InputStreamReader(stream)

                result = reader.readFromJson()

                reader.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            callback(result)
        }
    }

    private fun InputStreamReader.readFromJson(): List<ShoppingItem> =
            GsonBuilder().create().fromJson(this, ShoppingItemList::class.java)

}
