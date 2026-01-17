//
//  RatingBar.swift
//  iosApp
//
//  Created by Pranit Rane on 05/04/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI

struct RatingBar: View {
    let rating: Float
    let max: Int
    let numStars: Int
    var background: Color = Color(.systemBackground)
    var onBackground: Color = .yellow // Assuming Star color
    
    private var percent: CGFloat {
        CGFloat(rating / Float(max)) * CGFloat(numStars)
    }
    
    var body: some View {
        HStack(spacing: 2) {
            ForEach(0..<numStars, id: \.self) { index in
                let starIndex = CGFloat(index)
                
                // Calculate fill for this specific star
                let fillAmount: CGFloat = {
                    if starIndex + 1 <= percent { return 1.0 }
                    if starIndex < percent { return percent - starIndex }
                    return 0.0
                }()
                
                GeometryReader { geo in
                    ZStack {
                        // Background of the star
                        Image(systemName: "star.fill")
                            .resizable()
                            .foregroundColor(background)
                        
                        // Foreground (Fill)
                        Image(systemName: "star.fill")
                            .resizable()
                            .foregroundColor(onBackground)
                            .mask(
                                HStack(spacing: 0) {
                                    Rectangle().frame(width: geo.size.width * fillAmount)
                                    Spacer(minLength: 0)
                                }
                            )
                    }
                }
                .aspectRatio(1, contentMode: .fit)
            }
        }
    }
}
