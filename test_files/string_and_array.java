class string_and_array
{
    public static void main(String[] arg)
    {
        String str = "helloworld";
        int[] codepoints = str.codePoints().toArray();
        System.out.println(codepoints);
	String skr  = new String(codepoints,0,codepoints.length);
	System.out.println(skr);
        
    }
}




