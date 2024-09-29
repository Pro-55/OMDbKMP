//
//  SizeCalculator.swift
//  iosApp
//
//  Created by Pranit Rane on 26/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct SizeCalculator: ViewModifier {
    @Binding var size: CGSize
    
    func body(content: Content) -> some View {
        content.background(
            GeometryReader { proxy in
                Color.clear
                    .onAppear {
                        size = proxy.size
                    }
            }
        )
    }
}
