//
//  HomeView.swift
//  iosApp
//
//  Created by Pranit Rane on 18/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct HomeView: View {
    let greeting: String
    let navigateHomeToSearchMovies: () -> Void
    let navigateHomeToSearchSeries: () -> Void
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(verbatim: greeting)
                .font(
                    .system(
                        size: 22
                    )
                )
                .fontWeight(.bold)
            Spacer()
                .frame(height: 16)
            ContentTypeCard(
                icon: "film",
                title: "label_movies",
                onClick: navigateHomeToSearchMovies
            )
            Spacer()
                .frame(height: 16)
            ContentTypeCard(
                icon: "tv",
                title: "label_series",
                onClick: navigateHomeToSearchSeries
            )
        }
        .padding()
    }
}
