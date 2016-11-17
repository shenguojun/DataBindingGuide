# DataBindingGuide
因为官方的DataBinding文档写的实在太挫，看完之后有些地方还是不知道怎么用。故写了这个demo。Demo基本上包含了所有Databinding的特性，如果有新的特性没有包含进里面，请联系 junguoshen@gmail.com。

## 为什么使用Databinding
1. findViewById()写到烦，希望代码优雅一点
2. UI逻辑要在Java中不优雅，希望像在Html中加入Javascript一样在XML中加入一些动态逻辑
3. 处理数据时要写一大堆的if else或者try catch，希望避免NullPointerExecption
4. 嫌弃自定义一个View太麻烦，不想declare-styleable

## Databinding是什么
简单来讲就是连接数据和Layout的框架。
- 可以将数据传递到Xml中
- 可以简单自定义View的Xml属性和逻辑
- 可以在Xml中建立起View之间的依赖关系
- 可以自动检测数据变化并更改View的状态
- 可以根据View的变化改变Data Model，实现数据双向绑定

## 最佳实践
1. 不要在xml中加入业务逻辑
2. 保持xml的简洁性
3. 使用Binding Adapters真的很棒

## 存在的问题
1. 当使用int给xml属性赋值时，如果该属性接受资源id，那么这个int会认为是资源的id。如果android:text=@{1}, 这样子text不会显示1，反而会报错，因为找不到id为1的资源
2. 表达式里面不能有中文，否则会报错。
3. 表达式不能换行。
4. 当databinding报错时会有一堆找不到binding的错误，这些都可以忽略，真正的错误在最后面那一段。
5. 使用了databinding后没办法在Android Studio里面通过快捷键找到该view的引用（这一点实在有点麻烦，希望Google做工具的Team可以尽快解决吧）

## 技术细节
以下根据DataBinding不同的特性来一一说明。

### Expression
#### &emsp;&emsp;可以使用的常用运算符
- 数学符号 + - * / &
- String 连接符 +
- 逻辑运算符 && ||
- 一元操作符 + - ! ~
- 二元操作符 & | ^
- 三元操作符 ?:
- 移位操作符 >> >>> <<
- 比较运算符 == > < >= <=
- instanceof
- 括号 ()
- Cast
- 数组访问 []
- 常量 character, String, numeric, null
- 方法调用
- 访问域变量
- ??

对于"??"这个操作符是DataBinding自定义的，意思是如果前面那个不是空就取前面那个，如果为空则取后面那个。以下两个表达式等效：
```xml
android:text="@{user.displayName ?? user.lastName}"
android:text="@{user.displayName != null ? user.displayName : user.lastName}"
```

#### &emsp;&emsp;Resource内联字符串/复数/尺寸
DataBinding可以使用以下表达式
```xml
android:text="@{@string/first_name + @string/last_name}"
android:padding="@{@dimen/padding_inside + @dimen/ padding_outside}"
android:text="@{@plurals/banana(bananaCount)}" 
```
#### &emsp;&emsp;Collections(List Map访问)
```xml
<data>
    <import type="android.util.SparseArray"/>
    <import type="java.util.Map"/>
    <import type="java.util.List"/>
    <variable name="list" type="List&lt;String>"/>
    <variable name="sparse" type="SparseArray&lt;String>"/>
    <variable name="map" type="Map&lt;String, String>"/>
    <variable name="index" type="int"/>
    <variable name="key" type="String"/>
</data>

android:text="@{list[index]}"
android:text="@{sparse[index]}“
android:text="@{map[key]}" 
android:text='@{map["firstName"]}' 
android:text="@{map[`firstName`]}" 
android:text="@{map[&quot;firstName&quot;]}" 
```

#### &emsp;&emsp;有时候需要使用到的转义字符

字符 | 转义字符
---|---
&| \&amp;
< | \&lt;
> | \&gt;
" | \&quot;
' | \&apos;

