package com.example.travelbook

object RoomDetails {
    val types=listOf(
        Rooms("Standard",2,"2020-09-14","2020-09-20"),
        Rooms("Deluxe",2,"2020-10-14","2020-10-20"),
        Rooms("Standard",3,"2020-09-24","2020-09-30"),
        Rooms("Luxury",4,"2020-10-04","2020-10-10"),
        Rooms("Deluxe",2,"2020-09-14","2020-09-25"),
        Rooms("Standard",4,"2020-09-12","2020-09-15")
    )
    val noRoom= listOf<Rooms>()
    fun getRoom(category:String):List<Rooms>{
        when(category){
            "types"->return types
            else->return noRoom
        }
    }
}