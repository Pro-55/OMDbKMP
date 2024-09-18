//
//  SignUpView.swift
//  iosApp
//
//  Created by Pranit Rane on 17/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Combine

struct SignUpView: View {
    @Binding var firstName: String
    @Binding var lastName: String
    @Binding var email: String
    var signUp: () -> Void
    
    var body: some View {
        Form {
            Section {
                TextField("hint_first_name", text: $firstName)
                    .onReceive(Just(firstName)) { value in
                        let filteredValue = value.filterOutNonLetters()
                        if firstName != filteredValue {
                            firstName = filteredValue
                        }
                    }
                    .autocorrectionDisabled()
                
                TextField("hint_last_name", text: $lastName)
                    .onReceive(Just(lastName)) { value in
                        let filteredValue = value.filterOutNonLetters()
                        if lastName != filteredValue {
                            lastName = filteredValue
                        }
                    }
                    .autocorrectionDisabled()
                
                TextField("hint_email", text: $email)
                    .keyboardType(.emailAddress)
                    .autocapitalization(.none)
                    .autocorrectionDisabled()
            }
            Button("btn_save") {
                signUp()
            }
        }
    }
}
