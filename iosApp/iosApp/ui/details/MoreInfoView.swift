//
//  MoreInfoView.swift
//  iosApp
//
//  Created by Pranit Rane on 17/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct MoreInfoView: View {
    let label: LocalizedStringKey
    let onClick: () -> Void
    
    var body: some View {
        Button(action: onClick) {
            HStack {
                Text(label)
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.primary)
                
                Spacer()
                
                Image(systemName: "chevron.right")
                    .font(.system(size: 24))
                    .foregroundColor(.secondary)
            }
            .contentShape(Rectangle()) // Ensures the whole row is clickable
            .padding(16)
        }
        .buttonStyle(.plain)
    }
}
