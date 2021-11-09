package tn.tekup.eventapp.persons

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_person.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.tekup.eventapp.R
import tn.tekup.eventapp.models.request.PersonReq
import tn.tekup.eventapp.utils.Utils
import tn.tekup.eventapp.webservices.RetrofitClient

class AddPersonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initUi()
        initListener()
    }

    private fun initListener() {
validerBtn.setOnClickListener {
    addPerson()
}
    }

    private fun initUi() {
        progressBar.visibility=View.INVISIBLE
    }

    private fun initData() {
     }
    fun addPerson(){
        progressBar.visibility=View.VISIBLE
        var req = PersonReq("feriana","sfs","sdfs","saiiiff","souilmii",null,null,null,null,null,null,null,null)

        RetrofitClient.INSTANCE.addPerson("Bearer "+Utils.getToken(requireContext()).toString(),nomPerEt.text.toString(),prenomPerEt.text.toString(),null,adressePerEt.text.toString(),sexeEt.text.toString(),binEt.text.toString(),null,nationaliteEt.text.toString(),nomMereEt.text.toString(),nomPereEt.text.toString(),null,professionEt.text.toString(),referenceCinEt.text.toString())
            .enqueue(object : Callback<PersonReq> {
                override fun onFailure(call: Call<PersonReq>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Log.i("testreesp", "message::::: "+t.message.toString())
                    Utils.erreurPopUp(t.message.toString(), requireContext())
                    Log.i("testreesp", "message::::: "+t.message.toString())

                }

                override fun onResponse(
                    call: Call<PersonReq>,
                    response: Response<PersonReq>
                ) {
                    progressBar.visibility=View.GONE
                    Utils.infoPopUp(response.body()?.nomPer.toString(),requireContext())
                    response.body()?.let { Log.i("testreesp", "nomPer:::: "+it.nomPer)

                    }

                }
            })
    }

}