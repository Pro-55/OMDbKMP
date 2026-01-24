//
//  RatingsViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 24/01/26.
//  Copyright © 2026 orgName. All rights reserved.
//
import Foundation
import shared
import UIKit

extension RatingsScreen {
    @MainActor class RatingsViewModel: ObservableObject {
        
        // Global
        private let TAG = "RatingsViewModel"
        @Published private(set) var ratings: [Rating] = []
        
        func setRatings(
            ratings: [Rating]
        ) {
            self.ratings = ratings
        }
    }
}
