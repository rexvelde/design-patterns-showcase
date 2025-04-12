package org.example.com

import org.example.com.observerpattern.Observer
import org.example.com.observerpattern.Subject

fun main() {
    // YouTube channels
    val summoningSalt = Channel("Summoning Salt")
    val rileyCR = Channel("RileyCR")
    val historyForGranite = Channel("History For GRANITE")

    // Viewers
    val rexvelde = Subscriber("rexvelde")
    val mrallegiant = Subscriber("Mr Allegiant")
    val anonymous = Subscriber("Anonymous")

    // Subscriber moment for rexvelde
    summoningSalt.attach(rexvelde)
    rileyCR.attach(rexvelde)
    historyForGranite.attach(rexvelde)

    // Subscriber moment for mrallegiant
    rileyCR.attach(mrallegiant)

    // Anonymous does not subscribe

    // All channels upload a video
    summoningSalt.notify("Early SM64 speedrunning history (2004-2014)")
    historyForGranite.notify("Explanation of internal and external ramp")
    rileyCR.notify("This deck WITHOUT CHAMPIONS has 94% win rate")

    // Show all alerts
    println("rexvelde's notifications: " + rexvelde.notifications)
    println("MrAllegiant's notifications: " + mrallegiant.notifications)
    println("Anonymous' notifications: " + anonymous.notifications)

    // Show subscription
    println("rexvelde's subscribed channels: " + rexvelde.subscribedChannels)
    println("MrAllegiant's subscribed channels: " + mrallegiant.subscribedChannels)
    println("Anonymous' subscribed channels: " + anonymous.subscribedChannels)
}

class Channel(val name: String) : Subject {
    var subscribers: MutableList<Subscriber> = mutableListOf()

    override fun attach(observer: Observer) {
        subscribers.add(observer as Subscriber)
        observer.newSubscription(this)
    }

    override fun detach(observer: Observer) {
        subscribers.remove(observer as Subscriber)
        observer.removeSubscription(this)
    }

    override fun notify(message: String) {
        for (subscriber in subscribers) {
            subscriber.update(message)
        }
    }

    override fun toString(): String {
        return name + " @ " + hashCode()
    }
}

class Subscriber(val name: String) : Observer {
    var notifications: MutableList<String> = mutableListOf()
    var subscribedChannels: MutableList<Channel> = mutableListOf()

    override fun update(pattern: String) {
        notifications.add(pattern)
    }

    override fun newSubscription(subject: Subject) {
        subscribedChannels.add(subject as Channel)
    }

    override fun removeSubscription(subject: Subject) {
        subscribedChannels.remove(subject as Channel)
    }
}
