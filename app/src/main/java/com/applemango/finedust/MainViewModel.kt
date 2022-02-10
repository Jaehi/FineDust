package com.applemango.finedust

import android.app.Application
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.applemango.finedust.models.NewDustResponse
import java.time.LocalDate
import java.util.*

class MainViewModel (application: Application):AndroidViewModel(application) {

    val tempList = MutableLiveData<TempResponse>()

    val dust = MutableLiveData<NewDustResponse>()

    val date = LocalDate.now().toString()

    val timer = Timer(true).schedule(object : TimerTask() {
        override fun run() {
            getTemp()
            getDust()
        }

    }, 0, 5000)

    val temp = Transformations.map(tempList) {
        (it.main?.temp?.minus(273.15f))?.toInt().toString()
    }

    val statelist = Transformations.map(dust) {
        getState(
            it.response.body.items[0].informGrade.split(",").filter { state ->
            state.contains("서울")
            }.toString()
        )
    }


    private fun getState(state : String): String{
        return state.split(":").last().dropLast(1)
    }


    init {
        timer
        getTemp()
        Log.d("666666666", "$temp")
    }

    private fun getTemp() {
        ServerConnector.getTemp(ConstData.TEMP_KEY, ConstData.TEMP_AREA, ConstData.LANG) {
            tempList.value = it
            // Log.d("999999999999999999999","$it")
        }
    }

    private fun getDust() {
        ServerConnector.getDust(ConstData.DUST_KEY, ConstData.TYPE, date) {
            dust.value = it
            Log.d("44444444444444444444", "$it")
            Log.d("33333333333333", "$statelist")
        }
    }


}



