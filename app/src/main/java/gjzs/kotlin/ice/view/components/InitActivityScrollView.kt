package gjzs.kotlin.ice.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

class InitActivityScrollView(context: Context, attrs: AttributeSet? = null): ScrollView(context, attrs) {

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

}