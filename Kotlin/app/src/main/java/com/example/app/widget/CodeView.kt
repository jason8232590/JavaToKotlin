package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.R
import com.example.core.utils.dp2px
import java.util.*

class CodeView constructor(var codeViewContext: Context, var attributes: AttributeSet?): AppCompatTextView(codeViewContext, attributes) {

    //we should put the code before using it
    val  paint: Paint =  Paint()

    private val codeList = arrayOf(
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    )

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        setGravity(Gravity.CENTER);
        setBackgroundColor(getContext().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);

        paint.run {
            isAntiAlias = true;
            style = Paint.Style.STROKE;
            color = getContext().getColor(R.color.colorAccent);
            strokeWidth = 6f.dp2px();
        }


        updateCode();
    }
    constructor(context: Context): this(context, null){

    }







    fun updateCode() {
        text= codeList[Random().nextInt(codeList.size)];
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint);
        super.onDraw(canvas)
    }
}