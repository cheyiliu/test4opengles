package com.pstreets.opengl.demo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.os.Bundle;

public class DrawSphere extends OpenGLESActivity 
  implements IOpenGLDemo{
	
	Sphere sphere=new Sphere();
	
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    }

    public void initScene(GL10 gl){
    	float[] mat_amb = {0.2f * 1.0f, 0.2f * 0.4f, 0.2f * 0.4f, 1.0f,};
		float[] mat_diff = {1.0f, 0.4f, 0.4f, 1.0f,};
		float[] mat_spec = {1.0f, 1.0f, 1.0f, 1.0f,};    	
		
        ByteBuffer mabb = ByteBuffer.allocateDirect(mat_amb.length*4);
		mabb.order(ByteOrder.nativeOrder());
		FloatBuffer mat_ambBuf = mabb.asFloatBuffer();
		mat_ambBuf.put(mat_amb);
		mat_ambBuf.position(0);    	
		
		ByteBuffer mdbb = ByteBuffer.allocateDirect(mat_diff.length*4);
		mdbb.order(ByteOrder.nativeOrder());
		FloatBuffer mat_diffBuf = mdbb.asFloatBuffer();
		mat_diffBuf.put(mat_diff);
		mat_diffBuf.position(0);    	
		
		ByteBuffer msbb = ByteBuffer.allocateDirect(mat_spec.length*4);
		msbb.order(ByteOrder.nativeOrder());
		FloatBuffer mat_specBuf = msbb.asFloatBuffer();
		mat_specBuf.put(mat_spec);
		mat_specBuf.position(0);
		
		
        
        gl.glClearColor(0.8f, 0.8f, 0.8f, 0.0f);
    	gl.glEnable(GL10.GL_DEPTH_TEST);
    	gl.glEnable(GL10.GL_CULL_FACE);	
    	gl.glShadeModel(GL10.GL_SMOOTH);

    	gl.glEnable(GL10.GL_LIGHTING);	
    	gl.glEnable(GL10.GL_LIGHT0);	

    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, mat_ambBuf);	
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, mat_diffBuf);
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, mat_specBuf);
    	gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 64.0f);
    	
    	gl.glLoadIdentity();
    	GLU.gluLookAt(gl,0.0f, 0.0f, 10.0f, 
    			0.0f, 0.0f, 0.0f,
    			0.0f, 1.0f, 0.0f);
    	
    }
    
	public void drawScene(GL10 gl) {
		super.drawScene(gl);
		sphere.draw(gl);

		
		
	}
	
	
}
