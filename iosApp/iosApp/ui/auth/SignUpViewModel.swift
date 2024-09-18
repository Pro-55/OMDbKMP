//
//  SignUpViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 01/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import shared

extension SignUpScreen {
    @MainActor class SignUpViewModel: ObservableObject {
        
        // Global
        private let TAG = "SignUpViewModel"
        private let signUpUseCase: SignUpUseCase  = UseCaseHelper().signUpUseCase
        @Published private(set) var isLoading = false
        @Published private(set) var hasSignUpSuccessfully = false
        @Published private(set) var error: String? = nil
        @Published var firstName = ""
        @Published var lastName = ""
        @Published var email = ""
        
        func signUp() {
            if isInvalid() {
                return
            }
            signUpUseCase.invoke(
                id: NSUUID().uuidString,
                firstName: firstName.filterOutNonLetters(),
                lastName: lastName.filterOutNonLetters(),
                email: email.trimmingCharacters(in: .whitespacesAndNewlines)
            )
            .onEach(
                onLoading: {
                    self.isLoading = true
                },
                onSuccess: { user in
                    self.isLoading = false
                    self.hasSignUpSuccessfully = true
                },
                onError: { error in
                    self.error = error
                    self.isLoading = false
                })
        }
        
        private func isInvalid() -> Bool {
            let firstName = firstName.filterOutNonLetters()
            let firstNameError: String? = if firstName.isEmpty {
                ""
            } else {
                nil
            }
            
            let lastName = lastName.filterOutNonLetters()
            let lastNameError: String? = if lastName.isEmpty {
                ""
            } else {
                nil
            }
            
            let email = email.trimmingCharacters(in: .whitespacesAndNewlines)
            let emailError: String? = if email.isEmpty || !email.isValidEmail() {
                ""
            } else {
                nil
            }
            return firstNameError != nil
            || lastNameError != nil
            || emailError != nil
        }
    }
}
