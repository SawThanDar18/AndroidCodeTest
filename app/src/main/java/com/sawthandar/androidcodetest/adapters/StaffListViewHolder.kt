package com.sawthandar.androidcodetest.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.carbs.android.avatarimageview.library.AvatarImageView
import com.bumptech.glide.Glide
import com.sawthandar.androidcodetest.R
import com.sawthandar.androidcodetest.api.response.Employees

/**
 * Created by lin min phyo on 2/25/18.
 */
class StaffListViewHolder(itemView: View) : RecyclerView.ViewHolder(
    itemView
) {

    var staffProfileImage: AvatarImageView = itemView.findViewById(R.id.staffProfile)
    var staffName: TextView = itemView.findViewById(R.id.staffName)
    var status: TextView = itemView.findViewById(R.id.staffStatus)

    fun bind(employees: Employees) {
       /* Glide.with(itemView)
            .load(employees.image)
            .into(staffProfileImage)*/
        staffName.text = employees.name
        status.text = employees.value

    }
}