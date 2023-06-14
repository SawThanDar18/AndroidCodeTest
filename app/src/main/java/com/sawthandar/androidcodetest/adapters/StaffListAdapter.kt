package com.sawthandar.androidcodetest.adapters

import android.view.LayoutInflater import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sawthandar.androidcodetest.R
import com.sawthandar.androidcodetest.api.response.Employees

class StaffListAdapter : RecyclerView.Adapter<StaffListViewHolder>() {
    private val employeesList: MutableList<Employees> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_staff, parent, false)
        return StaffListViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffListViewHolder, position: Int) {
        holder.bind(employeesList[position])
    }

    override fun getItemCount(): Int {
        return employeesList.size
    }

    fun setDataSet(employees: List<Employees>) {
        if (employees.isNotEmpty()) {
            this.employeesList.clear()
            this.employeesList.addAll(employees)
            notifyDataSetChanged()
        }
    }
}
