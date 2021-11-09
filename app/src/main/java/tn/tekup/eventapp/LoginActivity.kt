package tn.tekup.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.tekup.eventapp.models.LoginResponse
import tn.tekup.eventapp.models.request.LoginReq
import tn.tekup.eventapp.utils.Utils
import tn.tekup.eventapp.webservices.RetrofitClient

import androidx.annotation.NonNull
import androidx.navigation.findNavController

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var rootView = window.decorView.rootView
        Utils.setupUI(this, rootView)
        initData()
        initUi()
        initListener()
    }
    fun initData(){

    }
    fun initUi(){
        loginPB.visibility=View.GONE
    }
    fun initListener(){
        login_btn.setOnClickListener {
          //  startActivity(Intent(this@LoginActivity,MainActivity::class.java))
        login(email_edt_text.text.toString(),pass_edt_text.text.toString())
        }



    }


    fun login(username:String,password:String){
        loginPB.visibility=View.VISIBLE
        var req =LoginReq(username,password)

        RetrofitClient.INSTANCE.userLogin(req)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    loginPB.visibility = View.GONE
                    Log.i("testreesp", "message::::: "+t.message.toString())
                    Utils.erreurPopUp(t.message.toString(), applicationContext)
                    Log.i("testreesp", "message::::: "+t.message.toString())

                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    loginPB.visibility=View.GONE

                    response.body()?.let { Log.i("testreesp", "token:::: "+it.token)
                        Log.i("testreesp", "message::::: "+it.message)
                        Utils.saveToken(this@LoginActivity,it.token)
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    }

                }
            })
    }
    }

