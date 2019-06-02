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
/*
 *  首页获取笔记的信息
 *
 *
 */
public class GetNoteInformation {
    @Autowired
    BookService bookService;
    private Bookjson bookjson;
    private JSONArray jsonArray;
    private String address = Address.LOCAL_ADDRESS;  //本地IP地址，速度快
    //private String address = "http://yishujutan.free.idcfengye.com";  //内网穿透，速度慢

    @GetMapping("/noteinformation")    //首页获取图书信息

    public String GetNoteInformation() {
        JSONObject result;
        jsonArray =new JSONArray();
        List<Book> books=null;
        books=bookService.getNoteInformation();
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
    @GetMapping("/notecontent")//点进笔记内容进一步显示详细信息
    public String GetBookcontent(String book_id){
        JSONObject result2;

        jsonArray =new JSONArray();
        List<Book> books=null;
        books=bookService.getBookContent(book_id);
        Book book=books.get(0);
        bookjson=new Bookjson();
        result2=bookjson.bookjson(book);
        jsonArray.add(result2);
        return jsonArray.toString();
    }


}
