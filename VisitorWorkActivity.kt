package com.example.travelbook

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_visitor_work.*
import java.util.*

class VisitorWorkActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {

    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    lateinit var tvindate: TextView
    lateinit var tvoutdate: TextView
    lateinit var tvcapacity:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitor_work)
        radioGroup = findViewById(R.id.radioGroup)
        tvcapacity = findViewById(R.id.noofguests)
        tvindate = findViewById(R.id.tvindate)
        tvoutdate = findViewById(R.id.tvoutdate)
        chkInBtn.setOnClickListener(){
            val calendar: Calendar = Calendar.getInstance()
            val year= calendar.get(Calendar.YEAR)
            val month= calendar.get(Calendar.MONTH)
            val day= calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog =
                DatePickerDialog(this, this, year, month,day)
            datePickerDialog.show()
        }
        chkOutBtn.setOnClickListener(){
            val calendar: Calendar = Calendar.getInstance()
            val year= calendar.get(Calendar.YEAR)
            val month= calendar.get(Calendar.MONTH)
            val day= calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog =
                DatePickerDialog(this, this, year, month,day)
            datePickerDialog.show()
            tvoutdate.text= "$myYear-$myMonth-$myDay"
        }
        searchBtn.setOnClickListener(){

        }
        bookBtn.setOnClickListener(){
            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)
            val roomtype = radioButton.text.toString()
            val capacity = tvcapacity.text.toString()
            val indate = tvindate.text.toString()
            val outdate = tvoutdate.text.toString()
            val type="book"
            var bookingBackground = BookingBackground()
            bookingBackground.execute(type,roomtype,capacity,indate,outdate)
            Toast.makeText(applicationContext,"Room Booked successfully !!",Toast.LENGTH_LONG)


        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = dayOfMonth
        myYear = year
        myMonth = month
        tvindate.text= "$myYear-$myMonth-$myDay"
    }
}