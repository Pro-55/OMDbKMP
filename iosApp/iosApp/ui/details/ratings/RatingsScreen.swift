//
//  RatingsScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 24/01/26.
//  Copyright © 2026 orgName. All rights reserved.
//
import shared
import SwiftUI

struct RatingsScreen: View {
    @StateObject private var viewModel = RatingsViewModel()
    let ratings: [Rating]
    let onBack: () -> Void
    
    var body: some View {
        RatingsView(
            ratings: viewModel.ratings,
            onBack: onBack
        )
        .onAppear {
            viewModel.setRatings(ratings: ratings)
        }
    }
}
