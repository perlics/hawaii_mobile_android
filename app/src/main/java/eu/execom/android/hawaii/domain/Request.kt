package eu.execom.android.hawaii.domain

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by sjugurdzija on 6/7/18
 */
data class Request(val reason:String, val requestStatus: String, val requestType: String, val fromDate: String, val duration: Int, val approvedById: Long) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readLong()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(reason)
        parcel.writeString(requestStatus)
        parcel.writeString(requestType)
        parcel.writeString(fromDate)
        parcel.writeInt(duration)
        parcel.writeLong(approvedById)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Request> {
        override fun createFromParcel(parcel: Parcel): Request {
            return Request(parcel)
        }

        override fun newArray(size: Int): Array<Request?> {
            return arrayOfNulls(size)
        }
    }

}