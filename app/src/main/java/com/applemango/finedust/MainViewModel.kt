package com.applemango.finedust

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.applemango.finedust.dust.DustResponse
import com.applemango.finedust.temp.TempResponse

import java.time.LocalDate
import java.util.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val tempList = MutableLiveData<TempResponse>()

    val dust = MutableLiveData<DustResponse>()

    val date = LocalDate.now().toString()

    val timer = Timer(true).schedule(object : TimerTask() {

        override fun run() {
            getTemp()
            getDust()
        }

    }, 0, 300000)

    val temp = Transformations.map(tempList) {
        (it.main?.temp?.minus(273.15f))?.toInt().toString()
    }

    val statelist = Transformations.map(dust) {
        getState(
            it?.body?.item?.itemlist?.get(0)?.informGrade?.split(",")?.filter { state ->
                state.contains(ConstData.LOCATION)
            }.toString()
        )
    }

    private fun getState(state: String): String {
        return state.split(":").last().dropLast(1)
    }

    init {
        timer
    }

    private fun getTemp() {
        ServerConnector.getTemp(ConstData.TEMP_KEY, ConstData.TEMP_AREA, ConstData.LANG) {
            tempList.value = it
        }
    }

    private fun getDust() {
        ServerConnector.getDust(ConstData.DUST_KEY, ConstData.TYPE, date) {
            dust.value = it
        }
    }

}



