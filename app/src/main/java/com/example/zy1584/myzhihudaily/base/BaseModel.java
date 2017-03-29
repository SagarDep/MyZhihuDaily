package com.example.zy1584.myzhihudaily.base;


import com.example.zy1584.myzhihudaily.http.Http;
import com.example.zy1584.myzhihudaily.http.HttpService;
import com.example.zy1584.myzhihudaily.interfaces.IModel;

public class BaseModel implements IModel {
    protected static HttpService httpService;

    //初始化httpService
    static {
        httpService = Http.getHttpService();
    }

}
