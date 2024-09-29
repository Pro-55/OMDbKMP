//
//  PosterView.swift
//  iosApp
//
//  Created by Pranit Rane on 22/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct PosterView: View {
    private let poster: String?
    private let width: CGFloat?
    private let height: CGFloat?
    
    init(
        poster: String?,
        width: CGFloat? = nil
    ) {
        let aspectRatio: CGFloat = 1.33
        let maxWidth = width ?? .infinity
        
        self.height = maxWidth * aspectRatio
        self.width = maxWidth
        self.poster = poster
    }
    
    var body: some View {
        ProImage(url: poster)
            .frame(
                maxWidth: width,
                maxHeight: height
            )
            .aspectRatio(0.75, contentMode: .fill)
            .cornerRadius(8)
            .shadow(radius: 8)
    }
}
