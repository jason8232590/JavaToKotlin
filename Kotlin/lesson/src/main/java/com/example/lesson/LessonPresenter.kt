package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class LessonPresenter constructor(var activity: LessonActivity) {

    companion object{
        //之前通过java 中的final 修饰为一个编译期常量，编译时已经确定好并且不能被修改
        //而kotlin中则要使用const来变为一个编译其常量
        private const val LESSON_PATH: String = "lessons"
    }


    var lessons: ArrayList<Lesson>  =  arrayListOf()

    private val type: Type = object : TypeToken<List<Lesson>>(){}.type

    fun fetchData() {
        HttpClient.INSTANCE.get(LESSON_PATH, type, object: EntityCallback<List<Lesson>>{

            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = lessons;
                activity!!.runOnUiThread{activity!!.showResult(lessons)}
            }

            override fun onFailure(message: String) {
                activity!!.runOnUiThread{toast(message);}

            }
        });
    }

    fun showPlayback() {
        var playbackLessons: MutableList<Lesson>  = arrayListOf() ;

        // filter Returns a list containing only elements matching the given [predicate].
        activity!!.showResult(lessons.filter { it.state == Lesson.State.PLAYBACK });


    }
}