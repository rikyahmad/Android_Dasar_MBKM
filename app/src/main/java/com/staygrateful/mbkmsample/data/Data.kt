package com.staygrateful.mbkmsample.data

import com.staygrateful.mbkmsample.data.model.MhsRoomModel
import com.staygrateful.mbkmsample.data.model.SampleModel

object Data {

    val DUMMY_DATA = mutableListOf<SampleModel>().apply {
        for (i in 0..100) {
            this.add(SampleModel(i, "Title $i", "Desc $i"))
        }
    }

    val MHS_ROOM_DATA = mutableListOf(
        MhsRoomModel(0, "Doni", "Universitas A"),
        MhsRoomModel(0, "Dina", "Universitas B"),
        MhsRoomModel(0, "Adi", "Universitas C"),
        MhsRoomModel(0, "Dian", "Universitas D"),
        MhsRoomModel(0, "Bayu", "Universitas E"),
        MhsRoomModel(0, "Endah", "Universitas F"),
        MhsRoomModel(0, "Andi", "Universitas G"),
        MhsRoomModel(0, "Budi", "Universitas H"),
        MhsRoomModel(0, "Cindy", "Universitas I"),
        MhsRoomModel(0, "Billa", "Universitas J"),
        MhsRoomModel(0, "Ronny", "Universitas K"),
        MhsRoomModel(0, "Rizal", "Universitas L"),
        MhsRoomModel(0, "Anang", "Universitas M"),
        MhsRoomModel(0, "Zendy", "Universitas N"),
        MhsRoomModel(0, "Salsa", "Universitas O"),
        MhsRoomModel(0, "Ayu", "Universitas P"),
        MhsRoomModel(0, "Shinta", "Universitas Q"),
        MhsRoomModel(0, "Shandy", "Universitas R"),
        MhsRoomModel(0, "Shinta", "Universitas S"),
        MhsRoomModel(0, "Nia", "Universitas T"),
        MhsRoomModel(0, "Rizal", "Universitas U"),
        MhsRoomModel(0, "Joko", "Universitas V"),
        MhsRoomModel(0, "Santoso", "Universitas W"),
        MhsRoomModel(0, "Deni", "Universitas X"),
        MhsRoomModel(0, "Risa", "Universitas Y"),
        MhsRoomModel(0, "Dona", "Universitas Z"),
    )
}