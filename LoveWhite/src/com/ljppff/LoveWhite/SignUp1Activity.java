package com.ljppff.LoveWhite;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
//��������
public class SignUp1Activity extends BaseActivity {

	
	private RelativeLayout mRlw1;
	private TextView mTv1;
	private ForegroundColorSpan redSpan;
	private CheckBox mCb1;
	private CheckBox mCb2;
	private RelativeLayout mRlw3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup1);
         initView();
		
	}

	private void initView() {
		mRlw1 =(RelativeLayout)this.findViewById(R.id.mRlw1);
		mRlw1.setOnClickListener(listener);
		
        mTv1 =(TextView)this.findViewById(R.id.mTv1);
		 redSpan = new ForegroundColorSpan(Color.RED);  
			SpannableStringBuilder builder = new SpannableStringBuilder("��ӭ�����������飡����Ե��ǣ����Ϊ���ҳ������ˣ��Ͽ���ɼ����򵥲��裬������ʼ~");  
			builder.setSpan(new ForegroundColorSpan(Color.RED),4,8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  

			mTv1.setText(builder);

			mCb1 =(CheckBox)this.findViewById(R.id.mCb1);
			mCb2 =(CheckBox)this.findViewById(R.id.mCb2);
			
			SpannableStringBuilder builder1 = new SpannableStringBuilder("��ͬ�����ǵ�ʹ��������");  
			builder1.setSpan(new UnderlineSpan(), 6, 11,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			builder1.setSpan(new ForegroundColorSpan(Color.GREEN), 6, 11,
	                 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			mCb1.setText(builder1);
			
			SpannableStringBuilder builder2 = new SpannableStringBuilder("��ͬ�����ǵ���˽����");  
			builder2.setSpan(new UnderlineSpan(), 6, 10,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			builder2.setSpan(new ForegroundColorSpan(Color.GREEN), 6, 10,
	                 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			mCb2.setText(builder1);
			mRlw3 =(RelativeLayout)this.findViewById(R.id.mRlw3);
			mRlw3.setOnClickListener(listener);
		
	}
	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mRlw1:
				finish();
				break;
			case R.id.mRlw3:
				startActivity(new Intent(getApplicationContext(), SignUp2Activity.class));
				break;

			default:
				break;
			}
		}
	};


}
