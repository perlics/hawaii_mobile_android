package eu.execom.android.hawaii.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.execom.android.hawaii.domain.Request
import eu.execom.android.hawaii.R
import kotlinx.android.synthetic.main.request_item.view.*

/**
 * Created by sjugurdzija on 6/7/18
 */
class LeaveHistoryAdapter(val context: Context?) : RecyclerView.Adapter<LeaveHistoryAdapter.ViewHolder>() {
    private var items: ArrayList<Request> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.request_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (items.get(position).requestStatus){
            "pending" -> holder?.ivStatusIcon?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_status_pending_24dp))
            "approved" -> holder?.ivStatusIcon?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_status_approved_24dp))
            "rejected" -> holder?.ivStatusIcon?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_status_rejected_24dp))
            "canceled" -> holder?.ivStatusIcon?.setImageDrawable(context?.resources?.getDrawable(R.drawable.ic_status_canceled_24dp))
        }
        holder?.tvRequestReason.setText(items.get(position).reason)
        holder?.tvRequestType.setText(items.get(position).requestType)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: ArrayList<Request>) {
        this.items = items
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivStatusIcon = view.ivStatusIcon
        val tvRequestReason = view.tvRequestReason
        val tvRequestType = view.tvRequestType
    }
}