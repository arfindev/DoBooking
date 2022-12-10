package com.arfincoding.dobooking.domain.model

import androidx.annotation.DrawableRes
import com.arfincoding.dobooking.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
) {
    object First : OnBoardingPage(
        image = R.drawable.luxyryboutique2,
        title = "Find the best hotels for" +
                " your vacation",
        description = "Feel the sunset and dive deep into the ocean." +
                "One of the best place to give your heart and mind purity." +
                "Don't miss the chance. You only live once."
    )

    object Second : OnBoardingPage(
        image = R.drawable.seminyak,
        title = "Let's discover the world" +
                "with us",
        description = "Enjoy a fabulous hospitality " +
                "Booking & Cancellation anytime anywhere" +
                "you want to. Feel secure with our protection"
    )

    object Third : OnBoardingPage(
        image = R.drawable.travelman,
        title = "Travel safely," +
                "comfortably, & easily",
        description = "Enjoy a fabulous hospitality " +
                "Booking & Cancellation anytime anywhere" +
                "you want to. Feel secure with our protection"
    )

}
