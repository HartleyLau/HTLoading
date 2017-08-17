# HTLoading

一个Android端简单易用的LoadingDialog，基于Kotlin语言

## 项目中使用

步骤1.将jitpack仓库添加到**工程级别**的build.gradle里:

```groovy
repositories {
  		...
        maven { url "https://jitpack.io" }
    }
```

步骤2.将依赖添加到**项目级别**的bulid.gradle里:

```groovy
implementation 'com.superlht.code:HTLoading:v1.0.0'
```

## 使用方法

如果全部使用默认配置，需要显示的地方只需要调用:

```kotlin
HTLoading(this).show()
```





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