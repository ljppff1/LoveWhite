package com.ljppff.fragment;import java.io.ByteArrayOutputStream;import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.FileOutputStream;import java.io.IOException;import java.text.SimpleDateFormat;import com.ljppff.LoveWhite.GestureListener;import com.ljppff.LoveWhite.LianXiActivity;import com.ljppff.LoveWhite.PersonDangActivity;import com.ljppff.LoveWhite.R;import com.ljppff.utils.ImageTools;import com.ljppff.view.FlowLayout;import android.app.AlertDialog;import android.app.Fragment;import android.content.Context;import android.content.DialogInterface;import android.content.Intent;import android.content.SharedPreferences;import android.content.SharedPreferences.Editor;import android.content.res.Resources;import android.database.Cursor;import android.graphics.Bitmap;import android.graphics.BitmapFactory;import android.graphics.Matrix;import android.graphics.drawable.AnimationDrawable;import android.graphics.drawable.BitmapDrawable;import android.graphics.drawable.Drawable;import android.net.Uri;import android.os.AsyncTask;import android.os.Bundle;import android.os.Environment;import android.os.Handler;import android.provider.MediaStore;import android.support.annotation.Nullable;import android.util.Log;import android.view.Gravity;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.view.ViewGroup.LayoutParams;import android.view.Window;import android.view.WindowManager;import android.view.View.OnClickListener;import android.view.ViewTreeObserver.OnPreDrawListener;import android.view.animation.Animation;import android.widget.Button;import android.widget.ImageView;import android.widget.ImageView.ScaleType;import android.widget.LinearLayout;import android.widget.RelativeLayout;import android.widget.TextView;import android.widget.Toast;public class Fragment2 extends android.support.v4.app.Fragment{	private View parentView;	private ImageView mIvww;	private ImageView mIv1;	private ImageView mIv2;	private ImageView mIv3;	private ImageView mIv4;	private ImageView mIv5;	private ImageView mIv6;	private LinearLayout mLLw1;	private FlowLayout mFFF;	@Override	@Nullable	public View onCreateView(LayoutInflater inflater,			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {		parentView = inflater.inflate(R.layout.fragment2, container, false);		mIvww =(ImageView) parentView.findViewById(R.id.mIvww);		mIvww.setOnClickListener(listener);		mIv1 =(ImageView) parentView.findViewById(R.id.mIv1);		mIv1.setOnClickListener(listener);		mIv2 =(ImageView) parentView.findViewById(R.id.mIv2);		mIv2.setOnClickListener(listener);		mIv3 =(ImageView) parentView.findViewById(R.id.mIv3);		mIv3.setOnClickListener(listener);				mIv4 =(ImageView) parentView.findViewById(R.id.mIv4);		mIv4.setOnClickListener(listener);				mIv5 =(ImageView) parentView.findViewById(R.id.mIv5);		mIv5.setOnClickListener(listener);		mIv6 =(ImageView) parentView.findViewById(R.id.mIv6);		mIv6.setOnClickListener(listener);				mLLw1 =(LinearLayout)parentView.findViewById(R.id.mLLw1);						mFFF =(com.ljppff.view.FlowLayout)parentView.findViewById(R.id.mFFF);		init();								return parentView;	}	private void init() {        LinearLayout.LayoutParams layoutParamsButtonCancel1 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);          layoutParamsButtonCancel1.gravity = Gravity.CENTER;          layoutParamsButtonCancel1.leftMargin = dip2px(getActivity(), 1);          layoutParamsButtonCancel1.rightMargin = dip2px(getActivity(), 1);          layoutParamsButtonCancel1.topMargin= dip2px(getActivity(), 1);          layoutParamsButtonCancel1.bottomMargin= dip2px(getActivity(), 1);  		ImageView iv =new ImageView(getActivity());		iv.setImageResource(R.drawable.profile_addfav);		iv.setLayoutParams(layoutParamsButtonCancel1);		iv.setOnClickListener(new OnClickListener() {						@Override			public void onClick(View v) {				startActivity(new Intent(getActivity(), PersonDangActivity.class));			}		});		mFFF.addView(iv);				for(int i=0;i<80;i++){	        LinearLayout.LayoutParams layoutParamsButtonCancel = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  	        layoutParamsButtonCancel.gravity = Gravity.CENTER;  	        layoutParamsButtonCancel.leftMargin = dip2px(getActivity(), 1);  	        layoutParamsButtonCancel.rightMargin = dip2px(getActivity(), 1);  	        layoutParamsButtonCancel.topMargin= dip2px(getActivity(), 1);  	        layoutParamsButtonCancel.bottomMargin= dip2px(getActivity(), 1);  	     //   layoutParamsButtonCancel.weight = 1;  	        //Button取消  	    	TextView tv1 = new TextView(getActivity());	    	tv1.setLayoutParams(layoutParamsButtonCancel);  	    	String text ="2";	    	if(i<5){	    	 text = "asd";	    	}else if(i<20){	    		 text = "er";	    	}else if(i<30){	    		 text = "g";	    	}else if(i<36){	    		 text = "awefae";	    	}else{	    		text ="wahtd";	    	}	    		    		    	Drawable drawable= getResources().getDrawable(R.drawable.profile_book);	/// 这一步必须要做,否则不会显示.	drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());	tv1.setCompoundDrawables(drawable,null,null,null);	Drawable drawable1=getActivity().getResources().getDrawable(R.drawable.flag_01); 	tv1.setBackgroundDrawable(drawable1); 	tv1.setGravity(Gravity.CENTER);	tv1.setText(text);	    	mFFF.addView(tv1);						}	}	   /**      * 根据手机的分辨率从 dp 的单位 转成为 px(像素)      */      public static int dip2px(Context context, float dpValue) {          final float scale = context.getResources().getDisplayMetrics().density;          return (int) (dpValue * scale + 0.5f);      }        /**      * 根据手机的分辨率从 px(像素) 的单位 转成为 dp      */      public static int px2dip(Context context, float pxValue) {          final float scale = context.getResources().getDisplayMetrics().density;          return (int) (pxValue / scale + 0.5f);      }  	private int mIvwhat =0;	OnClickListener listener =new OnClickListener() {				@Override		public void onClick(View v) {			switch (v.getId()) {			case R.id.mIvww:				mIvwhat =0;				showCustomAlertDialog();				break;			case R.id.mIv4:				mIvwhat =4;				showCustomAlertDialog();				break;			case R.id.mIv3:				mIvwhat =3;				showCustomAlertDialog();				break;			case R.id.mIv2:				mIvwhat =2;				showCustomAlertDialog();				break;			case R.id.mIv1:				mIvwhat =1;				showCustomAlertDialog();				break;			case R.id.mIv5:				mIvwhat =5;				showCustomAlertDialog();				break;			case R.id.mIv6:				startActivity(new Intent(getActivity(), LianXiActivity.class));												final ImageView im = new ImageView(getActivity());								im.setPadding(10, 0, 0, 0);				im.setImageResource(R.drawable.profile_wechat);				im.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));				im.setScaleType(ScaleType.FIT_XY);				mLLw1.addView(im);/*				im.setOnClickListener(new OnClickListener() {					@Override					public void onClick(View v) {						BitmapDrawable bitmapDrawable = (BitmapDrawable) im								.getDrawable();						if (bitmapDrawable != null								&& !bitmapDrawable.getBitmap().isRecycled()) {							bitmapDrawable.getBitmap().recycle();						}						mLLw1.removeView(im);					}				});*/				break;			default:				break;			}		}	};			private AlertDialog alertDialog;		private void showCustomAlertDialog() {		/* alertDialog = new AlertDialog.Builder(getActivity()).create();		alertDialog.show();		Window win = alertDialog.getWindow();		WindowManager.LayoutParams lp = win.getAttributes();		win.setGravity(Gravity.CENTER );		//lp.alpha = 0.7f;		win.setAttributes(lp);		win.setContentView(R.layout.dialog);		Button camera_phone = (Button) win.findViewById(R.id.camera_phone);		camera_phone.setOnClickListener(new OnClickListener() {			@Override			public void onClick(View v) {				// TODO Auto-generated method stub				systemPhoto();			}		});		Button camera_camera = (Button) win.findViewById(R.id.camera_camera);		camera_camera.setOnClickListener(new OnClickListener() {			@Override			public void onClick(View v) {				// TODO Auto-generated method stub				cameraPhoto();			}		});				*/												        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());        builder.setTitle("加入照片");        //    指定下拉列表的显示数据        final String[] cities = {"拍摄照片", "选择照片"};        //    设置一个下拉的列表选择项        builder.setItems(cities, new DialogInterface.OnClickListener()        {            @Override            public void onClick(DialogInterface dialog, int which)            {                if(which==0){                	cameraPhoto();                }else{                	systemPhoto();                }            }        });        builder.show();									}	private final int SYS_INTENT_REQUEST = 0XFF01;	private final int CAMERA_INTENT_REQUEST = 0XFF02;	private Bitmap bitmap;	private static final int CROP_PICTURE = 3;	/**	 * 打开系统相册	 */	private void systemPhoto() {		Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);		openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");		startActivityForResult(openAlbumIntent, 2);	}	/**	 * 调用相机拍照	 */	private void cameraPhoto() {		String sdStatus = Environment.getExternalStorageState();		/* 检测sd是否可用 */	/*	if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {			//Toast.makeText(this, "SD卡不可用！", Toast.LENGTH_SHORT).show();			return;		}		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");		startActivityForResult(intent, CAMERA_INTENT_REQUEST);		*/						Uri imageUri = null;		String fileName = null;		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);			//删除上一次截图的临时文件			SharedPreferences sharedPreferences = getActivity().getSharedPreferences("temp",Context.MODE_WORLD_WRITEABLE);			ImageTools.deletePhotoAtPathAndName(Environment.getExternalStorageDirectory().getAbsolutePath(), sharedPreferences.getString("tempName", ""));			//保存本次截图临时文件名字			fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";			Editor editor = sharedPreferences.edit();			editor.putString("tempName", fileName);			editor.commit();		imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));		//指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);		startActivityForResult(openCameraIntent,2);			}	@Override	public void onActivityResult(int requestCode, int resultCode, Intent data) {		if (requestCode == 2 ) {				Uri uri = null;				if (data != null) {					uri = data.getData();					System.out.println("Data");				}else {					System.out.println("File");					String fileName = getActivity().getSharedPreferences("temp",Context.MODE_WORLD_WRITEABLE).getString("tempName", "");					uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));				}				cropImage(uri, 500, 500, CROP_PICTURE);							/*					Uri uri = data.getData();				Cursor cursor = getActivity().getContentResolver().query(uri, null, null,						null, null);				cursor.moveToFirst();				String imageFilePath = cursor.getString(1);				System.out.println("File path is----->" + imageFilePath);				FileInputStream fis = new FileInputStream(imageFilePath);				bitmap = BitmapFactory.decodeStream(fis);				file=new File(imageFilePath);				int width = bitmap.getWidth();				int height = bitmap.getHeight();				 压缩获取的图像 				showImgs(bitmap, false);				fis.close();				cursor.close();*/					} else if (requestCode == CAMERA_INTENT_REQUEST				&& resultCode == getActivity().RESULT_OK && data != null) {			cameraCamera(data);		} else if (requestCode == CROP_PICTURE) {			Bitmap photo = null;			Uri photoUri = data.getData();			if (photoUri != null) {				photo = BitmapFactory.decodeFile(photoUri.getPath());			}			if (photo == null) {				Bundle extra = data.getExtras();				if (extra != null) {	                photo = (Bitmap)extra.get("data");  	                ByteArrayOutputStream stream = new ByteArrayOutputStream();  	                photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);	            }  			}			showImgs(photo, false);		}		super.onActivityResult(requestCode, resultCode, data);	}	private final int PHOTO_PICKED_WITH_DATA = 0XFF03;	//截取图片	public void cropImage(Uri uri, int outputX, int outputY, int requestCode){		Intent intent = new Intent("com.android.camera.action.CROP");          intent.setDataAndType(uri, "image/*");          intent.putExtra("crop", "true");          intent.putExtra("aspectX", 1);          intent.putExtra("aspectY", 1);          intent.putExtra("outputX", outputX);           intent.putExtra("outputY", outputY);         intent.putExtra("outputFormat", "JPEG");        intent.putExtra("noFaceDetection", true);        intent.putExtra("return-data", true);  	    startActivityForResult(intent, requestCode);	}     	/**	 * @param bitmap	 * @return 压缩后的bitmap	 */	private Bitmap compressionBigBitmap(Bitmap bitmap, boolean isSysUp) {		Bitmap destBitmap = null;		/* 图片宽度调整为100，大于这个比例的，按一定比例缩放到宽度为100 */		if (bitmap.getWidth() > 80) {			float scaleValue = (float) (80f / bitmap.getWidth());			System.out.println("缩放比例---->" + scaleValue);			Matrix matrix = new Matrix();			/* 针对系统拍照，旋转90° */		//	if (isSysUp)		//		matrix.setRotate(90);			matrix.postScale(scaleValue, scaleValue);			destBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),					bitmap.getHeight(), matrix, true);			int widthTemp = destBitmap.getWidth();			int heightTemp = destBitmap.getHeight();			Log.i("zhiwei.zhao", "压缩后的宽高----> width: " + heightTemp					+ " height:" + widthTemp);		} else {			return bitmap;		}		return destBitmap;	}	/**	 * @param data	 *            拍照后获取照片	 */	private File file;	private void cameraCamera(Intent data) {/*		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");		String name = formatter.format(System.currentTimeMillis()) + ".jpg";		Log.i("zhiwei.zhao", "image name:" + name);		Bundle bundle = data.getExtras();		 获取相机返回的数据，并转换为Bitmap图片格式 		Bitmap bitmap = (Bitmap) bundle.get("data");		FileOutputStream b = null;		String path = Environment.getExternalStorageDirectory().getPath();		File file1 = new File(path + "/myImage/");		*//** 检测文件夹是否存在，不存在则创建文件夹 **//*		if (!file1.exists() && !file1.isDirectory())			file1.mkdirs();		String fileName = file1.getPath() + "/" + name;		file=new File(fileName);		Log.i("zhiwei.zhao", "camera file path:" + fileName);		try {			b = new FileOutputStream(fileName);			 把数据写入文件 			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);		} catch (FileNotFoundException e) {			e.printStackTrace();		} finally {			try {				if (b == null)					return;				b.flush();				b.close();			} catch (IOException e) {				e.printStackTrace();			}		}		showImgs(bitmap, true);*/			Uri imageUri = null;		String fileName = null;		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);			//删除上一次截图的临时文件			SharedPreferences sharedPreferences = getActivity().getSharedPreferences("temp",Context.MODE_WORLD_WRITEABLE);			ImageTools.deletePhotoAtPathAndName(Environment.getExternalStorageDirectory().getAbsolutePath(), sharedPreferences.getString("tempName", ""));			//保存本次截图临时文件名字			fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";			Editor editor = sharedPreferences.edit();			editor.putString("tempName", fileName);			editor.commit();				imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));		//指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);		startActivityForResult(openCameraIntent,3);		}	/**	 * 展示选择的图片	 * 	 * @param bitmap	 * @param isSysUp	 */	private void showImgs(Bitmap bitmap, boolean isSysUp) {/*		if(alertDialog.isShowing()){			alertDialog.cancel();		}*/		switch (mIvwhat) {		case 0:			mIvww.setImageBitmap(bitmap);			break;		case 1:			mIv1.setImageBitmap(bitmap);			break;		case 2:			mIv2.setImageBitmap(bitmap);			break;		case 3:			mIv3.setImageBitmap(bitmap);			break;		case 4:			mIv4.setImageBitmap(bitmap);			break;		case 5:			mIv5.setImageBitmap(bitmap);			break;		default:			break;		}					}}