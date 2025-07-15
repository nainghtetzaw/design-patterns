package com.nhz.designpatterns.patterns.creationalPatterns.builderPattern

fun main() {
    val userProfileWithJustUserNameAndEmail = UserProfile
        .Companion
        .Builder("bob", "bob@gmail.com")
        .build()
    val userProfileWithAllFieldsFilled = UserProfile
        .Companion
        .Builder("bob", "bob@gmail.com")
        .bio("Cat lover and software dev")
        .website("https://bobsite.com")
        .birthdate("1990-01-15")
        .location("New York")
        .profileImageUrl("http://...")
        .interests(listOf("music", "books"))
        .build()
    val userProfileWithSomeOptionalFields = UserProfile
        .Companion
        .Builder("bob", "bob@gmail.com")
        .bio("Cat lover and software dev")
        .birthdate("1990-01-15")
        .build()

    
}