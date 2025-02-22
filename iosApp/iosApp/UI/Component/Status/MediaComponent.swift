import SwiftUI
import shared
import NetworkImage
import AVKit

struct MediaComponent: View {
    @State var hideSensitive: Bool
    let medias: [UiMedia]
    let onMediaClick: (Int, String?) -> Void
    let sensitive: Bool
    var body: some View {
        let showSensitiveButton = medias.allSatisfy { media in
            media is UiMediaImage
        } && sensitive
        let columns = if medias.count == 1 {
            1
        } else if medias.count < 5 {
            2
        } else {
            3
        }
        ZStack(alignment: .topLeading) {
            CustomGrid(items: medias, columns: columns) { item in
                Button(action: {
                    let preview: String? = switch onEnum(of: item) {
                    case .audio:
                        nil
                    case .gif(let gif):
                        gif.previewUrl
                    case .image(let image):
                        image.previewUrl
                    case .video(let video):
                        video.thumbnailUrl
                    }
                    if let index = medias.firstIndex(where: { it in
                        it === item
                    }) {
                        onMediaClick(index - 1, nil)
                    }
                }, label: {
                    MediaItemComponent(media: item)
                })
                .buttonStyle(.borderless)
            }
            .if(hideSensitive, transform: { view in
                view.blur(radius: 32)
            })
            if showSensitiveButton {
                if hideSensitive {
                    Button(action: {
                        withAnimation {
                            hideSensitive = false
                        }
                    }, label: {
                        Color.clear
                    })
                    .buttonStyle(.borderless)
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    Button(action: {
                        withAnimation {
                            hideSensitive = false
                        }
                    }, label: {
                        Text("status_sensitive_media_show", comment: "Status media sensitive button")
                    })
                    .buttonStyle(.borderedProminent)
                    .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
                } else {
                    Button(action: {
                        withAnimation {
                            hideSensitive = true
                        }
                    }, label: {
                        Image(systemName: "eye.slash")
                            .foregroundColor(Color(uiColor: UIColor.systemBackground))
                    })
                    .padding()
                    .buttonStyle(.borderedProminent)
                    .tint(Color.primary)
                    .frame(maxWidth: .infinity, alignment: .topLeading)
                }
            }
        }
        .if(medias.count < 7) { view in
            view.aspectRatio(16/9, contentMode: .fit)
        }
        //        .aspectRatio(16/9, contentMode: .fit)
        .frame(maxWidth: 600)
        .clipShape(RoundedRectangle(cornerRadius: 8))
    }
}

struct MediaItemComponent: View {
    // #if os(iOS)
    //    @State var showCover = false
    // #else
    //    @Environment(\.openWindow) var openWindow
    // #endif
    let media: UiMedia
    var body: some View {
        ZStack {
            Color.clear.overlay {
                switch onEnum(of: media) {
                case .image(let data):
                    NetworkImage(url: URL(string: data.previewUrl)) { image in
                        image.resizable().scaledToFill()
                    }
                case .video(let video):
                    MutedVideoPlayer(url: video.url)
                case .audio(let audio):
                    VideoPlayer(player: AVPlayer(url: URL(string: audio.url)!)) {
                        if let cover = audio.previewUrl {
                            NetworkImage(url: URL(string: cover)) { image in
                                image.resizable().scaledToFill()
                            }
                        }
                    }
                case .gif(let gif):
                    MutedVideoPlayer(url: gif.url)
                }
            }
        }
        .clipped()
        // #if os(macOS)
        //        .onTapGesture {
        //            switch onEnum(of: media) {
        //            case .image(let data):
        //                openWindow(id: "image-view", value: data.url)
        //            case .video(let video):
        //                openWindow(id: "video-view", value: video.url)
        //            case .audio(let audio):
        //                openWindow(id: "video-view", value: audio.url)
        //            case .gif(let gif):
        //                openWindow(id: "video-view", value: gif.url)
        //            }
        //        }
        // #else
        //        .onTapGesture {
        //            showCover = true
        //        }
        //        .sheet(
        //            isPresented: $showCover,
        //            onDismiss: { showCover = false }
        //        ) {
        //            FullScreenImageViewer(media: media)
        //        }
        // #endif
    }
}

struct MutedVideoPlayer: View {
    let player: AVPlayer
    let autoPlay: Bool
    init(url: String, autoPlay: Bool = true) {
        self.player = AVPlayer(url: URL(string: url)!)
        self.player.isMuted = true
        self.autoPlay = autoPlay
    }
    var body: some View {
        VideoPlayer(player: player)
            .if(autoPlay) { view in
                view
                    .onAppear {
                        player.play()
                    }
                    .onDisappear {
                        player.pause()
                    }
            }
    }
}
