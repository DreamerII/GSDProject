package com.student.gsd.gsdstudentapp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.adapters.NavDrawerAdapter;
import com.student.gsd.gsdstudentapp.managers.ActionBarController;
import com.student.gsd.gsdstudentapp.model.Profile;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentAddCash_;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentAgentLocation_;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentDiscounted_;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentSendMoney_;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentSettings_;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentTransaction_;
import com.student.gsd.gsdstudentapp.ui.fragment.FragmentWithdraw_;
import com.student.gsd.gsdstudentapp.ui.fragment.MyGSDWallet;
import com.student.gsd.gsdstudentapp.ui.fragment.MyGSDWallet_;
import com.student.gsd.gsdstudentapp.ui.fragment.WelcomeFragment_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringArrayRes;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private ActionBarController mAbController;
    private String[] mItemMenu;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavDrawerAdapter mAdapter;

    @ViewById(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;
    @ViewById(R.id.list_slidermenu)
    protected ListView mDrawerList;

    private Realm realm;

    @AfterInject
    protected void afterinject(){
        realm = Realm.getInstance(this);
        Profile profile = realm.where(Profile.class).equalTo("userID", 1).findFirst();
        Log.d("DENYSYUK", "UserID = " + profile.getUserID());
        realm.close();
    }

    @AfterViews
    protected void afterViews(){
        initActionBar();

        mAbController.initEmptyToolbar();
        mItemMenu = getResources().getStringArray(R.array.list_items);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View header = inflater.inflate(R.layout.profile_header, mDrawerList, false);
        mDrawerList.addHeaderView(header);

        mAdapter = new NavDrawerAdapter(this, mItemMenu);
        mDrawerList.setAdapter(mAdapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.item_open, R.string.item_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                mAbController.setTitle();
                mDrawerToggle.syncState();
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                mDrawerToggle.syncState();
            }
        };

        mDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.container);
        if(fragment1 != null){
            fragment1.onResume();
            selectItem(Integer.valueOf(fragment1.getTag()));
        } else {
            selectItem(1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(!mDrawerLayout.isDrawerOpen(Gravity.LEFT))
                mDrawerLayout.openDrawer(Gravity.LEFT);
                else
                mDrawerLayout.closeDrawers();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initActionBar() {
        mAbController = new ActionBarController();
        mAbController.register(this);
    }

    public ActionBarController getAbController(){
        return mAbController;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int _position){
        Fragment fragment = MyGSDWallet_.builder().build();
        switch (_position){
            case 1:
                fragment = MyGSDWallet_.builder().build();
                break;
            case 2:
                fragment = FragmentAddCash_.builder().build();
                break;
            case 3:
                fragment = FragmentAgentLocation_.builder().build();
                break;
            case 4:
                fragment = FragmentTransaction_.builder().build();
                break;
            case 5:
                fragment = FragmentDiscounted_.builder().build();
                break;
            case 6:
                fragment = FragmentSendMoney_.builder().build();
                break;
            case 7:
                fragment = FragmentWithdraw_.builder().build();
                break;
            case 8:
                fragment = FragmentSettings_.builder().build();
                break;
        }

        if(_position != 0) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment, _position+"")
                    .commit();

            mDrawerList.setItemChecked(_position, true);
            setTitle(mItemMenu[_position-1]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mAbController.setTitle(title.toString());
    }
}
