package lv.luhmirin.sampleapp.list.model

import java.util.*


data class ShoppingItem(val name: String, val description: String, val price: Float)

class ShoppingItemList : ArrayList<ShoppingItem>()