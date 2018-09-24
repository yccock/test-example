/**
 * 生成客户端代码
 *
* 1.在target/class目录下新建文件夹wsdl、src,并进入target/class目录
* 2.wsgen -cp . -r ./wsdl -s ./ -d ./ -wsdl com.test.HelloServiceImpl
* 3.wsimport -s ./src -p com.test.ws http://127.0.0.1:9000/webserviceDemo?wsdl
 */