#### &emsp;&emsp;Lambda Expression
```xml
android:onClick="@{(v)->presenter.onViewClicked(v, user.gender)}"
```
可以调用
```java
public void onViewClicked(View view,  String content) {
    Toast.makeText(view.getContext(), content, Toast.LENGTH_SHORT).show();
}
```
在声明参数时，要么全部写，要么都不写，例如：
```xml
android:onFocusChange="@{(v, fcs)->presenter.onViewClicked(v, fcs, user.gender)}"
android:onFocusChange="@{()->presenter.onViewClicked(user.gender)}"
```
都可以调用
```java
onFocusChange(View v, boolean hasFocus)
```
#### &emsp;&emsp;特殊符号
在xml中可以通过ID来引用其他view，并且  
在DataBinding的xml中可以直接调用context变量，这个变量就是当前binding的context，例如
```xml
<TextView android:id="@+id/display_name“ …/>
<Button 
    android:onClick="@{()->presenter.onViewClicked(context, displayName.getText())}"
    …
/>

```

### Include
可以将变量传给include的view，例如：
```xml
<include
    layout="@layout/sub_layout"
    tools:subUser="@{user}"
    tools:lastName="@{user.lastName}"/>
```
然后在sub_layout.xml中
```xml
<layout …>
    <data>
        <variable
            name="subUser"
            type="com.xshen.databindingguide.data.User" />
        <variable name="lastName“ type="String" />
    </data>
    …
</layout>

```

### ViewStub
可以在ViewStub中使用DataBinding，例如在xml中
```xml
<ViewStub
    android:id="@+id/view_stub"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout="@layout/sub_layout" />
```
在使用Binding的地方，
```java
mBinding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
    @Override
    public void onInflate(ViewStub stub, View inflated) {
        // 第一次加载
        SubLayoutBinding binding = DataBindingUtil.bind(inflated);
        binding.setLastName("view_stub_inflated");
    }
});
…
if (!mBinding.viewStub.isInflated()) {
    mBinding.viewStub.getViewStub().inflate();
} else {
    // 往后的加载
    SubLayoutBinding binding = (SubLayoutBinding) mBinding.viewStub.getBinding();
    binding.setLastName("view_sub_after_inflate");
}

```

### Attribute Setters
#### &emsp;&emsp;Automatic Setters
DataBinding可以自动找到对应view的set方法，例如：
```xml
<com.xshen.databindingguide.ui.CustomTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:customText="@{`Custom Fonts Text`}"/>
```
可以调用View中的对应的set方法
```java
public class CustomTextView extends TextView {
    …
    public void setCustomText(CharSequence text){
        setText("Custom " + text);
    }
}
```
#### &emsp;&emsp;Renamed Seters
如果想自定义set方法的名字，可以这样做：
```java
// attribute = "app:customText"这个双引号一定要加，不然会报错，官方的文档错了。。
@BindingMethods({
    @BindingMethod(type = CustomTextView.class,
                   attribute = "app:customText",
                   method = "setMyCustomText")})
public class CustomTextView extends TextView {
    …
    public void setMyCustomText(CharSequence text) {
        setText("Custom " + text);
    }
}
```
#### &emsp;&emsp;Custom Setters
这个是神器，很好用，用来在全局自定义某个属性的对应的setter，例如
```xml
<TextView
    …
    app:font="@{`alegreya_bold`}" />
<ImageView
    …
    app:placeholder="@{@drawable/placeholder}" app:url="@{`http://img2.cache.netease.com/….jpg`}" />
```
可以绑定到以下的java代码中：
```java
@BindingAdapter({"bind:font"})
public static void setFont(TextView textView, String fontName) {
    textView.setTypeface(FontCache.getInstance().get(fontName));
}

@BindingAdapter({"bind:url", "bind:placeholder"})
public static void loadImage(ImageView imageView, String url, Drawable drawable){
    Glide.with(imageView.getContext()).load(url).centerCrop()         
         .placeholder(drawable).crossFade().into(imageView);
}
```
### RecycleView/ListView
一下是在RecyclerView中使用DataBinding的例子：
```java
public static class ViewHolder extends RecyclerView.ViewHolder {
    public DynamicTextViewBinding binding;
    public ViewHolder(DynamicTextViewBinding b) {
        super(b.getRoot());
        binding = b;
    }
    public DynamicTextViewBinding getBinding() {
        return binding;
    }
}

@Override
public DynamicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    DynamicTextViewBinding binding = DynamicTextViewBinding
       .inflate(layoutInflater, parent, false);
    ViewHolder vh = new ViewHolder(binding);
    return vh;
}

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    holder.getBinding().setText(mDataset[position]);
    holder.getBinding().executePendingBindings();
}
```
### Converter
可以自定义Conveter如下：
```xml
<RelativeLayout
    …
    android:background="@{error.get() ? @color/red: @color/green}"> 
