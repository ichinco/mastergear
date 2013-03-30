package com.mastergear;

/**
 * User: denise
 * Date: 3/27/13
 * Time: 9:01 PM
 */
public enum ProviderType {
    AMAZON("<a href=\"http://www.amazon.com/gp/product/{ID}/ref=as_li_ss_il?ie=UTF8&camp=1789&creative=390957&creativeASIN={ID}&linkCode=as2&tag=trythaton-20\"><img border=\"0\" src=\"http://ws.assoc-amazon.com/widgets/q?_encoding=UTF8&ASIN={ID}&Format=_SL160_&ID=AsinImage&MarketPlace=US&ServiceVersion=20070822&WS=1&tag=trythaton-20\" ></a><img src=\"http://www.assoc-amazon.com/e/ir?t=trythaton-20&l=as2&o=1&a={ID}\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" style=\"border:none !important; margin:0px !important;\" />\n"),
    EMS("<a href=\"http://www.ems.com/product/index.jsp?productId={ID}&cp=20311796.20311836\"><img class=\"ems-product\" src=\"http://ems.imageg.net/cms_widgets/18/63/1863650_assets/ems.gif\"/></a>"),
    REI("<a href=\"http://www.rei.com/product/{ID}\"><img class=\"rei-product\" src=\"http://www.rei.com/media/{IMAGE_ID}.jpg\" /></a>"),
    CAMPMOR("");

    private String html;

    private ProviderType(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }
}
