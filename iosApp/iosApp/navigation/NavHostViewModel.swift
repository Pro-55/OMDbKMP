//
//  NavHostViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 31/08/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

extension NavHost {
    @MainActor class NavHostViewModel: ObservableObject {
        
        // Global
        private let TAG = "NavHostViewModel"
        private let getSignUpStatusUseCase: GetSignUpStatusUseCase  = UseCaseHelper().getSignUpStatusUseCase
        @Published private(set) var loginStatus: Bool? = nil
        @Published private(set) var error: String? = nil
        
        init() {
            getLoginStatus()
        }
        
        func getLoginStatus() {
            getSignUpStatusUseCase.invoke()
                .onEach(
                    onLoading: {},
                    onSuccess: { loginStatus in
                        self.loginStatus = loginStatus as? Bool ?? false
                    },
                    onError: { error in
                        self.error = error
                        print("TestLog: onError => \(error ?? "" )")
                    })
        }
    }
}
