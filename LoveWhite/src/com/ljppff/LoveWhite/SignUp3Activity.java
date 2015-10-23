package com.ljppff.LoveWhite;

import java.io.ByteArrayOutputStream;
import java.io.File;

import com.ljppff.utils.ImageTools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
//布局内容
public class SignUp3Activity extends BaseActivity {

	
	private RelativeLayout mRlw1;
	private TextView mTv1;
	private ForegroundColorSpan redSpan;
	private CheckBox mCb1;
	private CheckBox mCb2;
	private ImageView mIv1;
	private RelativeLayout mRlw3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup2);
         initView();
		
	}

	private void initView() {
		mRlw1 =(RelativeLayout)this.findViewById(R.id.mRlw1);
		mRlw1.setOnClickListener(listener);
		mIv1 =(ImageView)this.findViewById(R.id.mIv1);
		mIv1.setOnClickListener(listener);
		mRlw3 =(RelativeLayout)this.findViewById(R.id.mRlw3);
		mRlw3.setOnClickListener(listener);
	}
	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mRlw3:
				startActivity(new Intent(getApplicationContext(), SignUp3Activity.class));
				break;

			case R.id.mRlw1:
				finish();
				break;
			case R.id.mIv1:
				showCustomAlertDialog();
				break;

			default:
				break;
			}
		}
	};


	private void showCustomAlertDialog() {

		
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp3Activity.this);
        builder.setTitle("加入照片");
        //    指定下拉列表的显示数据
        final String[] cities = {"拍摄照片", "选择照片"};
        //    设置一个下拉的列表选择项
        builder.setItems(cities, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if(which==0){
                	cameraPhoto();
                }else{
                	systemPhoto();
                }
            }
        });
        builder.show();
		
	}
	private final int SYS_INTENT_REQUEST = 0XFF01;
	private final int CAMERA_INTENT_REQUEST = 0XFF02;
	private Bitmap bitmap;
	private static final int CROP_PICTURE = 3;

	/**
	 * 打开系统相册
	 */
	private void systemPhoto() {

		Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
		openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
		startActivityForResult(openAlbumIntent, 2);
	}

	/**
	 * 调用相机拍照
	 */
	private void cameraPhoto() {
		String sdStatus = Environment.getExternalStorageState();
		/* 检测sd是否可用 */
	/*	if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
			//Toast.makeText(this, "SD卡不可用！", Toast.LENGTH_SHORT).show();
			return;
		}
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivityForResult(intent, CAMERA_INTENT_REQUEST);
		*/
		
		
		Uri imageUri = null;
		String fileName = null;
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			//删除上一次截图的临时文件
			SharedPreferences sharedPreferences = getSharedPreferences("temp",Context.MODE_WORLD_WRITEABLE);
			ImageTools.deletePhotoAtPathAndName(Environment.getExternalStorageDirectory().getAbsolutePath(), sharedPreferences.getString("tempName", ""));
			//保存本次截图临时文件名字
			fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
			Editor editor = sharedPreferences.edit();
			editor.putString("tempName", fileName);
			editor.commit();
		imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));
		//指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		startActivityForResult(openCameraIntent,2);

		
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 2 ) {
				Uri uri = null;
				if (data != null) {
					uri = data.getData();
					System.out.println("Data");
				}else {
					System.out.println("File");
					String fileName = getSharedPreferences("temp",Context.MODE_WORLD_WRITEABLE).getString("tempName", "");
					uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));
				}
				cropImage(uri, 500, 500, CROP_PICTURE);

				
			/*	
				Uri uri = data.getData();
				Cursor cursor = getContentResolver().query(uri, null, null,
						null, null);
				cursor.moveToFirst();

				String imageFilePath = cursor.getString(1);
				System.out.println("File path is----->" + imageFilePath);

				FileInputStream fis = new FileInputStream(imageFilePath);
				bitmap = BitmapFactory.decodeStream(fis);
				file=new File(imageFilePath);

				int width = bitmap.getWidth();
				int height = bitmap.getHeight();

				 压缩获取的图像 
				showImgs(bitmap, false);

				fis.close();
				cursor.close();*/
			

		} else if (requestCode == CAMERA_INTENT_REQUEST
				&& resultCode == RESULT_OK && data != null) {
			cameraCamera(data);
		} else if (requestCode == CROP_PICTURE) {
			Bitmap photo = null;
			Uri photoUri = data.getData();
			if (photoUri != null) {
				photo = BitmapFactory.decodeFile(photoUri.getPath());
			}
			if (photo == null) {
				Bundle extra = data.getExtras();
				if (extra != null) {
	                photo = (Bitmap)extra.get("data");  
	                ByteArrayOutputStream stream = new ByteArrayOutputStream();  
	                photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
	            }  
			}
			showImgs(photo, false);

		}
		super.onActivityResult(requestCode, resultCode, data);

	}
	private final int PHOTO_PICKED_WITH_DATA = 0XFF03;
	//截取图片
	public void cropImage(Uri uri, int outputX, int outputY, int requestCode){
		Intent intent = new Intent("com.android.camera.action.CROP");  
        intent.setDataAndType(uri, "image/*");  
        intent.putExtra("crop", "true");  
        intent.putExtra("aspectX", 1);  
        intent.putExtra("aspectY", 1);  
        intent.putExtra("outputX", outputX);   
        intent.putExtra("outputY", outputY); 
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);  
	    startActivityForResult(intent, requestCode);
	}

   
  
	/**
	 * @param bitmap
	 * @return 压缩后的bitmap
	 */
	private Bitmap compressionBigBitmap(Bitmap bitmap, boolean isSysUp) {
		Bitmap destBitmap = null;
		/* 图片宽度调整为100，大于这个比例的，按一定比例缩放到宽度为100 */
		if (bitmap.getWidth() > 80) {
			float scaleValue = (float) (80f / bitmap.getWidth());
			System.out.println("缩放比例---->" + scaleValue);

			Matrix matrix = new Matrix();
			/* 针对系统拍照，旋转90° */
		//	if (isSysUp)
		//		matrix.setRotate(90);
			matrix.postScale(scaleValue, scaleValue);

			destBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
					bitmap.getHeight(), matrix, true);
			int widthTemp = destBitmap.getWidth();
			int heightTemp = destBitmap.getHeight();
			Log.i("zhiwei.zhao", "压缩后的宽高----> width: " + heightTemp
					+ " height:" + widthTemp);
		} else {
			return bitmap;
		}
		return destBitmap;

	}

	/**
	 * @param data
	 *            拍照后获取照片
	 */
	private File file;
	private void cameraCamera(Intent data) {
/*		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String name = formatter.format(System.currentTimeMillis()) + ".jpg";
		Log.i("zhiwei.zhao", "image name:" + name);
		Bundle bundle = data.getExtras();
		 获取相机返回的数据，并转换为Bitmap图片格式 
		Bitmap bitmap = (Bitmap) bundle.get("data");
		FileOutputStream b = null;

		String path = Environment.getExternalStorageDirectory().getPath();
		File file1 = new File(path + "/myImage/");
		*//** 检测文件夹是否存在，不存在则创建文件夹 **//*
		if (!file1.exists() && !file1.isDirectory())
			file1.mkdirs();
		String fileName = file1.getPath() + "/" + name;
		file=new File(fileName);
		Log.i("zhiwei.zhao", "camera file path:" + fileName);
		try {
			b = new FileOutputStream(fileName);
			 把数据写入文件 
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (b == null)
					return;
				b.flush();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		showImgs(bitmap, true);
*/	
		Uri imageUri = null;
		String fileName = null;
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			//删除上一次截图的临时文件
			SharedPreferences sharedPreferences = getSharedPreferences("temp",Context.MODE_WORLD_WRITEABLE);
			ImageTools.deletePhotoAtPathAndName(Environment.getExternalStorageDirectory().getAbsolutePath(), sharedPreferences.getString("tempName", ""));
			//保存本次截图临时文件名字
			fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
			Editor editor = sharedPreferences.edit();
			editor.putString("tempName", fileName);
			editor.commit();
		
		imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));
		//指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		startActivityForResult(openCameraIntent,3);
	
	}
	/**
	 * 展示选择的图片
	 * 
	 * @param bitmap
	 * @param isSysUp
	 */
	private void showImgs(Bitmap bitmap, boolean isSysUp) {

			mIv1.setImageBitmap(bitmap);
		
		}
		
}
