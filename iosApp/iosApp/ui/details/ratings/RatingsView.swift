//
//  RatingsView.swift
//  iosApp
//
//  Created by Pranit Rane on 24/01/26.
//  Copyright © 2026 orgName. All rights reserved.
//
import shared
import SwiftUI

struct RatingsView: View {
    let ratings: [Rating]
    let onBack: () -> Void
    
    var body: some View {
        VStack(spacing: 0) {
            if ratings.isEmpty {
                ZStack(alignment: .center) {
                    Text("label_no_ratings")
                        .font(.title)
                        .fontWeight(.bold)
                        .multilineTextAlignment(.center)
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
                .padding(16)
            } else {
                ScrollView {
                    LazyVStack(spacing: 0) {
                        ForEach(ratings, id: \.self) { rating in
                            VStack(alignment: .center, spacing: 0) {
                                Text(rating.value)
                                    .lineLimit(1)
                                    .font(.title)
                                    .fontWeight(.bold)
                                    .multilineTextAlignment(.center)
                                
                                Spacer()
                                    .frame(height: 4)
                                
                                Text(rating.source)
                                    .font(.body)
                                    .fontWeight(.regular)
                                    .multilineTextAlignment(.center)
                            }
                            .frame(maxWidth: .infinity)
                            .padding([.leading, .top, .trailing], 16)
                        }
                    }
                    .padding(.bottom, 16)
                }
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .navigationTitle("label_ratings")
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .topBarLeading) {
                Button(action: onBack) {
                    Image(systemName: "chevron.left")
                }
            }
        }
    }
}
