### WebView知识点
#### 一、WebView常见的一些坑

|WebView常见的一些坑|
|------|
|在`Android API level 16`以及之前的版本存在`远程代码执行安全漏洞`，`该漏洞源于程序没有正确限制使用WebView.addJavascriptInterface方法`，`远程攻击者可通过使用Java Reflection API反射机制`利用该漏洞`执行任意Java对象的方法`|
|`WebView在布局文件中使用`，如`动态添加WebView到LinearLayout布局`中，当离开时要`销毁WebView`，在`onDestroy方法中一定要先把LinearLayout布局中的WebView remove掉`，再`调用WebView的removeAllViews方法和WebView的destroy方法才能真正的销毁整个WebView`，才`不会导致内存泄露问题`|
|`jsbridge`通过`jsbridge`构建几个桥，桥的两端分别是`web端`和`App端`，`App端可以调用web端的代码，反过来也可以`|
|`webviewClient.onPageFinished方法在当加载页面完成的时候会回调`，`但是这个方法会有很多坑：它会判断这个网页内容是不是真的加载完毕了，当前正在加载的网页如果正在跳转该方法就会被调用无数次`，所以`webview如果要加载各种各样的网页，并且要在网页上操作的时候最好还是调用webChromeClient.onProgressChanged()方法`|
|`后台耗电`，`当程序开启webview加载网页的时候，webview会自己开启线程，如果没有很好的将webview销毁的话，残余的线程将会在后台运行，将会导致程序耗电非常严重，所以在onDestory直接调用System.exit()关闭虚拟机，将不会有这个问题，一般不会这么做`|
|`webview硬件加速导致页面渲染问题`：`开启硬件加速时webview加载页面将会更加顺滑，但是要注意有副作用，容易出现页面加载白块同时页面闪烁的现象，解决方法：设置webview暂时关闭硬件加速`|

#### 二、WebView的内存泄露问题

|WebView的内存泄露问题|
|------|
|`webview`会关联一个`Activity`，而`webview操作是在新的线程当中，导致Activity引用不能及时回收`|
|`解决webview内存泄露问题`：`独立进程，简单暴力，不过可能涉及到进程间通信`，`大神使用最多该方法，因为webview使用完毕之后，直接干掉这个进程，不可能存在内存泄露，App主进程减少了内存容量`|
|`解决webview内存泄露问题`：`动态添加webview，对传入webview中使用的context使用弱引用，动态添加webvie意思是布局创建个ViewGroup用来放置webview，Activity创建时add进来，在Activity停止时remove掉`|

### URL&URI

|标志|说明|
|------|------|
|URI|`uniform resource identifier`统一资源标志符；是一个相对来说更广泛的概念，URL是URI的一种，是URI命名机制的一个子集，可以说URI是抽象的，而具体要使用URL来定位资源WEB上的每一种资源如：图片，文档，视频等，这里所谓的定位指的是WEB上的资源相对于主机服务器来说，存放在服务器上的具体路径；URI一般由三部分组成：访问资源的命名机制、存放资源的主机名、资源自身的名称|
|URL|`uniform resource location`统一资源定位符；是`internet`上用来描述信息资源文件的字符串，用在客户程序和服务器上，定位客户端连服务器所需要的信息，他不仅定位了这个信息资源，而且定位了如何找到这个资源|

### 使用现有的浏览器打开网页    
```
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Uri uri = Uri.parse("http://www.baidu.com");
         Intent intent = new Intent(Intent.ACTION_VIEW, uri);
         startActivity(intent);
     }
```
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-70.gif)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-71.gif)

### 使用WebView加载HTML代码
+ WebView提供了一个`loadData(String data , String mimeType , String encoding)`方法，该方法`可用于加载并显示HTML代码`，但在实际使用过程中`当它加载包含中文的HTML内容时`，`WebView将会显示乱码`；好在WebView提供了一个`loadDataWithBaseURL(String baseUrl , String data , String mimetype , String encoding , String historyUrl)`方法，该方法是loadData(String data , String mimetype , String encoding)方法的增强版，`它不会产生乱码`。关于该方法的几个参数简单说明如下：

|参数|说明|
|------|------|
|`data`|`指定需要加载的HTML代码`|
|`mimetype`|`指定HTML代码的MIME类型，对于HTML代码可指定为text/html`|
|`encoding`|`指定HTML代码编码所用的字符集，比如指定为GBK`|

```
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("<html>");
stringBuilder.append("<head>");
stringBuilder.append("<title>欢迎您</title>");
stringBuilder.append("</head>");
stringBuilder.append("<body>");
stringBuilder.append("<h2>欢迎您访问<a href=\"http://www.crazyit.org\">疯狂java联盟</a></h2>");
stringBuilder.append("</body>");
stringBuilder.append("</html>");
//使用简单的loadData方法会导致乱码show.loadData(sb.toString(),"text/html" , "utf-8")
//加载并显示HTML代码
webView.loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "utf-8", null);
```
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-72.gif)

### 打造自己的浏览器
```
    <uses-permission android:name="android.permission.INTERNET" />
```
```
    public class WebViewActivity extends AppCompatActivity {
        private WebView webview;
        private Uri uri = Uri.parse("http://www.baidu.com");
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.webview_layout);
            init();
        }
        private void init() {
            webview = (WebView) findViewById(R.id.webview);
            webview.loadUrl(String.valueOf(uri));//只是这一句话，还是会使用系统安装的浏览器
            //webview.loadUrl("file:///android_asset/xx.html");//加载本地文件使用该方法，本地文件存放在assets文件夹
            //webview.requestFocus();//使页面获得焦点
            /**
             * 要使得加载的页面在WebView中显示需要使用下面方法
             * */
            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //返回true的时候控制页面在WebView中打开，如果返回false调用系统浏览器或第三方浏览器显示
                    view.loadUrl(url);
                    return true;
                }
            });
            /**
             * 如果想在加载的Web页面使用JavaScript，需要使用下列方法
             * */
            WebSettings settings = webview.getSettings();
            settings.setJavaScriptEnabled(true);
            /**
             * 优先使用缓存
             * */
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            /**
             * 添加进度控制
             * */
            webview.setWebChromeClient(new WebChromeClient() {
                private ProgressDialog dialog;
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    if (newProgress == 100) {
                        closeDialog();
                    } else {
                        openDialog(newProgress);
                    }
                }
                private void closeDialog() {
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                        dialog = null;
                    }
                }
                private void openDialog(int newProgress) {
                    if (dialog == null) {
                        dialog = new ProgressDialog(WebViewActivity.this);
                        dialog.setTitle("正在加载....");
                        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        dialog.setProgress(newProgress);
                        dialog.show();
                    } else {
                        dialog.setProgress(newProgress);
                    }
                }
            });
        }
        /**
         * 通过goBack方法或goForward方法向后向前访问已经访问的过的站点 ， webview的其他方法如：zoomIn放大网页,zoomOut缩小网页
         * */
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (webview.canGoBack()) {
                    webview.goBack();
                    return true;
                } else {
                    System.exit(0);
                }
            }
            return false;
        }
    }
```
```
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical" android:layout_width="match_parent"
        android:layout_height="match_parent">
        <WebView
            android:id="@+id/webview"
            android:layout_width="match_parent"
            android:layout_height="match_parent"></WebView>
    </LinearLayout>
```

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-73.gif)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-74.gif)
