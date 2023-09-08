package com.example.limjinlok

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.limjinlok.model.MainTabsModel

class MainViewPagerAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {

    private val tabList = ArrayList<MainTabsModel>()

    fun addTabList(fragment: Fragment, title: String) {
        tabList.add(MainTabsModel(fragment, title))
    }

    fun getFragmentByIndex(position: Int): Fragment {
        return tabList[position].fragment
    }

    fun getTitleByIndex(position: Int): String {
        return tabList[position].title
    }

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(position: Int): Fragment {
        return tabList[position].fragment
    }
}