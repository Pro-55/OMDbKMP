//
//  DetailsScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 11/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct DetailsScreen: View {
    @StateObject private var viewModel = DetailsViewModel()
    let contentId: String?
    let shortContent: ShortContent?
    let onBack: () -> Void
    
    var body: some View {
        DetailsView(
            shortContent: viewModel.shortContent,
            content: viewModel.content,
            onBack: onBack,
            onShare: { content in
                viewModel.share(content: content)
            },
            onPosterClicked: { poster in
                print("TestLog: poster => \(poster ?? "nil")")
            },
            onRatingsClicked: { ratings in
                print("TestLog: ratings => \(ratings.count)")
            },
            onTeamClicked: { teamDetails in
                print("TestLog: teamDetails => \(teamDetails)")
            },
            onSeasonSelected: { contentId, season in
                print("TestLog: contentId => \(contentId) & season => \(season)")
            }
        )
        .frame(
            maxWidth: .infinity,
            maxHeight: .infinity,
            alignment: .top
        )
        .padding(.horizontal)
        .onAppear {
            viewModel.setContentData(
                contentId: contentId,
                shortContent: shortContent
            )
        }
    }
}
