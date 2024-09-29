//
//  SearchView.swift
//  iosApp
//
//  Created by Pranit Rane on 21/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct SearchView: View {
    @State private var searchBarSize: CGSize = CGSize()
    let type: Type
    let search: [ShortContent]
    let shouldPeek: Bool
    let peekContent: ShortContent?
    @Binding var query: String
    @FocusState var isFocused: Bool
    let onClearSearchQuery: () -> Void
    let onLoadMore: () -> Void
    let onHold: (ShortContent) -> Void
    let onRelease: () -> Void
    let onContentClicked: (ShortContent) -> Void
    
    var iconAndTitle: (icon: String?, title: LocalizedStringKey?) {
        switch type {
        case .movie:
            return ("film", "label_movies")
        case .series:
            return ("tv", "label_series")
        case .episodes:
            return ("film", "label_movies")
        default:
            return (nil, nil)
        }
    }
    
    var body: some View {
        ZStack(alignment: .bottom) {
            if search.isEmpty {
                EmptyContentView(
                    icon: iconAndTitle.icon,
                    title: iconAndTitle.title
                )
            } else {
                ContentGrid(
                    search: search,
                    searchBarHeight: searchBarSize.height,
                    isScrollLocked: shouldPeek,
                    onLoadMore: onLoadMore,
                    onHold: onHold,
                    onRelease: onRelease,
                    onContentClicked: onContentClicked,
                    clearFocus: {
                        isFocused = false
                    }
                )
            }
            
            SearchBar(
                query: $query,
                searchBarSize: $searchBarSize,
                isFocused: _isFocused,
                onClearSearchQuery: onClearSearchQuery
            )
            .padding(.horizontal)
            .padding(.bottom)
            
            VStack {
                PeekView(
                    shouldPeek: shouldPeek,
                    peekContent: peekContent
                )
            }
        }
    }
}
