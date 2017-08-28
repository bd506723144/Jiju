package com.project.cl.been;


/**
 * Created by PC on 2017/4/28.
 */

public class Test extends Base {
//    private String id;
    private String pubdate;
    private String binding;
    private String publisher;
//    private String alt;
//    private Object rating;
//    private Object author;
//    private String alt_title;
//    private String image;
//    private String title;
//    private Object attrs;
//    private String mobile_link;
//    private String summary;
//    private Object tags;


    @Override
    public String toString() {
        return "Test{" +
                "pubdate='" + pubdate + '\'' +
                ", binding='" + binding + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
