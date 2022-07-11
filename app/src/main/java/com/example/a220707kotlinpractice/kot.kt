package com.example.a220707kotlinpractice

import java.lang.NumberFormatException

val ip : (Int) -> String = {a: Int -> "$a 출력"}
val poi : Int.() -> Int = {this*this}

fun maxOf(a : Int , b : Int) : Int {
    if (a>b)
        return a
    else
        return b
}

fun maxOf2(a : Int , b: Int) : Int = if(a>b) a else b

fun parseInt(word : String) : Int? {
    var myNum : Int? = null
    try{myNum = word.toInt()}
    catch (nfe : NumberFormatException) {return null}
    return myNum
}

fun typeCheck(something : Any) : Unit {
    if (something is String)
        println("This is String type.")
    else if (something is Int)
        println("This is Int type.")
    else
        println("I don't know.")
}
fun getStringLength(str : Any) : Int? {
    if(str is String)
        return str.length
    else
        return null
}

fun listPrint(list : List<Any>) : Unit {
    for(idx in list.indices)
        println("인덱스 : $idx, 값 : ${list[idx]}")
}
fun main(){
    println(parseInt("100"))
    println(parseInt("문자열"))
    typeCheck(100)
    typeCheck("100")
    typeCheck(100.0f)
    println(getStringLength("abcd"))
    println(getStringLength(100))

    val items : List<Any> = listOf(1,2,"a")
    for (thing in items)
        if(thing is Int)
            println(thing)
    for (idx in items.indices)
        println("인덱스 : $idx, 값 : ${items[idx]}")
    listPrint(items)
    var idxx = 0
    while (idxx != items.size){
        println(items[idxx])
        idxx++
    }

    for(i in 1..10 step 2)
        print("$i ")
    println()
    println("띄고")
    for(i in 9 downTo 0 step 3)
        print("$i ")
    println()

    val itm = setOf("avocado","banana","apple","kiwifruit")
    itm
        .filter { it.startsWith("a") }   // "a"로 시작하는 인자 찾음 -> "avocado" , "apple"
        .sortedBy { it }                       // abc 순 정렬 -> "apple" , "avocado"
        .map { it.toUpperCase() }              // 대문자로 -> "APPLE" , "AVOCADO"
        .forEach { println(it) }               // "APPLE" , "AVOCADO" 출력



}