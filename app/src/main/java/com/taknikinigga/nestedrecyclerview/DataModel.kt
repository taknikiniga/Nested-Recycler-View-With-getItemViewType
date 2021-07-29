package com.taknikinigga.nestedrecyclerview

data class ItemGroup(
    val title: String="",
    val ItemList: List<ItemData>,
    val orientation: Int = 0,
)

data class ItemData(val name: String ="", val image: Int, val viewType: Int = 0)