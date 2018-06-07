package eu.execom.android.hawaii.usecase

import eu.execom.android.hawaii.domain.Request

/**
 * Created by sjugurdzija on 6/7/18
 */
class RequestUseCase {

    private val newRequests = arrayListOf<Request>()

    fun readLeaveRequestsHistory() : ArrayList<Request>{
        val request1 = Request("Godisnji odmor","pending","Leave",1)
        val request2 = Request("Godisnji odmor","approved","Leave",1)
        val request3 = Request("Bolovanje","rejected","Sickness",1)
        val request4 = Request("Konferencija","canceled","Bonus Days",1)
        val oldList = arrayListOf<Request>(request1, request2, request3, request4)
        oldList.addAll(0, newRequests)
        return oldList
    }

    fun createRequest (reason: String, type:String) : Boolean{
        val request = Request(reason, "pending", type, -1)
        newRequests.add(request)
        return true
    }
}