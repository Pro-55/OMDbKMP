//
//  SearchBar.swift
//  iosApp
//
//  Created by Pranit Rane on 26/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct SearchBar: View {
    @Binding var query: String
    @Binding var searchBarSize: CGSize
    @FocusState var isFocused: Bool
    let onClearSearchQuery: () -> Void
    
    var body: some View {
        HStack {
            Image(systemName: "magnifyingglass")
                .foregroundStyle(.foreground)
            
            TextField(
                "hint_search",
                text: $query
            )
            .textFieldStyle(PlainTextFieldStyle())
            .foregroundStyle(.foreground)
            .focused($isFocused)
            
            if !query.isEmpty {
                Image(systemName: "xmark.circle.fill")
                    .foregroundStyle(.foreground)
                    .onTapGesture(perform: onClearSearchQuery)
            }
        }
        .padding()
        .background(.background)
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(.foreground, lineWidth: 1)
        )
        .cornerRadius(8)
        .saveSize(in: $searchBarSize)
    }
}
