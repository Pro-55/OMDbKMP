//
//  SearchScreen.swift
//  iosApp
//
//  Created by Pranit Rane on 21/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct SearchScreen: View {
    @StateObject private var viewModel = SearchViewModel()
    let type: Type
    @Binding var isOverlayVisibile: Bool
    let navigateSearchToDetails: (ShortContent) -> Void
    
    var body: some View {
        SearchView(
            type: type,
            search: viewModel.result.search,
            shouldPeek: viewModel.shouldPeek,
            peekContent: viewModel.peekContent,
            query: $viewModel.query,
            onClearSearchQuery: viewModel.onClearSearchQuery,
            onLoadMore: viewModel.loadMore,
            onHold: viewModel.onHold,
            onRelease: viewModel.onRelease,
            onContentClicked: navigateSearchToDetails
        )
        .onChange(of: viewModel.shouldPeek) {
            isOverlayVisibile = viewModel.shouldPeek
        }
        .onAppear {
            viewModel.setType(type: type)
        }
    }
}
