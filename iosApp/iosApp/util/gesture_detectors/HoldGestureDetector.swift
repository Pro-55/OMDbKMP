//
//  HoldGestureDetector.swift
//  iosApp
//
//  Created by Pranit Rane on 26/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI

struct HoldGestureDetector: ViewModifier {
    @State private var shouldRelease: Bool = false
    let onClick: () -> Void
    let onHold: () -> Void
    let onRelease: () -> Void
    
    func body(content: Content) -> some View {
        content.onTapGesture {
            shouldRelease = false
            onClick()
        }
        .onLongPressGesture {
            shouldRelease = true
            onHold()
        }
        .simultaneousGesture(
            DragGesture(minimumDistance: 0)
                .onEnded({ _ in
                    if shouldRelease {
                        onRelease()
                    }
                    shouldRelease = false
                })
        )
    }
}
