//
//  ContentExtensions.swift
//  iosApp
//
//  Created by Pranit Rane on 17/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import shared

extension Content {
    func buildBasicInfo() -> String {
        let builder = NSMutableString()
        builder.append(year)
        builder.append(" ")
        builder.append(NSLocalizedString("divider_bullet", comment: ""))
        builder.append(" ")
        builder.append(rated)
        if isNotSeries() {
            builder.append(" ")
            builder.append(NSLocalizedString("divider_bullet", comment: ""))
            builder.append(" ")
            builder.append(runtime)
        }
        return builder as String
    }
}
