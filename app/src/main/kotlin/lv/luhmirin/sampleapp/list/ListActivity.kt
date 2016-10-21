package lv.luhmirin.sampleapp.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.pawegio.kandroid.d
import kotlinx.android.synthetic.main.activity_list.*
import lv.luhmirin.sampleapp.R
import lv.luhmirin.sampleapp.list.model.ShoppingItem

class ListActivity : AppCompatActivity(), ListViewContract {

    private lateinit var presenter: ListPresenter
    private lateinit var adapter: ShoppingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        presenter = ListPresenter(this, ListRepository())
        adapter = ShoppingListAdapter(this)

        list_recycler.layoutManager = LinearLayoutManager(this)
        list_recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getData()
    }

    override fun showData(items: List<ShoppingItem>) {
        runOnUiThread { adapter.setItemsAndNotify(items) }
    }
}
