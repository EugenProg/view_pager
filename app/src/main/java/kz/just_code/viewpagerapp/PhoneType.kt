package kz.just_code.viewpagerapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class PhoneType(@DrawableRes val image: Int, @StringRes val title: Int) {
    I_PHONE(R.drawable.ic_iphone, R.string.i_phone),
    PIXEL(R.drawable.ic_pixel, R.string.pixel),
    SAMSUNG(R.drawable.ic_samsung, R.string.samsung),
}