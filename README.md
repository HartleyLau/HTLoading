# HTLoading

> 一个Android端简单易用的LoadingDialog，基于Kotlin语言

[English Document](README-EN.md)

## 功能

- 显示默认的加载窗口
- 显示默认的加载成功/失败窗口
- 自定义加载/成功/失败页面
- 可以全局设置参数

## 效果

![](/img/Effect.gif)
![](/img/CustomView.gif)

## 基本使用

步骤1.将依赖添加到项目的bulid.gradle里:

```groovy
implementation 'com.superlht:HTLoading:1.0.0'
```

## 使用方法

### 显示默认动画

如果全部使用默认配置，需要显示Loading的地方只需要调用:

```kotlin
HTLoading(this).show()
```

需要设置展示的文字：

```kotlin
HTLoading(this).setLoadingText("加载中...").show()
```

加载成功:

```kotlin
HTLoading(this).setSuccessText("加载成功！").showSuccess()
```

HTLoading支持链式调用，如HTLoading(this).setLoadingText("加载中...").setsetFailedText("加载失败").show()，调用show方法后不支持链式调用

### 显示自定义View

### 显示SpinKit动画

## API文档

| fun(方法)                                  | describe(描述)        |
| ---------------------------------------- | ------------------- |
| show()                                   | 显示默认的Loading Dialog |
| showSuccess()                            | 显示默认的成功dialog       |
| showFailed()                             | 显示默认的失败dialog       |
| showCustomFailed()                       | 显示自定义的失败界面          |
| showCustomSuccess()                      | 显示自定义的成功界面          |
| showCustomLoading()                      | 显示自定义的加载界面          |
| setSuccessView(view:View)                | 设置自定义成功界面           |
| setFailedView(view:View)                 | 设置自定义失败界面           |
| setLoadingView(view:View)                | 设置自定义加载界面           |
| setOnDialogDismissListener(listener: OnDialogDismissListener) | 设置对话框消失的监听器         |

## 全局设置

有需要在全局都使用统一Loading样式或内容的，可以在Application中进行全局初始化设置，如:

```kotlin
HTLoadingManager.loadText("正在加载...").successText("加载成功")
```

目前支持全局设置的方法有:

- textSize(size:Float) :字体尺寸
- loadText() /failedText()/successText() :加载/失败/成功时显示的文字
- delay(time:Long) :成功和失败显示后延迟多少毫秒(ms)消失
- drawColor(color:Int) : 图形的颜色
- isAutoDismiss(boolean:Boolean) : 成功/失败后Dialog是否自动消失

### 感谢

[ForgetAll/LoadingDialog](https://github.com/ForgetAll/LoadingDialog)

[ybq/Android-SpinKit](https://github.com/ybq/Android-SpinKit)

有任何问题欢迎issue提出

### [更新日志]()

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```