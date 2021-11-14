package tn.tekup.eventapp.personevent

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import androidx.navigation.findNavController
import   androidx.recyclerview.widget.*
import tn.tekup.eventapp.R
import tn.tekup.eventapp.models.response.EventsResponse


class PersonEventAdapter(private var subjectList: MutableList<EventsResponse>) :

    RecyclerView.Adapter<PersonEventAdapter.CustomViewHolder>() {

    companion object {

        var pos = 0
        var type=-1

    }

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


    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        lateinit var subject: EventsResponse


        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
Log.i("ssss","sssss")
            v!!.findNavController()
                .navigate(R.id.detailsEventsFragment)

        }
    }


}




