package org.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File


// Class del exercici 2 i també farem servir el ProducteEx2
@Serializable
data class Category(
    val id: Int,
    val name: String
)

@Serializable
data class ProducteEx2(
    val name: String,
    val price: Int,
    val stock: Int,
    val picture: String,
    val categories: List<Category>
)

//Class del exercici 1
@Serializable
data class Producte(
    val name: String,
    val price: Int,
    val stock: Int,
    val picture: String,
    val categories: List<String>
)

fun exercici2() {
    val lines = File("/home/sergi.herrador.7e7/Baixades/products1.json").readLines()
    val resultList = mutableListOf<Producte>()
    for (line in lines) {
        val item = Json.decodeFromString<Producte>(line)
        resultList.add(item)
    }
    for (linea in resultList) {
        println(linea)
    }
}

fun exercici3() {
    // Leer productos existentes desde el archivo
    val existingProducts = mutableListOf<Producte>()

    // Crear cinco nuevos objetos Exercici1
    val newProduct1 = Producte("Producte 1", 100, 20, "product1.jpg", listOf("categoria1", "categoria2"))
    val newProduct2 = Producte("Producte 2", 150, 15, "product2.jpg", listOf("categoria1", "categoria3"))
    val newProduct3 = Producte("Producte 3", 80, 25, "product3.jpg", listOf("categoria2", "categoria4"))
    val newProduct4 = Producte("Producte 4", 200, 10, "product4.jpg", listOf("categoria3", "categoria5"))
    val newProduct5 = Producte("Producte 5", 120, 30, "product5.jpg", listOf("categoria4", "categoria5"))

    // Añadir los nuevos productos a la lista de productos existentes
    existingProducts.add(newProduct1)
    existingProducts.add(newProduct2)
    existingProducts.add(newProduct3)
    existingProducts.add(newProduct4)
    existingProducts.add(newProduct5)

    // Serializar todos los productos a JSON
    val jsonList = mutableListOf<String>()
    for (product in existingProducts) {
        val productJson = Json.encodeToString(product)
        jsonList.add(productJson)
    }

    // Escribir los JSON en el archivo
    val jsonFile = File("/home/sergi.herrador.7e7/Baixades/products1.json")
    jsonFile.appendText(jsonList.joinToString("\n")) // escric el text de la llista i per cada element el separo amb un breakline identificat com \n
}

fun exercici4() {
    // Leer el archivo products2.json
    val lines = File("/home/sergi.herrador.7e7/Baixades/products2.json").readLines()
    val productList = mutableListOf<ProducteEx2>()

    // Decodificar cada línea del JSON a un objeto Product
    for (line in lines) {
        try {
            val product = Json.decodeFromString<ProducteEx2>(line)
            productList.add(product)
        } catch (e: Exception) {
            println("Error decoding JSON line: $line")
            // e.printStackTrace()
        }
    }

    // Mostrar los datos por pantalla
    for (product in productList) {
        println("Name: ${product.name}")
        println("Price: ${product.price}")
        println("Stock: ${product.stock}")
        println("Picture: ${product.picture}")
        println("Categories:")
        for (category in product.categories) {
            println("  - ID: ${category.id}, Name: ${category.name}")
        }
        println()
    }
}


fun exercici5() {
    // Leer el archivo products2.json
    val lines = File("/home/sergi.herrador.7e7/Baixades/products2.json").readLines()
    val newProducts = mutableListOf<ProducteEx2>()

    // Decodificar cada línea del JSON a un objeto Product y agregarlo a la lista
    for (line in lines) {
        val product = Json.decodeFromString<ProducteEx2>(line)
        newProducts.add(product)
    }
    for (linea in newProducts) {
        println(linea)
    }
}


fun exercici6() {
    val products = mutableListOf<ProducteEx2>()

    // Crear cinco nuevos productos y agregarlos a la lista de productos
    for (i in 1..5) {
        val newProduct = ProducteEx2(
            "Nuevo Producto $i",
            1499,
            10,
            "nuevo_producto$i.jpg",
            listOf(Category(18, "nueva_categoria9"), Category(19, "nueva_categoria10"))
        )
        products.add(newProduct)
    }

    // Convertir la lista de nuevos productos a JSON
    val newProductsJsonList = mutableListOf<String>()
    for (product in products) {
        newProductsJsonList.add(Json.encodeToString(product))
    }

    // Escribir los nuevos productos en el archivo products2.json
    val jsonFile = File("/home/sergi.herrador.7e7/Baixades/products2.json")
    jsonFile.appendText("\n")
    jsonFile.appendText(newProductsJsonList.joinToString("\n"))
}

fun main() {
    // Execucío exercici2
    exercici2()


    // Execució exercici3
    exercici3()

    // Execucío exercici4
    exercici4()

    // Execucío exercici5
    exercici5()


    // Execucío exercici6
     exercici6()
}