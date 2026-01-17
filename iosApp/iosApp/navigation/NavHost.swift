//
//  NavHost.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI
import shared

struct NavHost: View {
    @StateObject private var viewModel = NavHostViewModel()
    @State private var stack: [Route] = []
    @State private var hasSignedUp: Bool?
    @State private var isOverlayVisible: Bool = false
    
    var body: some View {
        NavigationStack(path: $stack) {
            getRoot(hasSignedUp: hasSignedUp).navigationDestination(for: Route.self) { route in
                switch route {
                case .Signup:
                    SignUpScreen(hasSignedUp: $hasSignedUp)
                case .Home:
                    HomeScreen(
                        navigateHomeToSearchMovies: {
                            stack.append(.Search(type: Type.movie))
                        },
                        navigateHomeToSearchSeries: {
                            stack.append(.Search(type: Type.series))
                        }
                    )
                case .Search(let type):
                    SearchScreen(
                        type: type,
                        isOverlayVisible: $isOverlayVisible,
                        navigateSearchToDetails: { content in
                            stack.append(.Details(shortContent: content))
                        }
                    )
                    .navigationBarHidden(isOverlayVisible)
                case .Details(
                    let contentId,
                    let shortContent
                ):
                    DetailsScreen(
                        contentId: contentId,
                        shortContent: shortContent,
                        onBack: {
                            stack.removeLast()
                        }
                    )
                    .navigationBarBackButtonHidden(true)
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
            return AnyView(
                HomeScreen(
                    navigateHomeToSearchMovies: {
                        stack.append(.Search(type: Type.movie))
                    },
                    navigateHomeToSearchSeries: {
                        stack.append(.Search(type: Type.series))
                    }
                )
            )
        case false:
            return AnyView(SignUpScreen(hasSignedUp: $hasSignedUp))
        default:
            return AnyView(EmptyView())
        }
    }
}
