package com.example.user.bookstore.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by user on 18/1/11.
 */

public class BookInfo extends BmobObject {
//    private String author_des;  //作者详情
//    private String pager_materials; //纸张材质
    private int pages;  //页数
    private int price;  //价格
    private String publishing_company;  //出版社
    private String publishing_date; //发布日期
    private int revision;   //发行版本
    private int star;   //评级
    private String title;   //标题
//    private String packing; //包装
    private int letters;    //字数
//    private String ISBN;   //ISBN
    private String author;  //作者
//    private String catalog; //目录
    private String category_id;    //分类ID
    private String content_des; //内容详情
    private int discount;   //折扣
    private int discount_price; //折扣价
    private String folio;   //对开
//    private int impression;   //有效的广告收益
    private int total;  //总数
    private String image_url;  //图片地址

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    //    public int getImpression() {
//        return impression;
//    }
//
//    public void setImpression(int impression) {
//        this.impression = impression;
//    }
//
//    public String getAuthor_des() {
//        return author_des;
//    }
//
//    public void setAuthor_des(String author_des) {
//        this.author_des = author_des;
//    }
//
//    public String getPager_materials() {
//        return pager_materials;
//    }
//
//    public void setPager_materials(String pager_materials) {
//        this.pager_materials = pager_materials;
//    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublishing_company() {
        return publishing_company;
    }

    public void setPublishing_company(String publishing_company) {
        this.publishing_company = publishing_company;
    }

    public String getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(String publishing_date) {
        this.publishing_date = publishing_date;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getPacking() {
//        return packing;
//    }
//
//    public void setPacking(String packing) {
//        this.packing = packing;
//    }

    public int getLetters() {
        return letters;
    }

    public void setLetters(int letters) {
        this.letters = letters;
    }

//    public String getISBN() {
//        return ISBN;
//    }
//
//    public void setISBN(String ISBN) {
//        this.ISBN = ISBN;
//    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public String getCatalog() {
//        return catalog;
//    }
//
//    public void setCatalog(String catalog) {
//        this.catalog = catalog;
//    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getContent_des() {
        return content_des;
    }

    public void setContent_des(String content_des) {
        this.content_des = content_des;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(int discount_price) {
        this.discount_price = discount_price;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "pages=" + pages +
                ", price=" + price +
                ", publishing_company='" + publishing_company + '\'' +
                ", publishing_date='" + publishing_date + '\'' +
                ", revision=" + revision +
                ", star=" + star +
                ", title='" + title + '\'' +
                ", letters=" + letters +
                ", author='" + author + '\'' +
                ", category_id=" + category_id +
                ", content_des='" + content_des + '\'' +
                ", discount=" + discount +
                ", discount_price=" + discount_price +
                ", folio='" + folio + '\'' +
                ", total=" + total +
                '}';
    }
}
