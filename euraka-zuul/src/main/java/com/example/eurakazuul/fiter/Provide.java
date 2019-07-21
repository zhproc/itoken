package com.example.eurakazuul.fiter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class Provide implements FallbackProvider {
    @Override
    public String getRoute() {  //错误回调
        return "hystrix-dashboard";  //服务ID
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            /*
            * 网关向Api服务请求失败了，但是消费者客户端向网关发起的请求是成功的
            * 不应该把Api的404，500等问题抛给客户端
            * 网关和Api服务集群对于客户来说是黑盒
            *
            * */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;            //返回状态码
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {


                return null;
            }

            @Override
            public HttpHeaders getHeaders() {
                return null;
            }
        };
    }
}
