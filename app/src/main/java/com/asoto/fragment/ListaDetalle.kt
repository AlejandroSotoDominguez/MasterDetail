package com.asoto.fragment

object DummyContent{


    val ITEMS: MutableList<DummyItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    val LOGTAG = "SEGUIMIENTO"

    init {
    }

    fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }
}