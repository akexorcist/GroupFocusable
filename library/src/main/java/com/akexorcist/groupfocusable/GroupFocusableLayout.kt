package com.akexorcist.groupfocusable

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class GroupFocusableLayout : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}
