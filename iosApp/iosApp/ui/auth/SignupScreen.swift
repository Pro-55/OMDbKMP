//
//  SignupScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI

struct SignUpScreen: View {
    @StateObject private var viewModel = SignUpViewModel()
    @Binding var hasSignedUp: Bool?
    
    var body: some View {
        SignUpView(
            firstName: $viewModel.firstName,
            lastName: $viewModel.lastName,
            email: $viewModel.email,
            signUp: viewModel.signUp
        )
        .onChange(of: viewModel.hasSignUpSuccessfully) {
            hasSignedUp = viewModel.hasSignUpSuccessfully
        }
    }
}
