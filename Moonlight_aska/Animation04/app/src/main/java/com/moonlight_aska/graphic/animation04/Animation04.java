// -*- mode: java -*-  Time-stamp: <2012-02-03 9:49:49 kahata>
/*================================================================
 * title: 
 * file: Animation04.java
 * http://localhost/android/Moonlight_aska/Animation04/src/com/moonlight_aska/graphic/animation04/Animation04.java
 * created: Time-stamp: <2012-02-03 9:49:49 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%a5%d5%a5%a7%a1%bc%a5%c9%a5%a4%a5%f3/%a5%a2%a5%a6%a5%c8%a4%f2%b9%d4%a4%a6
 * description: フェードイン/アウトを行う
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:59:04履歴
 * アニメーションのタイプは大きく2つに分類できる.
 *  Tweenedアニメーション:1つのイメージを連続に変化させる
 *  Frame-By-Frameアニメーション:イメージを順番に並べてアニメーションする
 *  Tweenedアニメーションの一種であるフェードイン/アウトを行うには, 
 *  アルファアニメーション(AlphaAnimation)クラスを利用する.
 * フェードイン/アウト
 * findViewByIdメソッドで, 指定したリソースインデックスのIDに対応したイメージビューのインスタンスを取得する.
 * AnimationUtils#loadAnimationメソッドでアニメーション設定ファイル(alpha.xml)を読み込み, Animationを作成する.
 * ImageView#startAnimationメソッドでアニメーションを開始する.
 *================================================================*/

package com.moonlight_aska.graphic.animation04;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation04 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView img = (ImageView)findViewById(R.id.robot);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		img.startAnimation(anim);
	}
}

