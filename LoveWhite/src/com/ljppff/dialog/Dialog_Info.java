package com.ljppff.dialog;

import com.ljppff.LoveWhite.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Dialog_Info {
	ImageView img;
	Button auto;
	public Dialog_Info(final Context c) {
		View view = LayoutInflater.from(c).inflate(
                R.layout.dialog_info, null);
		DisplayMetrics getphonesize = new DisplayMetrics();
		((Activity) c).getWindowManager().getDefaultDisplay()
				.getMetrics(getphonesize);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(c);
		dialog.setView(view);
		dialog.create().show();
	}
}
