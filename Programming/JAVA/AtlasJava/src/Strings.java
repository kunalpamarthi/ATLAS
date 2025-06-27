public class Strings {
    /* For string methods: https://www.w3schools.com/java/java_ref_string.asp */
    public static void main(String[] args) {
        String string = "Hello World!!";
        int indexW = string.indexOf('W');
        String substring = string.substring(indexW);
        System.out.println(substring + "\n" +
                substring.charAt(substring.length()-1));

        System.out.println(Character.toLowerCase(string.charAt(0)) +
                string.substring(1, string.indexOf(substring.charAt(0))) +
                substring.toLowerCase());

        String xstring = string.replace('o', 'x');
        xstring = xstring.toLowerCase().replace("!!", " xD");
        System.out.println(xstring);
        String forCompString = string.toUpperCase();
        System.out.println(string.equals(forCompString) + "\t" + string.equalsIgnoreCase(forCompString));
    }
}
