//
//  NavHost.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI

struct NavHost: View {
    @State public var stack = [Route]()
    @State public var hasSignedUp = true
    
    var body: some View {
        NavigationStack(path: $stack) {
            getRoot(hasSignedUp: hasSignedUp).navigationDestination(for: Route.self) { route in
                switch(route) {
                case .Signup:
                    SignupScreen(hasSignedUp: $hasSignedUp)
                case .Home:
                    HomeScreen(stack: $stack)
                case .Search:
                    fatalError("Screens to be implemented")
                case .Details:
                    fatalError("Screens to be implemented")
                }
            }
        }
    }
    
    private func getRoot(hasSignedUp: Bool) -> some View {
        if hasSignedUp {
            return AnyView(SignupScreen(hasSignedUp: $hasSignedUp))
        } else {
            return AnyView(HomeScreen(stack: $stack))
        }
    }
}
