package com.example.snapshotgridview;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class Mymenu {
	private View MENU_VIEW, BUTTOM_VIEW;
	private Boolean IsOpen = false;
	private int MENU_HIGHT = 0;
	private int BUTTOM_MARGIN_TOP_HIGHT = 0;
	private int SCREEN_HIGHT = 0;
	private MymenuListem mymenuListem;
	private FrameLayout contextView;
	private Activity activity;
	public Mymenu(Activity activity, View menu, View buttomview, FrameLayout homeView) {
		this.MENU_VIEW = menu;
		this.BUTTOM_VIEW = buttomview;
		this.contextView = homeView;
		this.activity = activity;
	
		init();

	}
	public void setMymenuListem(MymenuListem mymenuListem) {
		this.mymenuListem = mymenuListem;
	}
	public void init() {
		// TODO Auto-generated method stub
		
		
		contextView.bringChildToFront(MENU_VIEW);
		contextView.bringChildToFront(BUTTOM_VIEW);
		SCREEN_HIGHT = getScreensHeight(activity);
		if (MENU_VIEW != null && SCREEN_HIGHT != 0) {
			ViewPropertyAnimator.animate(MENU_VIEW).translationY(SCREEN_HIGHT)
					.setListener(new AnimatorListener() {
						@Override
						public void onAnimationEnd(Animator arg0) {
							// TODO Auto-generated method stub
							MENU_VIEW.setVisibility(View.VISIBLE);
						}
						@Override
						public void onAnimationCancel(Animator arg0) {
							// TODO Auto-generated method stub
						}
						@Override
						public void onAnimationRepeat(Animator arg0) {
							// TODO Auto-generated method stub
						}
						@Override
						public void onAnimationStart(Animator arg0) {
							// TODO Auto-generated method stub
						}
					});
		}
		if (null != contextView) {
			contextView.setOnTouchListener(new OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					closemenu();
					return true;// 锟窖达拷锟斤拷锟斤拷牡锟斤拷锟�
				}
			});
		}

	}
	public Boolean getIsOpen() {
		return IsOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		IsOpen = isOpen;
	}

	
	public void openmenu() {
			
		if (!IsOpen) {
			if (MENU_VIEW.getVisibility() != View.VISIBLE) {
				MENU_VIEW.setVisibility(View.VISIBLE);
			}
			if (MENU_HIGHT == 0) {
				MENU_HIGHT = MENU_VIEW.getHeight();
			}
			if (BUTTOM_MARGIN_TOP_HIGHT == 0) {
				BUTTOM_MARGIN_TOP_HIGHT =  (int) activity.getResources().getDimension(R.dimen.buttomhight);
			}
			ViewPropertyAnimator.animate(MENU_VIEW).setDuration(300)
					.translationY(SCREEN_HIGHT-BUTTOM_MARGIN_TOP_HIGHT-MENU_HIGHT);
			IsOpen = true;
			if (null != mymenuListem) {
				mymenuListem.onMenuOpen();
			}
		}
	}

	public void closemenu() {
		if (IsOpen) {
			if (MENU_VIEW.getVisibility() != View.VISIBLE) {
				MENU_VIEW.setVisibility(View.VISIBLE);
			}
			if (MENU_HIGHT == 0) {
				MENU_HIGHT = MENU_VIEW.getHeight();
			}
			if (BUTTOM_MARGIN_TOP_HIGHT == 0) {
				BUTTOM_MARGIN_TOP_HIGHT = (int) activity.getResources().getDimension(R.dimen.buttomhight);
			}
			ViewPropertyAnimator.animate(MENU_VIEW).setDuration(300)
					.translationY(SCREEN_HIGHT);
			IsOpen = false;
			if (null != mymenuListem) {
				mymenuListem.onMenuClose();
			}

		}

	}

	public static int getScreensHeight(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int height = metrics.heightPixels;// 锟斤拷幕锟侥革拷dp
		int statusBarHeight = getStatusHeight(activity);
		return height - statusBarHeight;
	}

	public static int getStatusHeight(Activity activity) {
		int statusHeight = 0;
		Rect localRect = new Rect();
		activity.getWindow().getDecorView()
				.getWindowVisibleDisplayFrame(localRect);
		statusHeight = localRect.top;
		if (0 == statusHeight) {
			Class<?> localClass;
			try {
				localClass = Class.forName("com.android.internal.R$dimen");
				Object localObject = localClass.newInstance();
				int i5 = Integer.parseInt(localClass
						.getField("status_bar_height").get(localObject)
						.toString());
				statusHeight = activity.getResources()
						.getDimensionPixelSize(i5);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
		return statusHeight;
	}
}
