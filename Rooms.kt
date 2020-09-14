package com.example.travelbook

import java.util.*

class Rooms(var type:String,var capacity:Int,var indate:String,var outdate:String) {
    override fun toString(): String {
        return type
    }
}