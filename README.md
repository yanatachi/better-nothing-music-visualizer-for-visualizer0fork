# <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Travel%20and%20places/Fire.png" alt="Fire" width="35" height="35" />Better Nothing Music Visualizer Fork

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Travel%20and%20places/Globe%20with%20Meridians.png" alt="Globe" width="25" height="25" />ほかの言語で読む:  🇺🇸 [English](README_EN.md) | 🇹🇷 [Türkçe](README_TR.md)

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Symbols/Double%20Exclamation%20Mark.png" alt="Double Exclamation Mark" width="25" height="25" /> **重要なお知らせ**
このプロジェクトは[Aleks levet氏](https://github.com/Aleks-Levet)の作成した[Better-Nothing-Music-Visualizer](https://github.com/Aleks-Levet/better-nothing-music-visualizer)の**フォークであり**[Aleks levet氏](https://github.com/Aleks-Levet)が作成したものではありません。

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Face%20with%20Raised%20Eyebrow.png" alt="Face with Raised Eyebrow" width="25" height="25" /> どうしてこのフォークを作ったか・このフォークでは何が変わったか?
[Aleks levet氏](https://github.com/Aleks-Levet)の[Better-Nothing-Music-Visualizer](https://github.com/Aleks-Levet/better-nothing-music-visualizer)はMediaProjectionを必要とし、毎度毎度ポップアップから画面共有を許可しないといけませんし、通知も見れなくなるという欠点がありました。
そのためこのForkで音声の取得方法をMediaProjectionからVisualizer(0)にし、画面共有のポップアップをなくし、通知も見れるようにしました。

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Thinking%20Face.png" alt="Thinking Face" width="25" height="25" /> なぜBetterNothingMusicVisualizerが作られたのか？
Nothing Phone公式の「ミュージック視覚化」機能は、**反応がランダムに見えたり、Glyphインターフェースのポテンシャルを最大限に活かせていない**と感じることがあります。
このアプリは、音楽の波形をリアルタイムで精密に解析し、Nothing Phoneの背面を真のビジュアライザーへと変えるために作られました。

## <img src="https://fonts.gstatic.com/s/e/notoemoji/latest/2696_fe0f/512.gif" alt="⚖" width="32" height="32"> Nothing標準 vs Better Music Visualizer (Fork)
| 内容、機能 | Nothing 標準 | **Better Music Visualizer (Fork)** |
| :--- | :--- | :--- |
| **輝度レベル** | 約2ビット (3段階) | **12ビット (4096段階)** |
| **フレームレート** | 約25 FPS | **60 FPS** |
| **精度** | ランダムに感じられ、同期が分かりにくい | **FFT分析を用いて各ライトの強度を正確に決定** |
| **ゾーン** | 標準的な物理グリフ全体を使用 | **各Glyphセグメントとサブゾーンを個別に制御** |
| **可視化手法** | リアルタイムのみ | **20ms以下の低遅延リアルタイム、または事前処理されたオーディオファイル** |

## <img src="https://fonts.gstatic.com/s/e/notoemoji/latest/1f3ac/512.gif" alt="🎬" width="40" height=""> [動画のデモ&サンプル](https://github.com/Aleks-Levet/better-nothing-music-visualizer/blob/main/Demo-video-examples.md)

### 実際の違いを体感してください！ [**クリックすると簡単にサンプル動画を見ることができます！**](https://github.com/Aleks-Levet/better-nothing-music-visualizer/blob/main/Demo-video-examples.md)

## 📲 サポートされているNothing Phoneモデル
現在、以下のモデルをサポートしています:
- Nothing phone (1) 
  - アプリを使用するには、ADBコマンド adb shell settings put global nt_glyph_interface_debug_enable 1 を実行して、**GlyphデバッグモードをON**にする必要があります。
- Nothing phone (2)
- Nothing phone (2a)
- Nothing phone (2a) Plus
- Nothing phone (3a)
- Nothing phone (3a) Pro
- *Nothing phone (3)* **(ベータ版で最適化されていません)**
  
**おそらく使用可能:**
- *Nothing Phone (4a)*

** 使用不可: **
- *Nothing Phone (4a pro)*


### <img src="https://fonts.gstatic.com/s/e/notoemoji/latest/2699_fe0f/512.gif" alt="⚙" width="25" height="25"> 仕組み（技術解説）
-高品質なオーディオストリームをキャプチャします。
- **FFT (高速フーリエ変換)**を使用し、**16.666 ms（60 FPS）**の各フレームに対して **20 msのウィンドウ**で周波数を分析し、より正確な可視化を実現します
- 各Glyphゾーンの**周波数範囲**は zones.config で定義されており、自由にカスタマイズ可能です。
- 各Glyphの**明るさ**は、割り当てられた周波数範囲内の**ピーク振幅**によって決まります。これにより、異なる周波数「ゾーン」がどれだけ大きいかを測定します。
-レスポンスを維持しつつアニメーションを滑らかにするために、**下方のみのスムージング（Downward-only smoothing）**を適用しています（これが「秘伝のソース」です）。
- これで、Glyphに表示する準備が整います！

## 📖 新しいアプリの使い方は？
Readmeがまだ準備中なので、触りながら見つけてみてください（<img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Pensive%20Face.png" alt="Pensive Face" width="25" height="25" />）

## 📖 Pythonスクリプトの使い方は？
使い方は非常にシンプルで分かりやすいです。インストール、使用方法、設定ファイルの詳細、トラブルシューティングを説明した詳細なWikiページを用意しました。新しいプリセットの作成方法も確認できます（まだ準備中ですが）。musicViz.py をPythonスクリプトとして使用する方法はこちらをクリックしてください。また、無制限のファイルを一括で変換することも可能です！

## <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Hand%20gestures/Handshake.png" alt="Handshake" width="25" height="25" /> コミュニティに参加する
議論や質問がありますか？バグ報告や機能のリクエストは？ * [**公式のNothingサーバー内にあるDiscordスレッドにぜひ参加してください！**](このForkの不具合、機能リクエストは受け付けておりません。)(https://discord.com/channels/930878214237200394/1434923843239280743)

## 🏗️貢献する
あなたの助けを待っています！コントリビューションは大歓迎です。
以下のことが可能です：
-Issueの報告
-プルリクエストの送信
-改善案の提案
-新しい可視化アイデアの実験
-新しいプリセットの作成
-開発者との議論

##  <img src="https://fonts.gstatic.com/s/e/notoemoji/latest/1f512/512.gif" alt="🔒" width="25" height="25"> セキュリティ
**VirusTotalのスキャン結果はこちらで確認できます**  
[https://www.virustotal.com/gui/url/c92c1ff82b56eb60bfd1e159592d09f949f0ea2d195e01f7f5adbef0e0b0385b?nocache=1](https://www.virustotal.com/gui/file/d531d4b41997a7f4f24f5baae22aca43a706fbc7c81adbf8bbd7f6af435e95da?nocache=1)

### <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Symbols/Copyright.png" alt="Copyright" width="25" height="25" /> クレジット:
#### このプロジェクトに携わっているメンバー:
- [Aleks-Levet](https://github.com/Aleks-Levet) (創設者・コーディネーター、メインアイデア、オーナー)
- [Nicouschulas](https://github.com/Nicouschulas) (Readme & Wiki の強化)
- [rKyzen(a.k.a Shivank Dan)](https://github.com/rKyzen)(リアルタイムオーディオストリーム対応Androidアプリ開発)
- [SebiAi](https://github.com/SebiAi) (Glyphモッダー、Glyph関連のサポート)
- [Earnedel-lab](https://github.com/Earendel-lab) (Readmeの強化)
- [あけ なるかみ](https://github.com/Luke20YT) (このスクリプトを統合した音楽アプリを開発中)
- [Interlastic](https://github.com/Interlastic) (スクリプトを簡単に試せるDiscord Bot) (非推奨)

**このプロジェクトはGPL-3.0 ライセンスの下で公開されています。**
  
Founder & Owner:[Aleks-Levet](https://github.com/Aleks-Levet)

Visualizer(0) Engine 改良:[yanatachi](https://github.com/yanatachi)

### <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Travel%20and%20places/Star.png" alt="Star" width="25" height="25" /> スターヒストリー
[![Star History Chart](https://api.star-history.com/svg?repos=yanatachi/better-nothing-music-visualizer-for-visualizer0fork&type=Date)](https://star-history.com/#yanatachi/better-nothing-music-visualizer-for-visualizer0fork&Date)
