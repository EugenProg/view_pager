package kz.just_code.viewpagerapp

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import androidx.viewpager2.widget.ViewPager2.PageTransformer

class CarouselTransformer : PageTransformer {
    private val horizontalOffset = (-45).dp
    private val rotationDegree = 10
    private val topOffset = (-10f).dp

    override fun transformPage(page: View, position: Float) {
        page.translationX = horizontalOffset * position
        page.rotationY = rotationDegree * position

        if (position <= 0) {
            page.pivotX = page.width.toFloat()
            page.translationY = topOffset * position
        } else page.pivotX = 0f
    }
}

val Int.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )