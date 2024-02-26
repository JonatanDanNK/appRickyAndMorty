package com.example.apprickyandmorty.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apprickyandmorty.databinding.ActivityMainBinding
import com.example.apprickyandmorty.data.model.Card
import com.example.apprickyandmorty.data.model.ResultX
import com.example.apprickyandmorty.ui.adapter.CardAdapter
import com.example.apprickyandmorty.ui.viewmodel.CardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _mBinding: ActivityMainBinding
    lateinit var mAdapter: CardAdapter
    lateinit var linearLayoudManager: RecyclerView.LayoutManager

    private val cardViewModel : CardViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(_mBinding.root)
        cardViewModel.onCreate()
        changeData()
       // configAdapter()
    }

    fun changeData(){
        cardViewModel.isLoading.observe(this, {
            _mBinding.loading.isVisible = it
        })

        cardViewModel.quoteModel.observe(this, Observer {
            mAdapter = CardAdapter(it)
            linearLayoudManager = LinearLayoutManager(this)

            _mBinding.recyclerView.apply {
                layoutManager= linearLayoudManager
                adapter=mAdapter
            }
        })
    }


    private fun configAdapter(){
        val recyclerView = _mBinding.recyclerView

        mAdapter = CardAdapter(getCard())
        linearLayoudManager = LinearLayoutManager(this)

        _mBinding.recyclerView.apply {
            layoutManager= linearLayoudManager
            adapter=mAdapter
        }
    }

    private fun getCard(): MutableList<ResultX> {
        val cardFoot = mutableListOf<ResultX>()

        val card1= ResultX("https://futbol.radioformula.com.mx/u/fotografias/m/2022/5/10/f768x1-54540_54667_79.jpg", "El Gabilan")
        val card2= ResultX("", "El Pai")
        val card3= ResultX("", "Don Adasado")

        cardFoot.add(card1)
        cardFoot.add(card2)
        cardFoot.add(card3)
        return cardFoot
    }
}