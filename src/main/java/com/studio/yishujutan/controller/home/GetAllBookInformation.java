package com.studio.yishujutan.controller.home;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.home.JsonTool.Bookjson;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GetAllBookInformation {
    @Autowired
    BookService bookService;
    private Bookjson bookjson;
    private JSONArray jsonArray;
    private String address = Address.LOCAL_ADDRESS;  //本地IP地址，速度快
    //private String address = "http://yishujutan.free.idcfengye.com";  //内网穿透，速度慢

    @GetMapping("/allbookinformation")    //首页获取图书信息

    public String GetAllBookInformation() {
        JSONObject result;
        jsonArray =new JSONArray();
        List<Book> books=null;
        books=bookService.getAllBookInformation();
        int realNumber = books.size();
        Book book;
        bookjson=new Bookjson();
        for (int i = 0; i < realNumber; i++) {
            book= books.get(i);

            result=bookjson.bookjson(book);

            jsonArray.add(result);
        }
        System.out.println(books);
        return jsonArray.toString();
    }
}
