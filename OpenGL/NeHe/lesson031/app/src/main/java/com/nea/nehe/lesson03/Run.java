package com.nea.nehe.lesson03;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * The initial Android Activity, setting and initiating
 * the OpenGL ES Renderer Class @see Lesson03.java
 * 
 * @author Savas Ziplies (nea/INsanityDesign)
 */
public class Run extends Activity {

	/** The OpenGL View */
	private GLSurfaceView glSurface;

	/**
	 * Initiate the OpenGL View and set our own
	 * Renderer (@see Lesson03.java)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Create an Instance with this Activity
		glSurface = new GLSurfaceView(this);
		//Set our own Renderer
		glSurface.setRenderer(new Lesson03());
		//Set the GLSurface as View to this Activity
		setContentView(glSurface);
	}

	/**
	 * Remember to resume the glSurface
	 */
	@Override
	protected void onResume() {
		super.onResume();
		glSurface.onResume();
	}

	/**
	 * Also pause the glSurface
	 */
	@Override
	protected void onPause() {
		super.onPause();
		glSurface.onPause();
	}

}