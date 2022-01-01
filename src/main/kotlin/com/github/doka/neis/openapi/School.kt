package com.github.doka.neis.openapi

class School {
    companion object{
        fun find(key:String, type: String, pIndex: Int = 1, pSize:Int = 100):String{
            val builder = StringBuilder("https://open.neis.go.kr/hub/schoolInfo?")
            builder.append("KEY=$key&")
            builder.append("Type=$type&")
            builder.append("pIndex=$pIndex&")
            builder.append("pSize=$pSize&")
            builder.deleteAt(builder.length-1)
            return builder.toString()
        }
    }
}