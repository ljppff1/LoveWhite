package com.ljppff.LoveWhite;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ljppff.fragment.Fragment1;
import com.ljppff.fragment.Fragment2;
import com.ljppff.fragment.Fragment6;

public class MainActivity extends FragmentActivity {
	public static int NONE = 0;
	public static int RED = 1;
	public static int GREEN = 2;
	public static int BLUE = 3;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new com.ljppff.dialog.Dialog_Info(this);
		mTitle = mDrawerTitle = getTitle();
		mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
/*        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));
*/   
        mDrawerList.setAdapter(new Myadapter());
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    //	Drawable colorDrawable = new ColorDrawable(R.color.yellow);
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.mytitle));
       // getActionBar().setSubtitle("adsf");
        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
              //  invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
               // invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
        
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
    //    boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
     //   menu.findItem(R.id.action_key).setVisible(!drawerOpen);
    //    menu.findItem(R.id.action_control).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
    	
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
		new AlertDialog.Builder(MainActivity.this)
		.setTitle("提示")
		.setMessage("您确定登出当前帐号？")
		.setNegativeButton("确定", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
			//	System.exit(0);
			}
		})
		.setPositiveButton("取消", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		}).create().show();


        // Handle action buttons
        switch(item.getItemId()) {
/*        case R.id.action_key:
        	new Dialog_Qrcode(this);
            return true;
        case R.id.action_control:
        	new Dialog_Info(this);
            return true;
*/        default:
            return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
    	android.support.v4.app.Fragment fragment = null;
    	switch (position) {
		case 0:
			fragment = new Fragment2();
			break;
		case 1:
			fragment = new Fragment1();
			break;
		case 6:
			fragment = new Fragment6();
			break;

		default:
		fragment = new android.support.v4.app.Fragment();

			break;
		}
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        
        fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	// TODO Auto-generated method stub
    	if(keyCode==KeyEvent.KEYCODE_BACK){
    		new AlertDialog.Builder(MainActivity.this)
			.setTitle("提示")
			.setMessage("您确定退出登陆？")
			.setNegativeButton("确定", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					System.exit(0);
				}
			})
			.setPositiveButton("取消", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			}).create().show();

    	}
    	return super.onKeyDown(keyCode, event);
    }
    
    

	class Holder{
		TextView mTvri12;
		ImageView imageView;
	}

	class  Myadapter extends   BaseAdapter{
		@SuppressLint("NewApi")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			        
			
			Holder holder = null;
			if(convertView==null){
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.item_left, null);
				holder = new Holder();
				holder.imageView =(ImageView)convertView.findViewById(R.id.ivThumb);
				holder.mTvri12 =(TextView)convertView.findViewById(R.id.tvName);
				convertView.setTag(holder);
	
			}else{
				holder =(Holder)convertView.getTag();
			}
				
			holder.imageView.setImageResource(R.drawable.menu_myprofile_icon_c);
			holder.mTvri12.setText(mPlanetTitles[position]);
			
			
			
			
			return convertView;

		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mPlanetTitles.length;
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


}
