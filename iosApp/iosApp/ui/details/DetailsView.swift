//
//  DetailsView.swift
//  iosApp
//
//  Created by Pranit Rane on 11/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct DetailsView: View {
    let shortContent: ShortContent?
    let content: Content?
    let onBack: () -> Void
    let onShare: (Content) -> Void
    let onPosterClicked: (String?) -> Void
    let onRatingsClicked: ([Rating]) -> Void
    let onTeamClicked: (TeamDetails) -> Void
    let onSeasonSelected: (String, Int) -> Void
    
    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 0) {
                ContentInfoView(
                    shortContent: shortContent,
                    content: content,
                    onPosterClicked: onPosterClicked
                )
                .padding(16)
                
                if let safeContent = content {
                    VStack(alignment: .leading, spacing: 16) {
                        // Plot Section
                        Text("label_plot")
                            .font(.title2)
                            .fontWeight(.bold)
                            .padding(.horizontal, 16)
                        
                        Text(safeContent.plot)
                            .font(.body)
                            .fontWeight(.regular)
                            .padding(.horizontal, 16)
                            .padding(.bottom, 8)
                        
                        // More Info Links
                        MoreInfoView(label: "label_ratings") {
                            onRatingsClicked(safeContent.ratings)
                        }
                        
                        MoreInfoView(label: "label_team") {
                            onTeamClicked(safeContent.team)
                        }
                        
                        // Seasons Grid
                        if safeContent.seasons > 0 {
                            Text("label_seasons")
                                .font(.title2)
                                .fontWeight(.bold)
                                .padding(.horizontal, 16)
                                .padding(.top, 8)
                            
                            LazyVGrid(columns: Array(repeating: GridItem(.flexible(), spacing: 12), count: 4), spacing: 12) {
                                ForEach(0..<safeContent.seasons, id: \.self) { index in
                                    let abc = Int(index)
                                    SeasonChip(seasonNumber: abc + 1) {
                                        onSeasonSelected(safeContent.id, abc + 1)
                                    }
                                }
                            }
                            .padding(.horizontal, 16)
                        }
                    }
                }
            }
        }
        .navigationTitle("label_details")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .topBarLeading) {
                Button(action: onBack) {
                    Image(systemName: "chevron.left")
                }
            }
            ToolbarItem(placement: .topBarTrailing) {
                if let safeContent = content {
                    Button {
                        onShare(safeContent)
                    } label: {
                        Image(systemName: "square.and.arrow.up")
                    }
                }
            }
        }
    }
}
