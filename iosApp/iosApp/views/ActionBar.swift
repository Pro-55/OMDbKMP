//
//  ActionBar.swift
//  iosApp
//
//  Created by Pranit Rane on 16/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct ActionBar: View {
    let title: LocalizedStringKey
    let subtitle: LocalizedStringKey?
    let onBack: (() -> Void)?
    let actionContent: AnyView?
    
    init(
        title: LocalizedStringKey,
        subtitle: LocalizedStringKey? = nil,
        onBack: (() -> Void)? = nil,
        actionContent: AnyView? = nil
    ) {
        self.title = title
        self.subtitle = subtitle
        self.onBack = onBack
        self.actionContent = actionContent
    }
    
    var body: some View {
        // Custom Top Bar
        HStack {
            // Back Button
            if let onBack = onBack {
                Button(action: onBack) {
                    Image(systemName: "chevron.left") // Use your custom back icon here
                        .font(.title2)
                        .foregroundColor(.primary)
                }
            }
            
            Spacer()
            
            VStack(alignment: .leading) {
                // Title
                Text(title)
                    .font(.headline)
                    .foregroundColor(.primary)
                    .fontWeight(.bold)
                    .frame(alignment: .leading)
                
                if let subtitle = subtitle {
                    // Subtitle
                    Text(subtitle)
                        .font(.subheadline)
                        .foregroundColor(.secondary)
                        .frame(alignment: .leading)
                }
            }
            .frame(
                maxWidth: .infinity,
                alignment: .leading
            ) // Ensure it takes all available space but aligns to the leading edge
            .padding(.horizontal)
            
            Spacer()
            
            if let actionContent = actionContent {
                actionContent
            }
        }
    }
}
