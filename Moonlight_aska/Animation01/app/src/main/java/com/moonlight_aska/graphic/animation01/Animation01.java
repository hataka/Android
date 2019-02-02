// -*- mode: java -*-  Time-stamp: <2012-02-03 9:26:51 kahata>
/*================================================================
 * title: Animation01 拡大・縮小アニメーションを行う
 * file: Animation01.java
 * http://localhost/android/Moonlight_aska/Animation01/src/com/moonlight_aska/graphic/animation01/Animation01.java
 * created: Time-stamp: <2012-02-03 9:26:51 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%b3%c8%c2%e7%a1%a6%bd%cc%be%ae%a5%a2%a5%cb%a5%e1%a1%bc%a5%b7%a5%e7%a5%f3%a4%f2%b9%d4%a4%a6
 * description: 拡大・縮小アニメーションを行う
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:56:35履歴
 *  アニメーションのタイプは大きく2つに分類できる.
 *  Tweenedアニメーション:1つのイメージを連続に変化させる
 *  Frame-By-Frameアニメーション:イメージを順番に並べてアニメーションする
 *  Tweenedアニメーションの一種である拡大・縮小アニメーションを行うには, 
 *    スケールアニメーション(ScaleAnimation)クラスを利用する.
 * 拡大・縮小アニメーション
 *  findViewByIdメソッドで, 指定したリソースインデックスのIDに対応したイメージビューのインスタンスを取得する.
 *  AnimationUtils#loadAnimationメソッドでアニメーション設定ファイル(scale.xml)を読み込み, Animationを作成する.
 *  ImageView#startAnimationメソッドでアニメーションを開始する.
 *================================================================*/

package com.moonlight_aska.graphic.animation01;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView img = (ImageView)findViewById(R.id.robot);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
		img.startAnimation(anim);
	}
}
