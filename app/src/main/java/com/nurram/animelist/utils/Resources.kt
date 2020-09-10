package com.nurram.animelist.utils

class Resources<out T>(val status: Status, val data: T?, val msg: String?) {
    companion object {
        fun <T> onSuccess(data: T?) = Resources(Status.SUCCESS, data, null)
        fun onLoading() = Resources(Status.LOADING, null, null)
        fun onError(msg: String?) = Resources(Status.ERROR, null, msg)
    }
}