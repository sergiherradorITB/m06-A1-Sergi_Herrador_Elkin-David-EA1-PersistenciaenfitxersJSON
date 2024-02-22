package org.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

//Class del exercici 1
@Serializable
data class Exercici1(
    val name: String,
    val price: Int,
    val stock:Int,
    val picture:String,
    val categories:Array<String>
)

fun exercici2(): List<Exercici1> {
    val jsonString = File("products1.json").readText()
    return Json.decodeFromString<List<Exercici1>>(jsonString)
}

fun main() {
    var resultat = exercici2()
    println(resultat)
}