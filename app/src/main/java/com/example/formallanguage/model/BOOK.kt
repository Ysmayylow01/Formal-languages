package com.example.formallanguage.model

import android.os.Parcel
import android.os.Parcelable

data class BOOK(val image:Int, val name:String, val pdf:String) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(pdf)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BOOK> {
        override fun createFromParcel(parcel: Parcel): BOOK {
            return BOOK(parcel)
        }

        override fun newArray(size: Int): Array<BOOK?> {
            return arrayOfNulls(size)
        }
    }
}