```
会调用一下java代码
```java
@BindingConversion
public static ColorDrawable convertColorToDrawable(int color) {
    return new ColorDrawable(color);
}

```
### Observable
Observable使用如下：
```java
// 先定义一个Observable的类
public class User extends BaseObservable {
    private String firstName;
    @Bindable
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
}
// 也可以这样定义
public class ObservableUser {
    public ObservableField<String> firstName = new ObservableField<>();
}
```
当这个类的属性改变时，与其有绑定的view会自动获取最新的值。  
更新Observable对象可以这样做：
```java
User user = new User();
ObservableUser observableUser = new ObservableUser();
ObservableArrayMap<String, Object> userMap = new ObservableArrayMap<>();
ObservableArrayList<Object> userList = new ObservableArrayList<>();

user.setFirstName("Jacky");
user.setLastName("Wang");
user.setAge(25);
observableUser.firstName.set("Jacky");
observableUser.lastName.set("Wang");
observableUser.age.set(25);
userMap.put("firstName", "Jacky");
userMap.put("lastName", "Wang");
userMap.put("age", 25);
userList.set(0, "Jacky");
userList.set(1, "Wang");
userList.set(2, 25);
```

### Two way binding
数据双向绑定，当view内容改变时改变data model，当data model改变时改变view  
具体实现如下：  
在xml中使用"@="给属性复制
```xml
<EditText
    android:id="@+id/user_name_edit"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:inputType="text"
    android:textSize="@dimen/text_30px"
    app:text="@={user.firstName}" />
```
在Java中
```java
@BindingAdapter("app:text")
public static void setText(TextView view, CharSequence text) {
    final CharSequence oldText = view.getText();
    if (text == oldText || (text == null && oldText.length() == 0)) {
        return;
    }
    if (text instanceof Spanned) {
        if (text.equals(oldText)) {
            return; // No change in the spans, so don't set anything.
        }
    } else if (!haveContentsChanged(text, oldText)) {
        return; // No content changes, so don't set anything.
    }
    view.setText(text);
}

@InverseBindingAdapter(attribute = "app:text", event = "android:textAttrChanged")
public static String getTextString(TextView view) {
    return view.getText().toString();
}
```
一个DataBinding实现里面已经使用了Two Way Binding的例子：
```xml
<CheckBox
    android:id="@+id/seeAds"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />

<ImageView
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:scaleType="centerInside"
    android:visibility="@{seeAds.checked ? View.VISIBLE : View.GONE}"
    app:placeholder="@{@drawable/placeholder}"
    app:url="@{`http://***.jpg`}" />
```
### Animation transition
可以在bind的过程中使用动画
```java
binding.addOnRebindCallback(new OnRebindCallback() {
    @Override
    public boolean onPreBind(ViewDataBinding binding) {
        ViewGroup sceneRoot = (ViewGroup) binding.getRoot();
        TransitionManager.beginDelayedTransition(sceneRoot);
        return true;
    }
});

```
### Dependency injection
依赖注入可以根据生成环境还是测试环境来使用不同的绑定，例如：
```java
public abstract class DIBindingAdapters {
    @BindingAdapter("app:ditext")
    public abstract void setText(TextView textView, String value);
}

public class TestDIBindingAdapters extends DIBindingAdapters {
    @Override
    public void setText(TextView textView, String value) {
        textView.setText("test " + value);
        }
}

public class TestComponent implements android.databinding.DataBindingComponent {
    @Override
    public DIBindingAdapters getDIBindingAdapters() {
        return new TestDIBindingAdapters();
    }
}

```

## 参考
1. [Data Binding官方指南](https://developer.android.com/topic/libraries/data-binding/index.html)
1. [Data Binding -- Write Apps Faster (Android Dev Summit 2015)](https://www.youtube.com/watch?v=NBbeQMOcnZ0)
1. [Advanced Data Binding - Google I/O 2016](https://www.youtube.com/watch?v=DAmMN7m3wLU)
1. [Android Spring Cleaning: Data Binding by Lisa Wray](https://www.youtube.com/watch?v=zYGVsTE_scI)
1. [精通 Android Data Binding](https://github.com/LyndonChin/MasteringAndroidDataBinding)
