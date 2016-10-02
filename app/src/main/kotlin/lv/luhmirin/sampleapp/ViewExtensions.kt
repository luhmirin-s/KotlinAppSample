package lv.luhmirin.sampleapp

import android.content.Context
import android.support.design.widget.TextInputLayout
import android.widget.EditText


// Some extension functions on views
fun EditText.getString() = this.text.toString()

fun TextInputLayout.removeError() {
    this.error = null
}

fun TextInputLayout.setErrorString(context: Context, id: Int) {
    this.error = context.resources.getString(id)
}
