package com.nhz.designpatterns.patterns.creationalPatterns.builderPattern

fun main() {
    val userProfileWithJustUserNameAndEmail = buildUserProfile(
        username = "bob",
        email = "bob@gmail.com"
    )
    val userProfileWithAllFieldsFilled = buildUserProfile(
        username = "bob",
        email = "bob@gmail.com",
        builder = {
            bio("Cat lover and software dev")
            website("https://bobsite.com")
            birthdate("1990-01-15")
            location("New York")
            profileImageUrl("http://...")
            interests(listOf("music", "books"))
        }
    )
    val userProfileWithSomeOptionalFields = buildUserProfile(
        username = "bob",
        email = "bob@gmail.com",
        builder = {
            bio("Cat lover and software dev")
            website("https://bobsite.com")
        }
    )

    println("User profile just username and email: $userProfileWithJustUserNameAndEmail")
    println("User profile with all fields filled: $userProfileWithAllFieldsFilled")
    println("User profile with some optional fields: $userProfileWithSomeOptionalFields")
}