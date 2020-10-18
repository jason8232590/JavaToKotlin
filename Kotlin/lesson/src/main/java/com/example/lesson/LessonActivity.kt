package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.core.BaseView
import com.example.lesson.entity.Lesson

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter?>, Toolbar.OnMenuItemClickListener {


    override val presenter: LessonPresenter? by lazy{
        //只在第一次调用的时候计算
        LessonPresenter(this)
    }

    private val lessonAdapter = LessonAdapter()
    private var refreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.run {
           inflateMenu(R.menu.menu_lesson)
           setOnMenuItemClickListener(this@LessonActivity)
        }


        findViewById<RecyclerView>(R.id.list).run {
           layoutManager = LinearLayoutManager(this@LessonActivity)
           adapter = lessonAdapter
           addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))

        }

        refreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)!!.apply{
           setOnRefreshListener({ presenter?.fetchData() })
           isRefreshing = true
        }

//        val coroutineScope = CoroutineScope(this)
        presenter?.fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout!!.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        presenter?.showPlayback()
        return false
    }


}