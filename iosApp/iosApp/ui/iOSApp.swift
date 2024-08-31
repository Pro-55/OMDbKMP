import SwiftUI
import Firebase
import shared

@main
struct iOSApp: App {
    
    init() {
        KoinHelperKt.doInit()
        FirebaseApp.configure()
    }
    
    var body: some Scene {
        WindowGroup {
            NavHost()
        }
    }
}
