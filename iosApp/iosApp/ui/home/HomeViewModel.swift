//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 18/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Combine
import Foundation
import shared

extension HomeScreen {
    @MainActor class HomeViewModel: ObservableObject {
        
        // Global
        private let TAG = "HomeViewModel"
        private let getCurrentUserUseCase: GetCurrentUserUseCase  = UseCaseHelper().getCurrentUserUseCase
        private let getGreetingUseCase: GetGreetingUseCase  = UseCaseHelper().getGreetingUseCase
        private var user: User? = nil
        @Published var greeting = ""
        
        init() {
            getCurrentUser()
        }
        
        private func getCurrentUser() {
            getCurrentUserUseCase.invoke()
                .onEach(
                    onLoading: {},
                    onSuccess: { user in
                        self.user = user as? User
                        self.getGreeting()
                    },
                    onError: { error in
                        self.user = nil
                        self.getGreeting()
                    }
                )
        }
        
        private func getGreeting() {
            Task {
                while true {
                    let greeting = try? await getGreetingUseCase.invoke(userName: user?.firstName)
                    if let greeting = greeting, !greeting.isEmpty {
                        DispatchQueue.main.async {
                            self.greeting = greeting
                        }
                    }
                    try? await Task.sleep(nanoseconds: 30_000_000_000)
                }
            }
        }
    }
}
