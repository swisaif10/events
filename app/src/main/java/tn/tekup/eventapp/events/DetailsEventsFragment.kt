package tn.tekup.eventapp.events

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.wasabeef.blurry.Blurry
import tn.tekup.eventapp.R


class DetailsEventsFragment : Fragment() {
    var container: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_details_events, container, false)
        this.container = container

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initUi()
        initListener()
    }

    private fun initListener() {

    }

    private fun initUi() {

    }

    private fun initData() {

    }

 }