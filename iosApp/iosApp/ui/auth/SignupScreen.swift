//
//  SignupScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI

struct SignupScreen: View {
    @Binding var hasSignedUp: Bool
    
    var body: some View {
        VStack {
            Text("Auth!")
            Button("Sign Up") {
                hasSignedUp = false
            }
        }
    }
}
