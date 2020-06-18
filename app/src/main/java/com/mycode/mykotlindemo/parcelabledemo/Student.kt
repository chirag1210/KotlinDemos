package com.mycode.mykotlindemo.parcelabledemo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(val name: String, val address: String) : Parcelable