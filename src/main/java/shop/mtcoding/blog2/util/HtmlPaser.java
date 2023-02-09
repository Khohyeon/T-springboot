package shop.mtcoding.blog2.util;

public class HtmlPaser {
    public static String getThumnail(String html) {
        Document doc = Jsoup.parse(html);
        Elements els = doc.select("img");
        String thumbnail = "";
        // System.out.println(els);
        if (els.size() == 0) {
            thumbnail = "/images/dora.png";
            // 임시사진
            // 디비 섬네일 -> /image/profile.png
        } else {
            Element el = els.get(0);
            thumbnail = el.attr("src");
        }
        return thumbnail;
    }
}