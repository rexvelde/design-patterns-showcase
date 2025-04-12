package org.example.com

import org.example.com.factorypattern.FactoryShowcase
import org.example.com.observerpattern.ObserverShowCase


fun main() {
    var selection: Int
    var option: MutableList<ShowCase> = mutableListOf()

    option.add(ObserverShowCase())
    option.add(FactoryShowcase())

    do {
        println("Enter option corresponding to list:")
        for (index in 0..(option.size-1)) println(message = "[${index+1}] ${option.get(index)}")
        print("[0] Exit\n>>> ")
        selection = readLine()!!.toInt()

        if (selection == 0) break
        option[selection-1].show()
        println("\n")
    } while (true)
}
