package com.example.maininterdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.maininterdemo.TopBar.TopbarClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private ViewPager vp;
	private LinearLayout Tabhome,Tabsearch,Tabme;
	private ImageButton Ibhome,Ibsearch,Ibme;
	private PagerAdapter pa;
	private List<View> vpList=new ArrayList<View>();	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//TopBar
		TopBar Topbar=(TopBar)findViewById(R.id.topbar);
		Topbar.setOnTopbarClickListener(new TopbarClickListener() {
			
			@Override
			public void rightClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick() {
				// TODO Auto-generated method stub
			}
		});
		//ViewPager
		initView();
		//TabButton
		tabEvents();
	}
	//------------------------------ViewPager	
	private void initView() {
		//ViewPager
		vp=(ViewPager)findViewById(R.id.viewpager);
		
		Tabhome=(LinearLayout)findViewById(R.id.hometab);
		Tabsearch=(LinearLayout)findViewById(R.id.searchtab);
		Tabme=(LinearLayout)findViewById(R.id.metab);
		
		Ibhome=(ImageButton)findViewById(R.id.homeimg);
		Ibsearch=(ImageButton)findViewById(R.id.searchimg);
		Ibme=(ImageButton)findViewById(R.id.meimg);
		
		LayoutInflater lInflater=LayoutInflater.from(this);
		View tabhome=lInflater.inflate(R.layout.tabhome, null);//home
		View tabsearch=lInflater.inflate(R.layout.tabsearch, null);//map  
		View tabme=lInflater.inflate(R.layout.tabme, null);//me  
		vpList.add(tabhome);//home
		vpList.add(tabsearch);//map  
		vpList.add(tabme);//me  
		//ViewAdapter
		pa=new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return vpList.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(vpList.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view =vpList.get(position);
				container.addView(view);
				return view;
			}
		};
		//set adapter
		vp.setAdapter(pa);
		}
	
	//------------------------------TabEvents
	private void tabEvents() {
		// TODO Auto-generated method stub
		Tabhome.setOnClickListener(this);
		Tabsearch.setOnClickListener(this);
		Tabme.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.hometab:
			vp.setCurrentItem(0);
			break;
		case R.id.searchtab:
			vp.setCurrentItem(1);
			break;
		case R.id.metab:
			vp.setCurrentItem(2);
			break;
		default:
			break;
		}
	}
	
}
