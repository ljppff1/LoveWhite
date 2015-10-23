package com.ljppff.LoveWhite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
//²¼¾ÖÄÚÈÝ
public class LianXiActivity extends BaseActivity {

	
	private RelativeLayout mRlw1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lianxi);
         initView();
		
	}

	private void initView() {
		mRlw1 =(RelativeLayout)this.findViewById(R.id.mRlw1);
		mRlw1.setOnClickListener(listener);
		
		
	}
	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mRlw1:
				finish();
				break;

			default:
				break;
			}
		}
	};


}
