//package com.jiju.chat.component;
//
//import com.jiju.chat.ui.contract.LoginContract;
//
//import dagger.Component;
//
//@Component(modules = AppComponent.class)                       // 指明Component查找Module的位置
//public interface MainComponent {                    // 必须定义为接口，Dagger2框架将自动生成Component的实现类，对应的类名是Dagger×××××
//    LoginContract.View inject(LoginContract.View activity);
//}