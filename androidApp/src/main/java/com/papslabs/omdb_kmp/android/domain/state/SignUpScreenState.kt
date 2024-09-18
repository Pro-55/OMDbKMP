package com.papslabs.omdb_kmp.android.domain.state

data class SignUpScreenState(
    val id: String = "",
    val firstName: TextFieldState = TextFieldState(),
    val lastName: TextFieldState = TextFieldState(),
    val email: TextFieldState = TextFieldState()
)