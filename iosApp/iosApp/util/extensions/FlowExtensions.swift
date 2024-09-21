//
//  FlowExtensions.swift
//  iosApp
//
//  Created by Pranit Rane on 02/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import Foundation
import shared

extension Kotlinx_coroutines_coreFlow {
    func onEach(
        onLoading: @escaping () -> Void,
        onSuccess: @escaping (AnyObject?) -> Void,
        onError: @escaping (String?) -> Void
    ) {
        FlowExtensionsKt.asNativeFlow(self)
            .callbacks(
                onLoading: {
                    DispatchQueue.main.async {
                        onLoading()
                    }
                },
                onSuccess: { data in
                    DispatchQueue.main.async {
                        onSuccess(data)
                    }
                },
                onError: { msg in
                    DispatchQueue.main.async {
                        onError(msg)
                    }
                }
            )
    }
}
