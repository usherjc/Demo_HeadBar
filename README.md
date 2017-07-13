# Demo_HeadBar
## 一个用于显示头部的自定义控件 A custom view made for headbar

![image.png](http://upload-images.jianshu.io/upload_images/1780352-8b24445c027b04e9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/360)

> 一个自定义的头部

这个头部总共有五个状态，在代码里设置如下所示。注意：必须要给它设置一个状态，否则会造成空指针。

```
public class MainActivity extends AppCompatActivity {

    private HeadBar mHbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHbMain = (HeadBar) findViewById(R.id.hb_main);
        mHbMain.setThisState(HeadBar.STATE.STATE5);
    }
}
```

> 不同状态显示

![result-2017-07-13-09-03-39.png](http://upload-images.jianshu.io/upload_images/1780352-0c7adbde1d57a9e1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)