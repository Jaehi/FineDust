package com.applemango.finedust

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.applemango.finedust.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private val bind : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        bind.mainviewmodel = viewModel
        bind.lifecycleOwner = this
        
    }


}
