//
//  PeekView.swift
//  iosApp
//
//  Created by Pranit Rane on 27/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct PeekView: View {
    let shouldPeek: Bool
    let peekContent: ShortContent?
    
    var body: some View {
        if shouldPeek {
            ZStack {
                Color.clear
                    .frame(
                        maxWidth: .infinity,
                        maxHeight: .infinity
                    )
                    .background(.ultraThinMaterial)
                    .transition(.opacity)
                
                PosterView(
                    poster: peekContent?.poster,
                    width: 250
                )
                .overlay {
                    ZStack(alignment: .bottomLeading) {
                        LinearGradient(
                            gradient: Gradient(
                                colors: [
                                    Color.clear,
                                    Color.black.opacity(0.5)
                                ]
                            ),
                            startPoint: .top,
                            endPoint: .bottom
                        )
                        .cornerRadius(8)
                        
                        Text(getOverlayText())
                            .font(
                                .system(
                                    size: 16
                                )
                            )
                            .fontWeight(.bold)
                            .foregroundColor(.white)
                            .shadow(color: .black, radius: 8)
                            .padding()
                    }
                }
                .transition(.scale)
            }
        }
    }
    
    private func getOverlayText() -> String {
        let title = peekContent?.title ?? ""
        let dividerBullet = NSLocalizedString("divider_bullet", comment: "Divider Bullet")
        let year = peekContent?.year ?? ""
        
        return "\(title) \(dividerBullet) (\(year))"
    }
}
