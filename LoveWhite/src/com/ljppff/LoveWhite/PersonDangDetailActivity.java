package com.ljppff.LoveWhite;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
//��������
public class PersonDangDetailActivity extends BaseActivity {

	
	private RelativeLayout mRlw1;
	private ForegroundColorSpan redSpan;
	private TextView mTv1;
	private ListView mLv1;
     private List<Data> list =new ArrayList<PersonDangDetailActivity.Data>();
     private int[] dd ={R.drawable.profile_music,R.drawable.profile_bteam,R.drawable.profile_team,R.drawable.profile_game,R.drawable.profile_travel,R.drawable.profile_dog,R.drawable.profile_cat,R.drawable.profile_idol,R.drawable.profile_movie,R.drawable.profile_tv,R.drawable.profile_sport,R.drawable.profile_bar,R.drawable.profile_restaurant,R.drawable.profile_instrument,R.drawable.profile_book,R.drawable.profile_app,R.drawable.profile_cartoon,R.drawable.profile_brand};
     private String[] dd1 ={"����","����","����","����","����","����֮��","��è֮��","����ż��","��Ӱ","���Ӿ缯","�˶�","CLUBBING","����","����","Ŀ��","���ж���","Apps","����","����Ʒ��"};
     private String[] dd2={"�������All TIME FAVOURITE SONG","���ˡ��������Ȼ������һ��","��Ϊ��׼���Ե���ӵ�������","��Щ������ù��ĵ�����Ϸ","������ô���������ֶ��Ƿ������ε���","����ӵ�еĹ���Ʒ��","ʲôƷ�ֵ�è�������Ļ���","����˭����ʵ��˿","����Ŀ������Щ�ľ����Ӱ","�����պ��ľ缯","�������ǿ�����ǵĻ","�����ҹ��","�㾭����ˣ���һ�������Ĳ���","���־Ϳɵ���һ��������","��������ϣ����ɵ���","����Щ���������ʳ׷������Ʒ","���ֻ���ر���Ӧ��","������������","����ʱ����˵�����ĳ���Ʒ��"};
	private Myadapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.persondangdetail);
         initView();
         mTv1 =(TextView)this.findViewById(R.id.mTv1);
         
		 redSpan = new ForegroundColorSpan(Color.RED);  

			SpannableStringBuilder builder = new SpannableStringBuilder("��ͬ���������򿪻�ϻ�ӣ�Ҳ����������ʶ��������������������İ��ó�ΪԵ�ݱ�ǩ����������Ѱ��Ȥζ��Ͷ����Ե�ˣ�");  
			builder.setSpan(new ForegroundColorSpan(Color.RED),35,39, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
			builder.setSpan(new ForegroundColorSpan(Color.RED),0,4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  

			mTv1.setText(builder);

		
	}

	private void initView() {
		mLv1 =(ListView) this.findViewById(R.id.mLv1);
		 initData();
		mRlw1 =(RelativeLayout)this.findViewById(R.id.mRlw1);
		mRlw1.setOnClickListener(listener);
	}
	class Holder{
		TextView mTv1,mTv2;
		ImageView mIv1;
	}

	private void initData() {
		adapter =new Myadapter();
		mLv1.setAdapter(adapter);
	}
	class  Myadapter extends   BaseAdapter{
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			        
			
			Holder holder = null;
			if(convertView==null){
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.item_listview_1, null);
				holder = new Holder();
				holder.mIv1 =(ImageView)convertView.findViewById(R.id.mIv1);
				holder.mTv1 =(TextView)convertView.findViewById(R.id.mTv1);
				holder.mTv2 =(TextView)convertView.findViewById(R.id.mTv2);
				convertView.setTag(holder);

			}else{
				holder =(Holder)convertView.getTag();
			}
			
			holder.mIv1.setImageResource(dd[position]);
			holder.mTv1.setText(dd1[position]);
			holder.mTv2.setText(dd2[position]);
			return convertView;

		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return dd.length;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	class Data{
		int pic;
		String name;
		String detail;
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
