package org.example.com.observerpattern

interface Observer {
    fun update(pattern: String)
    fun newSubscription(subject: Subject)
    fun removeSubscription(subject: Subject)
}