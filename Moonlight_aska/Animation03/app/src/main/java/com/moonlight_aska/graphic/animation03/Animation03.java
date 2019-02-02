// -*- mode: java -*-  Time-stamp: <2012-02-03 9:42:03 kahata>
/*================================================================
 * title: 
 * file: Animation03.java
 * created: Time-stamp: <2012-02-03 9:42:03 kahata>
 * link: http://wiki.livedoor.jp/moonlight_aska/d/%b0%dc%c6%b0%a5%a2%a5%cb%a5%e1%a1%bc%a5%b7%a5%e7%a5%f3%a4%f2%b9%d4%a4%a6
 * description: 移動アニメーションを行う
 * 最終更新：moonlight_aska 2011年09月24日(土) 09:57:58履歴
 * アニメーションのタイプは大きく2つに分類できる.
 * Tweenedアニメーション:1つのイメージを連続に変化させる
 * Frame-By-Frameアニメーション:イメージを順番に並べてアニメーションする
 * Tweenedアニメーションの一種である移動アニメーションを行うには, 
 *  トランスレートアニメーション(TranslateAnimation)クラスを利用する.
 * 移動アニメーション
 *  findViewByIdメソッドで, 指定したリソースインデックスのIDに対応したイメージビューのインスタンスを取得する.
 *  AnimationUtils#loadAnimationメソッドでアニメーション設定ファイル(translate.xml)を読み込み, Animationを作成する.
 *  ImageView#startAnimationメソッドでアニメーションを開始する.
 *================================================================*/

package com.moonlight_aska.graphic.animation03;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation03 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView img = (ImageView)findViewById(R.id.robot);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate);
		img.startAnimation(anim);
	}
}
