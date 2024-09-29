//
//  SearchViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 21/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Combine
import Foundation
import shared
import SwiftUI

extension SearchScreen {
    @MainActor class SearchViewModel: ObservableObject {
        
        // Global
        private let TAG = "SearchViewModel"
        private let searchContentUseCase = UseCaseHelper().searchContentUseCase
        private var cancellables = Set<AnyCancellable>()
        private var type = Type.movie
        private var lastSearchedQuery = ""
        private var lastSearchedPage: Int32 = 0
        @Published private(set) var isLoading = false
        @Published private(set) var error: String? = nil
        @Published var query = ""
        @Published var result: SearchResult = SearchResult(
            search: [],
            total: 0
        )
        @Published var shouldPeek = false
        @Published var peekContent: ShortContent? = nil
        
        init() {
            $query
                .debounce(
                    for: .milliseconds(300),
                    scheduler: RunLoop.main
                )
                .sink(receiveValue: { [weak self] query in
                    if !query.isEmpty {
                        self?.searchContent(
                            shouldClearResults: true,
                            query: query
                        )
                    }
                })
                .store(in: &self.cancellables)
        }
        
        func setType(type: Type) {
            self.type  = type
        }
        
        func onClearSearchQuery() {
            resetSearchResult()
            self.query = ""
        }
        
        func loadMore() {
            searchContent(
                shouldClearResults: false,
                query: query
            )
        }
        
        func onHold(peekContent: ShortContent) {
            self.peekContent = peekContent
            withAnimation(.easeInOut(duration: 0.3)) {
                shouldPeek.toggle()
            }
        }
        
        func onRelease() {
            withAnimation(.easeInOut(duration: 0.3)) {
                shouldPeek.toggle()
            }
        }
        
        func resetError() {
            error = nil
        }
        
        private func searchContent(
            shouldClearResults: Bool,
            query: String
        ) {
            if shouldClearResults && lastSearchedQuery != query {
                resetSearchResult()
            }
            let size = result.search.count
            let page: Int32
            if size <= 0 {
                page = 1
            } else {
                page = Int32(size) / Constants().PAGE_SIZE + 1
            }
            if lastSearchedQuery == query && lastSearchedPage == page {
                return
            }
            lastSearchedQuery = query
            lastSearchedPage = page
            searchContentUseCase.invoke(
                query: query,
                page: page,
                type: type
            )
            .onEach(
                onLoading: {
                    self.isLoading = true
                },
                onSuccess: { result in
                    self.result = self.result
                        .update(data: result as? SearchResult)
                    self.isLoading = false
                },
                onError: { error in
                    self.error = error
                    self.isLoading = false
                }
            )
        }
        
        private func resetSearchResult() {
            lastSearchedQuery = ""
            lastSearchedPage = 0
            result = SearchResult(
                search: [],
                total: 0
            )
        }
    }
}
