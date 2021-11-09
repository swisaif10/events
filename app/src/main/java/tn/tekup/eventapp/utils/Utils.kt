package tn.tekup.eventapp.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import kotlinx.android.synthetic.main.ko_popup.view.*
import kotlinx.android.synthetic.main.ok_popup.view.*
import tn.tekup.eventapp.R
import tn.tekup.eventapp.models.Persons


object Utils {

    val PREFERENCES_NAME = "login"
    val NAME_ID = "token"
    val PREFERENCES_IC = "ic"
    val NAME_IC = "ic"
    val isProduction = false
    val PREFERENCES_PREMIUM = "premium"
    val NAME_ID_PREMIUM = "premium"
    fun getBaseUrl(): String {

        if (isProduction) {
            return "https://backoffice.ma-regie.fr/api/"
        } else {
            return "https://maregie.recette-bilog.fr/api/"
        }
    }


    fun getToken(context: Context): String? {
        var sharedPreference = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val token = sharedPreference?.getString(NAME_ID, "")
        return token
    }
    fun initStatusbar(window: Window,context: Context) {
        val window: Window = window

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.statusBarColor = ContextCompat.getColor(context, R.color.colorBr)
    }
    fun insertSpace(input: String, n: Int): String {
        if (input.subSequence(2,3)==" "){
            return input

        }else{
            val str = StringBuilder(input)
            var idx = str.length - n
            while (idx > 0) {
                str.insert(idx, " ")
                idx = idx - n
            }
            return str.toString()
        }

    }




    fun saveCurrentUser(user: Persons ,context: Context) {
        var sharedPreference =
            context.getSharedPreferences(PREFERENCES_IC, Context.MODE_PRIVATE)
        val editor = sharedPreference?.edit()
        val gson =  Gson()
        val userJson = gson.toJson(user)
        editor?.putString(NAME_IC, userJson)
         editor?.apply()
    }

    fun getCurrentUser(context: Context): Persons {

        var gson = Gson()
        var sharedPreference = context.getSharedPreferences(PREFERENCES_IC, Context.MODE_PRIVATE)
        val userJson = sharedPreference?.getString(NAME_IC, "")
        if (userJson == ""){
            return Persons()
        } else{
            return gson.fromJson(userJson, Persons::class.java)
        }
     }
    fun setupUI(activity: Activity, view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    hideSoftKeyboard(activity)
                    return false
                }
            })
        }
    }

    fun hideSoftKeyboard(activity: Activity) {
        try {
            val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0
            )
        } catch (e: Exception) {
        }
    }
    fun infoPopUp(msg: String, context: Context) {
        var view = LayoutInflater.from(context).inflate(R.layout.ok_popup, null)
        var toast = Toast(context)
        view.msgOkPopUpTv.text = msg
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP, 0, 180)
        toast.show()

    }

    fun erreurPopUp(msg: String, context: Context) {
        var view = LayoutInflater.from(context).inflate(R.layout.ko_popup, null)
        view.msgKoPopUpTv.text = msg
        var toast = Toast(context)
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP, 0, 180)
        toast.show()

    }
    fun saveToken(context: Context, token: String) {
        var sharedPreference =
            context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreference?.edit()
        editor?.putString(NAME_ID, token)
        editor?.apply()
    }

}