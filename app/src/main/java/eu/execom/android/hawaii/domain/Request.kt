package eu.execom.android.hawaii.domain

/**
 * Created by sjugurdzija on 6/7/18
 */
data class Request(val reason:String, val requestStatus: String, val requestType: String, val approvedById: Long){
}