package com.xcx.dailynews.di.component;

import com.xcx.dailynews.di.module.ActivityModule;
import com.xcx.dailynews.di.qualifiter.PreFragment;
import com.xcx.dailynews.mvp.ui.activity.LoginActivity;
import com.xcx.dailynews.mvp.ui.activity.NewsDetailActivity;
import com.xcx.dailynews.mvp.ui.activity.SignUpActivity;
import com.xcx.dailynews.mvp.ui.fragment.BaseNewsFragment;
import com.xcx.dailynews.mvp.ui.fragment.CollectFragment;
import com.xcx.dailynews.mvp.ui.fragment.MyFragment;
import com.xcx.dailynews.mvp.ui.fragment.PhotoFragment;

import dagger.Component;

/**
 * Created by xcx on 2016/11/1.
 */
@PreFragment
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface FragmentComponent {
    void injectFragment(BaseNewsFragment fragment);
    void injectPhotoFragment(PhotoFragment fragment);
    void injectActivity(NewsDetailActivity activity);
    void injectLoginActivity(LoginActivity activity);
    void injectSignUpActivity(SignUpActivity activity);
    void injectCheckFragment(MyFragment fragment);
    void injectUpdateServerFragment(CollectFragment fragment);

}
