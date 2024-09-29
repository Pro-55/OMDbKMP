//
//  ContentTypeCard.swift
//  iosApp
//
//  Created by Pranit Rane on 18/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct ContentTypeCard: View {
    let icon: String
    let title: LocalizedStringKey
    let onClick: () -> Void
    
    var body: some View {
        Button(action: onClick) {
            VStack {
                Image(systemName: icon)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(
                        width: 100,
                        height: 100
                    )
                Text(title)
                    .font(
                        .system(
                            size: 36
                        )
                    )
                    .fontWeight(.bold)
            }
            .frame(
                maxWidth: .infinity,
                maxHeight: .infinity
            )
            .layoutPriority(1)
            .foregroundColor(.white)
            .background(.gray)
            .cornerRadius(8)
            .shadow(radius: 8)
        }
    }
}
