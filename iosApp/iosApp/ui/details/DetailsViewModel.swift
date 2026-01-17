//
//  DetailsViewModel.swift
//  iosApp
//
//  Created by Pranit Rane on 11/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import shared
import UIKit

extension DetailsScreen {
    @MainActor class DetailsViewModel: ObservableObject {
        
        // Global
        private let TAG = "DetailsViewModel"
        private let getDetailsUseCase = UseCaseHelper().getDetailsUseCase
        private let deepLinkHelper = DeepLinkHelper.init()
        @Published private(set) var shortContent: ShortContent? = nil
        @Published private(set) var content: Content? = nil
        @Published private(set) var isLoading = false
        @Published private(set) var error: String? = nil
        
        func setContentData(
            contentId: String?,
            shortContent: ShortContent?
        ){
            if (contentId.isNilOrEmpty() && shortContent == nil) {
                error = Constants.init().ERROR_MESSAGE_INVALID_REQUEST
            } else {
                self.shortContent = shortContent!
                getDetails(id: contentId ?? shortContent!.id)
            }
        }
        
        private func getDetails(
            id: String,
            plot: String = "short"
        ) {
            getDetailsUseCase.invoke(
                id: id,
                plot: plot
            )
            .onEach(
                onLoading: {
                    self.isLoading = true
                },
                onSuccess: { content in
                    self.content = content as? Content
                    self.isLoading = false
                },
                onError: { error in
                    self.error = error
                    self.isLoading = false
                }
            )
        }
        
        func share(content: Content) {
            let contentUrl = deepLinkHelper.getDetailsDeepLink(contentId: content.id)
            
            guard let url = URL(string: contentUrl) else { return }
            let itemsToShare: [Any] = [content.title, url]
            
            let activityVC = UIActivityViewController(
                activityItems: itemsToShare,
                applicationActivities: nil
            )
            
            DispatchQueue.main.async {
                let windowScene = UIApplication.shared.connectedScenes
                    .first { $0.activationState == .foregroundActive } as? UIWindowScene
                
                guard let rootVC = windowScene?.keyWindow?.rootViewController else { return }
                
                if let popover = activityVC.popoverPresentationController {
                    popover.sourceView = rootVC.view
                    popover.sourceRect = CGRect(x: rootVC.view.bounds.midX, y: rootVC.view.bounds.midY, width: 0, height: 0)
                    popover.permittedArrowDirections = []
                }
                
                rootVC.present(activityVC, animated: true)
            }
        }
    }
}
