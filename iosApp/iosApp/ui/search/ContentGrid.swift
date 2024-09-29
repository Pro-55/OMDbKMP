//
//  ContentGrid.swift
//  iosApp
//
//  Created by Pranit Rane on 22/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct ContentGrid: View {
    private let columns = [
        GridItem(.flexible(), spacing: 0),
        GridItem(.flexible(), spacing: 0)
    ]
    let search: [ShortContent]
    let searchBarHeight: CGFloat
    let isScrollLocked: Bool
    let onLoadMore: () -> Void
    let onHold: (ShortContent) -> Void
    let onRelease: () -> Void
    let onContentClicked: (ShortContent) -> Void
    let clearFocus: () -> Void
    
    var body: some View {
        ScrollView(showsIndicators: false) {
            LazyVGrid(columns: columns, spacing: 0) {
                ForEach(search, id: \.self) { item in
                    PosterView(poster: item.poster)
                        .detectHoldGesture(
                            onClick: {
                                clearFocus()
                                onContentClicked(item)
                            },
                            onHold: {
                                clearFocus()
                                onHold(item)
                            },
                            onRelease: onRelease
                        )
                        .padding(4)
                }
                Spacer(minLength: searchBarHeight + 20)
                    .onAppear(perform: onLoadMore)
            }
            .padding(.horizontal, 4)
        }
        .scrollDisabled(isScrollLocked)
        .scrollDismissesKeyboard(.immediately)
    }
}
