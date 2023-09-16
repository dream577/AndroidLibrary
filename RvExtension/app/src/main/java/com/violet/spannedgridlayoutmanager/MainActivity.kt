package com.violet.spannedgridlayoutmanager

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.violet.spannedgridlayoutmanager.core.TwoWayLayoutManager
import com.violet.spannedgridlayoutmanager.extension.SpannableGridLayoutManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mButton: Button
    private lateinit var mAdapter: LiveAdapter
    private lateinit var source: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.rv)
        mButton = findViewById(R.id.exchange)
        mButton.setOnClickListener(this)

        /**
         * 自定义LayoutManager虽然可以实现item占据多行多列，但是行和列的默认单位长度是相同的，
         * 可通过改变[SpannableGridLayoutManager.ratio]来改变行和列的默认单位长度
         */
        val manager = SpannableGridLayoutManager(TwoWayLayoutManager.Orientation.HORIZONTAL, 3, 3)
        manager.ratio = 16 / 9f

//        val manager = GridLayoutManager(this,2, RecyclerView.HORIZONTAL, false)

        source = mutableListOf()
        for (i in 0..100) {
            source.add(i.toString())
        }

        mRecyclerView.layoutManager = manager
        mAdapter = LiveAdapter()
        mRecyclerView.adapter = mAdapter
        mAdapter.setData(source)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            mButton.id -> {
                mAdapter.exchange(1, 2)
            }
        }
    }


}