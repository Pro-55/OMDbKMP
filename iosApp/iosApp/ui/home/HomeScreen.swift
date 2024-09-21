//
//  HomeScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI

struct HomeScreen: View {
    @StateObject private var viewModel = HomeViewModel()
    let navigateHomeToSearchMovies: () -> Void
    let navigateHomeToSearchSeries: () -> Void
    
    var body: some View {
        HomeView(
            greeting: viewModel.greeting,
            navigateHomeToSearchMovies: navigateHomeToSearchMovies,
            navigateHomeToSearchSeries: navigateHomeToSearchSeries
        )
    }
}
