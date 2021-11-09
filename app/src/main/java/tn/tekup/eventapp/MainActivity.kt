package tn.tekup.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initUi()
        initListener()
    }

    private fun initListener() {
        navigationV.setOnNavigationItemSelectedListener {menu ->

            when(menu.itemId){

                R.id.peopleItem -> {
                    titleTv.text="Persons"
                    findNavController(R.id.fragmentContainerView).navigate(R.id.personFragment)
                    true
                }

                R.id.action_settings -> {
                    titleTv.text="Events"

                    findNavController(R.id.fragmentContainerView).navigate(R.id.eventFragment)

                    true
                }

                R.id.action_navigation -> {
                    titleTv.text="Persons Events"
                    findNavController(R.id.fragmentContainerView).navigate(R.id.personEventFragment)

                    true
                }

                else -> false
            }
        }
        logoutIv.setOnClickListener {
            finish()
           // startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }
    }

    private fun initUi() {
        titleTv.text="Persons"

    }

    private fun initData() {

    }
}