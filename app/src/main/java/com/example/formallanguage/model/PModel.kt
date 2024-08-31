package com.example.formallanguage.model

import android.os.Parcel
import android.os.Parcelable

data class PModel( val name:String,  val tv:String) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(tv)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PModel> {
        override fun createFromParcel(parcel: Parcel): PModel {
            return PModel(parcel)
        }

        override fun newArray(size: Int): Array<PModel?> {
            return arrayOfNulls(size)
        }
    }
}



