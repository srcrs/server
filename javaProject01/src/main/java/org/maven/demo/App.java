package org.maven.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Document doc = Jsoup.connect("https://wenku.baidu.com/view/573328de5222aaea998fcc22bcd126fff7055dd4.html?from=search")
                    .ignoreContentType(true)
                    .followRedirects(true)
                    .referrer("https://wenku.baidu.com/search?word=%C8%ED%BC%FE%BF%BC%CA%D4&lm=0&od=0&fr=top_home&ie=gbk")
                    .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Mobile Safari/537.36")
                    .cookie("Cookie","Hm_lvt_d348ccd08d80aaeb96f24bf28fbe7b1d=1583207887,1583209897; BIDUPSID=CD054F5108BE577898837AC1F64289AC; PSTM=1576409897; BAIDUID=CD054F5108BE5778F413FCD21EF8F353:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDUSS=V0b0lxTURqQXA3a2pKdDRvYTA5WmN2S1Z-Z3J6SW5XdUdsVHplUXVCazNEbHBlRVFBQUFBJCQAAAAAAAAAAAEAAADoxHzFZGhfMTg1Njc0NDIyMTIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADeBMl43gTJeNH; Hm_lvt_f76d987dbbb6104ea10fe19907268860=1583207887,1583209897; H_WISE_SIDS=141798_142205_142067_142183_142246_141002_135846_142113_142018_141837_139050_141748_138878_141898_142390_142780_142285_136862_140173_131246_142910_141261_136687_138883_133847_140259_141941_127969_140066_143365_140593_134046_143059_140236_138426_143274_141924_131423_141913_125696_107319_140984_138596_143091_138661_141103_110085; delPer=0; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; PSINO=1; BDRCVFR[dG2JNJb_ajR]=mk3SLVN4HKm; BDRCVFR[-pGxjrCMryR]=mk3SLVN4HKm; session_name=www.baidu.com; rebuild2019=4; yjs_js_security_passport=98146b698a831a675fe5bfa3bcca95631f0ebada_1583907590_js; H_PS_PSSID=30962_1465_21099_30825_30824; session_id=1583935505656; ___wk_scode_token=neSOjmfZ3VD00jhs2JCNeoDEAz5T71t79v1OS0sKrao%3D")
                    .maxBodySize(0)
                    .get();
            Elements em = doc.select("p");
            for(Element e : em) {
                System.out.println(e.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}