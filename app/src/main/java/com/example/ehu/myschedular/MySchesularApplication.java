package com.example.ehu.myschedular;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmCollection;
import io.realm.RealmConfiguration;
/*DBの設定や管理*/

public class MySchesularApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig=new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
