package com.example.snapshotgridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private RelativeLayout buttomcontext;
	private FrameLayout screen;
	private View menu;
	private Button openmenu,clockmenu,button4;
	private Context context;
	
	private Mymenu mymenu;
	
	private int hight=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		

		
		context=this;
		menu =findViewById(R.id.menu);
		button4= (Button)menu. findViewById(R.id.button3);
		openmenu = (Button) findViewById(R.id.btn_open);
		clockmenu = (Button) findViewById(R.id.btn_close);
		buttomcontext = (RelativeLayout) findViewById(R.id.buttomcontext);
		screen=(FrameLayout)findViewById(R.id.screen);
	
		mymenu=new Mymenu( this,menu, buttomcontext,screen);
		mymenu.setMymenuListem(new MymenuListem() {
			@Override
			public void onMenuOpen() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "菜单已经打开", 1).show();
			}
			
			@Override
			public void onMenuClose() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "菜单已经关闭", 1).show();
			}
		});
		
		
		
		button4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "菜单", 1).show();
				mymenu.closemenu();	
			}
		});
		
		openmenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				mymenu.openmenu();	
			}
		});
		clockmenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mymenu.closemenu();	
				
			}
		});
		
		
	}
	
	
	
}
