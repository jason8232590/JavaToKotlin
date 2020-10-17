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

class CodeView : AppCompatTextView {

    constructor(context: Context): this(context, null){

    }
    constructor(context: Context, attributes: AttributeSet?): super(context, attributes){
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
        setGravity(Gravity.CENTER);
        setBackgroundColor(getContext().getColor(R.color.colorPrimary));
        setTextColor(Color.WHITE);

        paint.isAntiAlias = true;
        paint.style = Paint.Style.STROKE;
        paint.color = getContext().getColor(R.color.colorAccent);
        paint.strokeWidth = dp2px(6f);

        updateCode();
    }


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



    fun updateCode() {
        val random =  Random().nextInt(codeList.size);
        val code = codeList[random];
        setText(code);
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint);
        super.onDraw(canvas)
    }
}