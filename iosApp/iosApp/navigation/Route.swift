//
//  Route.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import Foundation
import shared

enum Route: Hashable {
    case Signup
    case Home
    case Search(type: Type)
    case Details
}
