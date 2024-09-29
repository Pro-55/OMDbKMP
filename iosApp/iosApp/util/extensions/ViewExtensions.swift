//
//  ViewExtensions.swift
//  iosApp
//
//  Created by Pranit Rane on 26/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import SwiftUI

extension View {
    func saveSize(in size: Binding<CGSize>) -> some View {
        modifier(SizeCalculator(size: size))
    }
    
    func detectHoldGesture(
        onClick: @escaping () -> Void,
        onHold: @escaping () -> Void,
        onRelease: @escaping () -> Void
    ) -> some View {
        modifier(
            HoldGestureDetector(
                onClick: onClick,
                onHold: onHold,
                onRelease: onRelease
            )
        )
    }
}
