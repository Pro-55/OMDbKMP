//
//  EmptyContentView.swift
//  iosApp
//
//  Created by Pranit Rane on 22/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct EmptyContentView: View {
    let icon: String?
    let title: LocalizedStringKey?
    
    var body: some View {
        VStack {
            Image(systemName: icon!)
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(
                    width: 100,
                    height: 100
                )
            Text(title!)
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
    }
}
