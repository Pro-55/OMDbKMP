//
//  NavHost.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI

struct NavHost: View {
    @StateObject private var viewModel = NavHostViewModel()
    @State private var stack: [Route] = []
    @State private var hasSignedUp: Bool?
    
    var body: some View {
        NavigationStack(path: $stack) {
            getRoot(hasSignedUp: hasSignedUp).navigationDestination(for: Route.self) { route in
                switch route {
                case .Signup:
                    SignUpScreen(hasSignedUp: $hasSignedUp)
                case .Home:
                    HomeScreen(stack: $stack)
                case .Search:
                    fatalError("Screens to be implemented")
                case .Details:
                    fatalError("Screens to be implemented")
                }
            }
        }
        .onChange(of: viewModel.loginStatus) {
            hasSignedUp = viewModel.loginStatus
        }
    }
    
    private func getRoot(hasSignedUp: Bool?) -> some View {
        switch hasSignedUp {
        case true:
            return AnyView(HomeScreen(stack: $stack))
        case false:
            return AnyView(SignUpScreen(hasSignedUp: $hasSignedUp))
        default:
            return AnyView(EmptyView())
        }
    }
}
