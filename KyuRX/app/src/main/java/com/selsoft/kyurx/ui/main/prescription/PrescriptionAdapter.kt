package com.selsoft.kyurx.ui.main.prescription

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
import com.selsoft.kyurx.model.Prescription
import com.selsoft.kyurx.utils.FontUtils

class PrescriptionAdapter(
    var context: Context,
    val prescriptions: MutableList<Prescription>
) : RecyclerView.Adapter<PrescriptionAdapter.PrescriptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrescriptionViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.row_prescription, parent, false)
        return PrescriptionViewHolder(root)
    }

    override fun getItemCount(): Int {
        return prescriptions.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PrescriptionViewHolder, position: Int) {
        val prescription: Prescription = prescriptions[position]

//        holder.prescriptionLY.tag = prescription
        holder.medicineCount.text = "${prescription.medicines.size}"
        holder.patientName.text =
            "${prescription.patient?.firstName} ${prescription.patient?.lastName}"
        holder.drName.text = "DR. ${prescription.doctor?.firstName} ${prescription.doctor?.lastName}"
        holder.createdDate.text = prescription.createdDate

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.patientName.typeface = boldFont
        holder.drName.typeface = primary
        holder.createdDate.typeface = primary
        holder.medicineCount.typeface = boldFont
        holder.medicineCountTxt.typeface = boldFont
    }

    class PrescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        @BindView(R.id.ly_prescription)
//        lateinit var prescriptionLY: LinearLayout

        @BindView(R.id.medicine_count)
        lateinit var medicineCount: TextView

        @BindView(R.id.txt_medicine_count)
        lateinit var medicineCountTxt: TextView

        @BindView(R.id.patient_name)
        lateinit var patientName: TextView

        @BindView(R.id.dr_name)
        lateinit var drName: TextView

        @BindView(R.id.created_date)
        lateinit var createdDate: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

    }

}