package com.victoramaral.recyclerviewheader.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.victoramaral.recyclerviewheader.AlphabetActivity
import com.victoramaral.recyclerviewheader.R
import com.victoramaral.recyclerviewheader.common.Common
import com.victoramaral.recyclerviewheader.model.Person

class PersonAdapter(val context: Context, var personList: List<Person> = listOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflater: LayoutInflater? = LayoutInflater.from(context)
        if (viewType == Common.VIEWTYPE.VIEWTYPE_GROUP) {
            val group: ViewGroup =
                inflater?.inflate(R.layout.group_layout, parent, false) as ViewGroup
            val groupViewHolder: GroupViewHolder = GroupViewHolder(group)
            return groupViewHolder

        } else if (viewType == Common.VIEWTYPE.VIEWTYPE_PERSON) {
            val group: ViewGroup =
                inflater?.inflate(R.layout.person_layout, parent, false) as ViewGroup
            val personViewHolder: PersonViewHolder = PersonViewHolder(group)
            return personViewHolder
        } else {
            val group: ViewGroup =
                inflater?.inflate(R.layout.group_layout, parent, false) as ViewGroup
            val groupViewHolder: GroupViewHolder = GroupViewHolder(group)
            return groupViewHolder
        }
    }

    override fun getItemViewType(position: Int): Int {
        return personList[position].viewType!!
    }

    override fun getItemCount(): Int {
        return personList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GroupViewHolder) {
            val groupViewHolder: GroupViewHolder = holder
            groupViewHolder.textGroupTitle.text = personList[position].name
            groupViewHolder.itemView.setOnClickListener {
                context.startActivity(
                    Intent(
                        context.applicationContext,
                        AlphabetActivity::class.java
                    )
                )
            }
        } else if (holder is PersonViewHolder) {
            val personViewHolder: PersonViewHolder = holder
            personViewHolder.textPersonName.text = personList[position].name
            personViewHolder.textPersonPosition.text = personList[position].position

            val colorGenerator: ColorGenerator = ColorGenerator.MATERIAL
            val drawable: TextDrawable =
                TextDrawable.builder()
                    .buildRound(personList[position].name?.get(0)?.toString(), colorGenerator.randomColor)

            personViewHolder.imagePersonAvatar.setImageDrawable(drawable)
        }
    }
}

class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textGroupTitle: TextView = itemView.findViewById(R.id.text_group_title)

}

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textPersonName: TextView = itemView.findViewById(R.id.text_person_name)
    val textPersonPosition: TextView = itemView.findViewById(R.id.text_person_position)
    val imagePersonAvatar: ImageView = itemView.findViewById(R.id.person_avatar)

}
