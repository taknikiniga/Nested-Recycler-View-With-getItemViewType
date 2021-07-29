package com.taknikinigga.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingAds = mutableListOf(
            ItemData("", R.drawable.ic_android_black_24dp, 1)
        )

        val groupSubItemDataTwo = mutableListOf(
            ItemData("Abhinash singh", R.drawable.ic_android_black_24dp),
            ItemData("Abhinash singh", R.drawable.ic_android_black_24dp),
            ItemData("Abhinash singh", R.drawable.ic_launcher_background),
            ItemData("Abhinash singh", R.drawable.ic_launcher_background)
        )

        val groupSubItemData = mutableListOf(
            ItemData("Abhinash singh", R.drawable.ic_launcher_background),
            ItemData("Abhinash singh", R.drawable.ic_android_black_24dp),
            ItemData("Abhinash singh", R.drawable.ic_launcher_background),
            ItemData("Abhinash singh", R.drawable.ic_launcher_background)
        )

        val itemAddingInGroup = mutableListOf(
            ItemGroup("item one", groupSubItemData),
            ItemGroup("item Two", groupSubItemDataTwo, 0),
            ItemGroup("ads Layout", settingAds)
        )

        val groupAdapter = GroupAdapter(itemAddingInGroup)

        main_recyclerview.adapter = groupAdapter
        groupAdapter.notifyDataSetChanged()


    }
}