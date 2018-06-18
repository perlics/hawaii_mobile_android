package eu.execom.android.hawaii.usecase

import eu.execom.android.hawaii.domain.Request

/**
 * Created by sjugurdzija on 6/7/18
 */
class RequestUseCase {

    private val newRequests = arrayListOf<Request>()

    fun readLeaveRequestsHistory() : ArrayList<Request>{
        val request1 = Request("Godisnji odmor","pending","Leave","01.02.2018.", 5, 1)
        val request2 = Request("Godisnji odmor","approved","Leave","01.02.2018.", 5, 1)
        val request3 = Request("Bolovanje","rejected","Sickness","01.02.2018.", 5, 1)
        val request4 = Request("Konferencija","canceled","Bonus Days","01.02.2018.", 5, 1)
        val oldList = arrayListOf<Request>(request1, request2, request3, request4)
        oldList.addAll(0, newRequests)
        return oldList
    }

    fun createRequest (reason: String, startDate: String, duration: Int) : Boolean{
        val request = Request(reason, "pending", "pending", startDate, duration, -1)
        newRequests.add(request)
        return true
    }
}