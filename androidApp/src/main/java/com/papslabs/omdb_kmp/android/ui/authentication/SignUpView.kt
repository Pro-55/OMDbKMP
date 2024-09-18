package com.papslabs.omdb_kmp.android.ui.authentication

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.papslabs.omdb_kmp.android.R
import com.papslabs.omdb_kmp.android.domain.state.SignUpScreenState
import com.papslabs.omdb_kmp.android.domain.state.TextFieldState
import com.papslabs.omdb_kmp.android.theme.OMDbKmpTheme
import com.papslabs.omdb_kmp.android.util.PhoneLightPreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpView(
    snackbarHostState: SnackbarHostState,
    isLoading: Boolean,
    state: SignUpScreenState,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onSave: () -> Unit
) {
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(height = 32.dp)
            )
            PersonalDetailsView(
                isLoading = isLoading,
                firstName = state.firstName,
                onFirstNameChange = onFirstNameChange,
                lastName = state.lastName,
                onLastNameChange = onLastNameChange,
                email = state.email,
                onEmailChange = onEmailChange
            )
            Spacer(
                modifier = Modifier
                    .height(height = 16.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.small,
                enabled = !isLoading,
                onClick = onSave
            ) {
                Text(
                    text = stringResource(id = R.string.btn_save),
                    style = MaterialTheme.typography.labelLarge.copy(
                        textAlign = TextAlign.Center
                    )
                )
            }
            Spacer(
                modifier = Modifier
                    .height(height = 32.dp)
            )
        }
    }
}

@PhoneLightPreview
@Composable
fun SignUpViewPreview() {
    OMDbKmpTheme {
        val snackbarHostState = remember { SnackbarHostState() }
        SignUpView(
            snackbarHostState = snackbarHostState,
            isLoading = false,
            state = SignUpScreenState(
                firstName = TextFieldState(text = "Pranit"),
                lastName = TextFieldState(text = "Rane"),
                email = TextFieldState(text = "abc@xyz.com")
            ),
            onFirstNameChange = {},
            onLastNameChange = {},
            onEmailChange = {},
            onSave = {}
        )
    }
}