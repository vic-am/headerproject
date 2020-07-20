package com.victoramaral.recyclerviewheader

import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.victoramaral.recyclerviewheader.adapter.PersonAdapter
import com.victoramaral.recyclerviewheader.common.CommonJava
import com.victoramaral.recyclerviewheader.common.LinearLayoutManagerWithSmoothScroller
import com.victoramaral.recyclerviewheader.model.Person
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var personList: List<Person> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_person)
        val layoutManager: LinearLayoutManager =
            LinearLayoutManagerWithSmoothScroller(this, VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        createPersonList()
        val adapter: PersonAdapter = PersonAdapter(this, personList)
        recyclerView.adapter = adapter
    }



    fun createPersonList() {
        personList = CommonJava.genPeopleGroup()
        personList = CommonJava.sortList(personList as ArrayList<Person>?)
        personList = CommonJava.addAlphabets(personList as ArrayList<Person>?)
    }
}