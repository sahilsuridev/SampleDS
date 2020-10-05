package arrays

import java.util.HashMap

class HashMapTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val mapKotlin = mutableMapOf<String, String>()
            mapKotlin["key3"] = "Sahil3"
            mapKotlin["key1"] = "Sahil1"
            mapKotlin["key4"] = "Sahil4"
            mapKotlin["key7"] = "Sahil7"
            mapKotlin["key5"] = "Sahil5"
            mapKotlin["key6"] = "Sahil6"
            mapKotlin["key2"] = "Sahil2"
            mapKotlin.entries.forEach {
                println("mapKotlin key is ${it.key} value is ${it.value}")
            }

            val map = HashMap<String, String>()
            map["key3"] = "Sahil3"
            map["key1"] = "Sahil1"
            map["key4"] = "Sahil4"
            map["uukey7"] = "Sahil7"
            map["key9"] = "Sahil9"
            map["key5"] = "Sahil5"
            map["zzkey6"] = "Sahil6"
            map["key2"] = "Sahil2"
            map["key8"] = "Sahil8"
            map["key10"] = "Sahil10"

            map["FB1"] = "Sahil3"
            map["EA1"] = "Sahil1"
            map["FB0"] = "Sahil4"
            map["EA0"] = "Sahil7"
            map["FB2"] = "Sahil9"
            map["EA2"] = "Sahil5"

            map.entries.forEach {
                println("key is ${it.key} value is ${it.value}")
            }

            map.forEach { t, u -> println("** key is $t value is $u")  }
        }
    }
}