## やさしいAndroidプログラミング 高橋麻奈 第３版 SB Creative
### Sample101 テキストファイルを保存する テキストエディタ p.283
#### 解説
　ファイルを扱うには以下の方法があります
- 内部記憶装置にファイルを保存する
- 外部記憶装置(SDカード)にファイルを保存する
内部記憶装置に保存するには以下のようにします
    File dir = getFilesDir();
    File c=new File(dir,"Sample.3gp");
外部記憶装置(SDカード)に保存するには以下のようにします。
    File dir＝ Environment.getExternalStorageDirectory();
    File f = new File(dir, Sample.3gp); 
### Links
* [やさしいAndroidプログラミング  第三版　高橋麻奈](http://mana.on.coocan.jp/yasaa.html,favicon)
* [コマンドラインからのアプリ作成  |  Android Developers](https://developer.android.com/studio/build/building-cmdline?hl=ja,favicon)
* [SBクリエイティブ:【正誤情報】『やさしいAndroidプログラミング 第3版』](https://www.sbcr.jp/support/14003.html,favicon)

* [[Android] ImageView:画像を表示する | Programming Style](http://www.programing-style.com/android/android-api/android-imageview/,favicon)

### Gradle

### Git
* [Git - リモートでの作業](https://git-scm.com/book/ja/v1/Git-%E3%81%AE%E5%9F%BA%E6%9C%AC-%E3%83%AA%E3%83%A2%E3%83%BC%E3%83%88%E3%81%A7%E3%81%AE%E4%BD%9C%E6%A5%AD)
* [Git で変更を取り消して、元に戻す方法 (事例別まとめ)](http://www-creators.com/archives/1290)
* [Git - Book](https://git-scm.com/book/ja/v1/)
- [Learn Git Branching(本家)](http://learngitbranching.js.org/)
- [Learn Git Branching(日本語)](http://k.swd.cc/learnGitBranching-ja/)
- [Git Tutorial - Try Git](https://try.github.io/levels/1/challenges/1)
* [GitHub Help](https://help.github.com/categories/writing-on-github/)
* [README.mdファイル。マークダウン記法まとめ | codechord](http://codechord.com/2012/01/readme-markdown/)
* [Markdown記法 チートシート · GitHub] (https://gist.github.com/mignonstyle/083c9e1651d7734f84c99b8cf49d57fa)
* [hello-test](test/test.md)
