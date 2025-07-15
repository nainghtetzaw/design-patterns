package com.nhz.designpatterns.patterns.creationalPatterns.builderPattern

data class UserProfile(
    val username: String,
    val email: String,
    val bio: String = "",
    val website: String = "",
    val birthdate: String = "",
    val location: String = "",
    val profileImageUrl: String = "",
    val interests: List<String> = emptyList()
) {
    companion object {
        class Builder(username: String, email: String) {
            private var userProfile: UserProfile = UserProfile(username, email)

            fun bio(value: String): Builder {
                userProfile = userProfile.copy(bio = value)
                return this
            }

            fun website(value: String): Builder {
                userProfile = userProfile.copy(website = value)
                return this
            }

            fun birthdate(value: String): Builder {
                userProfile = userProfile.copy(birthdate = value)
                return this
            }

            fun location(value: String): Builder {
                userProfile = userProfile.copy(location = value)
                return this
            }

            fun profileImageUrl(value: String): Builder {
                userProfile = userProfile.copy(profileImageUrl = value)
                return this
            }

            fun interests(value: List<String>): Builder {
                userProfile = userProfile.copy(interests = value)
                return this
            }

            fun build(): UserProfile {
                val result = userProfile
                userProfile = UserProfile("", "")
                return result
            }
        }
    }
}
