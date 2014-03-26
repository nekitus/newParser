package main;

public class FileTemplate {
    public static String gethtml(String sourceName, String path) {
        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "\t\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                "\t<script language=\"javascript\" src=\"swfobject.js\" type=\"text/javascript\"></script>\n" +
                "\t<title>Math Player</title>\n" +
                "\t\n" +
                "</head>\n" +
                "\n" +
                "<body bgcolor=\"#CCCCFF\">\n" +
                "\t\n" +
                "\t<div id=\"wrapper\" align=\"center\">\n" +
                "\n" +
                "\t\t<div id=\"flashcontent\">\n" +
                "\t\t\t<div id=\"flashcontentwarn\">\n" +
                "\t\t\t\t<strong>Flash Player 7 and JavaScript required.</strong><br />\n" +
                "\t\t\t\tPlease <a href=\"http://www.adobe.com/go/getflashplayer\" title=\"Download Flash Player\" target=\"_blank\">download the latest Flash Player</a>, and make sure your browser's JavaScript support is enabled.\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<script type=\"text/javascript\">\t\t\n" +
                "\n" +
                "\t\t\t// <![CDATA[\n" +
                "\t\t\tvar so = new SWFObject(\"player.swf\", \"player\", \"640\", \"700\", \"7\", \"#FFFFFF\");\n" +
                "\t\t\tso.addParam(\"wmode\", \"transparent\");\n" +
                "\t\t\tso.addVariable(\"mediaPath\", \"" + path + "/\");\n" +
                "\t\t\tso.addVariable(\"contentID\", \"" + sourceName + "\");\t// CHANGE CONTENT ID HERE ##################\n" +
                "\t\t\tso.addVariable(\"hideButtons\", \"false\");\t\t\t// set BUTTON VISIBILITY here (\"true\" to hide)\n" +
                "\t\t\tso.write(\"flashcontent\");\n" +
                "\t\t\t// ]]>\n" +
                "\t\t</script>\n" +
                "\n" +
                "\t</div>\n" +
                "\n" +
                "<center>&copy; Cengage Learning. All Rights Reserved.</center></body>\n" +
                "</html>\n";
        return html;

    }
    public static String getxml(String enSubtitle, String esSubtitle, String srcName){
        System.out.println("video! " +  srcName);

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<movie>\n" +
                " <title>Section 1.1</title>\n" +
                " <subheader>Video Example 5</subheader>\n" +
                " <subtitles_en>" + enSubtitle + "</subtitles_en>\n" +
                " <subtitles_es>" + esSubtitle + "</subtitles_es>\n" +
                " <video>"+ srcName +"</video>\n" +
                "</movie>\t\n";


        return xml;
    }
}