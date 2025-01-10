package builder;

public class Demo {

    public static void main(String[] args) {
        String [] words = {"x", "y", "z"};

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word : words) {
            sb.append("  <li>").append(word).append("</li>\n");
        }
        sb.append("</ul>");

        System.out.println(sb.toString());

    }

}
