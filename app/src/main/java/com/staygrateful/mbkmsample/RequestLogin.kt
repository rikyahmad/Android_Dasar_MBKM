package com.staygrateful.mbkmsample

import com.google.gson.annotations.SerializedName


data class RequestLogin (

  @SerializedName("number"   ) var number   : String? = null,
  @SerializedName("password" ) var password : String? = null

)