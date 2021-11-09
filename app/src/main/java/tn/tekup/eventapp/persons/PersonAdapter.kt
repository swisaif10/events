package tn.tekup.eventapp.persons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import androidx.navigation.findNavController
import   androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.ui_item_row.view.*

import tn.tekup.eventapp.R
import tn.tekup.eventapp.models.Persons
import tn.tekup.eventapp.models.response.PersonResponseItem


class PersonAdapter(private var subjectList: MutableList<PersonResponseItem>) :

    RecyclerView.Adapter<PersonAdapter.CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.ui_item_row, parent, false)
        return CustomViewHolder(cellForRow)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
holder.view.PersonTv.text=subjectList[position].nomPer + " " + subjectList[position].prenomPer


    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        lateinit var subject: Persons


        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }


}




