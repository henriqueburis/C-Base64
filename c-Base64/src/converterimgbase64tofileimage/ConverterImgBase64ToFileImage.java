package converterimgbase64tofileimage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.primefaces.util.Base64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luiz Henrique Buris
 */
public class ConverterImgBase64ToFileImage implements Serializable {

    private final List<String> Base64Link = new ArrayList<>();
    private final List<String> LinkUrl = new ArrayList<>();
    private final List<String> Link = new ArrayList<>();
    private final List<String> LinkW = new ArrayList<>();
    private final List<String> LinkGetTexto = new ArrayList<>();
    StringBuffer NomeBuffer = new StringBuffer();

    public String Base64ToImageLocal(String getText, String pathWrite, String path, String onlyName) {

        Base64Link.clear();
        LinkUrl.clear();
        String CodeBase64;
        String nomeImg;

        Base64 decoder = new Base64();

        Pattern p = Pattern.compile("(base64,\\w\\S*|\\\\.)");
        Matcher m = p.matcher(getText.trim());

        Pattern pEx = Pattern.compile("(data:image\\/\\w+;base64)");
        Matcher mEx = pEx.matcher(getText.trim());

        try {
            String exten;
            while (mEx.find()) {
                NomeBuffer.delete(0, NomeBuffer.length());
                System.out.println(mEx.group().replaceFirst("data:image/", "").replaceFirst(";base64", ""));
                exten = mEx.group().replaceFirst("data:image/", "").replaceFirst(";base64", "");

                if (exten.equals("png") || exten.equals("gif")) {

                    while (m.find()) {

                        CodeBase64 = m.group().replaceFirst("base64,", "").replaceFirst("\"", "");
                        nomeImg = String.valueOf(NomeBuffer.append("Base64").append(onlyName).append(CodeBase64.subSequence(CodeBase64.length() - 25, CodeBase64.length())));
                        System.out.println(new File(path + nomeImg + ".jpg"));
                        FileOutputStream write = new FileOutputStream(new File(pathWrite + nomeImg + ".jpg"));
                        byte[] decoderBytes = decoder.decode(CodeBase64);
                        write.write(decoderBytes);
                        write.close();
                        Base64Link.add("src=\"data:image/" + exten + ";base64," + CodeBase64 + "\"");
                        LinkUrl.add("src=\"" + path + nomeImg + ".jpg\"");
                        LinkW.add("src=\"" + pathWrite + nomeImg + ".jpg\"");
                        break;
                    }
                }
            }

            for (int i = 0; i < Base64Link.size(); i++) {
                getText = getText.replace(Base64Link.get(i), LinkUrl.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return getText;
    }

    public List<String> getListaLink() {
        Link.clear();
        for (int i = 0; i < LinkW.size(); i++) {
            System.out.println(LinkW.get(i).replaceFirst("src=\"", "").replaceFirst("\"", ""));
            Link.add(LinkW.get(i).replaceFirst("src=\"", "").replaceFirst("\"", ""));
        }

        return Link;
    }

    public List<String> getAnaliseLinkBase64Text(String getText, String pathWrite) {
        LinkGetTexto.clear();
        Pattern p = Pattern.compile("(Base64Imagem\\S+\\.jpg)");
        Matcher m = p.matcher(getText.trim());
        while (m.find()) {
//            System.out.println(m.group());
            LinkGetTexto.add(pathWrite + m.group());

//            for (int i = 0; i < LinkW.size(); i++) {
//                System.out.println(LinkGetTexto.get(i));
//                System.out.println(Link.get(i));
//                if (LinkGetTexto.get(i).equals(Link.get(i))) {
//                    System.out.println("ok");
//                }
////            Link.add(LinkW.get(i).replaceFirst("src=\"", "").replaceFirst("\"", ""));
//            }
//            break;
        }
        return LinkGetTexto;
    }
}
