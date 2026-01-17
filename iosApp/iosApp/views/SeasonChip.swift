//
//  SeasonChip.swift
//  iosApp
//
//  Created by Pranit Rane on 13/01/26.
//  Copyright © 2026 orgName. All rights reserved.
//
import SwiftUI

struct SeasonChip: View {
    let seasonNumber: Int
    let action: () -> Void
    
    var body: some View {
        Button(action: action) {
            Text("label_season \(seasonNumber)")
                .font(.caption2)
                .padding(.horizontal, 12)
                .padding(.vertical, 8)
                .background(Capsule().strokeBorder(Color.secondary, lineWidth: 1))
        }
        .buttonStyle(.plain)
    }
}
