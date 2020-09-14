package com.example.travelbook

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_admin_work.*
import kotlinx.android.synthetic.main.activity_visitor_work.*
import java.util.*

class AdminWorkActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {

    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    lateinit var tvindate: TextView
    lateinit var capacity: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_work)
        radioGroup = findViewById(R.id.radioGroup)
        tvindate = findViewById(R.id.tvindate)
        capacity = findViewById<TextView>(R.id.noofguests)
        chkInButton.setOnClickListener() {
            val calendar: Calendar = Calendar.getInstance()
            val year= calendar.get(Calendar.YEAR)
            val month= calendar.get(Calendar.MONTH)
            val day= calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog =
                DatePickerDialog(this, this, year, month,day)
            datePickerDialog.show()

        }

        modifyBtn.setOnClickListener(){
            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)
            val roomtype = radioButton.text.toString()
            var noGuests=capacity.text.toString()
            var indate=tvindate.text.toString()
            var type = "modify"

            var bookingBackground = BookingBackground()
            bookingBackground.execute(type,roomtype,noGuests,indate)
            Toast.makeText(applicationContext,"Details updated successfully !!",Toast.LENGTH_LONG)
        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = dayOfMonth
        myYear = year
        myMonth = month
        tvindate.text= "$myYear-$myMonth-$myDay"
    }
}