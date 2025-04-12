package org.example.com.observerpattern

interface Subject {
    fun attach(observer: Observer)
    fun detach(observer: Observer)
    fun notify(message: String)
}