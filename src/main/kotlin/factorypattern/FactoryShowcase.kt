package org.example.com.factorypattern

import org.example.com.ShowCase

class FactoryShowcase: ShowCase {
    override fun show() {
        val sm64wr = VideoFactory.create("speedrun", "New SM64 WR 120 stars 1:43:12")
        val wrReviewVideo = VideoFactory.create("review", "Breakdown of *NEW WR*")
        val newTrickForOwlless = VideoFactory.create("tutorial", "New Trick for Owlless")

        sm64wr.play()
        wrReviewVideo.play()
        newTrickForOwlless.play()
    }

    override fun toString(): String {
        return "Factory Showcase"
    }
}