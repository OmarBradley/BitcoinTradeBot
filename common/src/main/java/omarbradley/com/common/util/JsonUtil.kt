package omarbradley.com.common.util

import com.google.gson.Gson

const val JSON_CONTENT_TYPE = "application/json"

fun Any.toJsonString(): String =
    Gson().toJson(this)
