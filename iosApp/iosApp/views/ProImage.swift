//
//  ProImage.swift
//  iosApp
//
//  Created by Pranit Rane on 29/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ProImage: View {
    let url: String?
    
    var body: some View {
        if url?.isEmpty != false {
            Color.gray
        } else {
            Glide(url: url!) { phase in
                if let image = phase.image {
                    image.resizable()
                } else {
                    Color.gray
                }
            }
        }
    }
}
