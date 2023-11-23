// swift-tools-version:5.7.1
import PackageDescription

let package = Package(
        name: "SharedApp",
 		    dependencies: [
 		        .package(url: "https://github.com/Mirzomuhsin2001/SharedApp", from: "1.0.0")
 		    ],
 		    targets: [
 		        .target(
 		            name: "SharedApp",
 		            dependencies: ["shared"]),
 		        .testTarget(
 		            name: "SharedAppTests",
 		            dependencies: ["SharedApp"]),
 		    ]
 		)