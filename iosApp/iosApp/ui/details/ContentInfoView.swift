//
//  ContentInfoView.swift
//  iosApp
//
//  Created by Pranit Rane on 17/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct ContentInfoView: View {
    let shortContent: ShortContent?
    let content: Content?
    let onPosterClicked: (String?) -> Void
    
    var body: some View {
        HStack(alignment: .top) {
            PosterView(
                poster: content?.poster ?? shortContent?.poster,
                width: 120
            )
            if let content = content {
                VStack(alignment: .leading) {
                    Text(content.title)
                        .font(.title)
                    
                    Text(content.buildBasicInfo())
                    
                    Text(content.genre)
                    
                    RatingBar(
                        rating: content.rating,
                        max: 10,
                        numStars: 5
                    )
                    .frame(height: 16)
                    
                    Text(content.language)
                }
                .padding(.leading)
            }
        }
        .frame(maxWidth: .infinity,
               alignment: .leading)
    }
}
