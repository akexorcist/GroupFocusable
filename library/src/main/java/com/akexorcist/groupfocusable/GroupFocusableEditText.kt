package com.akexorcist.groupfocusable

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class GroupFocusableEditText : AppCompatEditText {
    private var parentRect = Rect()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun getFocusedRect(r: Rect?) {
        super.getFocusedRect(r)
        getFocusableGroupLayout()?.let { view ->
            view.getFocusedRect(parentRect)
            r?.bottom = parentRect.bottom
        }
    }

    override fun getGlobalVisibleRect(r: Rect?, globalOffset: Point?): Boolean {
        val result = super.getGlobalVisibleRect(r, globalOffset)
        getFocusableGroupLayout()?.let { view ->
            view.getGlobalVisibleRect(parentRect)
            r?.bottom = parentRect.bottom
        }
        return result
    }

    override fun requestRectangleOnScreen(rectangle: Rect?): Boolean {
        val result = super.requestRectangleOnScreen(rectangle)
        getFocusableGroupLayout()?.let { view ->
            parentRect.set(
                0,
                0,
                view.width,
                view.height
            )
            view.requestRectangleOnScreen(parentRect, true)
        }
        return result
    }

    private fun getFocusableGroupLayout(): GroupFocusableLayout? {
        var viewParent = parent
        while (viewParent is View) {
            if (viewParent is GroupFocusableLayout) {
                return viewParent
            }
            viewParent = (viewParent as View).parent
        }
        return null
    }
}
