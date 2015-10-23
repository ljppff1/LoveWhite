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
//布局内容
public class PersonDangDetailActivity extends BaseActivity {

	
	private RelativeLayout mRlw1;
	private ForegroundColorSpan redSpan;
	private TextView mTv1;
	private ListView mLv1;
     private List<Data> list =new ArrayList<PersonDangDetailActivity.Data>();
     private int[] dd ={R.drawable.profile_music,R.drawable.profile_bteam,R.drawable.profile_team,R.drawable.profile_game,R.drawable.profile_travel,R.drawable.profile_dog,R.drawable.profile_cat,R.drawable.profile_idol,R.drawable.profile_movie,R.drawable.profile_tv,R.drawable.profile_sport,R.drawable.profile_bar,R.drawable.profile_restaurant,R.drawable.profile_instrument,R.drawable.profile_book,R.drawable.profile_app,R.drawable.profile_cartoon,R.drawable.profile_brand};
     private String[] dd1 ={"音乐","篮球","足球","电玩","旅游","爱狗之从","爱猫之人","明星偶像","电影","电视剧集","运动","CLUBBING","餐厅","乐器","目标","流行读物","Apps","动漫","潮流品牌"};
     private String[] dd2={"分享你的All TIME FAVOURITE SONG","湖人、帝王、热火，你最爱那一队","作为标准球迷的你拥护的球队","那些令你玩得过瘾的电玩游戏","世界这么大，有令你乐而记返的旅游地吗","最想拥有的狗狗品种","什么品种的猫咪最得你的欢心","你是谁的忠实粉丝","你心目中有那些的经典电影","中西日韩的剧集","助你锻炼强健体魄的活动","最常到的夜店","你经常光顾，或一试难忘的餐厅","随手就可弹奏一曲的乐器","你心里最希望达成的事","有那些令你废寝忘食追看的作品","你手机里必备的应用","海贼王，龙珠","走在时代尖端的你最爱的潮流品牌"};
	private Myadapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.persondangdetail);
         initView();
         mTv1 =(TextView)this.findViewById(R.id.mTv1);
         
		 redSpan = new ForegroundColorSpan(Color.RED);  

			SpannableStringBuilder builder = new SpannableStringBuilder("共同爱好有助打开话匣子，也有助加深认识！请在下面的类别加入您的爱好成为缘份标签，让我助你寻找趣味相投的有缘人！");  
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
