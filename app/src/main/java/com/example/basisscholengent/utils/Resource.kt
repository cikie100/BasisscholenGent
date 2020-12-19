package com.example.basisscholengent.utils

data class Resource<out T>(val status : Status, val data:T?,val message:String?){
    companion object{
        //data = getScholenApi

        //ALS API gelukt
        fun<T> success(data: T):Resource<T>{
            return Resource(Status.SUCCESS , data,null) //data =0 //TODO
        }

        //ALS API error
        fun<T> error(message: String,data: T? = null):Resource<T>{
            return  Resource(Status.ERROR,data,message)
        }

        //ALS API aan het loaden
        fun<T> loading(data: T?=null):Resource<T>{
            return Resource(Status.LOADING, data,null)
        }
    }

}
