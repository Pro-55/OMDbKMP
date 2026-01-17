//
//  StringExtensions.swift
//  iosApp
//
//  Created by Pranit Rane on 17/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import shared

extension String {
    
    func isValidEmail() -> Bool {
        return ValidationExtensionsKt.isValidEmail(self)
    }
    
    func filterOutNonLetters() -> String {
        return filter { char in
            char.isLetter
        }
    }
}


extension String? {
    
    func isNilOrEmpty() -> Bool {
        return self?.isEmpty != false
    }
}
