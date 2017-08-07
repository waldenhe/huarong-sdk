huarong-sdk
华融支付SDK项目


1. 第一步：git clone https://github.com/waldenhe/huarong-sdk.git 或者
[直接下载](https://github.com/waldenhe/huarong-sdk/archive/master.zip) 
2. 第二步： clone项目之后进入项目目录执行mvn eclipse:eclipse
3. 第三步：使用Eclipse  File>import 
4. 第四步：查看src/test/java里面的测试用例，针对不同的业务，参考不同的测试用例。
5. 第五步：测试环境调试通过，将生产证书放入src/main/resource目录进行打包，mvn clean install -Dmaven.test.skip=true
6. 将工具包放入自己系统的lib或者通过maven安装 
```xml
     <dependency>
          <groupId>com.wanrong</groupId>
          <artifactId>payment-sdk</artifactId>
          <version>1.0</version>
     <dependency>
```


