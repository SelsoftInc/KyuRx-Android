package com.selsoft.kyurx.ui.login.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Doctor
import com.selsoft.kyurx.utils.FontUtils

class DoctorAdapter(
    private val context: Context,
    private val doctors: MutableList<Doctor>
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.doctor_row, parent, false)
        return DoctorViewHolder(v)
    }

    override fun getItemCount(): Int {
        return doctors.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {

        val doctor: Doctor = doctors[position]

        holder.doctorRow.tag = doctor
        holder.doctorName.text = "Dr. ${doctor.firstName.toString()}"
        holder.specialist.text = doctor.emailId

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.specialist.typeface = primary
        holder.doctorName.typeface = boldFont

    }

    class DoctorViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @BindView(R.id.ly_doctor_row)
        lateinit var doctorRow: LinearLayout

        @BindView(R.id.doctor_name)
        lateinit var doctorName: TextView

        @BindView(R.id.dr_specialist)
        lateinit var specialist: TextView


        init {
            ButterKnife.bind(this, view)
        }

    }
}