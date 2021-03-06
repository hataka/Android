## Android SDK ポケットリファレンス
### Chapter01 レイアウト
#### アプリケーション全体で保持するデータを管理する p.46
アプロケーションが起動してから終了するまでデータを保持しておきたい場合には、
Activityだと端末のライフサイクルに則ってデータが破棄されるため、期待した動作をしないことがあります。  
　このような時には、Applicationクラスを継承し、onCreateメソッドをオーバーライドしてアプリ起動時に
データを保持しておくとよいでしょう。  
ただし、やりすぎるとApplicationクラスの肥大化となってしまいますので、データを何処に配置すべきかは
設計時に慎重に検討するようにしてください。
#### Links
- [GitHub shige0501/android-sdk-pokeri-v2](https://github.com/shige0501/android-sdk-pokeri-v2)
- [［改訂新版］Android SDK ポケットリファレンス：書籍案内｜技術評論社](https://gihyo.jp/book/2018/978-4-7741-9855-2)

### Git
* [Git - リモートでの作業](https://git-scm.com/book/ja/v1/Git-%E3%81%AE%E5%9F%BA%E6%9C%AC-%E3%83%AA%E3%83%A2%E3%83%BC%E3%83%88%E3%81%A7%E3%81%AE%E4%BD%9C%E6%A5%AD)

* [Git - Book](https://git-scm.com/book/ja/v1/)
- [Learn Git Branching(本家)](http://learngitbranching.js.org/)
- [Learn Git Branching(日本語)](http://k.swd.cc/learnGitBranching-ja/)
- [Git Tutorial - Try Git](https://try.github.io/levels/1/challenges/1)
* [GitHub Help](https://help.github.com/categories/writing-on-github/)
* [README.mdファイル。マークダウン記法まとめ | codechord](http://codechord.com/2012/01/readme-markdown/)
* [Markdown記法 チートシート · GitHub] (https://gist.github.com/mignonstyle/083c9e1651d7734f84c99b8cf49d57fa)
* [hello-test](test/test.md)
