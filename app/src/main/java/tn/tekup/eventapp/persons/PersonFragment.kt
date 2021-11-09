package tn.tekup.eventapp.persons

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_person.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.tekup.eventapp.R
import tn.tekup.eventapp.models.response.PersonResponse
import tn.tekup.eventapp.models.response.PersonResponseItem
import tn.tekup.eventapp.utils.Utils
import tn.tekup.eventapp.webservices.RetrofitClient

class PersonFragment : Fragment() {


    var dataList :ArrayList<PersonResponseItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initUi()
        initListener()
    }

    private fun initListener() {
        addPersonBtn.setOnClickListener {
            findNavController().navigate(R.id.addPersonFragment)
        }
    }

    private fun initUi() {
        personPb.visibility=View.INVISIBLE
        personListRv.layoutManager = LinearLayoutManager(context)
        personListRv.adapter = PersonAdapter(dataList)
    }

    private fun initData() {
        getPersons()
    }
    fun getPersons(){
        personPb.visibility=View.VISIBLE

        RetrofitClient.INSTANCE.getPersons("Bearer "+Utils.getToken(requireContext()).toString())
            .enqueue(object : Callback<PersonResponse> {
                override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                    personPb.visibility = View.GONE
                    Log.i("testreesp", "message::::: "+t.message.toString())
                    Utils.erreurPopUp(t.message.toString(), requireContext())
                    Log.i("testreesp", "message::::: "+t.message.toString())

                }

                override fun onResponse(
                    call: Call<PersonResponse>,
                    response: Response<PersonResponse>
                ) {
                    personPb.visibility=View.GONE

                         Log.i("testreesp", "size::::: "+response.body()?.size)
                    dataList.clear()
                    dataList.addAll(response.body()!!)
                    personListRv.adapter?.notifyDataSetChanged()


                }
            })
    }

}