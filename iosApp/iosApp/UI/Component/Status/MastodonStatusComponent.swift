import SwiftUI
import MarkdownUI
import shared

struct MastodonStatusComponent: View {
    let mastodon: UiStatus.Mastodon
    var body: some View {
        let actual = mastodon.reblogStatus ?? mastodon
        VStack(alignment: .leading) {
            if mastodon.reblogStatus != nil {
                HStack {
                    Image(systemName: "arrow.left.arrow.right")
                        .font(.caption)
                    Markdown {
                        Paragraph {
                            mastodon.user.extra.nameMarkdown
                            " boosted a status"
                        }
                    }
                    .lineLimit(1)
                    .markdownTextStyle(\.text) {
                        FontSize(12)
                    }
                    .markdownInlineImageProvider(.emoji)
                }
                .foregroundColor(.primary)
                .opacity(0.6)
            }
            CommonStatusComponent(content: actual.extra.contentMarkdown, avatar: actual.user.avatarUrl, name: actual.user.extra.nameMarkdown, handle: actual.user.handle, userKey: actual.user.userKey, medias: actual.media, timestamp: actual.createdAt.epochSeconds, headerTrailing: {
                MastodonVisibilityIcon(visibility: actual.visibility)
            })
            Spacer()
                .frame(height: 8)
            HStack {
                Button(action: {
                }) {
                    HStack {
                        Image(systemName: "arrowshape.turn.up.left")
                        if let humanizedReplyCount = actual.matrices.humanizedReplyCount {
                            Text(humanizedReplyCount)
                        }
                    }
                }
                Spacer()
                Button(action: {}) {
                    HStack {
                        Image(systemName: "arrow.left.arrow.right")
                        if let humanizedReblogCount = actual.matrices.humanizedReblogCount {
                            Text(humanizedReblogCount)
                        }
                    }
                }
                Spacer()
                Button(action: {}) {
                    HStack {
                        Image(systemName: "star")
                        if let humanizedFavouriteCount = actual.matrices.humanizedFavouriteCount {
                            Text(humanizedFavouriteCount)
                        }
                    }
                }
                Spacer()
                Button(action: {}) {
                    Image(systemName: "ellipsis")
                }
            }
            .buttonStyle(.borderless)
            .tint(.primary)
            .opacity(0.6)
            .font(.caption)
        }
    }
}
