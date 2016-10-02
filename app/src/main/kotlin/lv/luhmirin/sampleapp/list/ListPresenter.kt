package lv.luhmirin.sampleapp.list

internal class ListPresenter(private val contract: ListViewContract, private val repository: ListRepository) {

    fun getData() {
        repository.getData { items ->
            contract.showData(items)
        }
    }

}
