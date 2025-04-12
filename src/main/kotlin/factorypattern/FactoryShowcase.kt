package org.example.com.factorypattern

import org.example.com.ShowCase

class FactoryShowcase: ShowCase {
    override fun show() {
        println("Showcase")
    }

    override fun toString(): String {
        return "Factory Showcase"
    }
}